package fiuba.algo3.tp2.cartas;

import fiuba.algo3.tp2.LadoDelCampo;
import fiuba.algo3.tp2.atributosCarta.Efecto;
import fiuba.algo3.tp2.atributosCarta.Posicion;

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
		// TODO Auto-generated method stub
		
	}

}
