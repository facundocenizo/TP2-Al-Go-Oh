package fiuba.algo3.tp2.vista.eventos;

import fiuba.algo3.tp2.cartas.Magica;
import fiuba.algo3.tp2.vista.ContenedorPrincipal;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ClickSobreCartaMagica implements EventHandler<MouseEvent> {

	private ContenedorPrincipal contenedorPrincipal;
	private Magica carta;

	public ClickSobreCartaMagica(ContenedorPrincipal contenedorPrincipal, Magica carta) {
		this.contenedorPrincipal = contenedorPrincipal;
		this.carta = carta;
	}
	
	@Override
	public void handle(MouseEvent event) {
		contenedorPrincipal.setContenedorIzquierdo();
		ContenedorPrincipal.consola.setText(carta.getDescripcion());
		Button botonAplicarEfectoMagica = new Button("Aplicar efecto");
        BotonAplicarEfectoMagica aplicarEfectoMagica =
            new BotonAplicarEfectoMagica(carta, contenedorPrincipal);
        botonAplicarEfectoMagica.setOnAction(aplicarEfectoMagica);
        botonAplicarEfectoMagica.setMinSize(200, 7);
        botonAplicarEfectoMagica.setFont(Font.font("Courier New",FontWeight.BOLD, 15));
        
        ContenedorPrincipal.contenedorIzquierdo.getChildren().add(botonAplicarEfectoMagica);
        ContenedorPrincipal.cartaSeleccionada = null;
	}

}
