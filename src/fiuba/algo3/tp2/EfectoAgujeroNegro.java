package fiuba.algo3.tp2;

import java.util.LinkedList;

public class EfectoAgujeroNegro implements Efecto {
	
	
	private LinkedList<Monstruo> monstruosDelJugador1;
	private LinkedList<Monstruo> monstruosDelJugador2;
	

	public EfectoAgujeroNegro(LinkedList<Monstruo> monstruosDeJugador1, LinkedList<Monstruo> monstruosDeJugador2) {
		
		this.monstruosDelJugador1 = monstruosDeJugador1;
		this.monstruosDelJugador2 = monstruosDeJugador2;
		
	}

	@Override
	public void aplicarEfecto() {
	
		
	}

}
