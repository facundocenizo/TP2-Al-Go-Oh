package fiuba.algo3.tp2.fabricas;

import fiuba.algo3.tp2.Efectos.EfectoSogen;
import fiuba.algo3.tp2.Efectos.EfectoWasteland;
import fiuba.algo3.tp2.atributosCarta.Efecto;
import fiuba.algo3.tp2.cartas.CartaCampo;

public enum FabricaCartaCampo {
	
	
	WASTELAND{
		public CartaCampo crear(){
			
			Efecto efecto = new EfectoWasteland();
			CartaCampo cartaCampo = new CartaCampo(efecto);
			cartaCampo.setNombre("wasteland");
			cartaCampo.setDescripcion("Efecto: aumenta en 200\r\n" + 
					"puntos el ataque de tus monstruos, \r\n" + 
					"y 300 puntos la defensa de los\r\n" + 
					"monstruos de tu oponente.\r\n" + 
					"");
			return cartaCampo;
		}
	},
	SOGEN{
		public CartaCampo crear(){
			
			Efecto efecto = new EfectoSogen();
			CartaCampo cartaCampo = new CartaCampo(efecto);
			cartaCampo.setNombre("sogen");
			cartaCampo.setDescripcion("Efecto: aumenta en 500\r\n" + 
					"los puntos de defensa de tus\r\n" + 
					"monstruos, y 200 los puntos de \r\n" + 
					"ataque de los monstruos de \r\n" + 
					"tu oponente.\r\n" + 
					"");
			return cartaCampo;
		}
	};
	

	public abstract CartaCampo crear();
}
