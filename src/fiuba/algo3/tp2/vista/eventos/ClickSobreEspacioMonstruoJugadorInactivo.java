package fiuba.algo3.tp2.vista.eventos;

import fiuba.algo3.tp2.vista.ContenedorPrincipal;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ClickSobreEspacioMonstruoJugadorInactivo implements EventHandler<MouseEvent> {
	
	public ClickSobreEspacioMonstruoJugadorInactivo() {
	}
	
	@Override
	public void handle(MouseEvent event) {
		ContenedorPrincipal.consola.setText(" No se puede colocar\n aqui, es zona del oponente.");
		ContenedorPrincipal.cartaSeleccionada = null;
	}

}
