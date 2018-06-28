package fiuba.algo3.tp2;

import java.util.ArrayList;
import java.util.Random;

public class Juego {
    private ArrayList<Jugador> jugadores;
    int posicion;
    Jugador jugadorActivo;
    Jugador jugadorInactivo;
    
    public Juego() {
    	this.jugadores = new ArrayList<Jugador>();
    	this.inicializarJugadores();
    	this.posicion = new Random().nextInt(2);
    	this.siguienteTurno();
    	
	}
    
    private void inicializarJugadores() {
    	Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		LadoDelCampo lado1 = new LadoDelCampo();
		LadoDelCampo lado2 = new LadoDelCampo();
		lado1.setOtroLado(lado2);
		lado2.setOtroLado(lado1);
		
		lado1.setJugador(jugador1);
		lado2.setJugador(jugador2);
		
		jugador1.setLado(lado1);
		jugador2.setLado(lado2);
		
		jugador1.agregarCartasALaMano();
		jugador2.agregarCartasALaMano();
		
		this.jugadores.add(jugador1);
		this.jugadores.add(jugador2);
		
    }
    
    public void siguienteTurno() {    	

    	this.posicion = (this.posicion + 1) % this.jugadores.size();
    	this.jugadorActivo = jugadores.get(this.posicion);
    	this.posicion = (this.posicion + 1) % this.jugadores.size();
    	this.jugadorInactivo = jugadores.get(this.posicion);
    	
    }
    
    public Jugador getJugadorActivo() {
    	return this.jugadorActivo;
    }
    public Jugador getJugadorInactivo() {
    	return this.jugadorInactivo;
    }

    public Jugador getJugadorInferior() {
		return jugadores.get(0);
	}
    public Jugador getJugadorSuperior() {
		return jugadores.get(1);
	}
    
	
}
