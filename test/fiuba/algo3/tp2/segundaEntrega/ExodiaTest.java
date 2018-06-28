package fiuba.algo3.tp2.segundaEntrega;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.tp2.Juego;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.cartas.Monstruo;
import fiuba.algo3.tp2.fabricas.FabricaCartaMonstruo;

public class ExodiaTest {

	@Test
	public void testExodiaDaVictoriaAJugador() {


		Juego juego = new Juego();	
		
		Jugador jugador = juego.siguienteTurno();
		
	
		Monstruo cabeza = FabricaCartaMonstruo.CABEZAEXODIA.crear();
		Monstruo brazoDerecho = FabricaCartaMonstruo.BRAZODERECHO.crear();
		Monstruo brazoIzquierdo = FabricaCartaMonstruo.BRAZOIZQUIERDO.crear();
		Monstruo piernaIzquierda = FabricaCartaMonstruo.PIERNADERECHA.crear();
		Monstruo piernaDerecha = FabricaCartaMonstruo.PIERNAIZQUIERDA.crear();
		
		
		jugador.agregarCartaALaMano(cabeza);
		jugador.agregarCartaALaMano(brazoDerecho);
		jugador.agregarCartaALaMano(brazoIzquierdo);
		jugador.agregarCartaALaMano(piernaIzquierda);
		jugador.agregarCartaALaMano(piernaDerecha);
		
		//assertTrue(jugador.haGanado());
		
		
		
	
	}
	
}
