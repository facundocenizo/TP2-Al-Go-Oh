package fiuba.algo3.tp2;

public abstract class Carta {
	
	protected Posicion posicion;
	protected Estado estado;
	
	///-.-.-.-.-.-..-
	
	public Carta(Posicion nuevaPosicion) {
		this.posicion = nuevaPosicion;
		this.estado = new Vivo();
		
	}
	
	public abstract void aplicarEfecto();
	
	public boolean estaBocaAbajo() { 
		return this.posicion.estaBocaAbajo();
	}
	
	public boolean estaMuerta() {
		return this.estado.estaMuerta();
	}
	//pruebas gitHub
	//sigo haciendo pruebas pablo.
}