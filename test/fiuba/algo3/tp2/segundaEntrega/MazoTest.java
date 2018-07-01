package fiuba.algo3.tp2.segundaEntrega;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;

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

		for(int i= 0; i<35 ; i++) {
			jugador.tomarCartaDelMazo();
			cartasDelJugador = jugador.darCartasDeLaMano();
			
			for(Carta carta : cartasDelJugador) {
				if(carta.esParteExodia()) {
					jugador.colocarCarta((Monstruo) carta);
					//cuando encuentra una carta del tipo exodia deja de buscar cartas en la mano.
					break;
				}
			}
		}
	
		
		//chequeamos que este jugador No gano, por lo tanto perdio
		assertFalse(jugador.haGanado());

		jugador = juego.terminarTurno(); //cambia el jugador
		
		// y que el juego tiene un ganador que es el oponente.
		assertTrue(juego.hayGanador());
		assertTrue(jugador.haGanado());

	
	}
	
	@Test
	public void finJuegoTest() {
	
		Juego juego = new Juego();
		Jugador jugador1 = juego.siguienteTurno();
		
		ArrayList<Carta> cartas = jugador1.darCartasDeLaMano();
		//recorrer cartas y buscar una del tipo monstruo (xq puede ser trampa magica etc)
		// o sino le podemos asignar una carta asi:
		//Monstruo huevoMonstruoso = FabricaCartaMonstruo.HUEVO.crear();
		//jugador1.agregarCartaALaMano(huevoMonstruoso);
		
	}
	
	
}
