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
			cartaMagica.setNombre("agujero");
			cartaMagica.setDescripcion("efecto: destruye todos los\r\n" + 
					"monstruos del campo.");
			return cartaMagica;
		}
	},
	
	FISURA{
		public Magica crear(){
			Posicion posicion = new BocaAbajo();
			Efecto efecto = new EfectoFisura();
			Magica cartaMagica = new Magica(posicion, efecto);
			cartaMagica.setNombre("fisura");
			cartaMagica.setDescripcion("efecto: destruye el\r\n" + 
					"monstruo boca arriba con\r\n" + 
					"menor ataque en el campo\r\n" + 
					"del oponente (si hay\r\n" + 
					"empate elige al azar).");
			return cartaMagica;
		}
	},
	OLLADELACODICIA{
		public Magica crear(){
			Posicion posicion = new BocaAbajo();
			Efecto efecto = new EfectoOllaDeLaCodicia();
			Magica cartaMagica = new Magica(posicion, efecto);
			cartaMagica.setNombre("olla");
			cartaMagica.setDescripcion("efecto: toma 2 cartas del\r\n" + 
					"mazo");
			return cartaMagica;
		}
	};
	
	

	public abstract Magica crear();
}
