package fiuba.algo3.tp2;

import java.util.LinkedList;

public class CampoDeBatalla {

	private static CampoDeBatalla instanciaCampoDeBatalla = null;
	
	
	private LinkedList<Monstruo> zonaDeMonstruosDeJugador1;
	private LinkedList<Monstruo> zonaDeMonstruosDeJugador2;
	private Cementerio cementerioDeJugador1;
	private Cementerio cementerioDeJugador2;
	private LadoDelCampo ladoj1; //inicializar en constructor
	private LadoDelCampo ladoj2;
	
	

	public static CampoDeBatalla getInstance (){
		if (instanciaCampoDeBatalla == null)
			instanciaCampoDeBatalla = new CampoDeBatalla();
		return instanciaCampoDeBatalla;
	}
	
	private CampoDeBatalla() {
		zonaDeMonstruosDeJugador1 = new LinkedList<Monstruo>();
		zonaDeMonstruosDeJugador2 = new LinkedList<Monstruo>();
		cementerioDeJugador1 = new Cementerio();
		cementerioDeJugador2 = new Cementerio();
	}
	

	
	public void recibirMonstruoDeJugador1(Monstruo cartaMonstruo) {
		if (cartaMonstruo.esNormal()) {
			zonaDeMonstruosDeJugador1.get(0).morir();
		}
		if (cartaMonstruo.esPoderoso()) {
			zonaDeMonstruosDeJugador1.get(0).morir();
			zonaDeMonstruosDeJugador1.get(1).morir();
		}
		zonaDeMonstruosDeJugador1.add(cartaMonstruo);
	}
	
	
	public void recibirMonstruoDeJugador2(Monstruo cartaMonstruo) {
		if (cartaMonstruo.esNormal()) {
			zonaDeMonstruosDeJugador2.get(0).morir();
		}
		if (cartaMonstruo.esPoderoso()) {
			zonaDeMonstruosDeJugador2.get(0).morir();
			zonaDeMonstruosDeJugador2.get(1).morir();
		}
		zonaDeMonstruosDeJugador2.add(cartaMonstruo);
	}

	public void matarATodosLosMonstruos() {
		
		for (Monstruo monstruo: this.zonaDeMonstruosDeJugador1)  {
			monstruo.morir();
			
		}
		for (Monstruo monstruo: this.zonaDeMonstruosDeJugador2)  {
			monstruo.morir();
		}
	}
	
	public void barrerZonaDeMonstruos() {
		cementerioDeJugador1.limpiarZonaDeMonstruosMuertos(this.zonaDeMonstruosDeJugador1);
		cementerioDeJugador2.limpiarZonaDeMonstruosMuertos(this.zonaDeMonstruosDeJugador2);
	}
	
	public int cantidadDeMonstruosActivos() {
		return (this.zonaDeMonstruosDeJugador1.size()) + (this.zonaDeMonstruosDeJugador2.size());
	}
	
	
	
	

	
	
	public static void reiniciarCampoDeBatalla (){
		instanciaCampoDeBatalla = null;
	}
}
