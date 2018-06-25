package fiuba.algo3.tp2.segundaEntrega;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.tp2.CampoDeBatalla;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.LadoDelCampo;
import fiuba.algo3.tp2.Magica;
import fiuba.algo3.tp2.Monstruo;
import fiuba.algo3.tp2.Trampa;
import fiuba.algo3.tp2.fabricas.FabricaCartaMagica;
import fiuba.algo3.tp2.fabricas.FabricaCartaMonstruo;
import fiuba.algo3.tp2.fabricas.FabricaCartaTrampa;

public class CartaCilindroMagicoTest {
	@Test
	public void testCilindroMagicoSeActivaAlAtacarUnMonstruoDelLadoDondeEstaUbicada() {
		
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		LadoDelCampo lado1 = new LadoDelCampo();
		LadoDelCampo lado2 = new LadoDelCampo();
		lado1.setOtroLado(lado2);
		lado2.setOtroLado(lado1);
		
		lado1.setJugador(jugador1);
		lado2.setJugador(jugador2);
		
		jugador1.setLado(lado1);
		jugador2.setLado(lado2);
		

		Monstruo huevo1 = FabricaCartaMonstruo.HUEVOMONSTRUOSO.crear();
        Monstruo huevo2 = FabricaCartaMonstruo.HUEVOMONSTRUOSO.crear();

        Trampa cilindroMagico = FabricaCartaTrampa.CILINDROMAGICO.crear();
        
       // jugador1.colocarCarta(huevoMonstruoso);
       // jugador2.colocarCarta(huevoMonstruoso);
       //  jugador1.colocarCarta(cilindroMagico);
       // jugador2.atacar(huevoMonstruoso1, huevoMonstruoso2);
		
	//	assertTrue(jugador1.verMonstruosRivales().contains(huevoMonstruoso));
//		assertTrue(jugador1.verMonstruosRivales().contains(insectoComeHombres));
				
	}	
}
