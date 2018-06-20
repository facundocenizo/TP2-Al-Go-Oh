package fiuba.algo3.tp2.fabricas;

import fiuba.algo3.tp2.Monstruo;
import fiuba.algo3.tp2.Efectos.EfectoInsectoComeHombres;
import fiuba.algo3.tp2.Efectos.EfectoJinzoSiete;
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
	},

	HUEVOMONSTRUOSO{
		public Monstruo crear(){
			Posicion posicion = new BocaAbajo();
			Modo modo = new ModoAtaque();
			Nivel nivel = new Debil();
			int puntosDeAtaque = 600;
			int puntosDeDefensa = 900;
			Efecto efecto = new EfectoNulo();
			
			return new Monstruo(posicion, modo, nivel, puntosDeAtaque, puntosDeDefensa, efecto);
		}
	},
	INSECTOCOMEHOMBRES{
		public Monstruo crear(){
			Posicion posicion = new BocaAbajo();
			Modo modo = new ModoAtaque();
			Nivel nivel = new Debil();
			int puntosDeAtaque = 450;
			int puntosDeDefensa = 600;
			Efecto efecto = new EfectoInsectoComeHombres();
			
			return new Monstruo(posicion, modo, nivel, puntosDeAtaque, puntosDeDefensa, efecto);
		}
	},
	DRAGONBLANCO{
		public Monstruo crear(){
			Posicion posicion = new BocaAbajo();
			Modo modo = new ModoAtaque();
			Nivel nivel = new Debil();
			int puntosDeAtaque = 3000;
			int puntosDeDefensa = 2500;
			Efecto efecto = new EfectoNulo();
			
			return new Monstruo(posicion, modo, nivel, puntosDeAtaque, puntosDeDefensa, efecto);
		}
	},
	JINZOSIETE{
		public Monstruo crear(){
			Posicion posicion = new BocaAbajo();
			Modo modo = new ModoAtaque();
			Nivel nivel = new Debil();
			int puntosDeAtaque = 500;
			int puntosDeDefensa = 400;
			Efecto efecto = new EfectoJinzoSiete();
			
			return new Monstruo(posicion, modo, nivel, puntosDeAtaque, puntosDeDefensa, efecto);
		}
	};
	
	
	public abstract Monstruo crear();
	
	
	
}
