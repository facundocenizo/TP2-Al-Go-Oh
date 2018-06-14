package fiuba.algo3.tp2;

public class ModoDefensa implements Modo {
	
	private int puntosDeDefensa;
	

	@Override
	public boolean estaEnModoAtaque() {
		return false;
	}

	

	@Override
	public void cargarPuntos(int puntosDeAtaque, int puntosDeDefensa) {
		this.puntosDeDefensa = puntosDeDefensa;
		
	}

	@Override
	public int recibirAtaque(int puntosDeAtaque, Estado estado) {
		int diferencia = this.puntosDeDefensa - puntosDeAtaque;
		
		if(diferencia < 0 ) 
			estado = new Muerto();
		return diferencia;
	}



	@Override
	public int atacar(Monstruo monstruoAtacado, Estado estado) {
		// TODO Auto-generated method stub
		return 0;
	}
}
