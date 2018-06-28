package fiuba.algo3.tp2.segundaEntrega;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.tp2.CartaCampo;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.LadoDelCampo;
import fiuba.algo3.tp2.Monstruo;
import fiuba.algo3.tp2.fabricas.FabricaCartaCampo;
import fiuba.algo3.tp2.fabricas.FabricaCartaMonstruo;

public class CartaSogenTest {

	@Test
	public void testCartaSogenAumenta500PuntosDefensaMonstruosPropiosY200PuntosAtaqueMonstruosOponente() {
		
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
		
		Monstruo dragonBlanco = FabricaCartaMonstruo.DRAGONBLANCO.crear();
		Monstruo dragonComun = FabricaCartaMonstruo.DRAGON.crear();
		
		jugador1.colocarCarta(dragonBlanco);
		jugador2.colocarCarta(dragonComun);

		
		CartaCampo sogen = FabricaCartaCampo.SOGEN.crear();
		jugador1.colocarCarta(sogen);
		jugador1.activarCartaCampo();
		
		int puntosDeAtaqueDelDragonComun = 400;
		int puntosDeDefensaDelDragonBlanco = 2500;
		
		assertEquals(puntosDeAtaqueDelDragonComun + 200,jugador1.verMonstruosRivales().get(0).darPuntosDeAtaque());
		assertEquals(puntosDeDefensaDelDragonBlanco + 500,jugador2.verMonstruosRivales().get(0).darPuntosDeDefensa());
		 
	
		
	}
}
