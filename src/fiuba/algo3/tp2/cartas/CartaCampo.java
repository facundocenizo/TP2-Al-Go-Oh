package fiuba.algo3.tp2.cartas;

import fiuba.algo3.tp2.LadoDelCampo;
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

	@Override
	public void aplicarEfecto(Monstruo atacante, Monstruo atacado) {
		// TODO Auto-generated method stub
		
	}
	
}
