package fiuba.algo3.tp2.Efectos;

import fiuba.algo3.tp2.Campo;
import fiuba.algo3.tp2.atributosCarta.Efecto;

public class EfectoAgujeroNegro implements Efecto {
	
	private Campo campo;

	public EfectoAgujeroNegro(Campo campo) {
		
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
