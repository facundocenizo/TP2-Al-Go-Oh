package fiuba.algo3.tp2.atributosMonstruo;

import java.util.ArrayList;

import fiuba.algo3.tp2.Monstruo;
import fiuba.algo3.tp2.excepciones.CartasMonstruosInsuficientesParaSacrificio;

public class Normal implements Nivel {

	@Override
	public boolean esDebil() {
		return false;
	}

	@Override
	public boolean esNormal() {
		return true;
	}

	@Override
	public boolean esPoderoso() {
		return false;
	}

	@Override
	public void manejarSacrificiosPorEsteMonstruo(ArrayList<Monstruo> zonaMonstruos) {
		if (zonaMonstruos.size() < 1) {
			throw new CartasMonstruosInsuficientesParaSacrificio();
		}
		zonaMonstruos.get(0).morir();
	}

}
