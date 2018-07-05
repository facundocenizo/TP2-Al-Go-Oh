package fiuba.algo3.tp2.cartas;

import fiuba.algo3.tp2.atributosCarta.Efecto;
import fiuba.algo3.tp2.atributosCarta.Posicion;
import fiuba.algo3.tp2.juego.LadoDelCampo;

public class Magica extends Carta{
	
	public Magica(Posicion posicion, Efecto efecto) {
		super(posicion, efecto);
	}

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
		return true;
	}
	@Override
	public Boolean esTrampa() {
		return false;
	}

	@Override
	public Boolean esCartaCampo() {
		return false;
	}
	
}
