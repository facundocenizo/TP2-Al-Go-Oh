package fiuba.algo3.tp2.atributosMonstruo;

public class Poderoso implements Nivel {

	@Override
	public boolean esDebil() {
		return false;
	}

	@Override
	public boolean esNormal() {
		return false;
	}

	@Override
	public boolean esPoderoso() {
		return true;
	}

}
