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
			cartaCampo.setDescripcion("Nombre: Wasteland\n"
					+ "Tipo de carta: Campo\n"
					+ "Efecto: aumenta en 200\r\n" + 
					"puntos el ataque de tus\r\n"
					+ "monstruos y 300 puntos la\n"
					+ "defensa de los monstruos\r\n"
					+ "de tu oponente.");
			return cartaCampo;
		}
	},
	SOGEN{
		public CartaCampo crear(){
			
			Efecto efecto = new EfectoSogen();
			CartaCampo cartaCampo = new CartaCampo(efecto);
			cartaCampo.setNombre("sogen");
			cartaCampo.setDescripcion("Nombre: Sogen\n"
					+ "Tipo de carta: Campo\n"
					+ "Efecto: aumenta en 500\r\n" + 
					"los puntos de defensa de\r\n" + 
					"tus monstruos, y 200 los\r\n" + 
					"puntos de ataque de los\r\n" + 
					"monstruos de tu oponente.");
			return cartaCampo;
		}
	};
	

	public abstract CartaCampo crear();
}
