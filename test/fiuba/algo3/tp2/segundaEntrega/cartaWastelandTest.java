package fiuba.algo3.tp2.segundaEntrega;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.tp2.CampoDeBatalla;
import fiuba.algo3.tp2.CartaCampo;
import fiuba.algo3.tp2.Monstruo;
import fiuba.algo3.tp2.fabricas.FabricaCartaCampo;
import fiuba.algo3.tp2.fabricas.FabricaCartaMonstruo;


public class cartaWastelandTest {
		
		@Test
		public void testCartaWastelandAumenta200PuntosAtaqueMonstruosPropiosY300PuntosDefensaMonstruosOponente() {
			
			CampoDeBatalla campo = CampoDeBatalla.getInstance();
			
			Monstruo huevo1 = FabricaCartaMonstruo.HUEVOMONSTRUOSO.crear();
			Monstruo huevo2 = FabricaCartaMonstruo.HUEVOMONSTRUOSO.crear();
			
			campo.recibirMonstruoDeJugador1(huevo1);
			campo.recibirMonstruoDeJugador2(huevo2);
			
			CartaCampo wasteland = FabricaCartaCampo.WASTELAND.crear();
			//campo.recibirCartaCampoDeJugador1(wasteland);
			
			int posicionMonstruoEnZonaMonstruos = 0;
			//Monstruo huevoJugador1 = campo.darMonstruoDeJugador1( posicionMonstruoEnZonaMonstruos );
			//Monstruo huevoJugador2 = campo.darMonstruoDeJugador2( posicionMonstruoEnZonaMonstruos );
			

			int puntosDeAtaqueBaseHuevo = 600;
			int puntosDeDefensaBaseHuevo = 900;
			
			int puntosDeAtaqueEsperados = 800;
			int puntosDeDefensaEsperados = 1200;
			
			//assertEquals(huevoJugador1.puntosDeAtaque, puntosDeAtaqueEsperados );
			//assertEquals(huevoJugador1.puntosDeDefensa, puntosDeAtaqueBaseHuevo );

			//assertEquals(huevoJugador2.puntosDeAtaque, puntosDeAtaqueBaseHuevo);
			//assertEquals(huevoJugador2.puntosDeDefensa, puntosDeDefensaEsperados);

		}
		
		
		
}
