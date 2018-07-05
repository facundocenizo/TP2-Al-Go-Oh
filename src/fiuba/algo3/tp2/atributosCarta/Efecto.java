package fiuba.algo3.tp2.atributosCarta;

import fiuba.algo3.tp2.cartas.Monstruo;
import fiuba.algo3.tp2.juego.LadoDelCampo;

public interface Efecto {
	
	public void aplicarEfecto(LadoDelCampo propio, LadoDelCampo rival);
	public void aplicarEfecto(Monstruo atacante, Monstruo atacado);


}
