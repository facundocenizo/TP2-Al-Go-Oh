package fiuba.algo3.tp2.primeraEntrega;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

import fiuba.algo3.tp2.Efectos.SinEfecto;
import fiuba.algo3.tp2.atributosCarta.BocaAbajo;
import fiuba.algo3.tp2.atributosCarta.BocaArriba;
import fiuba.algo3.tp2.atributosCarta.Efecto;
import fiuba.algo3.tp2.atributosLadoDelCampo.Cementerio;
import fiuba.algo3.tp2.atributosMonstruo.Debil;
import fiuba.algo3.tp2.atributosMonstruo.ModoAtaque;
import fiuba.algo3.tp2.atributosMonstruo.ModoDefensa;
import fiuba.algo3.tp2.cartas.Carta;
import fiuba.algo3.tp2.cartas.Magica;
import fiuba.algo3.tp2.cartas.Monstruo;
import fiuba.algo3.tp2.cartas.Trampa;
import fiuba.algo3.tp2.excepciones.MonstruoEnModoDefensaNoPuedeAtacarException;
import fiuba.algo3.tp2.fabricas.FabricaCartaMagica;
import fiuba.algo3.tp2.fabricas.FabricaCartaMonstruo;
import fiuba.algo3.tp2.juego.Jugador;
import fiuba.algo3.tp2.juego.LadoDelCampo;

public class PrimeraEntregaTest {

	@Test
	public void testColocarUnaCartaDeMonstruoEnPosicionDeAtaque() {
		int puntosDeAtaque = 1000;
		int puntosDeDefensa = 500;
		Monstruo monstruo = new Monstruo(new BocaArriba(),new ModoAtaque(puntosDeAtaque), new Debil(), puntosDeAtaque, puntosDeDefensa, new SinEfecto(), new SinEfecto());
		
		assertTrue(monstruo.estaEnModoAtaque());
	}
	
	@Test
	public void testColocarUnaCartaDeMonstruoEnPosicionDeDefensa() {
		int puntosDeAtaque = 1000;
		int puntosDeDefensa = 500;
		Monstruo monstruo = new Monstruo(new BocaArriba(),new ModoDefensa(puntosDeDefensa), new Debil(), puntosDeAtaque, puntosDeDefensa, new SinEfecto(), new SinEfecto());
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
		Carta carta = new Monstruo(new BocaArriba(),new ModoDefensa(2000), new Debil(), 1500, 2000, new SinEfecto(), new SinEfecto());
		Cementerio cementerio = new Cementerio();
		cementerio.agregarCarta(carta);
		
		assertTrue(cementerio.contieneCarta(carta));	
	}

	@Test
	public void AtacarDosMonstruosEnModoAtaqueElPrimeroMuerePorqueTieneMenosPuntosAtaque() {
		Jugador jugador1 = new Jugador();	
		Jugador jugador2 = new Jugador();	
		Monstruo monstruoAtacado = new Monstruo(new BocaArriba(),new ModoAtaque(400), new Debil(), 400, 300, new SinEfecto(), new SinEfecto());
		Monstruo monstruoAtacante = new Monstruo(new BocaArriba(),new ModoAtaque(500), new Debil(), 500, 200, new SinEfecto(), new SinEfecto());
		
		monstruoAtacado.aniadirObservador(jugador1);
		monstruoAtacante.aniadirObservador(jugador2);
		monstruoAtacante.atacar(monstruoAtacado);
		
		// El jugador1 pierde 100 puntos de vida, el jugador2 queda con 8000
		int puntosVidaJugador1 = 8000 - (500 - 400);
		int puntosVidaJugador2 = 8000;
		
		assertEquals(puntosVidaJugador1, jugador1.darVida());
		assertEquals(puntosVidaJugador2, jugador2.darVida());
		
		assertTrue(monstruoAtacado.estaMuerta());
		assertFalse(monstruoAtacante.estaMuerta());
		
	}

	@Test
	public void AtacarDosMonstruosEnModoAtaqueElSegundoMuerePorqueTieneMenosPuntosAtaque() {
		Jugador jugador1 = new Jugador();	
		Jugador jugador2 = new Jugador();			
		Monstruo monstruoAtacado = new Monstruo(new BocaArriba(),new ModoAtaque(400), new Debil(), 400, 300, new SinEfecto(), new SinEfecto());
		Monstruo monstruoAtacante = new Monstruo(new BocaArriba(),new ModoAtaque(300), new Debil(), 300, 200, new SinEfecto(), new SinEfecto());
		
		monstruoAtacado.aniadirObservador(jugador1);
		monstruoAtacante.aniadirObservador(jugador2);
		monstruoAtacante.atacar(monstruoAtacado);
		
		// El jugador1 queda con 8000, el jugador2 se le resta 100 puntos de vida
		int puntosVidaJugador1 = 8000;
		int puntosVidaJugador2 = 8000 - (400 - 300);
			
		assertEquals(puntosVidaJugador1, jugador1.darVida());
		assertEquals(puntosVidaJugador2, jugador2.darVida());
		
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
		
		Monstruo jinzo1DeJugador1 = FabricaCartaMonstruo.JINZOSIETE.crear();
		Monstruo jinzo2DeJugador1 = FabricaCartaMonstruo.JINZOSIETE.crear();
		Monstruo jinzo3DeJugador1 = FabricaCartaMonstruo.JINZOSIETE.crear();
		Monstruo jinzo4DeJugador1 = FabricaCartaMonstruo.JINZOSIETE.crear();
		Monstruo jinzo5DeJugador1 = FabricaCartaMonstruo.JINZOSIETE.crear();
		
		jugador1.colocarCarta(jinzo1DeJugador1);
		jugador1.colocarCarta(jinzo2DeJugador1);
		jugador1.colocarCarta(jinzo3DeJugador1);
		jugador1.colocarCarta(jinzo4DeJugador1);
		jugador1.colocarCarta(jinzo5DeJugador1);
		
		
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
		
		
		assertTrue(jinzo1DeJugador1.estaMuerta());
		assertTrue(jinzo2DeJugador1.estaMuerta());
		assertTrue(jinzo3DeJugador1.estaMuerta());
		assertTrue(jinzo4DeJugador1.estaMuerta());
		assertTrue(jinzo5DeJugador1.estaMuerta());
		
		
		
		
	}


	@Test
	public void AtacarDosMonstruosEnModoAtaqueAmbosMuerenPorqueTienenIgualPuntosAtaqueNingunJugadorPierdeVida() {
		Jugador jugador1 = new Jugador();	
		Jugador jugador2 = new Jugador();	
		Monstruo monstruoAtacado = new Monstruo(new BocaArriba(),new ModoAtaque(400), new Debil(), 400, 300, new SinEfecto(), new SinEfecto());
		Monstruo monstruoAtacante = new Monstruo(new BocaArriba(),new ModoAtaque(400), new Debil(), 400, 200, new SinEfecto(), new SinEfecto());
		
		monstruoAtacado.aniadirObservador(jugador1);
		monstruoAtacante.aniadirObservador(jugador2);
		monstruoAtacante.atacar(monstruoAtacado);
		
		// Ningun jugador pierde vida
		int vida = 8000;

		assertEquals(vida, jugador1.darVida());
		assertEquals(vida, jugador2.darVida());
		
		assertTrue(monstruoAtacante.estaMuerta());
		assertTrue(monstruoAtacado.estaMuerta());
		
	}
	
	@Test
	public void AtacarDosMonstruosEnModoAtaqueYModoDefensaMuereElQueEstaEnDefensaPorqueTieneMenosPuntosDeDefensaQuePuntosDeAtaque() {
		Jugador jugador1 = new Jugador();	
		Jugador jugador2 = new Jugador();	
		Monstruo monstruoAtacado = new Monstruo(new BocaArriba(),new ModoDefensa(400), new Debil(), 400, 300, new SinEfecto(), new SinEfecto());
		Monstruo monstruoAtacante = new Monstruo(new BocaArriba(),new ModoAtaque(500), new Debil(), 500, 200, new SinEfecto(), new SinEfecto());
		
		monstruoAtacado.aniadirObservador(jugador1);
		monstruoAtacante.aniadirObservador(jugador2);
		monstruoAtacante.atacar(monstruoAtacado);
		
		// Ningun jugador pierde vida
		int vida = 8000;
		
		assertEquals(vida, jugador1.darVida());
		assertEquals(vida, jugador2.darVida());		
		
		assertTrue(monstruoAtacado.estaMuerta());
		assertFalse(monstruoAtacante.estaMuerta());
	}
	
	@Test
	public void AtacarDosMonstruosEnModoAtaqueYModoDefensaMuereElAtacanteYaQueTieneMenosPuntosAtaqueQuePuntosDeDefensaDelAtacado() {
		Jugador jugador1 = new Jugador();	
		Jugador jugador2 = new Jugador();
		Monstruo monstruoAtacado = new Monstruo(new BocaArriba(),new ModoDefensa(300), new Debil(), 300, 600, new SinEfecto(), new SinEfecto());
		Monstruo monstruoAtacante = new Monstruo(new BocaArriba(),new ModoAtaque(500), new Debil(), 500, 200, new SinEfecto(), new SinEfecto());
		
		monstruoAtacado.aniadirObservador(jugador1);
		monstruoAtacante.aniadirObservador(jugador2);
		monstruoAtacante.atacar(monstruoAtacado);
		
		// Ningun jugador pierde vida
		int vida = 8000;
	
		assertEquals(vida, jugador1.darVida());
		assertEquals(vida, jugador2.darVida());			
		
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
		
		Monstruo huevo = FabricaCartaMonstruo.HUEVOMONSTRUOSO.crear();
		
		Monstruo magoOscuro = FabricaCartaMonstruo.MAGOOSCURO.crear();
		
		jugador1.colocarCarta(huevo);
		jugador1.colocarCarta(magoOscuro);
		
		
		assertTrue(huevo.estaMuerta());
		
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
		
		Monstruo huevo1 = FabricaCartaMonstruo.HUEVOMONSTRUOSO.crear();
		Monstruo huevo2 = FabricaCartaMonstruo.HUEVOMONSTRUOSO.crear();
		
		Monstruo dragonBlanco = FabricaCartaMonstruo.DRAGONBLANCO.crear();
		
		jugador1.colocarCarta(huevo1);
		jugador1.colocarCarta(huevo2);
		jugador1.colocarCarta(dragonBlanco);
		
		
		assertTrue(huevo1.estaMuerta());
		assertTrue(huevo2.estaMuerta());
		
	}
	

	@Test
	public void MonstruoEnModoDeDefensaNoPuedeAtacar() {
		
		Monstruo monstruoDefensa = new Monstruo(new BocaArriba(),new ModoDefensa(300), new Debil(), 300, 600, new SinEfecto(), new SinEfecto());
		Monstruo monstruoAtaque = new Monstruo(new BocaArriba(),new ModoAtaque(300), new Debil(), 300, 600, new SinEfecto(), new SinEfecto());
		
		assertThrows(MonstruoEnModoDefensaNoPuedeAtacarException.class,
                ()->{
                	monstruoDefensa.atacar(monstruoAtaque);
                });
		
	}
	
	@Test
    public void AtacarAHuevoEnModoDefensaConMonstruoEnModoAtaqueConMenosPuntosNoMataAlHuevo() {

       Monstruo huevo = FabricaCartaMonstruo.HUEVOMONSTRUOSO.crear();
       Monstruo piernaDerecha = FabricaCartaMonstruo.PIERNADERECHA.crear();
       
       huevo.cambiarModo();
       
       piernaDerecha.atacar(huevo);
       
       assertFalse(piernaDerecha.estaMuerta());
       assertFalse(huevo.estaMuerta());

    }

}