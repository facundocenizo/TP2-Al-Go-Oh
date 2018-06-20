package fiuba.algo3.tp2;

import java.util.ArrayList;

import fiuba.algo3.tp2.fabricas.FabricaCartaMonstruo;

public class MazoCartas {

	private ArrayList<Carta> mazo;
	
	public MazoCartas() {
		this.mazo = new ArrayList<Carta>();
		
		mazo.add(FabricaCartaMonstruo.MAGOOSCURO.crear());
		mazo.add(FabricaCartaMonstruo.MAGOOSCURO.crear());
		mazo.add(FabricaCartaMonstruo.MAGOOSCURO.crear());
		
		
		//mezclar las cartas con un random o shuffle
	}
}
