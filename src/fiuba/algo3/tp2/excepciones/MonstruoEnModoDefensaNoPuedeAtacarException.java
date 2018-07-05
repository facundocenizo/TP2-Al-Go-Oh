package fiuba.algo3.tp2.excepciones;

public class MonstruoEnModoDefensaNoPuedeAtacarException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getMessage() {
		return ("No se puede atacar con \nun monstruo en modo\nde Defensa");
	}
}
