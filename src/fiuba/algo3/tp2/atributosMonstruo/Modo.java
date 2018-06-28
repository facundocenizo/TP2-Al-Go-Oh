package fiuba.algo3.tp2.atributosMonstruo;

import fiuba.algo3.tp2.cartas.Monstruo;

public interface Modo {
	
	public boolean estaEnModoAtaque();
	
	public void cargarPuntos(int puntosDeAtaque, int puntosDeDefensa);
	
	public int atacar(Monstruo monstruoAtacado, Monstruo mounstruo);
	
	public int recibirAtaque(int puntosDeAtaque, Monstruo monstruo);

	public void aumentarPuntosDeAtaque(int aumentoDePruebas);
		

}
