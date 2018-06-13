package fiuba.algo3.tp2;

public interface Modo {
	
	public boolean estaEnModoAtaque();
	public int atacar(Monstruo monstruoAtacado);
	public void cargarPuntos(int puntosDeAtaque, int puntosDeDefensa);
	public int calcularDanio(int puntosDeAtaqueRecibidos);
		
	

}
