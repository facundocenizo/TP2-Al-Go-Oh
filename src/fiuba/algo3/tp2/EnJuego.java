package fiuba.algo3.tp2;

import java.util.ArrayList;
import java.util.Random;

public class EnJuego implements EstadoDeJuego {

	private ArrayList<Jugador> jugadores;
    private int posicion;
	
	public EnJuego(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
		this.posicion = new Random().nextInt(2);
    	this.siguienteTurno();
	}

	@Override
	public boolean hayGanador() {
		return false;
	}

	@Override
	public Jugador siguienteTurno() {
		this.posicion = (this.posicion + 1) % this.jugadores.size();
    	Jugador jugador = jugadores.get(this.posicion);
    	jugador.tomarCartaDelMazo();
    	return jugador;
	}

	@Override
	public void terminarTurno() {
		for(Jugador jugador : jugadores)
			jugador.terminarTurno();
	}

	@Override
	public Jugador getJugadorActivo() {
		return this.jugadores.get(this.posicion);
	}

	@Override
	public Jugador getJugadorInactivo() {
		return this.jugadores.get((this.posicion + 1) % this.jugadores.size());
	}

	@Override
	public String darNombreGanador() {
		// Deberia lanzar una excepcion de PartidaEnJuegoException
		return null;
	}
	
}
