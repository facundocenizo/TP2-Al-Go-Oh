package fiuba.algo3.tp2.fabricas;

import fiuba.algo3.tp2.Efectos.EfectoCilindroMagico;
import fiuba.algo3.tp2.Efectos.EfectoReinforcements;
import fiuba.algo3.tp2.atributosCarta.Efecto;
import fiuba.algo3.tp2.cartas.Trampa;

public enum FabricaCartaTrampa {

	
	CILINDROMAGICO{
		public Trampa crear(){
			
			Efecto efecto = new EfectoCilindroMagico();
			Trampa cartaTrampa = new Trampa(efecto);
			cartaTrampa.setNombre("cilindroMagico");
			cartaTrampa.setDescripcion("Nombre: Cilindro Magico\n"
					+ "Tipo de carta: Trampa\n"
					+ "Efecto: niega el ataque del\r\n" + 
					"monstruo atacante, e\r\n" + 
					"inflige el mismo danio\r\n" + 
					"directamente a los puntos\r\n" + 
					"de vida del oponente.");
			return cartaTrampa;
		}
	},
	REINFORCEMENTS{
		public Trampa crear(){
			
			Efecto efecto = new EfectoReinforcements();
			Trampa cartaTrampa = new Trampa(efecto);
			cartaTrampa.setNombre("reinforcements");
			cartaTrampa.setDescripcion("Nombre: Reinforcements\n"
					+ "Tipo de carta: Trampa\n"
					+ "Efecto: tu monstruo\r\n" + 
					"atacado, gana 500 puntos\r\n" + 
					"de ataque hasta el final\r\n" + 
					"del turno.");
			return cartaTrampa;
		}
	};

	public abstract Trampa crear();
}
