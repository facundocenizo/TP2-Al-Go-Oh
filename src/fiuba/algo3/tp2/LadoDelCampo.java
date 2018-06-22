package fiuba.algo3.tp2;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.tp2.excepciones.ZonaDeTrampaYMagicasLlenaException;
import fiuba.algo3.tp2.excepciones.ZonaMonstruosLlenaException;

public class LadoDelCampo {
	
	private Jugador jugador;
	private LadoDelCampo otroLado;
	private Cementerio cementerio;
	private MazoCartas mazoCartas;
	private List<Monstruo> zonaMonstruos;
	private List<Trampa> cartasTrampa;
	private List<Magica> cartasMagicas;
	
	public LadoDelCampo() {
		this.cementerio = new Cementerio();
		this.mazoCartas = new MazoCartas();
		this.zonaMonstruos = new ArrayList<Monstruo>();
		this.cartasTrampa = new ArrayList<Trampa>();
		this.cartasMagicas = new ArrayList<Magica>();
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
		}
	}
	
	public void llevarMonstruosMuertosAlCementerio() {
		for (Monstruo monstruo: zonaMonstruos) {
			if (monstruo.estaMuerta()) {
				cementerio.agregarCarta(monstruo);
				zonaMonstruos.remove(monstruo);
			}
		}
	}

	public List<Monstruo> verMonstruosRivales() {
		return this.otroLado.verMonstruos();
	}

	public List<Monstruo> verMonstruos() {
		return zonaMonstruos;
	}
	
	public void activarTrampa(Monstruo atacante, Monstruo atacado) {
		if (cartasTrampa.size()!=0) {
			Trampa trampa = cartasTrampa.remove(0);
			trampa.aplicarEfecto(this, this.otroLado);
		}
	}

	public void activarMagicaDeMano(Magica magica) {
		magica.aplicarEfecto(this, this.otroLado);
	}

	public void activarMagicaEnCampo(Magica magica) {
		this.cartasMagicas.remove(magica);
		magica.aplicarEfecto(this, this.otroLado);
	}
	
	public void atacarPuntosDelRival(int puntos) {
		this.otroLado.sufrirDanioAJugador(puntos);
	}

	public void sufrirDanioAJugador(int puntos) {
		this.jugador.sufrirDanio(puntos);
	}

}
