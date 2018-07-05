package fiuba.algo3.tp2.atributosLadoDelCampo;

import java.util.ArrayList;

import fiuba.algo3.tp2.cartas.Carta;
import fiuba.algo3.tp2.fabricas.FabricaCartaCampo;
import fiuba.algo3.tp2.fabricas.FabricaCartaMagica;
import fiuba.algo3.tp2.fabricas.FabricaCartaMonstruo;
import fiuba.algo3.tp2.fabricas.FabricaCartaTrampa;

import java.util.Random;

public class MazoCartas {

	private ArrayList<Carta> mazo;
	
	public MazoCartas() {
		this.mazo = new ArrayList<Carta>();
		
		mazo.add(FabricaCartaMonstruo.MAGOOSCURO.crear());
		mazo.add(FabricaCartaMonstruo.MAGOOSCURO.crear());
		mazo.add(FabricaCartaMonstruo.MAGOOSCURO.crear());

		mazo.add(FabricaCartaMonstruo.DRAGONBLANCO.crear());
		mazo.add(FabricaCartaMonstruo.DRAGONBLANCO.crear());
		mazo.add(FabricaCartaMonstruo.DRAGONBLANCO.crear());

		mazo.add(FabricaCartaMonstruo.DRAGONDEFINITIVO.crear());

		mazo.add(FabricaCartaMonstruo.HUEVOMONSTRUOSO.crear());
		mazo.add(FabricaCartaMonstruo.HUEVOMONSTRUOSO.crear());
		mazo.add(FabricaCartaMonstruo.HUEVOMONSTRUOSO.crear());
		
		mazo.add(FabricaCartaMonstruo.INSECTOCOMEHOMBRES.crear());
		mazo.add(FabricaCartaMonstruo.INSECTOCOMEHOMBRES.crear());
		mazo.add(FabricaCartaMonstruo.INSECTOCOMEHOMBRES.crear());

		mazo.add(FabricaCartaMonstruo.JINZOSIETE.crear());
		mazo.add(FabricaCartaMonstruo.JINZOSIETE.crear());
		mazo.add(FabricaCartaMonstruo.JINZOSIETE.crear());

		mazo.add(FabricaCartaMonstruo.CABEZAEXODIA.crear());
		mazo.add(FabricaCartaMonstruo.BRAZODERECHO.crear());
		mazo.add(FabricaCartaMonstruo.BRAZOIZQUIERDO.crear());
		mazo.add(FabricaCartaMonstruo.PIERNADERECHA.crear());
		mazo.add(FabricaCartaMonstruo.PIERNAIZQUIERDA.crear());
		
		//21 monstruos 

		mazo.add(FabricaCartaMagica.AGUJERONEGRO.crear());
		mazo.add(FabricaCartaMagica.AGUJERONEGRO.crear());
		mazo.add(FabricaCartaMagica.AGUJERONEGRO.crear());

		mazo.add(FabricaCartaMagica.FISURA.crear());
		mazo.add(FabricaCartaMagica.FISURA.crear());
		mazo.add(FabricaCartaMagica.FISURA.crear());
		
		mazo.add(FabricaCartaMagica.OLLADELACODICIA.crear());
		mazo.add(FabricaCartaMagica.OLLADELACODICIA.crear());
		mazo.add(FabricaCartaMagica.OLLADELACODICIA.crear());
		
		//9 magicas

		mazo.add(FabricaCartaTrampa.CILINDROMAGICO.crear());
		mazo.add(FabricaCartaTrampa.CILINDROMAGICO.crear());
		mazo.add(FabricaCartaTrampa.CILINDROMAGICO.crear());

		mazo.add(FabricaCartaTrampa.REINFORCEMENTS.crear());
		mazo.add(FabricaCartaTrampa.REINFORCEMENTS.crear());
		mazo.add(FabricaCartaTrampa.REINFORCEMENTS.crear());
		//6 trampas

		mazo.add(FabricaCartaCampo.SOGEN.crear());
		mazo.add(FabricaCartaCampo.SOGEN.crear());

		mazo.add(FabricaCartaCampo.WASTELAND.crear());
		mazo.add(FabricaCartaCampo.WASTELAND.crear());
		//4  de campo
		
		//Total = 40 cartas
	}
	
	public Carta sacarCarta() {

		Random rand = new Random();
		int numeroCartasEnElMazo = mazo.size();
		int numeroRandom = rand.nextInt(numeroCartasEnElMazo);
		//numeroCartasEnElMazo es el maximo y 0 es el minimo
		
		Carta cartaADevolverCarta = mazo.get(numeroRandom);
		mazo.remove(numeroRandom);
		return cartaADevolverCarta;
	}

	public boolean estaVacio() {
		return mazo.isEmpty();
	}
	
}
