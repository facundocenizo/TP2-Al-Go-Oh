package fiuba.algo3.tp2.excepciones;

public class SeNecesitanDosMonstruosDeMenorNivelParaSacrificarException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getMessage() {
		return ("No se puede colocar.\nNecesitas dos monstruos\nde menor nivel \npara sacrificar.");
	}
}
