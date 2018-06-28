package fiuba.algo3.tp2.segundaEntrega;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.tp2.CampoDeBatalla;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.LadoDelCampo;
import fiuba.algo3.tp2.Monstruo;
import fiuba.algo3.tp2.fabricas.FabricaCartaMonstruo;

public class CartaDragonDefinitivoTest {

		@Test
		public void SeRequiereDosSacrificiosParaPonerUnMonstruoDeSieteOMasEstrellas() {
			
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
			
			Monstruo dragon1 = FabricaCartaMonstruo.DRAGONBLANCO.crear();
			Monstruo dragon2 = FabricaCartaMonstruo.DRAGONBLANCO.crear();
			
			Monstruo dragonDefinitivo = FabricaCartaMonstruo.DRAGONDEFINITIVO.crear();
			
			jugador1.colocarCarta(dragon1);
			jugador1.colocarCarta(dragon2);
			jugador1.colocarCarta(dragonDefinitivo);
			
			
			assertTrue(dragon1.estaMuerta());
			assertTrue(dragon2.estaMuerta());			
			
		}
	
		
		
		
}
