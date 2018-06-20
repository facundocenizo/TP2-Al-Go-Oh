package fiuba.algo3.tp2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.tp2.factories.FabricaMonstruos;

public class SegundaEntregaTest {
	
	@Test
	public void testCartaWastelandAumenta200PuntosAtaqueMonstruosPropiosY300PuntosDefensaMonstruosOponente() {
		
	}
	
	@Test
	public void testCrearCartaMonstruoDebilConFactory() {
		Monstruo Drogon = FabricaMonstruos.DROGON.crear();

		assertTrue(Drogon.estaEnModoAtaque());
		assertTrue(Drogon.estaBocaAbajo());
		
		assertTrue(Drogon.esDebil());
		assertFalse(Drogon.esNormal());
		assertFalse(Drogon.esPoderoso());
	}
	@Test
	public void testCrearCartaMonstruoNormalConFactory() {
		Monstruo Drogon = FabricaMonstruos.MAGOOSCURO.crear();

		assertTrue(Drogon.estaEnModoAtaque());
		assertTrue(Drogon.estaBocaAbajo());
		

		assertFalse(Drogon.esDebil());
		assertTrue(Drogon.esNormal());
		assertFalse(Drogon.esPoderoso());
		
	}

	@Test
	public void testCrearCartaMonstruoPoderosoConFactory() {
		Monstruo Drogon = FabricaMonstruos.DROGONDEFINITIVO.crear();

		assertTrue(Drogon.estaEnModoAtaque());
		assertTrue(Drogon.estaBocaAbajo());
		
		assertFalse(Drogon.esDebil());
		assertFalse(Drogon.esNormal());
		assertTrue(Drogon.esPoderoso());
	}

}
