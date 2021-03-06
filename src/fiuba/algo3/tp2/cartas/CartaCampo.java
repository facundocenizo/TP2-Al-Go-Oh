package fiuba.algo3.tp2.cartas;

import fiuba.algo3.tp2.atributosCarta.BocaArriba;
import fiuba.algo3.tp2.atributosCarta.Efecto;
import fiuba.algo3.tp2.juego.LadoDelCampo;

public class CartaCampo extends Carta {

	public CartaCampo(Efecto efecto) {
		super(new BocaArriba(), efecto);
	}

	@Override
	public void aplicarEfecto(LadoDelCampo propio, LadoDelCampo rival) {
		efecto.aplicarEfecto(propio, rival);
		morir();
		
	}

	@Override
	public void aplicarEfecto(Monstruo atacante, Monstruo atacado) {		
	}

	@Override
	public Boolean esMonstruo() {
		return false;
	}

	@Override
	public Boolean esMagica() {
		return false;
	}
	@Override
	public Boolean esTrampa() {
		return false;
	}

	@Override
	public Boolean esCartaCampo() {
		return true;
	}
	
}
