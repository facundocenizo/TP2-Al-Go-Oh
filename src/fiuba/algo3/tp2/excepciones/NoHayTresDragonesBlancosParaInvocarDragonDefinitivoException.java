package fiuba.algo3.tp2.excepciones;

public class NoHayTresDragonesBlancosParaInvocarDragonDefinitivoException extends RuntimeException {
	
	public String getMessage() {
		return ("No se puede colocar.\nNecesitas tres \ndragones blancos \npara sacrificar.");
	}
}
