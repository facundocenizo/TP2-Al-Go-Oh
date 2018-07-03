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
	private Jugador jugador;
	
	public ClickSobreEspacioMagicaTrampa(Jugador jugador, ImageView imagenCarta) {
		this.jugador = jugador;
		this.imagenCarta = imagenCarta;
	}
	@Override
	public void handle(MouseEvent arg0) {
		
		if(ContenedorPrincipal.cartaSeleccionada != null) {
			Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/cartas/"+ContenedorPrincipal.cartaSeleccionada.getNombre()+".jpg");
			imagenCarta.setImage(imagen);
			
			//aca agregarle un nuevo evento on mouse click ??
			
			this.jugador.colocarCarta((Magica) ContenedorPrincipal.cartaSeleccionada);
			this.jugador.colocarCarta((Trampa) ContenedorPrincipal.cartaSeleccionada);
			ContenedorPrincipal.cartaSeleccionada = null;
			ContenedorPrincipal.consola.limpiar();
		}
	}

}
