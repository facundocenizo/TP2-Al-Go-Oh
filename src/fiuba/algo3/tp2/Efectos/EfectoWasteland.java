package fiuba.algo3.tp2.Efectos;

import fiuba.algo3.tp2.atributosCarta.Efecto;
import fiuba.algo3.tp2.cartas.Monstruo;
import fiuba.algo3.tp2.juego.LadoDelCampo;

public class EfectoWasteland implements Efecto {
	
	private int aumentoDeAtaque = 200;
	private int aumentoDeDefensa = 300;

	@Override
	public void aplicarEfecto(LadoDelCampo propio, LadoDelCampo rival) {
		for (Monstruo unMonstruo: propio.verMonstruos()) {
			unMonstruo.aumentarPuntosDeAtaque(this.aumentoDeAtaque);
		}
		for (Monstruo unMonstruo: rival.verMonstruos()) {
			unMonstruo.aumentarPuntosDeDefensa(this.aumentoDeDefensa);
		}
				
	}

	@Override
	public void aplicarEfecto(Monstruo atacante, Monstruo atacado) {
	}



}
