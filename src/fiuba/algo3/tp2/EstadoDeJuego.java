package fiuba.algo3.tp2;

public interface EstadoDeJuego {
	public boolean hayGanador();
	public Jugador siguienteTurno();
	public Jugador terminarTurno();
	public String darNombreGanador();
	public Jugador getJugadorInferior();
	public Jugador getJugadorSuperior();
}
