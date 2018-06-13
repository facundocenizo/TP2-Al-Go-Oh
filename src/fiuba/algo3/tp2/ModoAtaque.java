package fiuba.algo3.tp2;

public class ModoAtaque implements Modo {
	
	private int puntosDeAtaque;

	@Override
	public boolean estaEnModoAtaque() {
		return true;
	}

	@Override
	public int atacar(Monstruo monstruoAtacado, int puntosDeAtaque) {
		return monstruoAtacado.calcularDanio(puntosDeAtaque);
		
	}

	@Override
	public void cargarPuntos(int puntosDeAtaque, int puntosDeDefensa) {
		this.puntosDeAtaque = puntosDeAtaque;
		
	}

}
