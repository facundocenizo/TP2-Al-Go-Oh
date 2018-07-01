package fiuba.algo3.tp2.segundaEntrega;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.LadoDelCampo;
import fiuba.algo3.tp2.cartas.Monstruo;
import fiuba.algo3.tp2.fabricas.FabricaCartaMonstruo;

public class CartaJinzoSieteTest {
	
	@Test
	public void test01MonstruoJinzoSieteAtacaDirectamenteALosPuntosDeVidaDelOponente() {
		
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
		
		Monstruo jinzo = FabricaCartaMonstruo.JINZOSIETE.crear();
		Monstruo dragonComun = FabricaCartaMonstruo.DRAGON.crear();
		
		jugador1.colocarCarta(jinzo);
		jugador2.colocarCarta(dragonComun);
		
		jugador2.atacar(jinzo,dragonComun);
		
		int puntosDeAtaqueDelDragon = 400;
		int puntosDeAtaqueDelGinzo = 500;
		int puntosDelEfectoGinzo = 500;
		
		int vidaDelJugadorEsperada = 8000 - puntosDelEfectoGinzo - (puntosDeAtaqueDelGinzo - puntosDeAtaqueDelDragon);
		
		assertEquals(vidaDelJugadorEsperada,jugador1.vida());
		
	}	
	
	@Test
	public void test02MonstruoJinzoSieteAtacaDirectamenteALosPuntosDeVidaDelOponente() {
		
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
		
		Monstruo jinzo = FabricaCartaMonstruo.JINZOSIETE.crear();
		Monstruo dragonComun = FabricaCartaMonstruo.DRAGON.crear();
		
		jugador1.colocarCarta(jinzo);
		jugador2.colocarCarta(dragonComun);
		
		jugador2.atacar(dragonComun,jinzo);
		
		int puntosDeAtaqueDelDragon = 400;
		int puntosDeAtaqueDelGinzo = 500;
		
		int vidaDelJugadorEsperada = 8000 - (puntosDeAtaqueDelGinzo - puntosDeAtaqueDelDragon);
		
		assertEquals(vidaDelJugadorEsperada,jugador2.vida());
	}
	
	
	@Test
	public void test03MonstruoJinzoSieteAtacaDirectamenteALosPuntosDeVidaDelOponente() {
		
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
		
		Monstruo jinzo = FabricaCartaMonstruo.JINZOSIETE.crear();
		Monstruo huevo = FabricaCartaMonstruo.HUEVOMONSTRUOSO.crear();
		
		jugador1.colocarCarta(jinzo);
		jugador2.colocarCarta(huevo);
		
		jugador2.atacar(jinzo,huevo);
		
		int puntosDelEfectoGinzo = 500;
		
		int vidaDelJugadorEsperada = 8000 - puntosDelEfectoGinzo;
		
		assertEquals(vidaDelJugadorEsperada,jugador1.vida());
		
	}
	
	
}
