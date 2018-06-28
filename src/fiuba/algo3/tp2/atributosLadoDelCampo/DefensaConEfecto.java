package fiuba.algo3.tp2.atributosLadoDelCampo;

import fiuba.algo3.tp2.cartas.Monstruo;

public class DefensaConEfecto implements Atacable {
	
	private Monstruo monstruo;

	public DefensaConEfecto(Monstruo monstruo) {
		this.monstruo = monstruo;
	}
	
	@Override
	public void recibirAtaque(Monstruo atacante, Monstruo atacado) {
		monstruo.aplicarEfectoDefensa(atacante, atacado);
	}
	
}
