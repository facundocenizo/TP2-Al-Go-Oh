package fiuba.algo3.tp2.vista.eventos;

import fiuba.algo3.tp2.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonTerminarTurno implements EventHandler<ActionEvent>{
	private ContenedorPrincipal contenedorPrincipal;
	
	public BotonTerminarTurno(ContenedorPrincipal contenedorPrincipal){
		this.contenedorPrincipal = contenedorPrincipal;
	}

	@Override
	public void handle(ActionEvent event) {
		this.contenedorPrincipal.terminarTurno();
		this.contenedorPrincipal.setContenedorPrincipal();
	}
}
