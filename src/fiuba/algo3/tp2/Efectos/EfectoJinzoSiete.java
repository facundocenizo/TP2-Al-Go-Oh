package fiuba.algo3.tp2.Efectos;

import fiuba.algo3.tp2.LadoDelCampo;
import fiuba.algo3.tp2.Monstruo;
import fiuba.algo3.tp2.atributosCarta.Efecto;

public class EfectoJinzoSiete implements Efecto {
	
	private int puntosDelEfectoGinzo = 500;

	@Override
	public void aplicarEfecto(LadoDelCampo propio, LadoDelCampo rival) {
		rival.sufrirDanioAJugador(puntosDelEfectoGinzo);
		
	}

	@Override
	public void aplicarEfecto(Monstruo atacante, Monstruo atacado) {
		//implementar
		
	}
	

}
