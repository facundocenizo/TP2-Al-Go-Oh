package fiuba.algo3.tp2;

public abstract class Carta {
	
	protected Posicion posicion;
	protected Estado estado;
	protected Efecto efecto;
	
	public Carta(Posicion nuevaPosicion ,Efecto efecto) {
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