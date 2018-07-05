package fiuba.algo3.tp2.Efectos;

import fiuba.algo3.tp2.atributosCarta.Efecto;
import fiuba.algo3.tp2.cartas.Monstruo;
import fiuba.algo3.tp2.juego.LadoDelCampo;

public class EfectoSogen implements Efecto {
	
	int aumentoDeDefensa = 500;
	int aumentoDeAtaque = 200;

	@Override
	public void aplicarEfecto(LadoDelCampo propio, LadoDelCampo rival) {
			for (Monstruo unMonstruo: propio.verMonstruos()) {
				unMonstruo.aumentarPuntosDeDefensa(this.aumentoDeDefensa);
			}
			for (Monstruo unMonstruo: rival.verMonstruos()) {
				unMonstruo.aumentarPuntosDeAtaque(this.aumentoDeAtaque);
			}
				
		}

	@Override
	public void aplicarEfecto(Monstruo atacante, Monstruo atacado) {		
	}

	

}
