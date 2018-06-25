package fiuba.algo3.tp2;

public class AtaqueConTrampa implements Atacable {

	private Trampa trampa;

	public AtaqueConTrampa(Trampa trampa) {
		this.trampa = trampa;
	}
	
	@Override
	public void recibirAtaque(Monstruo atacante, Monstruo atacado) {
		trampa.aplicarEfecto(atacante, atacado);
	}

}
