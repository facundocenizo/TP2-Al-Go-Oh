package fiuba.algo3.tp2.atributosLadoDelCampo;

import fiuba.algo3.tp2.cartas.Monstruo;

public class DefensaNormal implements Atacable {

	@Override
	public void recibirAtaque(Monstruo atacante, Monstruo atacado) {
		atacante.atacar(atacado);
	}

}
