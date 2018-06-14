package fiuba.algo3.tp2;

public class Magica extends Carta{
	
	private Posicion posicion;
	private Efecto efecto;

	public Magica(Posicion posicion, Efecto efecto) {
		super(posicion);
		this.efecto = efecto;
	}

	@Override
	public void aplicarEfecto() {
		// TODO Auto-generated method stub
		
	}
	// es magico (como diria cenizo q dice listorti)
}
