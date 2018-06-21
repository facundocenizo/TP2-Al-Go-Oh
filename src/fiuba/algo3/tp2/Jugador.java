package fiuba.algo3.tp2;

import java.util.ArrayList;
import java.util.List;

public class Jugador implements Observador {
	
	private int vida;
	private List<Carta> cartasEnMano;
	private LadoDelCampo ladoDelCampo;
	private Turno turno;
	
	public Jugador(LadoDelCampo lado) {
		this.vida = 8000;
		this.cartasEnMano = new ArrayList<Carta>();
		this.ladoDelCampo = lado;
		//this.turno = new TurnoActivo();
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
	
	public List<Monstruo> verMonstruosRivales() {
		return this.ladoDelCampo.verMonstruosRivales();
	}
	
	public void morir() {
		//implementar
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
	
	public void activarMagicaDeMano(Magica magica) {
		this.ladoDelCampo.activarMagicaDeMano(magica);
		this.cartasEnMano.remove(magica);
	}
	
	public void activarMagicaEnCampo(Magica magica) {
		this.ladoDelCampo.activarMagicaEnCampo(magica);
	}

	public void jugarTurno() {
		// TODO Apéndice de método generado automáticamente
		
	}

}
