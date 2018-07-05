package fiuba.algo3.tp2.segundaEntrega;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.tp2.cartas.Monstruo;
import fiuba.algo3.tp2.fabricas.FabricaCartaMonstruo;
import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.juego.Jugador;

public class AtacarAUnJugadorSinMonstruosEnElCampoRestaDirectamenteSusPuntosDeVidaTest {
	
	@Test
	public void AtacarAUnJugadorSinMonstruosEnElCampoRestaDirectamenteSusPuntosDeVida() {
		
		Juego juego = new Juego();
		
		Jugador jugador1 = juego.siguienteTurno();
		
		Monstruo huevo = FabricaCartaMonstruo.HUEVOMONSTRUOSO.crear();
	
		jugador1.colocarCarta(huevo);
		jugador1.atacar(huevo, null);
		
		juego.terminarTurno();
		Jugador jugador2 = juego.siguienteTurno();
		
		int vidaEsperada = 7400;
	
		assertEquals(vidaEsperada, jugador2.darVida());
	}

}
