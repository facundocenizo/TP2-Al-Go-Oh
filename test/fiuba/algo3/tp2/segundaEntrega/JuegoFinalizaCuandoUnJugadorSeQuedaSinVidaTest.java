package fiuba.algo3.tp2.segundaEntrega;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.tp2.cartas.Monstruo;
import fiuba.algo3.tp2.fabricas.FabricaCartaMonstruo;
import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.juego.Jugador;

public class JuegoFinalizaCuandoUnJugadorSeQuedaSinVidaTest {
	
	@Test
	public void JuegoFinalizaCuandoUnJugadorSeQuedaSinVida() {
		
		Juego juego = new Juego();
		Monstruo huevo1 = FabricaCartaMonstruo.HUEVOMONSTRUOSO.crear();
		Monstruo huevo2 = FabricaCartaMonstruo.HUEVOMONSTRUOSO.crear();
		Monstruo dragonBlanco = FabricaCartaMonstruo.DRAGONBLANCO.crear();
		
		Jugador jugador1 = juego.siguienteTurno();
		
		jugador1.colocarCarta(huevo1);
		jugador1.colocarCarta(huevo2);
		jugador1.colocarCarta(dragonBlanco);
		
		jugador1.atacar(dragonBlanco, null);
		jugador1.atacar(dragonBlanco, null);
		jugador1.atacar(dragonBlanco, null);
		
		juego.terminarTurno();
		
		assertTrue(juego.hayGanador());
	}
	
}
