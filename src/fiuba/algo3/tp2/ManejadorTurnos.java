package fiuba.algo3.tp2;

import java.util.List;
import java.util.Random;

public class ManejadorTurnos {
	
	private List<Jugador> jugadores;

	public ManejadorTurnos(Jugador jugador1, Jugador jugador2) {
		this.jugadores.add(jugador1);
		this.jugadores.add(jugador2);
	}
	
	public void jugar() {
		Jugador jugadorQueEmpieza = jugadores.get(new Random().nextInt(2));
		jugadorQueEmpieza.jugarTurno();
		siguienteTurno(jugadorQueEmpieza);
	}

	private void siguienteTurno(Jugador jugadorAnterior) {
		
		
		
		if (jugadores.get(0)==jugadorAnterior) {
			jugadores.get(1).jugarTurno();
			siguienteTurno(jugadores.get(1));
		}
		jugadores.get(0).jugarTurno();
		siguienteTurno(jugadores.get(0));
	}

}
