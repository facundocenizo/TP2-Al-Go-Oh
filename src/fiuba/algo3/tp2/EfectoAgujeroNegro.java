package fiuba.algo3.tp2;

public class EfectoAgujeroNegro implements Efecto {
	
	private Campo campo;

	public EfectoAgujeroNegro(Campo campo) {
		
		this.campo = campo;
	}

	@Override
	public void aplicarEfecto() {
		
		this.campo.matarATodosLosMonstruos();
	
		
	}

}