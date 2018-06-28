package fiuba.algo3.tp2.atributosMonstruo;

import java.util.ArrayList;

import fiuba.algo3.tp2.Monstruo;

public interface Nivel {

	boolean esDebil();
	boolean esNormal();
	boolean esPoderoso();
	public void manejarSacrificiosPorEsteMonstruo(ArrayList<Monstruo> zonaMonstruos);

}
