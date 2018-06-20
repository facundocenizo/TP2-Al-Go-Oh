package fiuba.algo3.tp2.atributosMonstruo;

import fiuba.algo3.tp2.Monstruo;
import fiuba.algo3.tp2.excepciones.MonstruoEnModoDefensaNoPuedeAtacarException;

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
	public int recibirAtaque(int puntosDeAtaque, Monstruo monstruo) {
		int diferencia = Math.abs(this.puntosDeDefensa - puntosDeAtaque);
		if(diferencia < 0 ) 
			monstruo.morir();
			monstruo.notificar(diferencia);	
		return diferencia;
	}



	@Override
	public int atacar(Monstruo monstruoAtacado, Monstruo monstruo) {
		throw new MonstruoEnModoDefensaNoPuedeAtacarException();
	}
}
