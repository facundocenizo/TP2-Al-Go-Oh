package fiuba.algo3.tp2;

import java.util.ArrayList;
import java.util.List;

public class Jugador implements Observador {
	
	private int vida;
	private List<Carta> cartasEnMano;
	private Turno turno;
	
	public Jugador() {
		this.vida = 8000;
		this.cartasEnMano = new ArrayList<Carta>();
		this.turno = new TurnoActivo();
	}
	
	public int vida() {
		return vida;
	}
	
	public void sufrirDanio(int danio) {
		this.vida -= danio;
	}

	@Override
	public void actualizar(int puntosARestar) {
		this.vida -= puntosARestar;
	}
	
	public void atacar(Monstruo atacante, Monstruo atacado) {
		this.turno.atacar(atacante, atacado);
	}
	
	public void voltearCarta(Carta unaCarta) {
		unaCarta.voltearCarta();
	}

}
