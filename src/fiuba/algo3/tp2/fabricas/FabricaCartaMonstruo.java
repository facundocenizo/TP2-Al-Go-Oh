package fiuba.algo3.tp2.fabricas;

import fiuba.algo3.tp2.EfectoDefensa;
import fiuba.algo3.tp2.Monstruo;
import fiuba.algo3.tp2.Efectos.EfectoExodia;
import fiuba.algo3.tp2.Efectos.EfectoInsectoComeHombres;
import fiuba.algo3.tp2.Efectos.EfectoJinzoSiete;
import fiuba.algo3.tp2.Efectos.SinEfecto;
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

	DRAGON{
		public Monstruo crear(){
			Posicion posicion = new BocaAbajo();
			Modo modo = new ModoAtaque();
			Nivel nivel = new Debil();
			int puntosDeAtaque = 400;
			int puntosDeDefensa = 300;
			Efecto efecto = new SinEfecto();
			EfectoDefensa efectoDefensa = new SinEfecto();
			
			Monstruo cartaMonstruo = new Monstruo(posicion, modo, nivel, puntosDeAtaque, puntosDeDefensa, efecto, efectoDefensa);
			cartaMonstruo.setNombre("dragon");
			return cartaMonstruo;
		}
	},
	MAGOOSCURO{
		public Monstruo crear(){
			Posicion posicion = new BocaAbajo();
			Modo modo = new ModoAtaque();
			Nivel nivel = new Normal();
			int puntosDeAtaque = 2500;
			int puntosDeDefensa = 2100;
			Efecto efecto = new SinEfecto();
			EfectoDefensa efectoDefensa = new SinEfecto();
			
			Monstruo cartaMonstruo = new Monstruo(posicion, modo, nivel, puntosDeAtaque, puntosDeDefensa, efecto, efectoDefensa);
			cartaMonstruo.setNombre("magoOscuro");
			return cartaMonstruo;
		}
	},
	DRAGONDEFINITIVO{
		public Monstruo crear(){
			Posicion posicion = new BocaAbajo();
			Modo modo = new ModoAtaque();
			Nivel nivel = new Poderoso();
			int puntosDeAtaque = 4500;
			int puntosDeDefensa = 3800;
			Efecto efecto = new SinEfecto();
			EfectoDefensa efectoDefensa = new SinEfecto();
		
			Monstruo cartaMonstruo = new Monstruo(posicion, modo, nivel, puntosDeAtaque, puntosDeDefensa, efecto, efectoDefensa);
			cartaMonstruo.setNombre("dragonDefinitivo");
			return cartaMonstruo;
		}
	},

	HUEVOMONSTRUOSO{
		public Monstruo crear(){
			Posicion posicion = new BocaAbajo();
			Modo modo = new ModoAtaque();
			Nivel nivel = new Debil();
			int puntosDeAtaque = 600;
			int puntosDeDefensa = 900;
			Efecto efecto = new SinEfecto();
			EfectoDefensa efectoDefensa = new SinEfecto();

			Monstruo cartaMonstruo = new Monstruo(posicion, modo, nivel, puntosDeAtaque, puntosDeDefensa, efecto, efectoDefensa);
			cartaMonstruo.setNombre("huevo");
			return cartaMonstruo;
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
			EfectoDefensa efectoDefensa = new EfectoInsectoComeHombres();

			Monstruo cartaMonstruo = new Monstruo(posicion, modo, nivel, puntosDeAtaque, puntosDeDefensa, efecto, efectoDefensa);
			cartaMonstruo.setNombre("insecto");
			return cartaMonstruo;
		}
	},
	DRAGONBLANCO{
		public Monstruo crear(){
			Posicion posicion = new BocaAbajo();
			Modo modo = new ModoAtaque();
			Nivel nivel = new Debil();
			int puntosDeAtaque = 3000;
			int puntosDeDefensa = 2500;
			Efecto efecto = new SinEfecto();
			EfectoDefensa efectoDefensa = new SinEfecto();

			Monstruo cartaMonstruo = new Monstruo(posicion, modo, nivel, puntosDeAtaque, puntosDeDefensa, efecto, efectoDefensa);
			cartaMonstruo.setNombre("dragonBlanco");
			return cartaMonstruo;
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
			EfectoDefensa efectoDefensa = new SinEfecto();

			Monstruo cartaMonstruo = new Monstruo(posicion, modo, nivel, puntosDeAtaque, puntosDeDefensa, efecto, efectoDefensa);
			cartaMonstruo.setNombre("jinzo7");
			return cartaMonstruo;
		}
	},
	CABEZAEXODIA{
		public Monstruo crear(){
			Posicion posicion = new BocaAbajo();
			Modo modo = new ModoAtaque();
			Nivel nivel = new Debil();
			int puntosDeAtaque = 1000;
			int puntosDeDefensa = 1000;
			Efecto efecto = new EfectoExodia();
			EfectoDefensa efectoDefensa = new SinEfecto();

			Monstruo cartaMonstruo = new Monstruo(posicion, modo, nivel, puntosDeAtaque, puntosDeDefensa, efecto, efectoDefensa);
			cartaMonstruo.setNombre("cabezaExodia");
			return cartaMonstruo;
		}
	},
	BRAZODERECHO{
		public Monstruo crear(){
			Posicion posicion = new BocaAbajo();
			Modo modo = new ModoAtaque();
			Nivel nivel = new Debil();
			int puntosDeAtaque = 200;
			int puntosDeDefensa = 300;
			Efecto efecto = new EfectoExodia();
			EfectoDefensa efectoDefensa = new SinEfecto();

			Monstruo cartaMonstruo = new Monstruo(posicion, modo, nivel, puntosDeAtaque, puntosDeDefensa, efecto, efectoDefensa);
			cartaMonstruo.setNombre("brazoDerecho");
			return cartaMonstruo;
		}
	},
	BRAZOIZQUIERDO{
		public Monstruo crear(){
			Posicion posicion = new BocaAbajo();
			Modo modo = new ModoAtaque();
			Nivel nivel = new Debil();
			int puntosDeAtaque = 200;
			int puntosDeDefensa = 300;
			Efecto efecto = new EfectoExodia();
			EfectoDefensa efectoDefensa = new SinEfecto();

			Monstruo cartaMonstruo = new Monstruo(posicion, modo, nivel, puntosDeAtaque, puntosDeDefensa, efecto, efectoDefensa);
			cartaMonstruo.setNombre("brazoIzquierdo");
			return cartaMonstruo;
		}
	},
	PIERNADERECHA{
		public Monstruo crear(){
			Posicion posicion = new BocaAbajo();
			Modo modo = new ModoAtaque();
			Nivel nivel = new Debil();
			int puntosDeAtaque = 200;
			int puntosDeDefensa = 300;
			Efecto efecto = new EfectoExodia();
			EfectoDefensa efectoDefensa = new SinEfecto();
			
			Monstruo cartaMonstruo = new Monstruo(posicion, modo, nivel, puntosDeAtaque, puntosDeDefensa, efecto, efectoDefensa);
			cartaMonstruo.setNombre("piernaDerecha");
			return cartaMonstruo;
		}
	},
	PIERNAIZQUIERDA{
		public Monstruo crear(){
			Posicion posicion = new BocaAbajo();
			Modo modo = new ModoAtaque();
			Nivel nivel = new Debil();
			int puntosDeAtaque = 200;
			int puntosDeDefensa = 300;
			Efecto efecto = new EfectoExodia();
			EfectoDefensa efectoDefensa = new SinEfecto();
			
			Monstruo cartaMonstruo = new Monstruo(posicion, modo, nivel, puntosDeAtaque, puntosDeDefensa, efecto, efectoDefensa);
			cartaMonstruo.setNombre("piernaIzquierda");
			return cartaMonstruo;
		}
	};
	
	
	
	
	public abstract Monstruo crear();
	
	
	
}
