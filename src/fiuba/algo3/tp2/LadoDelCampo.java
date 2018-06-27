package fiuba.algo3.tp2;

import java.util.ArrayList;

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
		this.atacable = new AtaqueNormal();
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
		if (zonaMonstruos.size()>4) {
			throw new ZonaMonstruosLlenaException();
		}
		zonaMonstruos.add(monstruo);
	}
	
	public void colocarTrampa(Trampa trampa) {
		if (cartasTrampa.size()+cartasMagicas.size()>4) {
			throw new ZonaDeTrampaYMagicasLlenaException();
		}
		cartasTrampa.add(trampa);
	}
	
	public void colocarMagica(Magica magica) {
		if (cartasTrampa.size()+cartasMagicas.size()>4) {
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
		for (Monstruo monstruo: zonaMonstruos) {
			if (monstruo.estaMuerta()) {
				cementerio.agregarCarta(monstruo);
				zonaMonstruos.remove(monstruo);
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
			this.atacable = new AtaqueConTrampa(trampa);
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



	private void recibirAtaque(Monstruo atacante, Monstruo atacado) {
		atacado.aplicarEfecto(atacante, atacado);
		this.activarTrampa();
		this.atacable.recibirAtaque(atacante, atacado);
	}



	public void colocarTrampa(CartaCampo cartaCampo) {
		if (this.cartaDeCampo.size() == 1) {
			throw new ZonaDeCampoLlenaException();
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

	
}
