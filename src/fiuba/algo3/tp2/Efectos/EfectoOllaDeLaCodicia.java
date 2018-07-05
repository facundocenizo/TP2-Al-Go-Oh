package fiuba.algo3.tp2.Efectos;

import fiuba.algo3.tp2.atributosCarta.Efecto;
import fiuba.algo3.tp2.cartas.Monstruo;
import fiuba.algo3.tp2.juego.LadoDelCampo;

public class EfectoOllaDeLaCodicia implements Efecto {

	@Override
	public void aplicarEfecto(LadoDelCampo propio, LadoDelCampo rival) {
		
		propio.darCartaAJugador();
		propio.darCartaAJugador();		
	}

	@Override
	public void aplicarEfecto(Monstruo atacante, Monstruo atacado) {
	}

	

}
