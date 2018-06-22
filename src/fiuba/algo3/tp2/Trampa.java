package fiuba.algo3.tp2;

import fiuba.algo3.tp2.atributosCarta.BocaAbajo;
import fiuba.algo3.tp2.atributosCarta.Efecto;

public class Trampa extends Carta{
	
	public Trampa(Efecto efecto) {
		super(new BocaAbajo(), efecto);
	}

	@Override
	public void aplicarEfecto(LadoDelCampo propio, LadoDelCampo rival) {
		efecto.aplicarEfecto(propio, rival);
		morir();
	}

}
