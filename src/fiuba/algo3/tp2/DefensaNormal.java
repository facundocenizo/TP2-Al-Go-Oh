package fiuba.algo3.tp2;

public class DefensaNormal implements Atacable {

	@Override
	public void recibirAtaque(Monstruo atacante, Monstruo atacado) {
		atacante.atacar(atacado);
	}

}