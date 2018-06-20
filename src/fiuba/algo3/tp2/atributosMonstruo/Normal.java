package fiuba.algo3.tp2.atributosMonstruo;

public class Normal implements Nivel {

	@Override
	public boolean esDebil() {
		return false;
	}

	@Override
	public boolean esNormal() {
		return true;
	}

	@Override
	public boolean esPoderoso() {
		return false;
	}

}
