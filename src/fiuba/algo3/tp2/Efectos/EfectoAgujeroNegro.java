package fiuba.algo3.tp2.Efectos;

import fiuba.algo3.tp2.LadoDelCampo;
import fiuba.algo3.tp2.Monstruo;
import fiuba.algo3.tp2.atributosCarta.Efecto;

public class EfectoAgujeroNegro implements Efecto {
	

	public EfectoAgujeroNegro() {
	}

	@Override
	public void aplicarEfecto(LadoDelCampo propio, LadoDelCampo rival) {
		
		propio.matarATodosLosMonstruos();
		rival.matarATodosLosMonstruos();
	}

	@Override
	public void aplicarEfecto(Monstruo atacante, Monstruo atacado) {
		// TODO Auto-generated method stub
		
	}


}
