package fiuba.algo3.tp2.vista.eventos;

import fiuba.algo3.tp2.cartas.Monstruo;
import fiuba.algo3.tp2.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class BotonAtacar implements EventHandler<ActionEvent> {
	
	private ContenedorPrincipal contenedorPrincipal;
	private Monstruo atacante;
	
	public BotonAtacar(Monstruo atacante, ContenedorPrincipal contenedorPrincipal) {
		this.atacante = atacante;
		this.contenedorPrincipal = contenedorPrincipal;
	}
	
	@Override
	public void handle(ActionEvent event) {
		
		if (ContenedorPrincipal.juego.getJugadorInactivo().getMonstruos().size() == 0) {
			ContenedorPrincipal.juego.getJugadorActivo().atacar(atacante, null);
			contenedorPrincipal.terminarTurno();
			return;
		}
		
		ContenedorPrincipal.consola.setText("Selecciona el \nmonstruo a atacar");
		
		HBox zonaMonstruosJugadorInactivo = new HBox(); 
		for (Monstruo unMonstruo: ContenedorPrincipal.juego.getJugadorInactivo().getMonstruos()) {
			ImageView unaImagenMonstruo = new ImageView("file:" + 
		            "src/fiuba/algo3/tp2/vista/imagenes/cartas/" + unMonstruo.getNombre() + ".jpg");
			unaImagenMonstruo.setOnMouseClicked(new ClickSobreCartaMonstruoASerAtacada(atacante, unMonstruo, contenedorPrincipal));
			zonaMonstruosJugadorInactivo.getChildren().add(unaImagenMonstruo);
		}
		int cantidadDeMonstruos = zonaMonstruosJugadorInactivo.getChildren().size();
		if (cantidadDeMonstruos < 5) {
			for (int i = 0; i < 5 - cantidadDeMonstruos; i++) {
				zonaMonstruosJugadorInactivo.getChildren().add(ContenedorPrincipal.espacioCartaMonstruoJugadorInactivo());
			}
		}
		contenedorPrincipal.actualizarContenedorCentralZonaMonstruosJugadorInactivo(zonaMonstruosJugadorInactivo);
	}

}
