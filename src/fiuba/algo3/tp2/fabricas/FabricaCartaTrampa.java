package fiuba.algo3.tp2.fabricas;

import cartas.Trampa;
import fiuba.algo3.tp2.Efectos.EfectoCilindroMagico;
import fiuba.algo3.tp2.Efectos.EfectoReinforcements;
import fiuba.algo3.tp2.atributosCarta.Efecto;

public enum FabricaCartaTrampa {

	
	CILINDROMAGICO{
		public Trampa crear(){
			
			Efecto efecto = new EfectoCilindroMagico();
			Trampa cartaTrampa = new Trampa(efecto);
			cartaTrampa.setNombre("cilindroMagico");
			cartaTrampa.setDescripcion("efecto: niega el ataque del\r\n" + 
					"monstruo atacante, e\r\n" + 
					"inflige el mismo daño\r\n" + 
					"directamente a los puntos\r\n" + 
					"de vida del oponente");
			return cartaTrampa;
		}
	},
	REINFORCEMENTS{
		public Trampa crear(){
			
			Efecto efecto = new EfectoReinforcements();
			Trampa cartaTrampa = new Trampa(efecto);
			cartaTrampa.setNombre("reinforcements");
			cartaTrampa.setDescripcion("efecto: tu monstruo\r\n" + 
					"atacado, gana 500 puntos\r\n" + 
					"de ataque hasta el final\r\n" + 
					"del turno.");
			return cartaTrampa;
		}
	};

	public abstract Trampa crear();
}
