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
    	return jugadores.get(this.posicion);
	}

	@Override
	public Jugador terminarTurno() {
		for(Jugador jugador : jugadores)
			jugador.terminarTurno();
		return this.siguienteTurno();
	}

	@Override
	public String darNombreGanador() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
    public Jugador getJugadorInferior() {
		return jugadores.get(0);
	}
	
	@Override
    public Jugador getJugadorSuperior() {
		return jugadores.get(1);
	}

}
