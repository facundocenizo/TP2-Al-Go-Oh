package fiuba.algo3.tp2.atributosMonstruo;

import java.util.ArrayList;

import fiuba.algo3.tp2.cartas.Monstruo;
import fiuba.algo3.tp2.excepciones.SeNecesitanDosMonstruosDeMenorNivelParaSacrificarException;
import fiuba.algo3.tp2.excepciones.NoHayTresDragonesBlancosParaInvocarDragonDefinitivoException;

public class DragonDefinitivo implements Nivel {

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
			if(monstruo.getNombre().equals("dragonBlanco"))
				monstruosASacrificar.add(monstruo);
		}
		
		if (monstruosASacrificar.size() < 3) {
			throw new NoHayTresDragonesBlancosParaInvocarDragonDefinitivoException();
		}
				
		monstruosASacrificar.get(0).morir();
		monstruosASacrificar.get(1).morir();
		monstruosASacrificar.get(2).morir();
	}

	@Override
	public boolean esDragonDefinitivo() {
		return true;
	}
	

}
