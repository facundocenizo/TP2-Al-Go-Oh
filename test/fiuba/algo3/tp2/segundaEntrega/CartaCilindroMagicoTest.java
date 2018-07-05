package fiuba.algo3.tp2.segundaEntrega;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.tp2.cartas.Monstruo;
import fiuba.algo3.tp2.cartas.Trampa;
import fiuba.algo3.tp2.fabricas.FabricaCartaMonstruo;
import fiuba.algo3.tp2.fabricas.FabricaCartaTrampa;
import fiuba.algo3.tp2.juego.Jugador;
import fiuba.algo3.tp2.juego.LadoDelCampo;

public class CartaCilindroMagicoTest {
	@Test
	public void testCilindroMagicoSeActivaAlAtacarUnMonstruoDelLadoDondeEstaUbicada() {
		
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
		

		Monstruo atacante = FabricaCartaMonstruo.HUEVOMONSTRUOSO.crear();
        Monstruo atacado = FabricaCartaMonstruo.INSECTOCOMEHOMBRES.crear();
        Trampa cilindroMagico = FabricaCartaTrampa.CILINDROMAGICO.crear();
        
        atacado.aniadirObservador(jugador);
        cilindroMagico.aniadirObservador(jugador);
        atacante.aniadirObservador(jugadorEnemigo);
        jugador.colocarCarta(atacado);
        jugador.colocarCarta(cilindroMagico);
        jugadorEnemigo.colocarCarta(atacante);
        jugadorEnemigo.atacar(atacante, atacado);
 
        int vidaEsperada = 8000-600;
        
        assertEquals(vidaEsperada, jugadorEnemigo.darVida());
	}	
}
