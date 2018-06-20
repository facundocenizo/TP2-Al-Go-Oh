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

	@Override
	public void aplicarEfecto() {
		
	}

	public int atacar(Monstruo monstruoAtacado) {
		return this.modo.atacar(monstruoAtacado, this);
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
	



	
}