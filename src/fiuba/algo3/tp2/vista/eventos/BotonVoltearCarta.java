package fiuba.algo3.tp2.vista.eventos;

import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.cartas.Monstruo;
import fiuba.algo3.tp2.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class BotonVoltearCarta implements EventHandler<ActionEvent> {

	private Monstruo monstruo;
	private ContenedorPrincipal contenedorPrincipal;
	private Jugador jugador;
	
	public BotonVoltearCarta(Monstruo monstruo, ContenedorPrincipal contenedorPrincipal, Jugador jugador) {
		this.monstruo = monstruo;
		this.contenedorPrincipal = contenedorPrincipal;
		this.jugador = jugador;
		
	}

	@Override
	public void handle(ActionEvent event) {

		this.monstruo.voltearCarta();
		
		HBox zonaMonstruosJugadorActivo = new HBox(); 
		for (Monstruo unMonstruo: ContenedorPrincipal.juego.getJugadorActivo().getMonstruos()) {
			ImageView unaImagenMonstruo = new ImageView();
			Image imagenCarta;
			if(unMonstruo.estaBocaAbajo()) {
				imagenCarta = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/cartas/bocaAbajo.jpg");
				unaImagenMonstruo.setImage(imagenCarta);
				ContenedorPrincipal.consola.setText(monstruo.getNombre()+"\nCambio a boca Abajo");
			}
			else{
				imagenCarta = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/cartas/" + unMonstruo.getNombre() + ".jpg");
				unaImagenMonstruo.setImage(imagenCarta);
				ContenedorPrincipal.consola.setText(monstruo.getNombre()+"\nCambio a boca Arriba");
			}
			if (unMonstruo.estaEnModoAtaque()) {
				unaImagenMonstruo.setRotate(0);
			}
			else unaImagenMonstruo.setRotate(90);
			unaImagenMonstruo.setOnMouseClicked(new ClickSobreCartaMonstruo(jugador, contenedorPrincipal, unMonstruo));
			zonaMonstruosJugadorActivo.getChildren().add(unaImagenMonstruo);
		}
		int cantidadDeMonstruos = zonaMonstruosJugadorActivo.getChildren().size();
		if (cantidadDeMonstruos < 5) {
			for (int i = 0; i < 5 - cantidadDeMonstruos; i++) {
				zonaMonstruosJugadorActivo.getChildren().add(contenedorPrincipal.espacioCartaMonstruoJugadorActivo());
			}
		}
		contenedorPrincipal.actualizarContenedorCentralZonaMonstruosJugadorActivo(zonaMonstruosJugadorActivo);
		
	}

}
