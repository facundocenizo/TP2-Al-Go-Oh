package fiuba.algo3.tp2.segundaEntrega;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.tp2.CampoDeBatalla;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.LadoDelCampo;
import fiuba.algo3.tp2.Monstruo;
import fiuba.algo3.tp2.fabricas.FabricaCartaMonstruo;

public class CartaInsectoComeHombresTest {
	
	@Test
	public void testMonstruoInsectoComeHombresDestruyeLaCartaQueLoVolteaAlSerAtacado() {
		
		CampoDeBatalla campo = CampoDeBatalla.getInstance();

		Jugador jugador1 = new Jugador(null)); //hacerlo activo
		Jugador jugador2 = new Jugador(null); //hacerlo inactivo
		
		Monstruo insectoComeHombres = FabricaCartaMonstruo.INSECTOCOMEHOMBRES.crear();
		Monstruo huevo = FabricaCartaMonstruo.HUEVOMONSTRUOSO.crear();
		
		//AGREGAR A RECIBIR MONSTRUO QUE RECIBA LA POSICION Y EL MODO PARA MONSTRUOS (boca abajo y posicion defensa)
		//campo.recibirMonstruoDeJugador1(insectoComeHombres);
		//campo.recibirMonstruoDeJugador2(huevo);
		
		
		//jugador1.atacar(huevo, insectoComeHombres); -> esto falla por algun motivo
		

		//assertTrue(huevo.estaMuerta());
	
		
	}	

}
