package fiuba.algo3.tp2;

public abstract class Carta {
	
	protected Posicion posicion;
	
	
	public Carta(Posicion nuevaPosicion) {
		this.posicion = nuevaPosicion;
	}
	
	public abstract void aplicarEfecto();
	
	public boolean estaBocaAbajo() { 
		return this.posicion.estaBocaAbajo();
	}
	
	

}