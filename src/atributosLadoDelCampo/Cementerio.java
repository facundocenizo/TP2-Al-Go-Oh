package atributosLadoDelCampo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import cartas.Carta;
import cartas.Monstruo;

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
