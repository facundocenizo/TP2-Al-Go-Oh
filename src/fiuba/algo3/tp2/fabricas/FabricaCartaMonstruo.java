package fiuba.algo3.tp2.fabricas;

import fiuba.algo3.tp2.Efectos.EfectoDefensa;
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
import fiuba.algo3.tp2.cartas.Monstruo;


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
			cartaMonstruo.setDescripcion("ATK: 400\r\n" + 
					"DEF: 300.\r\n");
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
			cartaMonstruo.setDescripcion("ATK: 2500\r\n" + 
					"DEF: 2100.\r\n");
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
			cartaMonstruo.setDescripcion("ATK: 4500\r\n" + 
					"DEF: 3800.\r\n");
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
			cartaMonstruo.setDescripcion("ATK: 600\r\n" + 
					"DEF: 900.\r\n");
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
			cartaMonstruo.setDescripcion("ATK: 450 DEF: 600\r\n"
					+ "Efecto: destruye un monstruo\r\n" + 
					"en el campo. Este efecto\r\n" + 
					"unicamente puede activarse \r\n" + 
					"cuando esta carta pasa de \r\n" + 
					"estar boca abajo a boca arriba.\r\n" + 
					"");
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
			cartaMonstruo.setDescripcion("ATK: 3000\r\n" + 
					"DEF: 2500.\r\n");
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
			cartaMonstruo.setDescripcion("ATK: 500\r\n" + 
					"DEF: 400.\r\n"
					+ "Efecto: puede atacar\r\n" + 
					"directamente a los puntos\r\n" + 
					"de vida del oponente");
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
			cartaMonstruo.setDescripcion("ATK: 1000\r\n" + 
					"DEF: 1000.\r\n" +
					"Efecto: al tener las 5\r\n" + 
					"partes juntas en la mano\r\n" + 
					"automaticamente se gana\r\n" + 
					"la partida.");
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
			cartaMonstruo.setDescripcion("ATK: 200\r\n" + 
					"DEF: 300.\r\n" +
					"Efecto: al tener las 5\r\n" + 
					"partes juntas en la mano\r\n" + 
					"automaticamente se gana\r\n" + 
					"la partida.");
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
			cartaMonstruo.setDescripcion("ATK: 200\r\n" + 
					"DEF: 300.\r\n" +
					"Efecto: al tener las 5\r\n" + 
					"partes juntas en la mano\r\n" + 
					"automaticamente se gana\r\n" + 
					"la partida.");
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
			cartaMonstruo.setDescripcion("ATK: 200\r\n" + 
					"DEF: 300.\r\n" +
					"Efecto: al tener las 5\r\n" + 
					"partes juntas en la mano\r\n" + 
					"automaticamente se gana\r\n" + 
					"la partida.");
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
			cartaMonstruo.setDescripcion("ATK: 200\r\n" + 
					"DEF: 300.\r\n" +
					"Efecto: al tener las 5\r\n" + 
					"partes juntas en la mano\r\n" + 
					"automaticamente se gana\r\n" + 
					"la partida.");
			return cartaMonstruo;
		}
	};
	
	
	
	
	public abstract Monstruo crear();
	
	
	
}
