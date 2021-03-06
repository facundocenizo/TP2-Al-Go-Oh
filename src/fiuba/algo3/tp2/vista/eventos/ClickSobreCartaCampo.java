package fiuba.algo3.tp2.vista.eventos;

import fiuba.algo3.tp2.cartas.CartaCampo;
import fiuba.algo3.tp2.juego.Jugador;
import fiuba.algo3.tp2.vista.ContenedorPrincipal;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ClickSobreCartaCampo implements EventHandler<MouseEvent> {
	
	private Jugador jugador;
	private ImageView imagenCarta;
	private ContenedorPrincipal contenedorPrincipal;
	private CartaCampo carta;
	
	public ClickSobreCartaCampo(Jugador jugador, ImageView imagenCarta, ContenedorPrincipal contenedorPrincipal, CartaCampo carta) {
		this.jugador = jugador;
		this.imagenCarta = imagenCarta;
		this.contenedorPrincipal = contenedorPrincipal;
		this.carta = carta;
	}
	
	@Override
	public void handle(MouseEvent event) {		
		contenedorPrincipal.setContenedorIzquierdo();
		if(ContenedorPrincipal.cartaSeleccionada != null) {
			if(ContenedorPrincipal.cartaSeleccionada.esCartaCampo()) {
				Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/cartas/"+ContenedorPrincipal.cartaSeleccionada.getNombre()+".jpg");
				imagenCarta.setImage(imagen);
				imagenCarta.setOnMouseClicked(new ClickSobreCartaCampo(jugador, imagenCarta, contenedorPrincipal, (CartaCampo)ContenedorPrincipal.cartaSeleccionada));
				this.jugador.colocarCarta((CartaCampo) ContenedorPrincipal.cartaSeleccionada);
				ContenedorPrincipal.cartaSeleccionada = null;
				ContenedorPrincipal.consola.limpiar();
				
				ContenedorPrincipal.cartasEnManoJugadorActivo.getChildren().remove(ContenedorPrincipal.cartaSeleccionada);
				contenedorPrincipal.setContenedorAbajo();
			 }
			else
				ContenedorPrincipal.consola.setText("La carta debe ser del\ntipo Carta Campo para\ncolocarla en ese lugar..");
				ContenedorPrincipal.cartaSeleccionada = null;
		}
		else {
			ContenedorPrincipal.consola.setText(carta.getDescripcion());
			Button botonAplicarEfectoCartaCampo = new Button("Aplicar efecto");
	        BotonAplicarEfectoCartaCampo aplicarEfectoCartaCampo =
	            new BotonAplicarEfectoCartaCampo(carta, contenedorPrincipal);
	        botonAplicarEfectoCartaCampo.setOnAction(aplicarEfectoCartaCampo);
	        botonAplicarEfectoCartaCampo.setMinSize(200, 7);
	        botonAplicarEfectoCartaCampo.setFont(Font.font("Courier New",FontWeight.BOLD, 15));
	        
	        ContenedorPrincipal.contenedorIzquierdo.getChildren().add(botonAplicarEfectoCartaCampo);
		}
	}
}