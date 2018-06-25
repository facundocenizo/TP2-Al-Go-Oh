package fiuba.algo3.tp2.Efectos;

import fiuba.algo3.tp2.LadoDelCampo;
import fiuba.algo3.tp2.Monstruo;
import fiuba.algo3.tp2.atributosCarta.Efecto;

public class EfectoSogen implements Efecto {
	
	int aumentoDeDefensa = 500;
	int aumentoDeAtaque = 200;

	@Override
	public void aplicarEfecto(LadoDelCampo propio, LadoDelCampo rival) {
			for (Monstruo unMonstruo: propio.verMonstruos()) {
				unMonstruo.aumentarPuntosDeDefensa(this.aumentoDeDefensa);
			}
			for (Monstruo unMonstruo: rival.verMonstruos()) {
				unMonstruo.aumentarPuntosDeAtaque(this.aumentoDeAtaque);
			}
				
		}

	@Override
	public void aplicarEfecto(Monstruo atacante, Monstruo atacado) {
		// TODO Auto-generated method stub
		
	}

	

}
