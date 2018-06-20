package fiuba.algo3.tp2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.tp2.factories.FabricaCartaMonstruo;

public class SegundaEntregaTest {
	
	@Test
	public void testCartaWastelandAumenta200PuntosAtaqueMonstruosPropiosY300PuntosDefensaMonstruosOponente() {
		
	}
	
	@Test
	public void testCrearCartaMonstruoDebilConFactory() {
		Monstruo Dragon = FabricaCartaMonstruo.DROGON.crear();

		assertTrue(Dragon.estaEnModoAtaque());
		assertTrue(Dragon.estaBocaAbajo());
		
		assertTrue(Dragon.esDebil());
		assertFalse(Dragon.esNormal());
		assertFalse(Dragon.esPoderoso());
	}
	@Test
	public void testCrearCartaMonstruoNormalConFactory() {
		Monstruo magoOscuro = FabricaCartaMonstruo.MAGOOSCURO.crear();

		assertTrue(magoOscuro.estaEnModoAtaque());
		assertTrue(magoOscuro.estaBocaAbajo());
		

		assertFalse(magoOscuro.esDebil());
		assertTrue(magoOscuro.esNormal());
		assertFalse(magoOscuro.esPoderoso());
		
	}

	@Test
	public void testCrearCartaMonstruoPoderosoConFactory() {
		Monstruo dragonDefinitivo = FabricaCartaMonstruo.DROGONDEFINITIVO.crear();

		assertTrue(dragonDefinitivo.estaEnModoAtaque());
		assertTrue(dragonDefinitivo.estaBocaAbajo());
		
		assertFalse(dragonDefinitivo.esDebil());
		assertFalse(dragonDefinitivo.esNormal());
		assertTrue(dragonDefinitivo.esPoderoso());
	}

}
