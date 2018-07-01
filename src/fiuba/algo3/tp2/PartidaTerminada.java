package fiuba.algo3.tp2;

public class PartidaTerminada implements EstadoDeJuego {
	
	private Jugador ganador;
	
	public PartidaTerminada(Jugador jugador) {
		this.ganador = jugador;
	}

	@Override
	public boolean hayGanador() {
		return true;
	}

	@Override
	public Jugador siguienteTurno() {
		// Deberia tirar excepcion de PartidaTerminadaException
		return null;
	}

	@Override
	public Jugador terminarTurno() {
		// Deberia tirar excepcion de PartidaTerminadaExceptio
		System.out.println("El juego termino Scooby Doo Papa");
		return null;
	}

	@Override
	public String darNombreGanador() {
		return this.ganador.darNombre();
	}

	@Override
	public Jugador getJugadorInferior() {
		// Deberia tirar excepcion de PartidaTerminadaException
		return null;
	}

	@Override
	public Jugador getJugadorSuperior() {
		// Deberia tirar excepcion de PartidaTerminadaException
		return null;
	}

}
