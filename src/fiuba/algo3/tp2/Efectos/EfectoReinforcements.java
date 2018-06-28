package fiuba.algo3.tp2.Efectos;

import cartas.Monstruo;
import fiuba.algo3.tp2.LadoDelCampo;
import fiuba.algo3.tp2.atributosCarta.Efecto;

public class EfectoReinforcements implements Efecto {

	@Override
	public void aplicarEfecto(LadoDelCampo propio, LadoDelCampo rival) {
		// TODO Apéndice de método generado automáticamente
		
	}

	@Override
	public void aplicarEfecto(Monstruo atacante, Monstruo atacado) {
		atacado.aumentarPuntosDeAtaque(500);		
		atacante.atacar(atacado);
	}

	

}
