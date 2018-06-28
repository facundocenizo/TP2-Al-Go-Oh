package fiuba.algo3.tp2;

public interface EfectoDefensa {
	public void aplicarEfecto(LadoDelCampo propio, LadoDelCampo rival);
	public void aplicarEfecto(Monstruo atacante, Monstruo atacado);
	public boolean tieneEfectoDefensa();
}
