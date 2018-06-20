package fiuba.algo3.tp2;


public class CampoDeBatalla {

	private static CampoDeBatalla instanciaCampoDeBatalla = null;

	public static CampoDeBatalla getInstance (){
		if (instanciaCampoDeBatalla == null)
			instanciaCampoDeBatalla = new CampoDeBatalla();
		return instanciaCampoDeBatalla;
	}
	

	
	
	public static void reiniciarCampoDeBatalla (){
		instanciaCampoDeBatalla = null;
	}
}
