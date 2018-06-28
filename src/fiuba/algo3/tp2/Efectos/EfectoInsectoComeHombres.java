package fiuba.algo3.tp2.Efectos;

import fiuba.algo3.tp2.LadoDelCampo;
import fiuba.algo3.tp2.atributosCarta.Efecto;
import fiuba.algo3.tp2.cartas.Monstruo;

public class EfectoInsectoComeHombres implements Efecto, EfectoDefensa {
	
	private boolean aplicado = false;

	@Override
	public void aplicarEfecto(LadoDelCampo propio, LadoDelCampo rival) {
		// TODO Apéndice de método generado automáticamente
		
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
		return true;
	}


}
