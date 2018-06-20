package fiuba.algo3.tp2.atributosCarta;

public class BocaAbajo implements Posicion {

	@Override
	public boolean estaBocaAbajo() {
		return true;
	}

	@Override
	public Posicion voltear() {
		return new BocaArriba();
	}
	
}
