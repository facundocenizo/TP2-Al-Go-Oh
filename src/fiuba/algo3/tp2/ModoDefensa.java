package fiuba.algo3.tp2;

public class ModoDefensa implements Modo {
	
	private int puntosDeDefensa;
	

	@Override
	public boolean estaEnModoAtaque() {
		return false;
	}

	@Override
	public int atacar(Monstruo monstruoAtacado) {
		return 0;
	}

	@Override
	public void cargarPuntos(int puntosDeAtaque, int puntosDeDefensa) {
		this.puntosDeDefensa = puntosDeDefensa;
		
	}

	@Override
	public int calcularDanio(int puntosDeAtaqueRecibidos) {
		return 
	}

}
