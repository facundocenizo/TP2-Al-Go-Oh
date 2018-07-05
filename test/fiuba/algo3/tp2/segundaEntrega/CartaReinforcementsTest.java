package fiuba.algo3.tp2.segundaEntrega;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.LadoDelCampo;
import fiuba.algo3.tp2.cartas.Monstruo;
import fiuba.algo3.tp2.cartas.Trampa;
import fiuba.algo3.tp2.fabricas.FabricaCartaMonstruo;
import fiuba.algo3.tp2.fabricas.FabricaCartaTrampa;

public class CartaReinforcementsTest {

	@Test
	public void testCartaEfectoReinforcements() {
		
		Jugador jugador = new Jugador();
		Jugador jugadorEnemigo = new Jugador();
		LadoDelCampo lado = new LadoDelCampo();
		LadoDelCampo ladoEnemigo = new LadoDelCampo();
		lado.setOtroLado(ladoEnemigo);
		ladoEnemigo.setOtroLado(lado);
		lado.setJugador(jugador);
		ladoEnemigo.setJugador(jugadorEnemigo);
		jugador.setLado(lado);
		jugadorEnemigo.setLado(ladoEnemigo);
		
		Monstruo atacante = FabricaCartaMonstruo.CABEZAEXODIA.crear();
        Monstruo atacado = FabricaCartaMonstruo.HUEVOMONSTRUOSO.crear();
        Trampa reinforcements = FabricaCartaTrampa.REINFORCEMENTS.crear();
        
        atacado.aniadirObservador(jugador);
        reinforcements.aniadirObservador(jugador);
        atacante.aniadirObservador(jugadorEnemigo);
        jugador.colocarCarta(atacado);
        jugador.colocarCarta(reinforcements);
        jugadorEnemigo.colocarCarta(atacante);
        jugadorEnemigo.atacar(atacante, atacado);
 
        int vidaEsperada = 8000-100;

        assertEquals(vidaEsperada, jugadorEnemigo.darVida());
	}
}
