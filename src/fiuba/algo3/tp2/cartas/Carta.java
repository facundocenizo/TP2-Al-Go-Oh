package fiuba.algo3.tp2.cartas;

import fiuba.algo3.tp2.atributosCarta.Efecto;
import fiuba.algo3.tp2.atributosCarta.Estado;
import fiuba.algo3.tp2.atributosCarta.Muerto;
import fiuba.algo3.tp2.atributosCarta.Observador;
import fiuba.algo3.tp2.atributosCarta.Posicion;
import fiuba.algo3.tp2.atributosCarta.SujetoCartaObservable;
import fiuba.algo3.tp2.atributosCarta.Vivo;

public abstract class Carta implements SujetoCartaObservable,Efecto{
	
	protected Posicion posicion;
	protected Estado estado;
	protected Efecto efecto;
	protected Observador observador;
	public String nombre;
	public String descripcion;
	
	public Carta(Posicion nuevaPosicion, Efecto efecto) {
		this.posicion = nuevaPosicion;
		this.estado = new Vivo();
		this.efecto = efecto;
	}
	
	@Override
	public void aniadirObservador(Observador observador) {
		this.observador = observador;
	}
	
	@Override
	public void notificar(int puntosARestar) {
		observador.actualizar(puntosARestar);
	}
	
	public boolean estaBocaAbajo() { 
		return this.posicion.estaBocaAbajo();
	}
	
	public boolean estaMuerta() {
		return this.estado.estaMuerta();
	}
	
	public void morir() {
		this.estado = new Muerto();
	}

	public void voltearCarta() {
		this.posicion = this.posicion.voltear();
	}

	public boolean esParteExodia() {
		return false;
	}
	
	public void setNombre(String unNombre) {
		this.nombre = unNombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	public void setDescripcion(String unaDescripcion) {
		this.descripcion = unaDescripcion;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public abstract Boolean esMonstruo();
	public abstract Boolean esMagica();
	public abstract Boolean esTrampa();
	public abstract Boolean esCartaCampo();
	
	
}