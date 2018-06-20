package fiuba.algo3.tp2.atributosMonstruo;

public class Debil implements Nivel {

	@Override
	public boolean esDebil() {
		return true;
	}

	@Override
	public boolean esNormal() {
		return false;
	}

	@Override
	public boolean esPoderoso() {
		return false;
	}

}
