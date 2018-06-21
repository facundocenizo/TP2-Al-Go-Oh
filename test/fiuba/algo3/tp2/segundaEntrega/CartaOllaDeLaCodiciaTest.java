package fiuba.algo3.tp2.segundaEntrega;

import org.junit.Test;

import fiuba.algo3.tp2.CampoDeBatalla;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Magica;
import fiuba.algo3.tp2.fabricas.FabricaCartaMagica;

public class CartaOllaDeLaCodiciaTest {

	@Test
	public void activarOllaDeLaCodiciaAgregaDosCartasALaManoDelJugador() {
		
		Magica ollaDeLaCodicia = FabricaCartaMagica.OLLADELACODICIA.crear();
		Jugador jugador = new Jugador(); //hacerlo turno activo.
		CampoDeBatalla campo = CampoDeBatalla.getInstance();
		
		//campo.agregarCartaMagica(ollaDeLaCodicia, new BocaArriba);
		
		int cantidadDeCartasASumarPorEfecto = 2;
		//int cantidadDeCartasActual = jugador.cantidadDeCartasEnLaMano();
		//int cantidadDeCartasFinal = jugador.cantidadDeCartasEnLaMano() + cantidadDeCartasASumarPorEfecto;
		
		//assertEquals(cantidadDeCartasFinal, jugador.cantidadDeCartasEnLaMano())
			
	}
}
