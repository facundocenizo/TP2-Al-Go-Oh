package fiuba.algo3.tp2;

public class TurnoActivo implements Turno{

	@Override
	public void atacar(Monstruo monstruoAtacante, Monstruo monstruoAtacado) {
		monstruoAtacante.atacar(monstruoAtacado);
		
	}

	@Override
	public void colocarCarta(Carta carta, int posicion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sacarCartaDelMazo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void voltearCarta(Carta carta) {
		carta.voltearCarta();
		
	}


}
