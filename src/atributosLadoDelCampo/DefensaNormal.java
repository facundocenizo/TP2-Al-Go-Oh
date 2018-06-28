package atributosLadoDelCampo;

import cartas.Monstruo;

public class DefensaNormal implements Atacable {

	@Override
	public void recibirAtaque(Monstruo atacante, Monstruo atacado) {
		atacante.atacar(atacado);
	}

}
