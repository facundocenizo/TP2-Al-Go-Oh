package fiuba.algo3.tp2.fabricas;

import fiuba.algo3.tp2.CartaCampo;
import fiuba.algo3.tp2.Efectos.EfectoSogen;
import fiuba.algo3.tp2.Efectos.EfectoWasteland;
import fiuba.algo3.tp2.atributosCarta.Efecto;

public enum FabricaCartaCampo {
	
	
	WASTELAND{
		public CartaCampo crear(){
			
			Efecto efecto = new EfectoWasteland();
			CartaCampo cartaCampo = new CartaCampo(efecto);
			cartaCampo.setNombre("wasteland");
			return cartaCampo;
		}
	},
	SOGEN{
		public CartaCampo crear(){
			
			Efecto efecto = new EfectoSogen();
			CartaCampo cartaCampo = new CartaCampo(efecto);
			cartaCampo.setNombre("sogen");
			return cartaCampo;
		}
	};
	

	public abstract CartaCampo crear();
}
