package fiuba.algo3.tp2.cartas;

import java.util.ArrayList;

import fiuba.algo3.tp2.LadoDelCampo;
import fiuba.algo3.tp2.Efectos.EfectoDefensa;
import fiuba.algo3.tp2.Efectos.EfectoExodia;
import fiuba.algo3.tp2.atributosCarta.Efecto;
import fiuba.algo3.tp2.atributosCarta.Posicion;
import fiuba.algo3.tp2.atributosMonstruo.Modo;
import fiuba.algo3.tp2.atributosMonstruo.Nivel;
public class Monstruo extends Carta{
	
	private Modo modo;
	private int puntosDeAtaque;
	private int puntosDeDefensa;
	private Nivel nivel;
	private EfectoDefensa efectoDefensa;
	
	public Monstruo(Posicion posicion, Modo modo, Nivel nivel, int puntosDeAtaque, int puntosDeDefensa, Efecto efecto, EfectoDefensa efectoDefensa) {
		super(posicion, efecto);
		this.modo = modo;
		this.modo.cargarPuntos(puntosDeAtaque,puntosDeDefensa);
		this.puntosDeAtaque = puntosDeAtaque;
		this.puntosDeDefensa = puntosDeDefensa;
		this.nivel = nivel;
		this.efectoDefensa = efectoDefensa;
    }
	

	public boolean estaEnModoAtaque() {
		return modo.estaEnModoAtaque();
	}


	public void atacar(Monstruo monstruoAtacado) {
		this.modo.atacar(monstruoAtacado, this);
	}

	public int recibirAtaque(int puntosDeAtaque) {
		return this.modo.recibirAtaque(puntosDeAtaque, this);
	}

	public boolean esDebil() {
		return nivel.esDebil();
	}
	public boolean esNormal() {
		return nivel.esNormal();
	}
	public boolean esPoderoso() {
		return nivel.esPoderoso();
	}
	
	public int darPuntosDeAtaque() {
		return this.puntosDeAtaque;
	}
	
	public int darPuntosDeDefensa() {
		return this.puntosDeDefensa;
	}


	@Override
	public void aplicarEfecto(LadoDelCampo propio, LadoDelCampo rival) {
		this.efecto.aplicarEfecto(propio, rival);
	}


	public void aumentarPuntosDeAtaque(int aumentoDePruebas) {
		this.puntosDeAtaque += aumentoDePruebas;
		modo.aumentarPuntosDeAtaque(aumentoDePruebas);
	}

	public void aumentarPuntosDeDefensa(int aumentoDeDefensa) {
		this.puntosDeDefensa += aumentoDeDefensa;
		
	}


	@Override
	public void aplicarEfecto(Monstruo atacante, Monstruo atacado) {
		// TODO Auto-generated method stub
		
	}
	
	
	public boolean esParteExodia() {
		return (this.efecto instanceof EfectoExodia);
	}


	public boolean tieneEfectoDefensa() {
		return efectoDefensa.tieneEfectoDefensa();
	}


	public void aplicarEfectoDefensa(Monstruo atacante, Monstruo atacado) {
		this.efectoDefensa.aplicarEfecto(atacante, atacado);
	}


	public void manejarNivel(ArrayList<Monstruo> zonaMonstruos) {
		this.nivel.manejarSacrificiosPorEsteMonstruo(zonaMonstruos);
		
	}


	@Override
	public Boolean esMonstruo() {
		return true;
	}


	@Override
	public Boolean esMagica() {
		return false;
	}
	
	@Override
	public Boolean esTrampa() {
		return false;
	}


	@Override
	public Boolean esCartaCampo() {
		return false;
	}
	



	
}