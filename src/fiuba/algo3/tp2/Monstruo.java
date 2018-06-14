package fiuba.algo3.tp2;

public class Monstruo extends Carta{
	
	private Modo modo;
	private int estrellas;
	private int puntosDeAtaque;
	private int puntosDeDefensa;
	
	public Monstruo(Posicion posicion, Modo modo, int estrellas, int puntosDeAtaque, int puntosDeDefensa) {
		super(posicion);
		this.modo = modo;
		this.modo.cargarPuntos(puntosDeAtaque,puntosDeDefensa);
		this.estrellas = estrellas;
		this.puntosDeAtaque = puntosDeAtaque;
		this.puntosDeDefensa = puntosDeDefensa;
		
    }

	public boolean estaEnModoAtaque() {
		return modo.estaEnModoAtaque();
	}

	@Override
	public void aplicarEfecto() {
		// TODO Auto-generated method stub
		
	}

	public int atacar(Monstruo monstruoAtacado) {
		return this.modo.atacar(monstruoAtacado, this);
	}

	public int recibirAtaque(int puntosDeAtaque) {
		return this.modo.recibirAtaque(puntosDeAtaque, this);
	}



	
}