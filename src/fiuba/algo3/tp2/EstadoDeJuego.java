package fiuba.algo3.tp2;

public interface EstadoDeJuego {
	public boolean hayGanador();
	public Jugador siguienteTurno();
	public void terminarTurno();
	public Jugador getJugadorActivo();
	public Jugador getJugadorInactivo();
	public String darNombreGanador();
}
