package atributosLadoDelCampo;

import cartas.Monstruo;
import cartas.Trampa;

public class DefensaConTrampa implements Atacable {

	private Trampa trampa;

	public DefensaConTrampa(Trampa trampa) {
		this.trampa = trampa;
	}
	
	@Override
	public void recibirAtaque(Monstruo atacante, Monstruo atacado) {
		trampa.aplicarEfecto(atacante, atacado);
	}

}
