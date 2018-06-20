package fiuba.algo3.tp2.factories;

import fiuba.algo3.tp2.Monstruo;
import fiuba.algo3.tp2.Efectos.EfectoNulo;
import fiuba.algo3.tp2.atributosCarta.BocaAbajo;
import fiuba.algo3.tp2.atributosCarta.Efecto;
import fiuba.algo3.tp2.atributosCarta.Posicion;
import fiuba.algo3.tp2.atributosMonstruo.Debil;
import fiuba.algo3.tp2.atributosMonstruo.Modo;
import fiuba.algo3.tp2.atributosMonstruo.ModoAtaque;
import fiuba.algo3.tp2.atributosMonstruo.Nivel;
import fiuba.algo3.tp2.atributosMonstruo.Normal;
import fiuba.algo3.tp2.atributosMonstruo.Poderoso;


public enum FabricaCartaMonstruo {

	DROGON{
		public Monstruo crear(){
			Posicion posicion = new BocaAbajo();
			Modo modo = new ModoAtaque();
			Nivel nivel = new Debil();
			int puntosDeAtaque = 400;
			int puntosDeDefensa = 300;
			Efecto efecto = new EfectoNulo();
			
			return new Monstruo(posicion, modo, nivel, puntosDeAtaque, puntosDeDefensa, efecto);
		}
	},
	MAGOOSCURO{
		public Monstruo crear(){
			Posicion posicion = new BocaAbajo();
			Modo modo = new ModoAtaque();
			Nivel nivel = new Normal();
			int puntosDeAtaque = 2500;
			int puntosDeDefensa = 2100;
			Efecto efecto = new EfectoNulo();

			return new Monstruo(posicion, modo, nivel, puntosDeAtaque, puntosDeDefensa, efecto);
		}
	},
	DROGONDEFINITIVO{
		public Monstruo crear(){
			Posicion posicion = new BocaAbajo();
			Modo modo = new ModoAtaque();
			Nivel nivel = new Poderoso();
			int puntosDeAtaque = 4500;
			int puntosDeDefensa = 3800;
			Efecto efecto = new EfectoNulo();
			
			return new Monstruo(posicion, modo, nivel, puntosDeAtaque, puntosDeDefensa, efecto);
		}
	};
	
	
	public abstract Monstruo crear();
	
	
	
}
