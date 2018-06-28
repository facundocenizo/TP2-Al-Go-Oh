package fiuba.algo3.tp2.fabricas;

import fiuba.algo3.tp2.Trampa;
import fiuba.algo3.tp2.Efectos.EfectoCilindroMagico;
import fiuba.algo3.tp2.Efectos.EfectoReinforcements;
import fiuba.algo3.tp2.atributosCarta.Efecto;

public enum FabricaCartaTrampa {

	
	CILINDROMAGICO{
		public Trampa crear(){
			
			Efecto efecto = new EfectoCilindroMagico();
			Trampa cartaTrampa = new Trampa(efecto);
			cartaTrampa.setNombre("cilindroMagico");
			return cartaTrampa;
		}
	},
	REINFORCEMENTS{
		public Trampa crear(){
			
			Efecto efecto = new EfectoReinforcements();
			Trampa cartaTrampa = new Trampa(efecto);
			cartaTrampa.setNombre("reinforcements");
			return cartaTrampa;
		}
	};

	public abstract Trampa crear();
}
