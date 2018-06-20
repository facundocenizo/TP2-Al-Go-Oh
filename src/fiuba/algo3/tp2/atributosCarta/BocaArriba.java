package fiuba.algo3.tp2.atributosCarta;

public class BocaArriba implements Posicion {

	@Override
	public boolean estaBocaAbajo() {
		return false;
	}

	@Override
	public Posicion voltear() {
		return new BocaAbajo();
	}

}
