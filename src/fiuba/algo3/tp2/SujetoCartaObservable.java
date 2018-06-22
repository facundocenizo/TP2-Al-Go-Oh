package fiuba.algo3.tp2;

public interface SujetoCartaObservable {
	public void aniadirObservador(Observador observador);
	public void notificar(int puntosARestar);
}
