package fiuba.algo3.tp2.Efectos;

import fiuba.algo3.tp2.atributosCarta.Efecto;
import fiuba.algo3.tp2.cartas.Monstruo;
import fiuba.algo3.tp2.juego.LadoDelCampo;

public class EfectoJinzoSiete implements Efecto {
	
	private int puntosDelEfectoJinzo = 500;

	@Override
	public void aplicarEfecto(LadoDelCampo propio, LadoDelCampo rival) {
		rival.sufrirDanioAJugador(puntosDelEfectoJinzo);
		
	}

	@Override
	public void aplicarEfecto(Monstruo atacante, Monstruo atacado) {
	}
	

}
