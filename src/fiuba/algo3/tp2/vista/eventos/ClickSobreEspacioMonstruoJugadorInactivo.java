package fiuba.algo3.tp2.vista.eventos;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ClickSobreEspacioMonstruoJugadorInactivo implements EventHandler<MouseEvent> {
	
	private ImageView imagenCarta;
	
	public ClickSobreEspacioMonstruoJugadorInactivo(ImageView imagenCarta) {
		this.imagenCarta = imagenCarta;
	}
	
	@Override
	public void handle(MouseEvent event) {
		// TODO Auto-generated method stub
		
	}

}
