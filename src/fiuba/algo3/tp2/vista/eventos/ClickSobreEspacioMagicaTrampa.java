package fiuba.algo3.tp2.vista.eventos;

import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.cartas.Magica;
import fiuba.algo3.tp2.cartas.Trampa;
import fiuba.algo3.tp2.vista.ContenedorPrincipal;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ClickSobreEspacioMagicaTrampa implements EventHandler<MouseEvent> {
	
	private ImageView imagenCarta;
	private ContenedorPrincipal contenedorPrincipal;
	private Jugador jugador;
	
	public ClickSobreEspacioMagicaTrampa(Jugador jugador, ImageView imagenCarta, ContenedorPrincipal contenedorPrincipal ) {
		this.imagenCarta = imagenCarta;
		this.contenedorPrincipal = contenedorPrincipal;
		this.jugador = jugador;
	}
	@Override
	public void handle(MouseEvent arg0) {
		
		if(ContenedorPrincipal.cartaSeleccionada != null) {
			if(ContenedorPrincipal.cartaSeleccionada.esMagica()) {
			Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/cartas/"+ContenedorPrincipal.cartaSeleccionada.getNombre()+".jpg");
			imagenCarta.setImage(imagen);
			imagenCarta.setOnMouseClicked(new ClickSobreCartaMagica(contenedorPrincipal, (Magica)ContenedorPrincipal.cartaSeleccionada));
			//aca agregarle un nuevo evento on mouse click
			this.jugador.colocarCarta((Magica) ContenedorPrincipal.cartaSeleccionada);
			
			ContenedorPrincipal.cartaSeleccionada = null;
			ContenedorPrincipal.consola.limpiar();
			
			ContenedorPrincipal.cartasEnManoJugadorActivo.getChildren().remove(ContenedorPrincipal.cartaSeleccionada);
			contenedorPrincipal.setContenedorAbajo();
			}
			else if(ContenedorPrincipal.cartaSeleccionada.esTrampa()) {
				Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/cartas/"+ContenedorPrincipal.cartaSeleccionada.getNombre()+".jpg");
				imagenCarta.setImage(imagen);
				//aca agregarle un nuevo evento on mouse click
				this.jugador.colocarCarta((Trampa) ContenedorPrincipal.cartaSeleccionada);
				
				ContenedorPrincipal.cartaSeleccionada = null;
				ContenedorPrincipal.consola.limpiar();
				
				ContenedorPrincipal.cartasEnManoJugadorActivo.getChildren().remove(ContenedorPrincipal.cartaSeleccionada);
				contenedorPrincipal.setContenedorAbajo();
			}else
				ContenedorPrincipal.consola.setText("La carta debe ser del\ntipo Magica o Trampa para\ncolocarla en ese lugar..");
		}	
		ContenedorPrincipal.cartaSeleccionada = null;
		ContenedorPrincipal.consola.limpiar();
	}

}
