package fiuba.algo3.tp2.segundaEntrega;

import org.junit.Test;

import fiuba.algo3.tp2.CampoDeBatalla;
import fiuba.algo3.tp2.Magica;
import fiuba.algo3.tp2.Monstruo;
import fiuba.algo3.tp2.fabricas.FabricaCartaMagica;
import fiuba.algo3.tp2.fabricas.FabricaCartaMonstruo;

public class CartaFisuraTest {

	@Test
	public void activarFisuraDestruyeElMonstruoConMenorPuntosDeAtaqueDelOponente() {
		
		Magica fisura = FabricaCartaMagica.FISURA.crear();
		CampoDeBatalla campo = CampoDeBatalla.getInstance();
		
		Monstruo huevoMonstruoso = FabricaCartaMonstruo.HUEVOMONSTRUOSO.crear();
		Monstruo insectoComeHombres = FabricaCartaMonstruo.INSECTOCOMEHOMBRES.crear();
		
		//campo.recibirMonstruoDeJugador2(huevoMonstruoso);
		//ampo.recibirMonstruoDeJugador2(insectoComeHombres);
		
		//campo.recibirCartaMagicaDeJugador1(fisura, new BocaArriba);
		
		//como chequeo q no esta la carta en la zona del oponente?? "string getNombre()" en Monstruo?
		//campo.monstruosAtacables(); 
	}
}
