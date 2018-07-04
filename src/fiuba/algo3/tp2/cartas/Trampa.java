package fiuba.algo3.tp2.cartas;

import fiuba.algo3.tp2.LadoDelCampo;
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

	@Override
	public void aplicarEfecto(Monstruo atacante, Monstruo atacado) {
		efecto.aplicarEfecto(atacante, atacado);		
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
		return true;
	}

	@Override
	public Boolean esCartaCampo() {
		return false;
	}

}
