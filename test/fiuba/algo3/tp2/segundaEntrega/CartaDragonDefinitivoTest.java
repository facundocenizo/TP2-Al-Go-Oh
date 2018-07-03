package fiuba.algo3.tp2.segundaEntrega;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.tp2.Juego;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.cartas.Monstruo;
import fiuba.algo3.tp2.fabricas.FabricaCartaMonstruo;

public class CartaDragonDefinitivoTest {

		@Test
		public void SeRequiereSacrificarTresDragonesBlancosParaPonerUnDragonDefinitivo() {
			
			Juego juego = new Juego();
			
			Monstruo huevo1 = FabricaCartaMonstruo.HUEVOMONSTRUOSO.crear();
			Monstruo huevo2 = FabricaCartaMonstruo.HUEVOMONSTRUOSO.crear();
			Monstruo huevo3 = FabricaCartaMonstruo.HUEVOMONSTRUOSO.crear();
			Monstruo huevo4 = FabricaCartaMonstruo.HUEVOMONSTRUOSO.crear();
			Monstruo huevo5 = FabricaCartaMonstruo.HUEVOMONSTRUOSO.crear();
			Monstruo huevo6 = FabricaCartaMonstruo.HUEVOMONSTRUOSO.crear();
			Monstruo dragonBlanco1 = FabricaCartaMonstruo.DRAGONBLANCO.crear();
			Monstruo dragonBlanco2 = FabricaCartaMonstruo.DRAGONBLANCO.crear();
			Monstruo dragonBlanco3 = FabricaCartaMonstruo.DRAGONBLANCO.crear();

			Monstruo dragonDefinitivo = FabricaCartaMonstruo.DRAGONDEFINITIVO.crear();
			
			Jugador jugador1 = juego.siguienteTurno();

			jugador1.colocarCarta(huevo1);
			jugador1.colocarCarta(huevo2);
			jugador1.colocarCarta(dragonBlanco1);
			jugador1.terminarTurno();

			assertTrue(huevo1.estaMuerta());
			assertTrue(huevo2.estaMuerta());
			
			
			jugador1.colocarCarta(huevo3);
			jugador1.colocarCarta(huevo4);
			jugador1.colocarCarta(dragonBlanco2);
			jugador1.terminarTurno();

			assertTrue(huevo3.estaMuerta());
			assertTrue(huevo4.estaMuerta());	
			
			jugador1.colocarCarta(huevo5);
			jugador1.colocarCarta(huevo6);
			jugador1.colocarCarta(dragonBlanco3);
			jugador1.terminarTurno();
			
			assertTrue(huevo5.estaMuerta());
			assertTrue(huevo6.estaMuerta());
			
			jugador1.colocarCarta(dragonDefinitivo);
			
			assertTrue(dragonBlanco1.estaMuerta());
			assertTrue(dragonBlanco2.estaMuerta());	
			assertTrue(dragonBlanco3.estaMuerta());
			
			
		}
	
		
		
		
}
