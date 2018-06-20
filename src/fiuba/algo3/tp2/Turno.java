package fiuba.algo3.tp2;

public interface Turno {
	
	public void atacar(Monstruo monstruoAtacante,Monstruo monstruoAtacado);
	public void colocarCarta(Carta carta,int posicion);
	public void sacarCartaDelMazo();
	public void voltearCarta(Carta carta);

}
