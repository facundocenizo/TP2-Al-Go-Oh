package fiuba.algo3.tp2.segundaEntrega;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.tp2.cartas.Monstruo;
import fiuba.algo3.tp2.fabricas.FabricaCartaMonstruo;

public class FabricaMonstruoTest {
	
	
	@Test
	public void testCrearCartaMonstruoDebilConFactory() {
		Monstruo Dragon = FabricaCartaMonstruo.DRAGON.crear();

		assertTrue(Dragon.estaEnModoAtaque());
		assertFalse(Dragon.estaBocaAbajo());
		
		assertTrue(Dragon.esDebil());
		assertFalse(Dragon.esNormal());
		assertFalse(Dragon.esPoderoso());
	}
	@Test
	public void testCrearCartaMonstruoNormalConFactory() {
		Monstruo magoOscuro = FabricaCartaMonstruo.MAGOOSCURO.crear();

		assertTrue(magoOscuro.estaEnModoAtaque());
		assertFalse(magoOscuro.estaBocaAbajo());
		

		assertFalse(magoOscuro.esDebil());
		assertTrue(magoOscuro.esNormal());
		assertFalse(magoOscuro.esPoderoso());
		
	}

	@Test
	public void testCrearCartaMonstruoPoderosoConFactory() {
		Monstruo dragonDefinitivo = FabricaCartaMonstruo.DRAGONDEFINITIVO.crear();

		assertTrue(dragonDefinitivo.estaEnModoAtaque());
		assertFalse(dragonDefinitivo.estaBocaAbajo());
		
		assertFalse(dragonDefinitivo.esDebil());
		assertFalse(dragonDefinitivo.esNormal());
		assertTrue(dragonDefinitivo.esPoderoso());
	}

}
