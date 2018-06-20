package fiuba.algo3.tp2.factories;

import fiuba.algo3.tp2.Magica;
import fiuba.algo3.tp2.Efectos.EfectoAgujeroNegro;
import fiuba.algo3.tp2.Efectos.EfectoOllaDeLaCodicia;
import fiuba.algo3.tp2.Efectos.EfetoFisura;
import fiuba.algo3.tp2.atributosCarta.BocaAbajo;
import fiuba.algo3.tp2.atributosCarta.Efecto;
import fiuba.algo3.tp2.atributosCarta.Posicion;

public enum FabricaCartaMagica {

	AGUJERONEGRO{
		public Magica crear(){
			Posicion posicion = new BocaAbajo();
			Efecto efecto = new EfectoAgujeroNegro();
			return new Magica(posicion, efecto);
		}
	},
	
	FISURA{
		public Magica crear(){
			Posicion posicion = new BocaAbajo();
			Efecto efecto = new EfetoFisura();
			return new Magica(posicion, efecto);
		}
	},
	OLLADELACODICIA{
		public Magica crear(){
			Posicion posicion = new BocaAbajo();
			Efecto efecto = new EfectoOllaDeLaCodicia();
			return new Magica(posicion, efecto);
		}
	}
	;
	
	

	public abstract Magica crear();
}
