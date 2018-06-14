package fiuba.algo3.tp2;

public class Magica extends Carta{
	
	public Magica(Posicion posicion, Efecto efecto) {
		super(posicion, efecto);
	}

	@Override
	public void aplicarEfecto() {
		efecto.aplicarEfecto();
		
	}
}
