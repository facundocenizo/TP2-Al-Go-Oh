package fiuba.algo3.tp2.segundaEntrega;

import org.junit.Test;

import fiuba.algo3.tp2.Juego;
import fiuba.algo3.tp2.Jugador;

public class MazoTest {

	@Test
	public void FinalizaElJuegoCuandoSeAcabanLasCartasDelMazo() {

		Juego juego = new Juego();
		Jugador jugador = juego.siguienteTurno();

		//for(int i= 0; i<38 ; i++)
			jugador.tomarCartaDelMazo();
		
		juego.terminarTurno();
		//assert
		
		
	
	}
}
