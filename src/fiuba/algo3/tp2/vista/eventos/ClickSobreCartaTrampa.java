package fiuba.algo3.tp2.vista.eventos;

import fiuba.algo3.tp2.cartas.Trampa;
import fiuba.algo3.tp2.vista.ContenedorPrincipal;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ClickSobreCartaTrampa implements EventHandler<MouseEvent> {
	
	private Trampa carta;
	private ContenedorPrincipal contenedorPrincipal;

	public ClickSobreCartaTrampa(Trampa carta, ContenedorPrincipal contenedorPrincipal) {
		this.carta = carta;
		this.contenedorPrincipal = contenedorPrincipal;
	}
	
	@Override
	public void handle(MouseEvent event) {
		contenedorPrincipal.setContenedorIzquierdo();
		ContenedorPrincipal.consola.setText(carta.getDescripcion());
	    ContenedorPrincipal.cartaSeleccionada = null;
	}

}
