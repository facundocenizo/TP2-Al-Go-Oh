package fiuba.algo3.tp2.segundaEntrega;

import org.junit.Test;

import fiuba.algo3.tp2.MazoCartas;

public class MazoTest {

	@Test
	public void FinalizaElJuegoCuandoSeAcabanLasCartasDelMazo() {

		//Juego juego = new Juego();
		
		MazoCartas mazo = new MazoCartas();
		for (int i = 0; i < 40; i++)
			mazo.sacarCarta();
		//mazo.sacarCarta(); -> esta la q cambia el booleano de juego.hayGanador()
		
		//assertTrue(juego.hayGanador());
	
	}
}
