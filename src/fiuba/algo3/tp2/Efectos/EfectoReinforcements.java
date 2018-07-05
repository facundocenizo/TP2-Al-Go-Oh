package fiuba.algo3.tp2.Efectos;

import fiuba.algo3.tp2.LadoDelCampo;
import fiuba.algo3.tp2.atributosCarta.Efecto;
import fiuba.algo3.tp2.cartas.Monstruo;

public class EfectoReinforcements implements Efecto {

	@Override
	public void aplicarEfecto(LadoDelCampo propio, LadoDelCampo rival) {
	}

	@Override
	public void aplicarEfecto(Monstruo atacante, Monstruo atacado) {
		atacado.aumentarPuntosDeAtaque(500);		
		atacante.atacar(atacado);
		atacado.aumentarPuntosDeAtaque(-500);
	}

	

}
