package fiuba.algo3.tp2.vista.eventos;

import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.cartas.Monstruo;
import fiuba.algo3.tp2.vista.ContenedorPrincipal;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class ClickSobreEspacioMonstruo implements EventHandler<MouseEvent> {
	
	private Jugador jugador;
	private ImageView imagenCarta;
	private ContenedorPrincipal contenedorPrincipal;
	
	public ClickSobreEspacioMonstruo(Jugador jugador, ImageView imagenCarta, ContenedorPrincipal contenedorPrincipal ) {
		this.jugador = jugador;
		this.imagenCarta = imagenCarta;
		this.contenedorPrincipal = contenedorPrincipal;
	}
	@Override
	public void handle(MouseEvent arg0) {
		
		if(ContenedorPrincipal.cartaSeleccionada != null) {
			if(ContenedorPrincipal.cartaSeleccionada.esMonstruo()) {
				Monstruo monstruo = (Monstruo) ContenedorPrincipal.cartaSeleccionada;
				if(monstruo.esNormal()) {}	//chequear si se puede y luego  poner: contenedorPrincipal.setContenedorAbajo();
				if(monstruo.esPoderoso()) {} //idem el de arriba
				
				Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/cartas/"+ContenedorPrincipal.cartaSeleccionada.getNombre()+".jpg");
				imagenCarta.setImage(imagen);
				
				//aca agregarle un nuevo evento on mouse click
				
				this.jugador.colocarCarta((Monstruo) ContenedorPrincipal.cartaSeleccionada);
				ContenedorPrincipal.cartaSeleccionada = null;
				ContenedorPrincipal.consola.limpiar();
				
				ContenedorPrincipal.cartasEnManoJugadorActivo.getChildren().remove(ContenedorPrincipal.cartaSeleccionada);
				contenedorPrincipal.setContenedorAbajo();
			 }else
				ContenedorPrincipal.consola.setText("La carta debe ser del\ntipo Monstruo para\ncolocarla en ese lugar..");
		}
	}

}
