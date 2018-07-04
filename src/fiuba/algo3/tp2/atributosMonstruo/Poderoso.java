package fiuba.algo3.tp2.atributosMonstruo;

import java.util.ArrayList;

import fiuba.algo3.tp2.cartas.Monstruo;
import fiuba.algo3.tp2.excepciones.SeNecesitanDosMonstruosDeMenorNivelParaSacrificarException;

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
		ArrayList<Monstruo> monstruosASacrificar = new ArrayList<Monstruo>(); 
		for(Monstruo monstruo : zonaMonstruos) {
			if(monstruo.esDebil())
				monstruosASacrificar.add(monstruo);
		}
		
		if (monstruosASacrificar.size() < 2) {
			throw new SeNecesitanDosMonstruosDeMenorNivelParaSacrificarException();
		}
		monstruosASacrificar.get(0).morir();
		monstruosASacrificar.get(1).morir();
	}

	@Override
	public boolean esDragonDefinitivo() {
		// TODO Auto-generated method stub
		return false;
	}

}
