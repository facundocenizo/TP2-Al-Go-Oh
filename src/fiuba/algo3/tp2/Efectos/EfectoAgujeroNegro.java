package fiuba.algo3.tp2.Efectos;

import fiuba.algo3.tp2.CampoDeBatalla;
import fiuba.algo3.tp2.atributosCarta.Efecto;

public class EfectoAgujeroNegro implements Efecto {
	
	private CampoDeBatalla campo;

	public EfectoAgujeroNegro(CampoDeBatalla campo) {
		
		this.campo = campo;
	}

	
	@Override
	public void aplicarEfecto() {
		
		this.campo.matarATodosLosMonstruos();
	
		
	}
	
	
	
	public EfectoAgujeroNegro() {
		// TODO Auto-generated constructor stub
	}


}
