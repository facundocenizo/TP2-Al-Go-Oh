package fiuba.algo3.tp2.excepciones;

public class SeNecesitaUnMonstruoDeMenorNivelParaSacrificarException extends RuntimeException {

	public String getMessage() {
		return ("No se puede colocar.\nNecesitas un monstruo\nde menor nivel \npara sacrificar.");
	}
}
