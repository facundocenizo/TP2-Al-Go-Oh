package fiuba.algo3.tp2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Cementerio {
	
	private ArrayList<Carta> cartasMuertas;

	public Cementerio() {
		cartasMuertas = new ArrayList<Carta>();
	
	}
	
	public void agregarCarta(Carta carta) {
		cartasMuertas.add(carta);
	}

	public boolean contieneCarta(Carta carta) {
		return cartasMuertas.contains(carta);
	}

	public void limpiarZonaDeMonstruosMuertos(LinkedList<Monstruo> zonaDeMonstruosDeJugador) {
		//for (Monstruo unMonstruo: zonaDeMonstruosDeJugador) {
		//	if (unMonstruo.estaMuerta()) {
		//		cartasMuertas.add(unMonstruo);
		//		//zonaDeMonstruosDeJugador.remove(unMonstruo);
		//	}
		//}
		for(Iterator<Monstruo> iter = zonaDeMonstruosDeJugador.iterator(); iter.hasNext();) {
		    Monstruo unMonstruo = iter.next();
		    if (unMonstruo.estaMuerta()) {
		    	cartasMuertas.add(unMonstruo);
		        iter.remove();
		    }
		}
		
	}


}
