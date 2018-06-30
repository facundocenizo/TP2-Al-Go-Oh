package fiuba.algo3.tp2.segundaEntrega;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.tp2.Juego;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.cartas.Monstruo;
import fiuba.algo3.tp2.fabricas.FabricaCartaMonstruo;

public class AtacarAUnJugadorSinMonstruosEnElCampoRestaDirectamenteSusPuntosDeVidaTest {
	
	@Test
	public void AtacarAUnJugadorSinMonstruosEnElCampoRestaDirectamenteSusPuntosDeVida() {
		
		Juego juego = new Juego();
		
		Jugador jugador1 = juego.siguienteTurno();
		
		Monstruo huevo = FabricaCartaMonstruo.HUEVOMONSTRUOSO.crear();
	
		jugador1.colocarCarta(huevo);
		jugador1.atacar(huevo, null);
		
		Jugador jugador2 = juego.terminarTurno();
		
		// El monstruo huevo resta 600 puntos de vida al oponente ya que este no tiene ningun monstruo en el campo
		int vidaEsperada = 7400;
	
		assertEquals(vidaEsperada, jugador2.darVida());
	}

}
