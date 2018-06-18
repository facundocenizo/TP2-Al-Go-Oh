package fiuba.algo3.tp2;

import fiuba.algo3.tp2.atributosCarta.Efecto;
import fiuba.algo3.tp2.atributosCarta.Posicion;

public class Magica extends Carta{
	
	public Magica(Posicion posicion, Efecto efecto) {
		super(posicion, efecto);
	}

	@Override
	public void aplicarEfecto() {
		efecto.aplicarEfecto();
		morir();
	}
}
