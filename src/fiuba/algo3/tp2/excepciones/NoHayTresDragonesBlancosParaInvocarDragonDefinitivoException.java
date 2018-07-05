package fiuba.algo3.tp2.excepciones;

public class NoHayTresDragonesBlancosParaInvocarDragonDefinitivoException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getMessage() {
		return ("No se puede colocar.\nNecesitas tres \ndragones blancos \npara sacrificar.");
	}
}
