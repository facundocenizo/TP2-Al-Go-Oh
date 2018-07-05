package fiuba.algo3.tp2.segundaEntrega;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import fiuba.algo3.tp2.Juego;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.cartas.Carta;
import fiuba.algo3.tp2.cartas.Monstruo;

public class MazoTest {
	
	@Test
	public void FinalizaElJuegoCuandoSeAcabanLasCartasDelMazo() {

		ArrayList<Carta> cartasDelJugador = new ArrayList<Carta>();
		Juego juego = new Juego();
		Jugador jugador = juego.siguienteTurno();

		for(int i= 0; i<34 ; i++) {
			jugador.tomarCartaDelMazo();
			cartasDelJugador = jugador.darCartasDeLaMano();
			
			for(Carta carta : cartasDelJugador) {
				if(carta.esParteExodia()) {
					jugador.colocarCarta((Monstruo) carta);
					break;
				}
			}
		}
	
		
		assertFalse(jugador.haGanado());
		
		juego.terminarTurno();
		
		assertTrue(juego.hayGanador());	
	}	
	
}
