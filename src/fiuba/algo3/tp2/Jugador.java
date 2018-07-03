package fiuba.algo3.tp2;



import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.tp2.atributosCarta.Observador;
import fiuba.algo3.tp2.cartas.Carta;
import fiuba.algo3.tp2.cartas.CartaCampo;
import fiuba.algo3.tp2.cartas.Magica;
import fiuba.algo3.tp2.cartas.Monstruo;
import fiuba.algo3.tp2.cartas.Trampa;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

public class Jugador implements Observador, SujetoJugadorObservable {
	
	private int vida;
	private String nombre;
	private ImageView imagen;
	private ArrayList<Carta> cartasEnMano;
	private LadoDelCampo ladoDelCampo;
	private boolean ganador;
	private ObservadorDeJugador observador;
	
	
	public Jugador() {
		this.vida = 8000;
		this.cartasEnMano = new ArrayList<Carta>();
		this.ganador = false;
	}
	
	public void agregarCartasALaMano() {
		tomarCartaDelMazo();
		tomarCartaDelMazo();
		tomarCartaDelMazo();
		tomarCartaDelMazo();
		tomarCartaDelMazo();
	}

	public void setLado(LadoDelCampo lado) {
		this.ladoDelCampo = lado;
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
	
	public ArrayList<Monstruo> getMonstruos() {
		return this.ladoDelCampo.verMonstruos();
	}
	
	public ArrayList<Monstruo> verMonstruosRivales() {
		return this.ladoDelCampo.verMonstruosRivales();
	}
	
	public void colocarCarta(Monstruo monstruo) {
		this.ladoDelCampo.colocarMonstruo(monstruo);
		this.cartasEnMano.remove(monstruo);

	}
	
	public void colocarCarta(Magica magica) {
		this.ladoDelCampo.colocarMagica(magica);
		this.cartasEnMano.remove(magica);
		
	}
	
	public void colocarCarta(Trampa trampa) {
		this.ladoDelCampo.colocarTrampa(trampa);
		this.cartasEnMano.remove(trampa);
	}
	
	public void colocarCarta(CartaCampo cartaCampo) {
		this.ladoDelCampo.colocarTrampa(cartaCampo);
		this.cartasEnMano.remove(cartaCampo);
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
			this.notificar();
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
	
	public void setImagen(ImageView imagen) {
		this.imagen = imagen;
	}
	
	public ImageView darImagen() {
		return this.imagen;
	}
	
	public ArrayList<Carta> darCartasDeLaMano() {
		return this.cartasEnMano;
	}

	public int darVida() {
		return this.vida;
	}

	public void agregarCartaALaMano(Monstruo monstruo) {
		this.cartasEnMano.add(monstruo);
		chequearExodiaCompleto();
	}

	public void terminarTurno() {
		this.ladoDelCampo.terminarTurno();
	}

	public void hasGanado() {
		this.ganador = true;
		this.notificar();
		
	}

	@Override
	public void aniadirObservador(ObservadorDeJugador observador) {
		this.observador = observador;
	}

	@Override
	public void notificar() {
		this.observador.actualizar(this);
		
	}

	public ArrayList<Magica> getMagicas() {
		return this.ladoDelCampo.getMagicas();
	}

	public ArrayList<Trampa> getTrampas() {
		return this.ladoDelCampo.getTrampas();
	}

	public ArrayList<CartaCampo> getCartaCampo() {
		return this.ladoDelCampo.getCartaCampo();
	}

}
