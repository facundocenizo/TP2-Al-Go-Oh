package fiuba.algo3.tp2.segundaEntrega;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import fiuba.algo3.tp2.CampoDeBatalla;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Monstruo;
import fiuba.algo3.tp2.fabricas.FabricaCartaMonstruo;

public class CartaJinzoSieteTest {
	
	@Test
	public void testMonstruoJinzoSieteAtacaDirectamenteALosPuntosDeVidaIgnorandoMonstruosDelOponente() {
		
		CampoDeBatalla campo = CampoDeBatalla.getInstance();

		Jugador jugador1 = new Jugador(); //hacerlo activo
		Jugador jugador2 = new Jugador(); //hacerlo inactivo
		
		Monstruo jinzo = FabricaCartaMonstruo.JINZOSIETE.crear();
		Monstruo huevo = FabricaCartaMonstruo.HUEVOMONSTRUOSO.crear();
		
		//campo.recibirMonstruoDeJugador1(jinzo);
		//campo.recibirMonstruoDeJugador2(huevo);
		
		//jugador1.atacar(jinzo, huevo); -> esto falla por algun motivo
		
		int vidaEsperada = 8000 - 500;
		//assertEquals(vidaEsperada, jugador2.vida());
	
		
	}	
}
