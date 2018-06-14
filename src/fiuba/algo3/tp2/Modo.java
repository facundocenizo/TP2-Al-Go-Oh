package fiuba.algo3.tp2;

public interface Modo {
	
	public boolean estaEnModoAtaque();
	public void cargarPuntos(int puntosDeAtaque, int puntosDeDefensa);
	
	public int atacar(Monstruo monstruoAtacado, Monstruo mounstruo);
	
	public int recibirAtaque(int puntosDeAtaque, Monstruo monstruo);
		
	

}
