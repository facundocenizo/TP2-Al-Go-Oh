package fiuba.algo3.tp2;

public interface SujetoJugadorObservable {
	public void aniadirObservador(ObservadorDeJugador observador);
	public void notificar();
}
