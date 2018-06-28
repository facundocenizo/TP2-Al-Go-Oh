package fiuba.algo3.tp2.segundaEntrega;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.tp2.CartaCampo;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.LadoDelCampo;
import fiuba.algo3.tp2.Monstruo;
import fiuba.algo3.tp2.Trampa;
import fiuba.algo3.tp2.fabricas.FabricaCartaCampo;
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
 
        // El monstruo atacado gana 500 puntos de ataque por lo que se le resta 100 puntos de vida
        // al jugador enemigo
        int vidaEsperada = 8000-100;

        assertEquals(vidaEsperada, jugadorEnemigo.vida());
	}
}
