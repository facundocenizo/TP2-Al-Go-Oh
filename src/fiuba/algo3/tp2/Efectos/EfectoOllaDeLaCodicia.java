package fiuba.algo3.tp2.Efectos;

import cartas.Monstruo;
import fiuba.algo3.tp2.LadoDelCampo;
import fiuba.algo3.tp2.atributosCarta.Efecto;

public class EfectoOllaDeLaCodicia implements Efecto {

	@Override
	public void aplicarEfecto(LadoDelCampo propio, LadoDelCampo rival) {
		
		propio.darCartaAJugador();
		propio.darCartaAJugador();		
	}

	@Override
	public void aplicarEfecto(Monstruo atacante, Monstruo atacado) {
		// TODO Auto-generated method stub
		
	}

	

}
