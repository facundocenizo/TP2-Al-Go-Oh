package fiuba.algo3.tp2.Efectos;

import fiuba.algo3.tp2.atributosCarta.Efecto;
import fiuba.algo3.tp2.cartas.Monstruo;
import fiuba.algo3.tp2.juego.LadoDelCampo;

public class EfectoInsectoComeHombres implements Efecto, EfectoDefensa {
	
	private boolean aplicado = false;

	@Override
	public void aplicarEfecto(LadoDelCampo propio, LadoDelCampo rival) {
	}

	@Override
	public void aplicarEfecto(Monstruo atacante, Monstruo atacado) {
		if (!aplicado) {
			atacante.morir();
			this.aplicado = true;
		}
	}

	@Override
	public boolean tieneEfectoDefensa() {
		if (!aplicado) {
			return true;
		}
		return false;
	}


}
