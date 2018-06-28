package fiuba.algo3.tp2.atributosMonstruo;

import java.util.ArrayList;

import cartas.Monstruo;

public interface Nivel {

	boolean esDebil();
	boolean esNormal();
	boolean esPoderoso();
	public void manejarSacrificiosPorEsteMonstruo(ArrayList<Monstruo> zonaMonstruos);

}
