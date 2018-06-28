package fiuba.algo3.tp2.primeraEntrega;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

import atributosLadoDelCampo.Cementerio;
import cartas.Carta;
import cartas.Magica;
import cartas.Monstruo;
import cartas.Trampa;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.LadoDelCampo;
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
import fiuba.algo3.tp2.fabricas.FabricaCartaMagica;
import fiuba.algo3.tp2.fabricas.FabricaCartaMonstruo;

public class PrimeraEntregaTest {

	@Test
	public void testColocarUnaCartaDeMonstruoEnPosicionDeAtaque() {
		int puntosDeAtaque = 1000;
		int puntosDeDefensa = 500;
		Monstruo monstruo = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), puntosDeAtaque, puntosDeDefensa, new SinEfecto(), new SinEfecto());
		
		assertTrue(monstruo.estaEnModoAtaque());
	}
	
	@Test
	public void testColocarUnaCartaDeMonstruoEnPosicionDeDefensa() {
		int puntosDeAtaque = 1000;
		int puntosDeDefensa = 500;
		Monstruo monstruo = new Monstruo(new BocaArriba(),new ModoDefensa(), new Debil(), puntosDeAtaque, puntosDeDefensa, new SinEfecto(), new SinEfecto());
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
		Carta carta = new Monstruo(new BocaArriba(),new ModoDefensa(), new Debil(), 1500, 2000, new SinEfecto(), new SinEfecto());
		Cementerio cementerio = new Cementerio();
		cementerio.agregarCarta(carta);
		
		assertTrue(cementerio.contieneCarta(carta));	
	}

	@Test
	public void AtacarDosMonstruosEnModoAtaqueElPrimeroMuerePorqueTieneMenosPuntosAtaque() {
		Jugador jugador1 = new Jugador();	
		Jugador jugador2 = new Jugador();	
		Monstruo monstruoAtacado = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 400, 300, new SinEfecto(), new SinEfecto());
		Monstruo monstruoAtacante = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 500, 200, new SinEfecto(), new SinEfecto());
		
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
		Monstruo monstruoAtacado = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 400, 300, new SinEfecto(), new SinEfecto());
		Monstruo monstruoAtacante = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 300, 200, new SinEfecto(), new SinEfecto());
		
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
		
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		LadoDelCampo lado1 = new LadoDelCampo();
		LadoDelCampo lado2 = new LadoDelCampo();
		lado1.setOtroLado(lado2);
		lado2.setOtroLado(lado1);
		
		lado1.setJugador(jugador1);
		lado2.setJugador(jugador2);
		
		jugador1.setLado(lado1);
		jugador2.setLado(lado2);
		
		Monstruo dragon1DeJugador1 = FabricaCartaMonstruo.DRAGONBLANCO.crear();
		Monstruo dragon2DeJugador1 = FabricaCartaMonstruo.DRAGONBLANCO.crear();
		Monstruo dragon3DeJugador1 = FabricaCartaMonstruo.DRAGONBLANCO.crear();
		Monstruo dragon4DeJugador1 = FabricaCartaMonstruo.DRAGONBLANCO.crear();
		Monstruo dragon5DeJugador1 = FabricaCartaMonstruo.DRAGONBLANCO.crear();
		
		jugador1.colocarCarta(dragon1DeJugador1);
		jugador1.colocarCarta(dragon2DeJugador1);
		jugador1.colocarCarta(dragon3DeJugador1);
		jugador1.colocarCarta(dragon4DeJugador1);
		jugador1.colocarCarta(dragon5DeJugador1);
		
		
		Monstruo huevo1DeJugador2 = FabricaCartaMonstruo.HUEVOMONSTRUOSO.crear();
		Monstruo huevo2DeJugador2 = FabricaCartaMonstruo.HUEVOMONSTRUOSO.crear();
		Monstruo huevo3DeJugador2 = FabricaCartaMonstruo.HUEVOMONSTRUOSO.crear();
		Monstruo huevo4DeJugador2 = FabricaCartaMonstruo.HUEVOMONSTRUOSO.crear();
		Monstruo huevo5DeJugador2 = FabricaCartaMonstruo.HUEVOMONSTRUOSO.crear();
		
		jugador2.colocarCarta(huevo1DeJugador2);
		jugador2.colocarCarta(huevo2DeJugador2);
		jugador2.colocarCarta(huevo3DeJugador2);
		jugador2.colocarCarta(huevo4DeJugador2);
		jugador2.colocarCarta(huevo5DeJugador2);
		
		Magica agujeroNegro = FabricaCartaMagica.AGUJERONEGRO.crear();
		
		jugador2.activarMagicaEnCampo(agujeroNegro);
		
		
		assertTrue(huevo1DeJugador2.estaMuerta());
		assertTrue(huevo2DeJugador2.estaMuerta());
		assertTrue(huevo3DeJugador2.estaMuerta());
		assertTrue(huevo4DeJugador2.estaMuerta());
		assertTrue(huevo5DeJugador2.estaMuerta());
		
		
		assertTrue(dragon1DeJugador1.estaMuerta());
		assertTrue(dragon2DeJugador1.estaMuerta());
		assertTrue(dragon3DeJugador1.estaMuerta());
		assertTrue(dragon4DeJugador1.estaMuerta());
		assertTrue(dragon5DeJugador1.estaMuerta());
		
		
		
		
	}


	@Test
	public void AtacarDosMonstruosEnModoAtaqueAmbosMuerenPorqueTienenIgualPuntosAtaqueNingunJugadorPierdeVida() {
		Jugador jugador1 = new Jugador();	
		Jugador jugador2 = new Jugador();	
		Monstruo monstruoAtacado = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 400, 300, new SinEfecto(), new SinEfecto());
		Monstruo monstruoAtacante = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 400, 200, new SinEfecto(), new SinEfecto());
		
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
		Monstruo monstruoAtacado = new Monstruo(new BocaArriba(),new ModoDefensa(), new Debil(), 400, 300, new SinEfecto(), new SinEfecto());
		Monstruo monstruoAtacante = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 500, 200, new SinEfecto(), new SinEfecto());
		
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
		Monstruo monstruoAtacado = new Monstruo(new BocaArriba(),new ModoDefensa(), new Debil(), 300, 600, new SinEfecto(), new SinEfecto());
		Monstruo monstruoAtacante = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 500, 200, new SinEfecto(), new SinEfecto());
		
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
		
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		LadoDelCampo lado1 = new LadoDelCampo();
		LadoDelCampo lado2 = new LadoDelCampo();
		lado1.setOtroLado(lado2);
		lado2.setOtroLado(lado1);
		
		lado1.setJugador(jugador1);
		lado2.setJugador(jugador2);
		
		jugador1.setLado(lado1);
		jugador2.setLado(lado2);
		
		Monstruo dragon = FabricaCartaMonstruo.DRAGONBLANCO.crear();
		
		Monstruo magoOscuro = FabricaCartaMonstruo.MAGOOSCURO.crear();
		
		jugador1.colocarCarta(dragon);
		jugador1.colocarCarta(magoOscuro);
		
		
		assertTrue(dragon.estaMuerta());
		
	}
	

	@Test
	public void SeRequiereDosSacrificiosParaPonerUnMonstruoDeSieteOMasEstrellas() {
		
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		LadoDelCampo lado1 = new LadoDelCampo();
		LadoDelCampo lado2 = new LadoDelCampo();
		lado1.setOtroLado(lado2);
		lado2.setOtroLado(lado1);
		
		lado1.setJugador(jugador1);
		lado2.setJugador(jugador2);
		
		jugador1.setLado(lado1);
		jugador2.setLado(lado2);
		
		Monstruo dragon1 = FabricaCartaMonstruo.DRAGONBLANCO.crear();
		Monstruo dragon2 = FabricaCartaMonstruo.DRAGONBLANCO.crear();
		
		Monstruo dragonDefinitivo = FabricaCartaMonstruo.DRAGONDEFINITIVO.crear();
		
		jugador1.colocarCarta(dragon1);
		jugador1.colocarCarta(dragon2);
		jugador1.colocarCarta(dragonDefinitivo);
		
		
		assertTrue(dragon1.estaMuerta());
		assertTrue(dragon2.estaMuerta());
		
	}
	

	@Test
	public void MonstruoEnModoDeDefensaNoPuedeAtacar() {
		
		Monstruo monstruoDefensa = new Monstruo(new BocaArriba(),new ModoDefensa(), new Debil(), 300, 600, new SinEfecto(), new SinEfecto());
		Monstruo monstruoAtaque = new Monstruo(new BocaArriba(),new ModoAtaque(), new Debil(), 300, 600, new SinEfecto(), new SinEfecto());
		
		assertThrows(MonstruoEnModoDefensaNoPuedeAtacarException.class,
                ()->{
                	monstruoDefensa.atacar(monstruoAtaque);
                });
		
	}
	
}