package fiuba.algo3.tp2.factories;

import fiuba.algo3.tp2.CartaCampo;
import fiuba.algo3.tp2.Efectos.EfectoSogen;
import fiuba.algo3.tp2.Efectos.EfectoWasteland;
import fiuba.algo3.tp2.atributosCarta.Efecto;

public enum FabricaCartaCampo {
	
	
	WASTELAND{
		public CartaCampo crear(){
			
			Efecto efecto = new EfectoWasteland();
			return new CartaCampo(efecto);
		}
	},
	SOGEN{
		public CartaCampo crear(){
			
			Efecto efecto = new EfectoSogen();
			return new CartaCampo(efecto);
		}
	};
	

	public abstract CartaCampo crear();
}
