package fiuba.algo3.tp2;

import java.util.LinkedList;

public class Campo {
	
	
	private LinkedList<Monstruo> zonaDeMonstruosDeJugador1;
	private LinkedList<Monstruo> zonaDeMonstruosDeJugador2;
	
	public Campo() {
		zonaDeMonstruosDeJugador1 = new LinkedList<Monstruo>();
		zonaDeMonstruosDeJugador2 = new LinkedList<Monstruo>();
	}
	
	public void recibirMonstruoDeJugador1(Monstruo cartaMonstruo) {
		zonaDeMonstruosDeJugador1.add(cartaMonstruo);
	}
	
	public void recibirMonstruoDeJugador2(Monstruo cartaMonstruo) {
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

}
