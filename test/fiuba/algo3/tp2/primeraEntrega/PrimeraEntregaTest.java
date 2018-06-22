package fiuba.algo3.tp2.primeraEntrega;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

import fiuba.algo3.tp2.CampoDeBatalla;
import fiuba.algo3.tp2.Carta;
import fiuba.algo3.tp2.Cementerio;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Magica;
import fiuba.algo3.tp2.Monstruo;
import fiuba.algo3.tp2.Trampa;
import fiuba.algo3.tp2.Efectos.EfectoAgujeroNegro;
import fiuba.algo3.tp2.Efectos.SinEfecto;
import fiuba.algo3.tp2.atributosCarta.BocaAbajo;
import fiuba.algo3.tp2.atributosCarta.BocaArriba;
import fiuba.algo3.tp2.atributosCarta.Efecto;
import fiuba.algo3.tp2.atributosMonstruo.Debil;
import fiuba.algo3.tp2.atributosMonstruo.ModoAtaque;
import fiuba.algo3.tp2.atributosMonstruo.ModoDefensa;
import fiuba.algo3.tp2.atributosMonstruo.Normal;
import fiuba.algo3.tp2.atributosMonstruo.Poderoso;
import fiuba.algo3.tp2.excepciones.MonstruoEnModoDefensaNoPuedeAtacarException;

public class PrimeraEntregaTest {

	@Test
	public void testColocarUnaCartaDeMonstruoEnPosicionDeAtaque() {
		int puntosDeAtaque = 1000;
		int puntosDeDefensa = 500;
		Monstruo monstruo = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), puntosDeAtaque, puntosDeDefensa, new SinEfecto());
		
		assertTrue(monstruo.estaEnModoAtaque());
	}
	
	@Test
	public void testColocarUnaCartaDeMonstruoEnPosicionDeDefensa() {
		int puntosDeAtaque = 1000;
		int puntosDeDefensa = 500;
		Monstruo monstruo = new Monstruo(new BocaArriba(),new ModoDefensa(), new Debil(), puntosDeAtaque, puntosDeDefensa, new SinEfecto());
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
		Trampa trampa = new Trampa(sinEfecto);
		assertTrue(trampa.estaBocaAbajo());
	}
	
	@Test
	public void testMandarUnaCartaAlCementerio() {
		Carta carta = new Monstruo(new BocaArriba(),new ModoDefensa(), new Debil(), 1500, 2000, new SinEfecto());
		Cementerio cementerio = new Cementerio();
		cementerio.agregarCarta(carta);
		
		assertTrue(cementerio.contieneCarta(carta));	
	}

	@Test
	public void AtacarDosMonstruosEnModoAtaqueElPrimeroMuerePorqueTieneMenosPuntosAtaque() {
		Jugador jugador1 = new Jugador();	
		Jugador jugador2 = new Jugador();	
		Monstruo monstruoAtacado = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 400, 300, new SinEfecto());
		Monstruo monstruoAtacante = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 500, 200, new SinEfecto());
		
		monstruoAtacado.aniadirObservador(jugador1);
		monstruoAtacante.aniadirObservador(jugador2);
		monstruoAtacante.atacar(monstruoAtacado);
		
		// El jugador1 pierde 100 puntos de vida, el jugador2 queda con 8000
		int puntosVidaJugador1 = 8000 - (500 - 400);
		int puntosVidaJugador2 = 8000;
		
		assertEquals(puntosVidaJugador1, jugador1.vida());
		assertEquals(puntosVidaJugador2, jugador2.vida());
		
		assertTrue(monstruoAtacado.estaMuerta());
		assertFalse(monstruoAtacante.estaMuerta());
		
	}

	@Test
	public void AtacarDosMonstruosEnModoAtaqueElSegundoMuerePorqueTieneMenosPuntosAtaque() {
		Jugador jugador1 = new Jugador();	
		Jugador jugador2 = new Jugador();			
		Monstruo monstruoAtacado = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 400, 300, new SinEfecto());
		Monstruo monstruoAtacante = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 300, 200, new SinEfecto());
		
		monstruoAtacado.aniadirObservador(jugador1);
		monstruoAtacante.aniadirObservador(jugador2);
		monstruoAtacante.atacar(monstruoAtacado);
		
		// El jugador1 queda con 8000, el jugador2 se le resta 100 puntos de vida
		int puntosVidaJugador1 = 8000;
		int puntosVidaJugador2 = 8000 - (400 - 300);
			
		assertEquals(puntosVidaJugador1, jugador1.vida());
		assertEquals(puntosVidaJugador2, jugador2.vida());
		
		assertTrue(monstruoAtacante.estaMuerta());
		assertFalse(monstruoAtacado.estaMuerta());
		
	}
	

	@Test
	public void DejarMonstruosActivosEnEstadoMuertoParaAgarrarConElCementerio() {
		Monstruo monstruo1 = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 400, 300, new SinEfecto());
		Monstruo monstruo2 = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 500, 200, new SinEfecto());
		Monstruo monstruo3 = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 400, 300, new SinEfecto());
		Monstruo monstruo4 = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 500, 200, new SinEfecto());
		Monstruo monstruo5 = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 400, 300, new SinEfecto());
		
		CampoDeBatalla campo = CampoDeBatalla.getInstance();
		campo.recibirMonstruoDeJugador1(monstruo1);
		campo.recibirMonstruoDeJugador1(monstruo2);
		campo.recibirMonstruoDeJugador1(monstruo3);
		campo.recibirMonstruoDeJugador1(monstruo4);
		campo.recibirMonstruoDeJugador1(monstruo5);
		
		
		Monstruo monstruo6 = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 400, 300, new SinEfecto());
		Monstruo monstruo7 = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 500, 200, new SinEfecto());
		Monstruo monstruo8 = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 400, 300, new SinEfecto());
		Monstruo monstruo9 = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 500, 200, new SinEfecto());
		Monstruo monstruo10 = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 400, 300, new SinEfecto());

		campo.recibirMonstruoDeJugador2(monstruo6);
		campo.recibirMonstruoDeJugador2(monstruo7);
		campo.recibirMonstruoDeJugador2(monstruo8);
		campo.recibirMonstruoDeJugador2(monstruo9);
		campo.recibirMonstruoDeJugador2(monstruo10);
		
		
		Efecto efectoAgujeroNegro = new EfectoAgujeroNegro();
		Magica cartaAgujeroNegro = new Magica(new BocaArriba(),efectoAgujeroNegro);
		cartaAgujeroNegro.aplicarEfecto(campo);
		campo.barrerZonaDeMonstruos();
		
		assertEquals(0,campo.cantidadDeMonstruosActivos());
		
		
	}


	@Test
	public void AtacarDosMonstruosEnModoAtaqueAmbosMuerenPorqueTienenIgualPuntosAtaqueNingunJugadorPierdeVida() {
		Jugador jugador1 = new Jugador();	
		Jugador jugador2 = new Jugador();	
		Monstruo monstruoAtacado = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 400, 300, new SinEfecto());
		Monstruo monstruoAtacante = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 400, 200, new SinEfecto());
		
		monstruoAtacado.aniadirObservador(jugador1);
		monstruoAtacante.aniadirObservador(jugador2);
		monstruoAtacante.atacar(monstruoAtacado);
		
		// Ningun jugador pierde vida
		int vida = 8000;

		assertEquals(vida, jugador1.vida());
		assertEquals(vida, jugador2.vida());
		
		assertTrue(monstruoAtacante.estaMuerta());
		assertTrue(monstruoAtacado.estaMuerta());
		
	}
	
	@Test
	public void AtacarDosMonstruosEnModoAtaqueYModoDefensaMuereElQueEstaEnDefensaPorqueTieneMenosPuntosDeDefensaQuePuntosDeAtaque() {
		Jugador jugador1 = new Jugador();	
		Jugador jugador2 = new Jugador();	
		Monstruo monstruoAtacado = new Monstruo(new BocaArriba(),new ModoDefensa(), new Debil(), 400, 300, new SinEfecto());
		Monstruo monstruoAtacante = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 500, 200, new SinEfecto());
		
		monstruoAtacado.aniadirObservador(jugador1);
		monstruoAtacante.aniadirObservador(jugador2);
		monstruoAtacante.atacar(monstruoAtacado);
		
		// Ningun jugador pierde vida
		int vida = 8000;
		
		assertEquals(vida, jugador1.vida());
		assertEquals(vida, jugador2.vida());		
		
		assertTrue(monstruoAtacado.estaMuerta());
		assertFalse(monstruoAtacante.estaMuerta());
	}
	
	@Test
	public void AtacarDosMonstruosEnModoAtaqueYModoDefensaMuereElAtacanteYaQueTieneMenosPuntosAtaqueQuePuntosDeDefensaDelAtacado() {
		Jugador jugador1 = new Jugador();	
		Jugador jugador2 = new Jugador();
		Monstruo monstruoAtacado = new Monstruo(new BocaArriba(),new ModoDefensa(), new Debil(), 300, 600, new SinEfecto());
		Monstruo monstruoAtacante = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 500, 200, new SinEfecto());
		
		monstruoAtacado.aniadirObservador(jugador1);
		monstruoAtacante.aniadirObservador(jugador2);
		monstruoAtacante.atacar(monstruoAtacado);
		
		// Ningun jugador pierde vida
		int vida = 8000;
	
		assertEquals(vida, jugador1.vida());
		assertEquals(vida, jugador2.vida());			
		
		assertFalse(monstruoAtacado.estaMuerta());
		assertFalse(monstruoAtacante.estaMuerta());
	}

	@Test
	public void SeRequiereSacrificioParaPonerUnMonstruoDeCincoOSeisEstrellas() {
		
		Monstruo monstruo = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 300, 600, new SinEfecto());
		Monstruo monstruoPoderoso = new Monstruo(new BocaArriba(),new ModoAtaque(), new Normal(), 300, 600, new SinEfecto());
		
		CampoDeBatalla campo = CampoDeBatalla.getInstance();
		campo.recibirMonstruoDeJugador1(monstruo);
		campo.recibirMonstruoDeJugador1(monstruoPoderoso); //estafuncion debe chequear las estrellas del monstruo  y sacrificar 1 mons del campo
		
		assertTrue(monstruo.estaMuerta());
		
	}
	

	@Test
	public void SeRequiereDosSacrificiosParaPonerUnMonstruoDeSieteOMasEstrellas() {

		Monstruo monstruoUno = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 300, 600, new SinEfecto());
		Monstruo monstruoDos = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 300, 600, new SinEfecto());
		Monstruo monstruoPoderoso = new Monstruo(new BocaArriba(),new ModoAtaque(), new Poderoso(), 300, 600, new SinEfecto());
		
		CampoDeBatalla campo = CampoDeBatalla.getInstance();
		campo.recibirMonstruoDeJugador1(monstruoUno);
		campo.recibirMonstruoDeJugador1(monstruoDos);
		campo.recibirMonstruoDeJugador1(monstruoPoderoso); //estafuncion debe chequear las estrellas del monstruo y sacrificar 2 mons del campo
		
		assertTrue(monstruoUno.estaMuerta());
		assertTrue(monstruoDos.estaMuerta());
		
	}
	

	@Test
	public void MonstruoEnModoDeDefensaNoPuedeAtacar() {
		
		Monstruo monstruoDefensa = new Monstruo(new BocaArriba(),new ModoDefensa(), new Debil(), 300, 600, new SinEfecto());
		Monstruo monstruoAtaque = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 300, 600, new SinEfecto());
		
		assertThrows(MonstruoEnModoDefensaNoPuedeAtacarException.class,
                ()->{
                	monstruoDefensa.atacar(monstruoAtaque);
                });
		
	}
	
}