package fiuba.algo3.tp2.Efectos;

import cartas.Monstruo;
import fiuba.algo3.tp2.LadoDelCampo;
import fiuba.algo3.tp2.atributosCarta.Efecto;

public class EfectoCilindroMagico implements Efecto {

	@Override
	public void aplicarEfecto(LadoDelCampo propio, LadoDelCampo rival) {
				
	}

	@Override
	public void aplicarEfecto(Monstruo atacante, Monstruo atacado) {
		atacante.notificar(atacante.darPuntosDeAtaque());
	}



}
