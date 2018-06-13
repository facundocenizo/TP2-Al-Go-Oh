package fiuba.algo3.tp2;

import java.util.ArrayList;

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


}
