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
	public int recibirAtaque(int puntosDeAtaque, Estado estado) {
		int diferencia = this.puntosDeAtaque - puntosDeAtaque;
		if(diferencia <= 0 ) {
			estado = new Muerto();
		}
		return diferencia;
		
	}

	@Override
	public int atacar(Monstruo monstruoAtacado, Estado estado) {
		int diferencia = monstruoAtacado.recibirAtaque(this.puntosDeAtaque);
		if(diferencia >= 0 ) {
			estado = new Muerto();

			System.out.println("por aca pasa, pero monstruo nunca actualiza su estado.");
			System.out.println("chequear como cambiar el estado, habria que pasar en vez de éstado, la carta por param");
		}
		return diferencia;
	}

}
