package fiuba.algo3.tp2.segundaEntrega;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.LadoDelCampo;
import fiuba.algo3.tp2.Magica;
import fiuba.algo3.tp2.Monstruo;
import fiuba.algo3.tp2.fabricas.FabricaCartaMagica;
import fiuba.algo3.tp2.fabricas.FabricaCartaMonstruo;

public class CartaFisuraTest {

	@Test
	public void activarFisuraDestruyeElMonstruoConMenorPuntosDeAtaqueDelOponente() {
		
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
		

		Magica fisura = FabricaCartaMagica.FISURA.crear();
		
		Monstruo huevoMonstruoso = FabricaCartaMonstruo.HUEVOMONSTRUOSO.crear();
		Monstruo insectoComeHombres = FabricaCartaMonstruo.INSECTOCOMEHOMBRES.crear();
		
		jugador2.colocarCarta(huevoMonstruoso);
		jugador2.colocarCarta(insectoComeHombres);
	
		assertTrue(jugador1.verMonstruosRivales().contains(huevoMonstruoso));
		assertTrue(jugador1.verMonstruosRivales().contains(insectoComeHombres));
			
		jugador1.colocarCarta(fisura);
		jugador1.activarMagicaEnCampo(fisura);
		
		assertTrue(jugador1.verMonstruosRivales().contains(huevoMonstruoso));
		assertFalse(jugador1.verMonstruosRivales().contains(insectoComeHombres));
		
		
		
	}
}
