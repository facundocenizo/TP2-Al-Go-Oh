package fiuba.algo3.tp2.segundaEntrega;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.tp2.cartas.Magica;
import fiuba.algo3.tp2.fabricas.FabricaCartaMagica;
import fiuba.algo3.tp2.juego.Jugador;
import fiuba.algo3.tp2.juego.LadoDelCampo;

public class CartaOllaDeLaCodiciaTest {
	@Test
	public void activarOllaDeLaCodiciaAgregaDosCartasALaManoDelJugador() {

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
		
		Magica ollaDeLaCodicia = FabricaCartaMagica.OLLADELACODICIA.crear();
		
		int cantidadDeCartasEnMano = 0;
		
		assertEquals(jugador1.darCantidadCartasEnLaMano(), cantidadDeCartasEnMano);
		
		jugador1.colocarCarta(ollaDeLaCodicia);
		jugador1.activarMagicaEnCampo(ollaDeLaCodicia);

		int cantidadDeCartasEnManoEsperadas = 2;
		assertEquals(jugador1.darCantidadCartasEnLaMano(), cantidadDeCartasEnManoEsperadas);
			
	}
}
