package fiuba.algo3.tp2.vista.eventos;

import fiuba.algo3.tp2.vista.ContenedorPrincipal;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class ClickSobreCartaTrampa implements EventHandler<MouseEvent> {
	
	private ContenedorPrincipal contenedorPrincipal;

	public ClickSobreCartaTrampa(ContenedorPrincipal contenedorPrincipal) {
		this.contenedorPrincipal = contenedorPrincipal;
	}
	
	@Override
	public void handle(MouseEvent event) {
		contenedorPrincipal.setContenedorIzquierdo();
		Button botonAplicarEfecto = new Button("Aplicar efecto");
        BotonAplicarEfecto aplicarEfecto =
            new BotonAplicarEfecto();
        botonAplicarEfecto.setOnAction(aplicarEfecto);
        ContenedorPrincipal.contenedorIzquierdo.getChildren().add(botonAplicarEfecto);
        ContenedorPrincipal.cartaSeleccionada = null;
	}

}
