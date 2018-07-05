package fiuba.algo3.tp2.atributosMonstruo;

import java.util.ArrayList;

import fiuba.algo3.tp2.cartas.Monstruo;
import fiuba.algo3.tp2.excepciones.SeNecesitaUnMonstruoDeMenorNivelParaSacrificarException;

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
		ArrayList<Monstruo> monstruosASacrificar = new ArrayList<Monstruo>(); 
		for(Monstruo monstruo : zonaMonstruos) {
			if(monstruo.esDebil())
				monstruosASacrificar.add(monstruo);
		}
		
		if (monstruosASacrificar.size() < 1) {
			throw new SeNecesitaUnMonstruoDeMenorNivelParaSacrificarException();
		}
		monstruosASacrificar.get(0).morir();
	}

	@Override
	public boolean esDragonDefinitivo() {
		return false;
	}

}
