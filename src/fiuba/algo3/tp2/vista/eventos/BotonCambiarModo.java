package fiuba.algo3.tp2.vista.eventos;

import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.cartas.Monstruo;
import fiuba.algo3.tp2.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class BotonCambiarModo implements EventHandler<ActionEvent> {

	private Monstruo monstruo;
	private ContenedorPrincipal contenedorPrincipal;
	private Jugador jugador;
	
	public BotonCambiarModo(Monstruo monstruo, ContenedorPrincipal contenedorPrincipal, Jugador jugador) {
		this.monstruo = monstruo;
		this.contenedorPrincipal = contenedorPrincipal;
		this.jugador = jugador;
	}
		
	@Override
	public void handle(ActionEvent event) {

		this.monstruo.cambiarModo();
		
		HBox zonaMonstruosJugadorActivo = new HBox(); 
		for (Monstruo unMonstruo: ContenedorPrincipal.juego.getJugadorActivo().getMonstruos()) {
			ImageView unaImagenMonstruo = new ImageView("file:" + 
		            "src/fiuba/algo3/tp2/vista/imagenes/cartas/" + unMonstruo.getNombre() + ".jpg");
			if(unMonstruo.estaEnModoAtaque()) {
				unaImagenMonstruo.setRotate(0);
				ContenedorPrincipal.consola.setText(monstruo.getNombre()+"\nCambio a modo Ataque");
			}
			else{
				unaImagenMonstruo.setRotate(90);
				ContenedorPrincipal.consola.setText(monstruo.getNombre()+"\nCambio a modo Defensa");
			}
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
