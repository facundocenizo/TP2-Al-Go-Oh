package fiuba.algo3.tp2;

import fiuba.algo3.tp2.atributosCarta.BocaArriba;
import fiuba.algo3.tp2.atributosCarta.Efecto;

public class CartaCampo extends Carta {

	public CartaCampo(Efecto efecto) {
		super(new BocaArriba(), efecto);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void aplicarEfecto(LadoDelCampo propio, LadoDelCampo rival) {
		efecto.aplicarEfecto(propio, rival);
		morir();
		
	}

}
