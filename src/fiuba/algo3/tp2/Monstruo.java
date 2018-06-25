package fiuba.algo3.tp2;

import fiuba.algo3.tp2.atributosCarta.Efecto;
import fiuba.algo3.tp2.atributosCarta.Posicion;
import fiuba.algo3.tp2.atributosMonstruo.Modo;
import fiuba.algo3.tp2.atributosMonstruo.Nivel;
public class Monstruo extends Carta{
	
	private Modo modo;
	private int puntosDeAtaque;
	private int puntosDeDefensa;
	private Nivel nivel;
	
	public Monstruo(Posicion posicion, Modo modo, Nivel nivel, int puntosDeAtaque, int puntosDeDefensa, Efecto efecto) {
		super(posicion, efecto);
		this.modo = modo;
		this.modo.cargarPuntos(puntosDeAtaque,puntosDeDefensa);
		this.puntosDeAtaque = puntosDeAtaque;
		this.puntosDeDefensa = puntosDeDefensa;
		this.nivel = nivel;
    }
	

	public boolean estaEnModoAtaque() {
		return modo.estaEnModoAtaque();
	}


	public void atacar(Monstruo monstruoAtacado) {
		this.modo.atacar(monstruoAtacado, this);
	}

	public int recibirAtaque(int puntosDeAtaque) {
		return this.modo.recibirAtaque(puntosDeAtaque, this);
	}

	public boolean esDebil() {
		return nivel.esDebil();
	}
	public boolean esNormal() {
		return nivel.esNormal();
	}
	public boolean esPoderoso() {
		return nivel.esPoderoso();
	}
	
	public int darPuntosDeAtaque() {
		return this.puntosDeAtaque;
	}
	
	public int darPuntosDeDefensa() {
		return this.puntosDeDefensa;
	}


	@Override
	public void aplicarEfecto(LadoDelCampo propio, LadoDelCampo rival) {
		this.efecto.aplicarEfecto(propio, rival);
	}


	public void aumentarPuntosDeAtaque(int aumentoDePruebas) {
		this.puntosDeAtaque += aumentoDePruebas;
		
	}

	public void aumentarPuntosDeDefensa(int aumentoDeDefensa) {
		this.puntosDeDefensa += aumentoDeDefensa;
		
	}
	



	
}