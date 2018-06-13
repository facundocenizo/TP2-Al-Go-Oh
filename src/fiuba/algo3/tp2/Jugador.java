package fiuba.algo3.tp2;

public class Jugador {
	
	int vida;
	
	public Jugador() {
		this.vida = 8000;
	}
	
	
	public int vida() {
		return vida;
	}
	
	public void sufrirDanio(int danio) {
		this.vida -= danio;
	}

}
