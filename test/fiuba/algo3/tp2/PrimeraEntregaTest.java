package fiuba.algo3.tp2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;

import org.junit.Test;

public class PrimeraEntregaTest {

	@Test
	public void testColocarUnaCartaDeMonstruoEnPosicionDeAtaque() {
		int estrellas = 3;
		int puntosDeAtaque = 1000;
		int puntosDeDefensa = 500;
		Monstruo monstruo = new Monstruo(new BocaArriba(),new ModoAtaque(), estrellas, puntosDeAtaque, puntosDeDefensa);
		
		assertTrue(monstruo.estaEnModoAtaque());
	}
	
	@Test
	public void testColocarUnaCartaDeMonstruoEnPosicionDeDefensa() {
		int estrellas = 3;
		int puntosDeAtaque = 1000;
		int puntosDeDefensa = 500;
		Monstruo monstruo = new Monstruo(new BocaArriba(),new ModoDefensa(), estrellas, puntosDeAtaque, puntosDeDefensa);
		
		assertFalse(monstruo.estaEnModoAtaque());
	}
	
	
	@Test
	public void testColocarUnaCartaMagicaBocaAbajo() {
		Efecto sinEfecto = new SinEfecto();
		Magica magica = new Magica(new BocaAbajo(),sinEfecto);
		assertTrue(magica.estaBocaAbajo());
		
	}
	
	@Test
	public void testColocarUnaCartaTrampaBocaAbajo() {
		Efecto sinEfecto = new SinEfecto();
		Trampa trampa = new Trampa(new BocaAbajo(),sinEfecto);
		assertTrue(trampa.estaBocaAbajo());
	}
	
	@Test
	public void testMandarUnaCartaAlCementerio() {
		Carta carta = new Monstruo(new BocaArriba(),new ModoDefensa(), 4, 1500, 2000);
		Cementerio cementerio = new Cementerio();
		cementerio.agregarCarta(carta);
		
		assertTrue(cementerio.contieneCarta(carta));	
	}
	
	@Test
	public void asd() {
		//esto no hace nada
		CampoDeBatalla campoDeBatalla = new CampoDeBatalla();
		Jugador jugadorAtacante = new Jugador();
		Jugador jugadorAtacado = new Jugador();
		Monstruo monstruoAtacante = new Monstruo(new BocaArriba(),new ModoAtaque(), 2, 500, 300);
		Monstruo monstruoAtacado = new Monstruo(new BocaArriba(),new ModoAtaque(), 2, 400, 200);
		
		
		campoDeBatalla.atacar(jugadorAtacante,jugadorAtacado,monstruoAtacante,monstruoAtacado);
				
	}

	@Test
	public void AtacarDosMonstruosEnModoAtaqueElPrimeroMuerePorqueTieneMenosPuntosAtaque() {
		
		Monstruo monstruoAtacado = new Monstruo(new BocaArriba(),new ModoAtaque(), 2, 400, 300);
		Monstruo monstruoAtacante = new Monstruo(new BocaArriba(),new ModoAtaque(), 2, 500, 200);
		
		monstruoAtacante.atacar(monstruoAtacado);
		
		assertTrue(monstruoAtacado.estaMuerta());
		assertFalse(monstruoAtacante.estaMuerta());
		
		
		
	}

	@Test
	public void AtacarDosMonstruosEnModoAtaqueElSegundoMuerePorqueTieneMenosPuntosAtaque() {
		
		
		Monstruo monstruoAtacado = new Monstruo(new BocaArriba(),new ModoAtaque(), 2, 400, 300);
		Monstruo monstruoAtacante = new Monstruo(new BocaArriba(),new ModoAtaque(), 2, 300, 200);
		
		monstruoAtacante.atacar(monstruoAtacado);
		
		assertTrue(monstruoAtacante.estaMuerta());
		assertFalse(monstruoAtacado.estaMuerta());
		
	}
	

	@Test
	public void DejarMonstruosActivosEnEstadoMuertoParaAgarrarConElCementerio() {
		Campo campo = new Campo();
		Monstruo monstruo1 = new Monstruo(new BocaArriba(),new ModoAtaque(), 2, 400, 300);
		Monstruo monstruo2 = new Monstruo(new BocaArriba(),new ModoAtaque(), 2, 500, 200);
		Monstruo monstruo3 = new Monstruo(new BocaArriba(),new ModoAtaque(), 2, 400, 300);
		Monstruo monstruo4 = new Monstruo(new BocaArriba(),new ModoAtaque(), 2, 500, 200);
		Monstruo monstruo5 = new Monstruo(new BocaArriba(),new ModoAtaque(), 2, 400, 300);
		LinkedList<Monstruo> monstruosDeJugador1 = new LinkedList<Monstruo>();
		monstruosDeJugador1.add(monstruo1);
		monstruosDeJugador1.add(monstruo2);
		monstruosDeJugador1.add(monstruo3);
		monstruosDeJugador1.add(monstruo4);
		monstruosDeJugador1.add(monstruo5);
		
		Monstruo monstruo6 = new Monstruo(new BocaArriba(),new ModoAtaque(), 2, 400, 300);
		Monstruo monstruo7 = new Monstruo(new BocaArriba(),new ModoAtaque(), 2, 500, 200);
		Monstruo monstruo8 = new Monstruo(new BocaArriba(),new ModoAtaque(), 2, 400, 300);
		Monstruo monstruo9 = new Monstruo(new BocaArriba(),new ModoAtaque(), 2, 500, 200);
		Monstruo monstruo10 = new Monstruo(new BocaArriba(),new ModoAtaque(), 2, 400, 300);

		LinkedList<Monstruo> monstruosDeJugador2 = new LinkedList<Monstruo>();
		monstruosDeJugador2.add(monstruo6);
		monstruosDeJugador2.add(monstruo7);
		monstruosDeJugador2.add(monstruo8);
		monstruosDeJugador2.add(monstruo9);
		monstruosDeJugador2.add(monstruo10);
		
		
		Efecto efectoAgujeroNegro = new EfectoAgujeroNegro(monstruosDeJugador1,monstruosDeJugador2);
		Magica cartaAgujeroNegro = new Magica(new BocaArriba(),efectoAgujeroNegro);
		cartaAgujeroNegro.aplicarEfecto();
		
	}


	@Test
	public void AtacarDosMonstruosEnModoAtaqueAmbosMuerenPorqueTienenIgualPuntosAtaque() {
		
		Monstruo monstruoAtacado = new Monstruo(new BocaArriba(),new ModoAtaque(), 2, 400, 300);
		Monstruo monstruoAtacante = new Monstruo(new BocaArriba(),new ModoAtaque(), 2, 400, 200);
		
		monstruoAtacante.atacar(monstruoAtacado);
		
		assertTrue(monstruoAtacante.estaMuerta());
		assertTrue(monstruoAtacado.estaMuerta());
		
	}
	
	@Test
	public void AtacarDosMonstruosEnModoAtaqueYModoDefensaMuereElQueEstaEnDefensaPorqueTieneMenosPuntosDeDefensaQuePuntosDeAtaque() {
		
		Monstruo monstruoAtacado = new Monstruo(new BocaArriba(),new ModoDefensa(), 2, 400, 300);
		Monstruo monstruoAtacante = new Monstruo(new BocaArriba(),new ModoAtaque(), 2, 500, 200);
		
		monstruoAtacante.atacar(monstruoAtacado);
		
		assertTrue(monstruoAtacado.estaMuerta());
		assertFalse(monstruoAtacante.estaMuerta());
	}
	
	@Test
	public void AtacarDosMonstruosEnModoAtaqueYModoDefensaMuereElAtacanteYaQueTieneMenosPuntosAtaqueQuePuntosDeDefensaDelAtacado() {
		
		Monstruo monstruoAtacado = new Monstruo(new BocaArriba(),new ModoDefensa(), 2, 300, 600);
		Monstruo monstruoAtacante = new Monstruo(new BocaArriba(),new ModoAtaque(), 2, 500, 200);
		
		monstruoAtacante.atacar(monstruoAtacado);
		
		assertFalse(monstruoAtacado.estaMuerta());
		assertTrue(monstruoAtacante.estaMuerta());
		//agregarSupuesto monstruo que ataca con 500 de Pts de ataque Muere al atacar a monstruo en defensa con 600putos de defensa.
	
	}

	@Test
	public void SeRequiereSacrificioParaPonerUnMonstruoDeCincoOSeisEstrellas() {
		
		Monstruo monstruo = new Monstruo(new BocaArriba(),new ModoAtaque(), 2, 300, 600);
		Monstruo monstruoPoderoso = new Monstruo(new BocaArriba(),new ModoAtaque(), 5, 300, 600);
		
		Campo campo = new Campo();
		campo.recibirMonstruoDeJugador1(monstruo);
		campo.recibirMonstruoDeJugador1(monstruoPoderoso); //estafuncion debe chequear las estrellas del monstruo  y sacrificar 1 mons del campo
		
		assertTrue(monstruo.estaMuerta());
		
	}
	

	@Test
	public void SeRequiereDosSacrificiosParaPonerUnMonstruoDeSieteOMasEstrellas() {

		Monstruo monstruoUno = new Monstruo(new BocaArriba(),new ModoAtaque(), 2, 300, 600);
		Monstruo monstruoDos = new Monstruo(new BocaArriba(),new ModoAtaque(), 2, 300, 600);
		Monstruo monstruoPoderoso = new Monstruo(new BocaArriba(),new ModoAtaque(), 5, 300, 600);
		
		Campo campo = new Campo();
		campo.recibirMonstruoDeJugador1(monstruoUno);
		campo.recibirMonstruoDeJugador1(monstruoDos);
		campo.recibirMonstruoDeJugador1(monstruoPoderoso); //estafuncion debe chequear las estrellas del monstruo y sacrificar 2 mons del campo
		
		assertTrue(monstruoUno.estaMuerta());
		assertTrue(monstruoDos.estaMuerta());
		
	}
	
}