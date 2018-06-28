package fiuba.algo3.tp2.atributosCarta;

import cartas.Monstruo;
import fiuba.algo3.tp2.LadoDelCampo;

public interface Efecto {
	
	public void aplicarEfecto(LadoDelCampo propio, LadoDelCampo rival);
	public void aplicarEfecto(Monstruo atacante, Monstruo atacado);


}
