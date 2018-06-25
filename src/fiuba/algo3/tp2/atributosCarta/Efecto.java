package fiuba.algo3.tp2.atributosCarta;

import fiuba.algo3.tp2.LadoDelCampo;
import fiuba.algo3.tp2.Monstruo;

public interface Efecto {
	
	public void aplicarEfecto(LadoDelCampo propio, LadoDelCampo rival);
	public void aplicarEfecto(Monstruo atacante, Monstruo atacado);
	


}
