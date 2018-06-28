package fiuba.algo3.tp2;



import java.util.ArrayList;

public class Jugador implements Observador {
	
	private int vida;
	private String nombre;
	private ArrayList<Carta> cartasEnMano;
	private LadoDelCampo ladoDelCampo;
	private boolean ganador;
	
	
	public Jugador() {
		this.vida = 8000;
		this.cartasEnMano = new ArrayList<Carta>();
		this.ganador = false;
	}
	
	public void setLado(LadoDelCampo lado) {
		this.ladoDelCampo = lado;
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
		this.ladoDelCampo.atacar(atacante, atacado);
	}
	
	public void voltearCarta(Carta unaCarta) {
		unaCarta.voltearCarta();
	}
	
	public ArrayList<Monstruo> verMonstruosRivales() {
		return this.ladoDelCampo.verMonstruosRivales();
	}
	
	public void colocarCarta(Monstruo monstruo) {
		this.ladoDelCampo.colocarMonstruo(monstruo);
	}
	
	public void colocarCarta(Magica magica) {
		this.ladoDelCampo.colocarMagica(magica);
	}
	
	public void colocarCarta(Trampa trampa) {
		this.ladoDelCampo.colocarTrampa(trampa);
	}
	
	public void colocarCarta(CartaCampo cartaCampo) {
		this.ladoDelCampo.colocarTrampa(cartaCampo);
	}
	
	public void activarMagicaDeMano(Magica magica) {
		this.ladoDelCampo.activarMagicaDeMano(magica);
		this.cartasEnMano.remove(magica);
	}
	
	public void activarMagicaEnCampo(Magica magica) {
		this.ladoDelCampo.activarMagicaEnCampo(magica);
	}
	
	public void tomarCartaDelMazo() {
		this.cartasEnMano.add(this.ladoDelCampo.sacarCarta());
		chequearExodiaCompleto();
	}
	
	private void chequearExodiaCompleto() {
		int partesExodia = 0;
		for (Carta carta : cartasEnMano) {
			if (carta.esParteExodia()) {
				partesExodia++;
			}
		}
		if (partesExodia==5) {
			this.ganador = true;
		}
	}

	public int darCantidadCartasEnLaMano() {
		return this.cartasEnMano.size();
	}

	public void activarCartaCampo() {
		this.ladoDelCampo.activarCartaEnCampo();
		
	}

	public boolean haGanado() {
		return this.ganador;
	}
	
	public void setNombre(String unNombre) {
		this.nombre = unNombre;
	}

	public String darNombre() {
		return this.nombre;
	}

}
