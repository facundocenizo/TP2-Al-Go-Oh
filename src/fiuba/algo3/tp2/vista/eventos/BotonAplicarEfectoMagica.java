package fiuba.algo3.tp2.vista.eventos;

import fiuba.algo3.tp2.cartas.Magica;
import fiuba.algo3.tp2.juego.LadoDelCampo;
import fiuba.algo3.tp2.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonAplicarEfectoMagica implements EventHandler<ActionEvent> {
	
	private ContenedorPrincipal contenedorPrincipal;
	private Magica carta;
	
	public BotonAplicarEfectoMagica(Magica carta, ContenedorPrincipal contenedorPrincipal) {
		this.contenedorPrincipal = contenedorPrincipal;
		this.carta = carta;
	}
	
	@Override
	public void handle(ActionEvent event) {
		LadoDelCampo ladoPropio = ContenedorPrincipal.juego.getJugadorActivo().getLadoDelCampo();
		LadoDelCampo ladoRival = ContenedorPrincipal.juego.getJugadorInactivo().getLadoDelCampo();
		carta.aplicarEfecto(ladoPropio, ladoRival);
		ladoPropio.limpiarZonaMagicaYTrampa();
		contenedorPrincipal.setContenedorCentral();
		contenedorPrincipal.setContenedorAbajo();
		contenedorPrincipal.setContenedorIzquierdo();
	}

}
