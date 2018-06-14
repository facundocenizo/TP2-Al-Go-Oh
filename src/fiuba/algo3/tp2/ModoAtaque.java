package fiuba.algo3.tp2;

public class ModoAtaque implements Modo {
	
	private int puntosDeAtaque;

	@Override
	public boolean estaEnModoAtaque() {
		return true;
	}

	@Override
	public void cargarPuntos(int puntosDeAtaque, int puntosDeDefensa) {
		this.puntosDeAtaque = puntosDeAtaque;
		
	}

	@Override
	public int recibirAtaque(int puntosDeAtaque, Monstruo monstruo) {
		int diferencia = this.puntosDeAtaque - puntosDeAtaque;
		if(diferencia <= 0 )
			monstruo.morir();
		
		return diferencia;
		
	}

	@Override
	public int atacar(Monstruo monstruoAtacado, Monstruo monstruo) {
		int diferencia = monstruoAtacado.recibirAtaque(this.puntosDeAtaque);
		if(diferencia >= 0 ) 
			monstruo.morir();
		
		return diferencia;
	}

}
