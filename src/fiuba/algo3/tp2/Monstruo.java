package fiuba.algo3.tp2;

import fiuba.algo3.tp2.atributosCarta.Posicion;
import fiuba.algo3.tp2.atributosMonstruo.Debil;
import fiuba.algo3.tp2.atributosMonstruo.Modo;
import fiuba.algo3.tp2.atributosMonstruo.Nivel;
import fiuba.algo3.tp2.atributosMonstruo.Normal;
import fiuba.algo3.tp2.atributosMonstruo.Poderoso;

public class Monstruo extends Carta{
	
	private Modo modo;
	private int estrellas;
	private int puntosDeAtaque;
	private int puntosDeDefensa;
	private Nivel nivel;
	
	public Monstruo(Posicion posicion, Modo modo, int estrellas, int puntosDeAtaque, int puntosDeDefensa) {
		super(posicion, new SinEfecto());
		this.modo = modo;
		this.modo.cargarPuntos(puntosDeAtaque,puntosDeDefensa);
		this.estrellas = estrellas;
		this.puntosDeAtaque = puntosDeAtaque;
		this.puntosDeDefensa = puntosDeDefensa;
		
		if(this.estrellas < 5)
			this.nivel = new Debil();
		if(this.estrellas > 6)
			this.nivel = new Poderoso();
		if(this.estrellas == 5 || estrellas == 6)
			this.nivel = new Normal();
    }

	public boolean estaEnModoAtaque() {
		return modo.estaEnModoAtaque();
	}

	@Override
	public void aplicarEfecto() {
		
	}

	public void atacar(Monstruo monstruoAtacado) {
		this.modo.atacar(monstruoAtacado, this);
	}

	public int recibirAtaque(int puntosDeAtaque) {
		return this.modo.recibirAtaque(puntosDeAtaque, this);
	}



	
}