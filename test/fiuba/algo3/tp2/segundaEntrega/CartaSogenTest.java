package fiuba.algo3.tp2.segundaEntrega;

import org.junit.Test;

import fiuba.algo3.tp2.CampoDeBatalla;
import fiuba.algo3.tp2.CartaCampo;
import fiuba.algo3.tp2.Monstruo;
import fiuba.algo3.tp2.fabricas.FabricaCartaCampo;
import fiuba.algo3.tp2.fabricas.FabricaCartaMonstruo;

public class CartaSogenTest {

	@Test
	public void testCartaSogenAumenta500PuntosDefensaMonstruosPropiosY200PuntosAtaqueMonstruosOponente() {
		
		CampoDeBatalla campo = CampoDeBatalla.getInstance();
		
		Monstruo huevo1 = FabricaCartaMonstruo.HUEVOMONSTRUOSO.crear();
		Monstruo huevo2 = FabricaCartaMonstruo.HUEVOMONSTRUOSO.crear();
		
		campo.recibirMonstruoDeJugador1(huevo1);
		campo.recibirMonstruoDeJugador2(huevo2);
		
		CartaCampo sogen = FabricaCartaCampo.SOGEN.crear();
		//campo.recibirCartaCampoDeJugador1(sogen);
		
		int posicionMonstruoEnZonaMonstruos = 0;
		//Monstruo huevoJugador1 = campo.darMonstruoDeJugador1( posicionMonstruoEnZonaMonstruos );
		//Monstruo huevoJugador2 = campo.darMonstruoDeJugador2( posicionMonstruoEnZonaMonstruos );
		
		
		int puntosDeAtaqueBaseHuevo = 600;
		int puntosDeDefensaBaseHuevo = 900;

		int puntosDeAtaqueEsperados = 800;
		int puntosDeDefensaEsperados = 1400;
		
		//assertEquals(huevoJugador1.puntosDeAtaque, puntosDeAtaqueBaseHuevo );
		//assertEquals(huevoJugador1.puntosDeDefensa, puntosDeDefensaEsperados );

		//assertEquals(huevoJugador2.puntosDeAtaque, puntosDeAtaqueEsperados);
		//assertEquals(huevoJugador2.puntosDeDefensa, puntosDeDefensaBaseHuevo);

	}
}
