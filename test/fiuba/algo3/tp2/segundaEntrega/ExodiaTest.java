package fiuba.algo3.tp2.segundaEntrega;

import org.junit.Test;

import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.atributosLadoDelCampo.MazoCartas;
import fiuba.algo3.tp2.cartas.Magica;
import fiuba.algo3.tp2.cartas.Monstruo;
import fiuba.algo3.tp2.fabricas.FabricaCartaMagica;
import fiuba.algo3.tp2.fabricas.FabricaCartaMonstruo;

public class ExodiaTest {

	@Test
	public void SeRequiereDosSacrificiosParaPonerUnMonstruoDeSieteOMasEstrellas() {


		//Juego juego = new Juego();	
		
		Jugador jugador = new Jugador(); //hacerlo turno activo.
		
	
		Monstruo cabeza = FabricaCartaMonstruo.CABEZAEXODIA.crear();
		Monstruo brazoDerecho = FabricaCartaMonstruo.BRAZODERECHO.crear();
		Monstruo brazoIzquierdo = FabricaCartaMonstruo.BRAZOIZQUIERDO.crear();
		Monstruo piernaIzquierda = FabricaCartaMonstruo.PIERNADERECHA.crear();
		Monstruo piernaDerecha = FabricaCartaMonstruo.PIERNAIZQUIERDA.crear();
		
		//jugador.agregarCartaALaMano(cabeza);
		//jugador.agregarCartaALaMano(brazoDerecho);
		//jugador.agregarCartaALaMano(brazoIzquierdo);
		//jugador.agregarCartaALaMano(piernaIzquierda);
		//jugador.agregarCartaALaMano(piernaDerecha);
				
		//assertTrue(juego.hayGanador());
	
	}
	
}
