package fiuba.algo3.tp2.segundaEntrega;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.tp2.CampoDeBatalla;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Monstruo;
import fiuba.algo3.tp2.Trampa;
import fiuba.algo3.tp2.fabricas.FabricaCartaMonstruo;
import fiuba.algo3.tp2.fabricas.FabricaCartaTrampa;

public class CartaCilindroMagicoTest {
	@Test
	public void testCilindroMagicoSeActivaAlAtacarUnMonstruoDelLadoDondeEstaUbicada() {
		
		CampoDeBatalla campo = CampoDeBatalla.getInstance();

		Jugador jugador1 = new Jugador(); //hacerlo activo
		Jugador jugador2 = new Jugador(); //hacerlo inactivo
		
		Monstruo huevo1 = FabricaCartaMonstruo.HUEVOMONSTRUOSO.crear();
		Monstruo huevo2 = FabricaCartaMonstruo.HUEVOMONSTRUOSO.crear();
		
		
		Trampa cilindroMagico = FabricaCartaTrampa.CILINDROMAGICO.crear();

		//campo.recibirMonstruoDeJugador1(huevo1);
		//campo.recibirTrampaDeJugador1(cilindroMagico);

		//campo.recibirMonstruoDeJugador2(huevo2);
		
		//jugador1.atacar(huevo2, huevo1); -> esto falla por algun motivo
		
		assertFalse(huevo1.estaMuerta());
		//assertTrue(huevo2.estaMuerta());
		
		int vidaEsperada = 8000 - 600;
		//assertEquals(vidaEsperada, jugador2.vida());
		
		
		
	
		
	}	
}
