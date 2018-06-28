package fiuba.algo3.tp2.Efectos;

import fiuba.algo3.tp2.LadoDelCampo;
import fiuba.algo3.tp2.cartas.Monstruo;

public interface EfectoDefensa {
	public void aplicarEfecto(LadoDelCampo propio, LadoDelCampo rival);
	public void aplicarEfecto(Monstruo atacante, Monstruo atacado);
	public boolean tieneEfectoDefensa();
}
