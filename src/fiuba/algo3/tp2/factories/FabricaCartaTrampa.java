package fiuba.algo3.tp2.factories;

import fiuba.algo3.tp2.Trampa;
import fiuba.algo3.tp2.Efectos.EfectoCilindroMagico;
import fiuba.algo3.tp2.Efectos.EfectoReinforcements;
import fiuba.algo3.tp2.atributosCarta.Efecto;

public enum FabricaCartaTrampa {

	
	CILINDROMAGICO{
		public Trampa crear(){
			
			Efecto efecto = new EfectoCilindroMagico();
			return new Trampa(efecto);
		}
	},
	REINFORCEMENTS{
		public Trampa crear(){
			
			Efecto efecto = new EfectoReinforcements();
			return new Trampa(efecto);
		}
	};

	public abstract Trampa crear();
}
