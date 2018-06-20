package fiuba.algo3.tp2;

public interface SujetoCartaObservable {
	public void añadirObservador(Observador observador);
	public void notificar(int puntosARestar);
}
