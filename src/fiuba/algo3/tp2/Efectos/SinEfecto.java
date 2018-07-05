package fiuba.algo3.tp2.Efectos;

import fiuba.algo3.tp2.atributosCarta.Efecto;
import fiuba.algo3.tp2.cartas.Monstruo;
import fiuba.algo3.tp2.juego.LadoDelCampo;

public class SinEfecto implements Efecto, EfectoDefensa {

	@Override
	public void aplicarEfecto(LadoDelCampo propio, LadoDelCampo rival) {
	}

	@Override
	public void aplicarEfecto(Monstruo atacante, Monstruo atacado) {
	}

	@Override
	public boolean tieneEfectoDefensa() {
		return false;
	}

}
