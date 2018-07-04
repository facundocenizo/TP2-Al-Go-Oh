package fiuba.algo3.tp2.vista.eventos;

import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.cartas.CartaCampo;
import fiuba.algo3.tp2.vista.ContenedorPrincipal;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ClickSobreCartaCampo implements EventHandler<MouseEvent> {
	
	private Jugador jugador;
	private ImageView imagenCarta;
	private ContenedorPrincipal contenedorPrincipal;
	
	public ClickSobreCartaCampo(Jugador jugador, ImageView imagenCarta, ContenedorPrincipal contenedorPrincipal) {
		this.jugador = jugador;
		this.imagenCarta = imagenCarta;
		this.contenedorPrincipal = contenedorPrincipal;
	}
	
	@Override
	public void handle(MouseEvent event) {		
		contenedorPrincipal.setContenedorIzquierdo();
		if(ContenedorPrincipal.cartaSeleccionada != null) {
			if(ContenedorPrincipal.cartaSeleccionada.esCartaCampo()) {
				Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/cartas/"+ContenedorPrincipal.cartaSeleccionada.getNombre()+".jpg");
				imagenCarta.setImage(imagen);
				imagenCarta.setOnMouseClicked(new ClickSobreCartaCampo(jugador, imagenCarta, contenedorPrincipal));
				this.jugador.colocarCarta((CartaCampo) ContenedorPrincipal.cartaSeleccionada);
				ContenedorPrincipal.cartaSeleccionada = null;
				ContenedorPrincipal.consola.limpiar();
				
				ContenedorPrincipal.cartasEnManoJugadorActivo.getChildren().remove(ContenedorPrincipal.cartaSeleccionada);
				contenedorPrincipal.setContenedorAbajo();
			 }
			else
				ContenedorPrincipal.consola.setText("La carta debe ser del\ntipo Carta Campo para\ncolocarla en ese lugar..");
		}
		else {
			Button botonAplicarEfecto = new Button("Aplicar efecto");
	        BotonAplicarEfecto aplicarEfecto =
	            new BotonAplicarEfecto();
	        botonAplicarEfecto.setOnAction(aplicarEfecto);
	        ContenedorPrincipal.contenedorIzquierdo.getChildren().add(botonAplicarEfecto);
		}
	}
}