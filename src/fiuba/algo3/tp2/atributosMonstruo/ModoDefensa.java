package fiuba.algo3.tp2.atributosMonstruo;

import fiuba.algo3.tp2.cartas.Monstruo;
import fiuba.algo3.tp2.excepciones.MonstruoEnModoDefensaNoPuedeAtacarException;

public class ModoDefensa implements Modo {
	
	private int puntosDeDefensa;
	

	public ModoDefensa(int puntosDeDefensa) {
		this.puntosDeDefensa = puntosDeDefensa;
	}

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
		int diferencia = this.puntosDeDefensa - puntosDeAtaque;
		if(diferencia < 0 ) {
			monstruo.morir();
			return diferencia;
		}
		return diferencia*-1; // Se le multiplica por -1 para que siempre devuelva algo negativo
	}



	@Override
	public int atacar(Monstruo monstruoAtacado, Monstruo monstruo) {
		throw new MonstruoEnModoDefensaNoPuedeAtacarException();
	}

	@Override
	public void aumentarPuntosDeAtaque(int aumentoDePruebas) {
		// TODO Auto-generated method stub
		
	}
}
