package fiuba.algo3.tp2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

import fiuba.algo3.tp2.Cementerio;
import fiuba.algo3.tp2.Efectos.EfectoAgujeroNegro;
import fiuba.algo3.tp2.atributosCarta.BocaAbajo;
import fiuba.algo3.tp2.atributosCarta.BocaArriba;
import fiuba.algo3.tp2.atributosCarta.Efecto;
import fiuba.algo3.tp2.atributosMonstruo.Debil;
import fiuba.algo3.tp2.atributosMonstruo.ModoAtaque;
import fiuba.algo3.tp2.atributosMonstruo.ModoDefensa;
import fiuba.algo3.tp2.excepciones.MonstruoEnModoDefensaNoPuedeAtacarException;

public class PrimeraEntregaTest {

	@Test
	public void testColocarUnaCartaDeMonstruoEnPosicionDeAtaque() {
		int puntosDeAtaque = 1000;
		int puntosDeDefensa = 500;
		Monstruo monstruo = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), puntosDeAtaque, puntosDeDefensa);
		
		assertTrue(monstruo.estaEnModoAtaque());
	}
	
	@Test
	public void testColocarUnaCartaDeMonstruoEnPosicionDeDefensa() {
		int puntosDeAtaque = 1000;
		int puntosDeDefensa = 500;
		Monstruo monstruo = new Monstruo(new BocaArriba(),new ModoDefensa(), new Debil(), puntosDeAtaque, puntosDeDefensa);
		
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
		Carta carta = new Monstruo(new BocaArriba(),new ModoDefensa(), new Debil(), 1500, 2000);
		Cementerio cementerio = new Cementerio();
		cementerio.agregarCarta(carta);
		
		assertTrue(cementerio.contieneCarta(carta));	
	}

	@Test
	public void AtacarDosMonstruosEnModoAtaqueElPrimeroMuerePorqueTieneMenosPuntosAtaque() {
		
		Monstruo monstruoAtacado = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 400, 300);
		Monstruo monstruoAtacante = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 500, 200);
		
		monstruoAtacante.atacar(monstruoAtacado);
		
		assertTrue(monstruoAtacado.estaMuerta());
		assertFalse(monstruoAtacante.estaMuerta());
		
	}

	@Test
	public void AtacarDosMonstruosEnModoAtaqueElSegundoMuerePorqueTieneMenosPuntosAtaque() {
		
		
		Monstruo monstruoAtacado = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 400, 300);
		Monstruo monstruoAtacante = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 300, 200);
		
		monstruoAtacante.atacar(monstruoAtacado);
		
		assertTrue(monstruoAtacante.estaMuerta());
		assertFalse(monstruoAtacado.estaMuerta());
		
	}
	

	@Test
	public void DejarMonstruosActivosEnEstadoMuertoParaAgarrarConElCementerio() {
		Monstruo monstruo1 = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 400, 300);
		Monstruo monstruo2 = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 500, 200);
		Monstruo monstruo3 = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 400, 300);
		Monstruo monstruo4 = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 500, 200);
		Monstruo monstruo5 = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 400, 300);
		
		Campo campo = new Campo();
		campo.recibirMonstruoDeJugador1(monstruo1);
		campo.recibirMonstruoDeJugador1(monstruo2);
		campo.recibirMonstruoDeJugador1(monstruo3);
		campo.recibirMonstruoDeJugador1(monstruo4);
		campo.recibirMonstruoDeJugador1(monstruo5);
		
		
		Monstruo monstruo6 = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 400, 300);
		Monstruo monstruo7 = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 500, 200);
		Monstruo monstruo8 = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 400, 300);
		Monstruo monstruo9 = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 500, 200);
		Monstruo monstruo10 = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 400, 300);

		campo.recibirMonstruoDeJugador2(monstruo6);
		campo.recibirMonstruoDeJugador2(monstruo7);
		campo.recibirMonstruoDeJugador2(monstruo8);
		campo.recibirMonstruoDeJugador2(monstruo9);
		campo.recibirMonstruoDeJugador2(monstruo10);
		
		
		Efecto efectoAgujeroNegro = new EfectoAgujeroNegro(campo);
		Magica cartaAgujeroNegro = new Magica(new BocaArriba(),efectoAgujeroNegro);
		cartaAgujeroNegro.aplicarEfecto();
		campo.barrerZonaDeMonstruos();
		
		assertEquals(0,campo.cantidadDeMonstruosActivos());
		
		
	}


	@Test
	public void AtacarDosMonstruosEnModoAtaqueAmbosMuerenPorqueTienenIgualPuntosAtaque() {
		
		Monstruo monstruoAtacado = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 400, 300);
		Monstruo monstruoAtacante = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 400, 200);
		
		monstruoAtacante.atacar(monstruoAtacado);
		
		assertTrue(monstruoAtacante.estaMuerta());
		assertTrue(monstruoAtacado.estaMuerta());
		
	}
	
	@Test
	public void AtacarDosMonstruosEnModoAtaqueYModoDefensaMuereElQueEstaEnDefensaPorqueTieneMenosPuntosDeDefensaQuePuntosDeAtaque() {
		
		Monstruo monstruoAtacado = new Monstruo(new BocaArriba(),new ModoDefensa(), new Debil(), 400, 300);
		Monstruo monstruoAtacante = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 500, 200);
		
		monstruoAtacante.atacar(monstruoAtacado);
		
		assertTrue(monstruoAtacado.estaMuerta());
		assertFalse(monstruoAtacante.estaMuerta());
	}
	
	@Test
	public void AtacarDosMonstruosEnModoAtaqueYModoDefensaMuereElAtacanteYaQueTieneMenosPuntosAtaqueQuePuntosDeDefensaDelAtacado() {
		
		Monstruo monstruoAtacado = new Monstruo(new BocaArriba(),new ModoDefensa(), new Debil(), 300, 600);
		Monstruo monstruoAtacante = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 500, 200);
		
		monstruoAtacante.atacar(monstruoAtacado);
		
		assertFalse(monstruoAtacado.estaMuerta());
		assertTrue(monstruoAtacante.estaMuerta());
		//agregarSupuesto monstruo que ataca con 500 de Pts de ataque Muere al atacar a monstruo en defensa con 600putos de defensa.
	}

	@Test
	public void SeRequiereSacrificioParaPonerUnMonstruoDeCincoOSeisEstrellas() {
		
		Monstruo monstruo = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 300, 600);
		Monstruo monstruoPoderoso = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 300, 600);
		
		Campo campo = new Campo();
		campo.recibirMonstruoDeJugador1(monstruo);
		campo.recibirMonstruoDeJugador1(monstruoPoderoso); //estafuncion debe chequear las estrellas del monstruo  y sacrificar 1 mons del campo
		
		assertTrue(monstruo.estaMuerta());
		
	}
	

	@Test
	public void SeRequiereDosSacrificiosParaPonerUnMonstruoDeSieteOMasEstrellas() {

		Monstruo monstruoUno = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 300, 600);
		Monstruo monstruoDos = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 300, 600);
		Monstruo monstruoPoderoso = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 300, 600);
		
		Campo campo = new Campo();
		campo.recibirMonstruoDeJugador1(monstruoUno);
		campo.recibirMonstruoDeJugador1(monstruoDos);
		campo.recibirMonstruoDeJugador1(monstruoPoderoso); //estafuncion debe chequear las estrellas del monstruo y sacrificar 2 mons del campo
		
		assertTrue(monstruoUno.estaMuerta());
		assertTrue(monstruoDos.estaMuerta());
		
	}
	

	@Test
	public void MonstruoEnModoDeDefensaNoPuedeAtacar() {
		
		Monstruo monstruoDefensa = new Monstruo(new BocaArriba(),new ModoDefensa(), new Debil(), 300, 600);
		Monstruo monstruoAtaque = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 300, 600);
		
		assertThrows(MonstruoEnModoDefensaNoPuedeAtacarException.class,
                ()->{
                	monstruoDefensa.atacar(monstruoAtaque);
                });
		
	}
	
}