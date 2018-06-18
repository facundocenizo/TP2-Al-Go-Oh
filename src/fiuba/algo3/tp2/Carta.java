package fiuba.algo3.tp2;

import fiuba.algo3.tp2.atributosCarta.Efecto;
import fiuba.algo3.tp2.atributosCarta.Estado;
import fiuba.algo3.tp2.atributosCarta.Muerto;
import fiuba.algo3.tp2.atributosCarta.Posicion;
import fiuba.algo3.tp2.atributosCarta.Vivo;

public abstract class Carta {
	
	protected Posicion posicion;
	protected Estado estado;
	protected Efecto efecto;
	
	public Carta(Posicion nuevaPosicion, Efecto efecto) {
		this.posicion = nuevaPosicion;
		this.estado = new Vivo();
		this.efecto = efecto;
		
	}
	
	public abstract void aplicarEfecto();
	
	public boolean estaBocaAbajo() { 
		return this.posicion.estaBocaAbajo();
	}
	
	public boolean estaMuerta() {
		return this.estado.estaMuerta();
	}
	
	public void morir() {
		this.estado = new Muerto();
	}
	
}