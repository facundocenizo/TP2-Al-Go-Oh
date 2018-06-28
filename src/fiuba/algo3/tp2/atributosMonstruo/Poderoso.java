package fiuba.algo3.tp2.atributosMonstruo;

import java.util.ArrayList;

import fiuba.algo3.tp2.cartas.Monstruo;
import fiuba.algo3.tp2.excepciones.CartasMonstruosInsuficientesParaSacrificio;

public class Poderoso implements Nivel {

	@Override
	public boolean esDebil() {
		return false;
	}

	@Override
	public boolean esNormal() {
		return false;
	}

	@Override
	public boolean esPoderoso() {
		return true;
	}

	@Override
	public void manejarSacrificiosPorEsteMonstruo(ArrayList<Monstruo> zonaMonstruos) {
		if (zonaMonstruos.size() < 2) {
			throw new CartasMonstruosInsuficientesParaSacrificio();
		}
		zonaMonstruos.get(0).morir();
		zonaMonstruos.get(1).morir();
	}

}
