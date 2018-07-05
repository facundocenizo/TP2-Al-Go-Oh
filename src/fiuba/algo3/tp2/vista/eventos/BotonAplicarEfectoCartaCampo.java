package fiuba.algo3.tp2.vista.eventos;

import fiuba.algo3.tp2.LadoDelCampo;
import fiuba.algo3.tp2.cartas.CartaCampo;
import fiuba.algo3.tp2.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonAplicarEfectoCartaCampo implements EventHandler<ActionEvent>  {

	private ContenedorPrincipal contenedorPrincipal;
	private CartaCampo carta;
	
	public BotonAplicarEfectoCartaCampo(CartaCampo carta, ContenedorPrincipal contenedorPrincipal) {
		this.contenedorPrincipal = contenedorPrincipal;
		this.carta = carta;
	}
	
	@Override
	public void handle(ActionEvent event) {
		LadoDelCampo ladoPropio = ContenedorPrincipal.juego.getJugadorActivo().getLadoDelCampo();
		LadoDelCampo ladoRival = ContenedorPrincipal.juego.getJugadorInactivo().getLadoDelCampo();
		carta.aplicarEfecto(ladoPropio, ladoRival);
		ladoPropio.limpiarZonaDeCampo();
		contenedorPrincipal.setContenedorPrincipal();
	}

}
