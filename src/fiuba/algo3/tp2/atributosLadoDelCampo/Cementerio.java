package fiuba.algo3.tp2.atributosLadoDelCampo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import fiuba.algo3.tp2.cartas.Carta;
import fiuba.algo3.tp2.cartas.Monstruo;

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

	public void limpiarZonaDeMonstruosMuertos(LinkedList<Monstruo> zonaDeMonstruosDeJugador) { //este metodo va a servir para todos los cambios de turnos.
		for(Iterator<Monstruo> iter = zonaDeMonstruosDeJugador.iterator(); iter.hasNext();) {
		    Monstruo unMonstruo = iter.next();
		    if (unMonstruo.estaMuerta()) {
		    	cartasMuertas.add(unMonstruo);
		        iter.remove();
		    }
		}
		
	}


}
