package fiuba.algo3.tp2.cartasMonstruo;

import fiuba.algo3.tp2.Monstruo;
import fiuba.algo3.tp2.Efectos.EfectoNulo;
import fiuba.algo3.tp2.atributosCarta.Efecto;
import fiuba.algo3.tp2.atributosCarta.Posicion;
import fiuba.algo3.tp2.atributosMonstruo.Debil;
import fiuba.algo3.tp2.atributosMonstruo.Modo;

public class HuevoMonstruoso extends Monstruo{

	public HuevoMonstruoso(Posicion posicion, Modo modo, Efecto efecto) {
		super(posicion, modo, new Debil(), 600, 900, new EfectoNulo());
	}

}