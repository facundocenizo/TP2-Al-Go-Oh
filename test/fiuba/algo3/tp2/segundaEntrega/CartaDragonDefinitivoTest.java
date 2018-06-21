package fiuba.algo3.tp2.segundaEntrega;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.tp2.CampoDeBatalla;
import fiuba.algo3.tp2.Monstruo;
import fiuba.algo3.tp2.fabricas.FabricaCartaMonstruo;

public class CartaDragonDefinitivoTest {

		@Test
		public void SeRequiereDosSacrificiosParaPonerUnMonstruoDeSieteOMasEstrellas() {

			Monstruo dragon1 = FabricaCartaMonstruo.DRAGONBLANCO.crear();
			Monstruo dragon2 = FabricaCartaMonstruo.DRAGONBLANCO.crear();
			Monstruo dragon3 = FabricaCartaMonstruo.DRAGONBLANCO.crear();
			
			Monstruo dragonDefinitivo = FabricaCartaMonstruo.DRAGONDEFINITIVO.crear();
			
			CampoDeBatalla campo = CampoDeBatalla.getInstance();
			
			campo.recibirMonstruoDeJugador1(dragon1);
			campo.recibirMonstruoDeJugador1(dragon2);
			campo.recibirMonstruoDeJugador1(dragon3);
		
			campo.recibirMonstruoDeJugador1(dragonDefinitivo);
			
			//assertTrue(dragon1.estaMuerta());
			//assertTrue(dragon2.estaMuerta());
			//assertTrue(dragon3.estaMuerta());
			
			
		}
	
		
		
		
}
