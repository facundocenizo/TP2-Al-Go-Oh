package fiuba.algo3.tp2.Efectos;

import java.util.ArrayList;

import fiuba.algo3.tp2.LadoDelCampo;
import fiuba.algo3.tp2.atributosCarta.Efecto;
import fiuba.algo3.tp2.cartas.Monstruo;

public class EfectoFisura implements Efecto {

	@Override
	public void aplicarEfecto(LadoDelCampo propio, LadoDelCampo rival) {
		
		ArrayList<Monstruo> listaMonstruos = rival.verMonstruos();
		Monstruo monstruoMasDebil = null;
		int puntosMasBajos = 9999999;
		
		for(Monstruo monstruo : listaMonstruos) {
			if(puntosMasBajos > monstruo.darPuntosDeAtaque()) {
				monstruoMasDebil = monstruo;			
				puntosMasBajos = monstruo.darPuntosDeAtaque();
			}
		}
		rival.sacarMonstruo(monstruoMasDebil);
		
	}

	@Override
	public void aplicarEfecto(Monstruo atacante, Monstruo atacado) {
		// TODO Auto-generated method stub
		
	}

	

}
