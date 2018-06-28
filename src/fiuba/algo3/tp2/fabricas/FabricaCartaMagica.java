package fiuba.algo3.tp2.fabricas;

import fiuba.algo3.tp2.Magica;
import fiuba.algo3.tp2.Efectos.EfectoAgujeroNegro;
import fiuba.algo3.tp2.Efectos.EfectoOllaDeLaCodicia;
import fiuba.algo3.tp2.Efectos.EfectoFisura;
import fiuba.algo3.tp2.atributosCarta.BocaAbajo;
import fiuba.algo3.tp2.atributosCarta.Efecto;
import fiuba.algo3.tp2.atributosCarta.Posicion;

public enum FabricaCartaMagica {

	AGUJERONEGRO{
		public Magica crear(){
			Posicion posicion = new BocaAbajo();
			Efecto efecto = new EfectoAgujeroNegro();
			Magica cartaMagica = new Magica(posicion, efecto);
			cartaMagica.setNombre("agujeroNegro");
			return cartaMagica;
		}
	},
	
	FISURA{
		public Magica crear(){
			Posicion posicion = new BocaAbajo();
			Efecto efecto = new EfectoFisura();
			Magica cartaMagica = new Magica(posicion, efecto);
			cartaMagica.setNombre("fisura");
			return cartaMagica;
		}
	},
	OLLADELACODICIA{
		public Magica crear(){
			Posicion posicion = new BocaAbajo();
			Efecto efecto = new EfectoOllaDeLaCodicia();
			Magica cartaMagica = new Magica(posicion, efecto);
			cartaMagica.setNombre("olla");
			return cartaMagica;
		}
	};
	
	

	public abstract Magica crear();
}
