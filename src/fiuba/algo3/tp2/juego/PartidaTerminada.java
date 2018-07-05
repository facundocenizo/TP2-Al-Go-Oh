package fiuba.algo3.tp2.juego;

public class PartidaTerminada implements EstadoDeJuego {
	
	private Jugador ganador;
	private String motivo;
	
	public PartidaTerminada(Jugador jugador, String motivo) {
		this.ganador = jugador;
		this.motivo = motivo;
	}

	@Override
	public boolean hayGanador() {
		return true;
	}

	@Override
	public Jugador siguienteTurno() {
		return null;
	}

	@Override
	public void terminarTurno() {
		System.out.println("Juego terminado");
	}

	@Override
	public String darNombreGanador() {
		return this.ganador.darNombre();
	}
	
	@Override
	public String darMotivoGanador() {
		return this.motivo;
	}

	@Override
	public Jugador getJugadorActivo() {
		return null;
	}

	@Override
	public Jugador getJugadorInactivo() {
		return null;
	}
}
