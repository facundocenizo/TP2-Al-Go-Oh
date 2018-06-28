package fiuba.algo3.tp2.segundaEntrega;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cartas.Magica;
import cartas.Monstruo;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.LadoDelCampo;
import fiuba.algo3.tp2.fabricas.FabricaCartaMagica;
import fiuba.algo3.tp2.fabricas.FabricaCartaMonstruo;

public class cartaAgujeroNegroTest {

	@Test
	public void activarAgujeroNegroDestruyeTodosLosMonstruosDelCampo() {
		
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
		

		Magica agujeroNegro = FabricaCartaMagica.AGUJERONEGRO.crear();
		
		Monstruo huevoMonstruoso = FabricaCartaMonstruo.HUEVOMONSTRUOSO.crear();
		Monstruo insectoComeHombres = FabricaCartaMonstruo.INSECTOCOMEHOMBRES.crear();
		
		jugador1.colocarCarta(huevoMonstruoso);
		jugador2.colocarCarta(insectoComeHombres);

		
		assertTrue(jugador1.verMonstruosRivales().contains(insectoComeHombres));
		assertTrue(jugador2.verMonstruosRivales().contains(huevoMonstruoso));
		
		jugador1.colocarCarta(agujeroNegro);
		jugador1.activarMagicaEnCampo(agujeroNegro);
		
		assertTrue(jugador1.verMonstruosRivales().isEmpty());
		assertTrue(jugador2.verMonstruosRivales().isEmpty());
		
	}	
}
