package fiuba.algo3.tp2.atributosMonstruo;

import java.util.ArrayList;

import fiuba.algo3.tp2.cartas.Monstruo;

public class Debil implements Nivel {

	@Override
	public boolean esDebil() {
		return true;
	}

	@Override
	public boolean esNormal() {
		return false;
	}

	@Override
	public boolean esPoderoso() {
		return false;
	}

	@Override
	public void manejarSacrificiosPorEsteMonstruo(ArrayList<Monstruo> zonaMonstruos) {
	}

	@Override
	public boolean esDragonDefinitivo() {
		return false;
	}

}
