package fiuba.algo3.tp2;

import java.util.ArrayList;
import java.util.Iterator;

import fiuba.algo3.tp2.atributosCarta.Observador;
import fiuba.algo3.tp2.atributosLadoDelCampo.Atacable;
import fiuba.algo3.tp2.atributosLadoDelCampo.Cementerio;
import fiuba.algo3.tp2.atributosLadoDelCampo.DefensaConEfecto;
import fiuba.algo3.tp2.atributosLadoDelCampo.DefensaConTrampa;
import fiuba.algo3.tp2.atributosLadoDelCampo.DefensaNormal;
import fiuba.algo3.tp2.atributosLadoDelCampo.MazoCartas;
import fiuba.algo3.tp2.cartas.Carta;
import fiuba.algo3.tp2.cartas.CartaCampo;
import fiuba.algo3.tp2.cartas.Magica;
import fiuba.algo3.tp2.cartas.Monstruo;
import fiuba.algo3.tp2.cartas.Trampa;
import fiuba.algo3.tp2.excepciones.ZonaDeCampoLlenaException;
import fiuba.algo3.tp2.excepciones.ZonaDeCampoVaciaException;
import fiuba.algo3.tp2.excepciones.ZonaDeTrampaYMagicasLlenaException;
import fiuba.algo3.tp2.excepciones.ZonaMonstruosLlenaException;

public class LadoDelCampo {
	
	private Jugador jugador;
	private LadoDelCampo otroLado;
	private Cementerio cementerio;
	private MazoCartas mazoCartas;
	private ArrayList<Monstruo> zonaMonstruos;
	private ArrayList<Trampa> cartasTrampa;
	private ArrayList<Magica> cartasMagicas;
	private ArrayList<CartaCampo> cartaDeCampo;
	private Atacable atacable;
	
	public LadoDelCampo() {
		this.cementerio = new Cementerio();
		this.mazoCartas = new MazoCartas();
		this.zonaMonstruos = new ArrayList<Monstruo>();
		this.cartasTrampa = new ArrayList<Trampa>();
		this.cartasMagicas = new ArrayList<Magica>();
		this.cartaDeCampo = new ArrayList<CartaCampo>();
		this.atacable = new DefensaNormal();
	}
	
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	
	public void setOtroLado(LadoDelCampo otroLado) {
		this.otroLado = otroLado;
	}
	
	public Carta sacarCarta() {
		return mazoCartas.sacarCarta();
	}
	
	public void colocarMonstruo(Monstruo monstruo) {
		if (zonaMonstruos.size()>5) {
			throw new ZonaMonstruosLlenaException();
		}
		this.verificarSacrificios(monstruo);
		zonaMonstruos.add(monstruo);
	}

	private void verificarSacrificios(Monstruo monstruo) {
		monstruo.manejarNivel(this.zonaMonstruos); //
	}

	public void colocarTrampa(Trampa trampa) {
		if (cartasTrampa.size()+cartasMagicas.size()>5) {
			throw new ZonaDeTrampaYMagicasLlenaException();
		}
		cartasTrampa.add(trampa);
	}
	
	public void colocarMagica(Magica magica) {
		if (cartasTrampa.size()+cartasMagicas.size()>5) {
			throw new ZonaDeTrampaYMagicasLlenaException();
		}
		cartasMagicas.add(magica);
	}
	
	public void matarATodosLosMonstruos() {
		for (Monstruo monstruo: zonaMonstruos) {
			monstruo.morir();
			cementerio.agregarCarta(monstruo);
		}
		zonaMonstruos = new ArrayList<Monstruo>();
		
	}
	
	public void llevarMonstruosMuertosAlCementerio() {
		Iterator<Monstruo> iteradorMonstruo = this.zonaMonstruos.iterator();
        while (iteradorMonstruo.hasNext()) {
            Monstruo monstruo = iteradorMonstruo.next();
            if (monstruo.estaMuerta()) {
                this.cementerio.agregarCarta(monstruo);
                iteradorMonstruo.remove();   
            }
        }
	}

	public ArrayList<Monstruo> verMonstruosRivales() {
		return this.otroLado.verMonstruos();
	}

	public ArrayList<Monstruo> verMonstruos() {
		return zonaMonstruos;
	}
	
	public void activarTrampa() {
		if (cartasTrampa.size()!=0) {
			Trampa trampa = cartasTrampa.remove(0);
			this.atacable = new DefensaConTrampa(trampa);
		}
	}

	public void activarMagicaDeMano(Magica magica) {
		magica.aplicarEfecto(this, this.otroLado);
	}

	public void activarMagicaEnCampo(Magica magica) {
		magica.aplicarEfecto(this, this.otroLado);
		this.cartasMagicas.remove(magica);
	}
	
	public void atacarPuntosDelRival(int puntos) {
		this.otroLado.sufrirDanioAJugador(puntos);
	}

	public void sufrirDanioAJugador(int puntos) {
		this.jugador.sufrirDanio(puntos);
	}
	
	public void sacarMonstruo(Monstruo unMonstruo) {
		unMonstruo.morir();
		zonaMonstruos.remove(unMonstruo);
		this.llevarMonstruosMuertosAlCementerio();
	}

	public void atacar(Monstruo atacante, Monstruo atacado) {
		if (atacado==null) {
			this.otroLado.sufrirDanioAJugador(atacante.darPuntosDeAtaque());
			return;
		}
		atacante.aniadirObservador(this.jugador);
		atacado.aniadirObservador(otroLado.getJugador());
		atacante.aplicarEfecto(atacante, atacado);
		atacante.aplicarEfecto(this, this.otroLado);
		this.otroLado.recibirAtaque(atacante, atacado);
	}

	private Observador getJugador() {
		return this.jugador;
	}

	private void activarEfecto(Monstruo monstruo) {
		if (monstruo.tieneEfectoDefensa()) {
			this.atacable = new DefensaConEfecto(monstruo);
		}
	}
	
	private void recibirAtaque(Monstruo atacante, Monstruo atacado) {
		this.activarEfecto(atacado);
		this.activarTrampa();
		this.atacable.recibirAtaque(atacante, atacado);
	}

	public void colocarCartaCampo(CartaCampo cartaCampo) {
		if(this.cartaDeCampo.size()>0) {
			CartaCampo carta = this.cartaDeCampo.get(0);
			cementerio.agregarCarta(carta);
			this.cartaDeCampo = new ArrayList<CartaCampo>();
		}
		this.cartaDeCampo.add(cartaCampo);
	}

	public void activarCartaEnCampo() {
		if (this.cartaDeCampo.size() == 0) {
			throw new ZonaDeCampoVaciaException();
		}
		this.cartaDeCampo.get(0).aplicarEfecto(this,this.otroLado);
		
	}
	
	public void darCartaAJugador() {
		jugador.tomarCartaDelMazo();
		
	}

	public void limpiarZonaMagicaYTrampa() {
		Iterator<Magica> iteradorMagicas = this.cartasMagicas.iterator();
        while (iteradorMagicas.hasNext()) {
            Magica magica = iteradorMagicas.next();
            if (magica.estaMuerta()) {
                this.cementerio.agregarCarta(magica);
                iteradorMagicas.remove();
                
            }
        }
        
        Iterator<Trampa> iteradorTrampa = this.cartasTrampa.iterator();
        while (iteradorTrampa.hasNext()) {
            Trampa trampa = iteradorTrampa.next();
            if (trampa.estaMuerta()) {
                this.cementerio.agregarCarta(trampa);
                iteradorTrampa.remove();
                
            }
        }
	}
	
	public void terminarTurno() {
		Iterator<Monstruo> iteradorMonstruo = this.zonaMonstruos.iterator();
        while (iteradorMonstruo.hasNext()) {
            Monstruo monstruo = iteradorMonstruo.next();
            if (monstruo.estaMuerta()) {
                this.cementerio.agregarCarta(monstruo);
                iteradorMonstruo.remove();
                
            }
        }
		
        Iterator<Magica> iteradorMagicas = this.cartasMagicas.iterator();
        while (iteradorMagicas.hasNext()) {
            Magica magica = iteradorMagicas.next();
            if (magica.estaMuerta()) {
                this.cementerio.agregarCarta(magica);
                iteradorMagicas.remove();
                
            }
        }
        
        Iterator<Trampa> iteradorTrampa = this.cartasTrampa.iterator();
        while (iteradorTrampa.hasNext()) {
            Trampa trampa = iteradorTrampa.next();
            if (trampa.estaMuerta()) {
                this.cementerio.agregarCarta(trampa);
                iteradorTrampa.remove();
                
            }
        }
        
        Iterator<CartaCampo> iteradorCartaCampo = this.cartaDeCampo.iterator();
        while (iteradorCartaCampo.hasNext()) {
        	CartaCampo cartaCampo = iteradorCartaCampo.next();
            if (cartaCampo.estaMuerta()) {
                this.cementerio.agregarCarta(cartaCampo);
                iteradorCartaCampo.remove();
                
            }
        }
        
		if (this.mazoCartas.estaVacio() || this.jugador.darVida() <= 0) {
			
			this.otroLado.hasGanado();
		}
		
	}

	public void hasGanado() {
		this.jugador.hasGanado();
	}

	public ArrayList<Magica> getMagicas() {
		return this.cartasMagicas;
	}

	public ArrayList<Trampa> getTrampas() {
		return this.cartasTrampa;
	}

	public ArrayList<CartaCampo> getCartaCampo() {
		return this.cartaDeCampo;
	}

	
}
