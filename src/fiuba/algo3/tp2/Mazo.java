package fiuba.algo3.tp2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fiuba.algo3.tp2.atributosCarta.BocaAbajo;
import fiuba.algo3.tp2.atributosMonstruo.ModoAtaque;
import fiuba.algo3.tp2.cartasMonstruo.HuevoMonstruoso;
import fiuba.algo3.tp2.excepciones.MazoVacioException;

public class Mazo {
	
	private int nroCartas;
	private List<Class<? extends Carta>> cartas;
	
	public Mazo () {
		nroCartas = 40;
		cartas = new ArrayList<Class<? extends Carta>>();
		cartas.add( HuevoMonstruoso.class );
	}
	
	public Carta tomarCarta() {
		if (nroCartas==0) {
			throw new MazoVacioException();
		}
		Carta aDevolver = null;
		try {
			aDevolver = cartas.get(new Random().nextInt(cartas.size())).getDeclaredConstructor().newInstance(new BocaAbajo(), new ModoAtaque());
		} catch (Exception e) {
		}
		nroCartas--;
		return aDevolver;
	}

}
