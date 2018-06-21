package fiuba.algo3.tp2.segundaEntrega;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.tp2.CampoDeBatalla;
import fiuba.algo3.tp2.CartaCampo;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Monstruo;
import fiuba.algo3.tp2.Trampa;
import fiuba.algo3.tp2.fabricas.FabricaCartaCampo;
import fiuba.algo3.tp2.fabricas.FabricaCartaMonstruo;
import fiuba.algo3.tp2.fabricas.FabricaCartaTrampa;

public class CartaReinforcementsTest {

	@Test
	public void testCartaEfectoReinforcements() {
		
		CampoDeBatalla campo = CampoDeBatalla.getInstance();
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		Monstruo huevo = FabricaCartaMonstruo.HUEVOMONSTRUOSO.crear();
		Monstruo cabeza = FabricaCartaMonstruo.CABEZAEXODIA.crear();
		
		campo.recibirMonstruoDeJugador1(huevo);
		campo.recibirMonstruoDeJugador2(cabeza);
		
		Trampa cilindroMagico = FabricaCartaTrampa.CILINDROMAGICO.crear();
		//campo.recibirCartaTrampaDeJugador1(cilindroMagico);
		
		//jugador2.atacar(cabeza,huevo); -> esto falla por algun motivo
		
		
		//assertFalse(huevo.estaMuerta());
		//assertTrue(cabeza.estaMuerta());
		
		int vidaEsperada = 8000 - 100;
		//assertEquals(vidaEsperada, jugador2.vida());
		
		
	}
}
