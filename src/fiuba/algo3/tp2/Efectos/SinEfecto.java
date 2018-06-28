package fiuba.algo3.tp2.Efectos;

import fiuba.algo3.tp2.LadoDelCampo;
import fiuba.algo3.tp2.atributosCarta.Efecto;
import fiuba.algo3.tp2.cartas.Monstruo;

public class SinEfecto implements Efecto, EfectoDefensa {

	@Override
	public void aplicarEfecto(LadoDelCampo propio, LadoDelCampo rival) {
		// No hay efecto que aplicar
	}

	@Override
	public void aplicarEfecto(Monstruo atacante, Monstruo atacado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean tieneEfectoDefensa() {
		return false;
	}

}
