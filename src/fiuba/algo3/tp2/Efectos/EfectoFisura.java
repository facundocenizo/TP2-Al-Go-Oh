package fiuba.algo3.tp2.Efectos;

import java.util.ArrayList;

import fiuba.algo3.tp2.LadoDelCampo;
import fiuba.algo3.tp2.Monstruo;
import fiuba.algo3.tp2.atributosCarta.Efecto;

public class EfectoFisura implements Efecto {

	@Override
	public void aplicarEfecto(LadoDelCampo propio, LadoDelCampo rival) {
		
		ArrayList<Monstruo> listaMonstruos = rival.verMonstruos();
		int posicionEnELCampo = 0;
		int puntosMasBajos = 9999999;
		
		for(Monstruo monstruo : listaMonstruos) {
			if(puntosMasBajos < monstruo.darPuntosDeAtaque()) {
				puntosMasBajos = monstruo.darPuntosDeAtaque();
			}
			posicionEnELCampo++;
		}
		
		rival.sacarMonstruo(posicionEnELCampo);
		
	}

	

}
