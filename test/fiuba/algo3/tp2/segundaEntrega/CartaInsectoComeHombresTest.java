package fiuba.algo3.tp2.segundaEntrega;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.tp2.cartas.Monstruo;
import fiuba.algo3.tp2.fabricas.FabricaCartaMonstruo;
import fiuba.algo3.tp2.juego.Jugador;
import fiuba.algo3.tp2.juego.LadoDelCampo;

public class CartaInsectoComeHombresTest {
	
	@Test
	public void testMonstruoInsectoComeHombresDestruyeLaCartaQueLoVolteaAlSerAtacado() {
		
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
		
		Monstruo insectoComeHombres = FabricaCartaMonstruo.INSECTOCOMEHOMBRES.crear();
		Monstruo dragonComun = FabricaCartaMonstruo.DRAGON.crear();
		
		jugador1.colocarCarta(insectoComeHombres);
		jugador2.colocarCarta(dragonComun);
		
		jugador2.atacar(dragonComun,insectoComeHombres);


		assertTrue(jugador1.verMonstruosRivales().get(0).estaMuerta());
		assertEquals(8000, jugador1.darVida());
		assertEquals(8000, jugador2.darVida());
	}	

}
