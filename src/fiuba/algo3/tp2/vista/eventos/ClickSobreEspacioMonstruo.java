package fiuba.algo3.tp2.vista.eventos;

import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.cartas.Monstruo;
import fiuba.algo3.tp2.excepciones.NoHayTresDragonesBlancosParaInvocarDragonDefinitivoException;
import fiuba.algo3.tp2.excepciones.SeNecesitaUnMonstruoDeMenorNivelParaSacrificarException;
import fiuba.algo3.tp2.excepciones.SeNecesitanDosMonstruosDeMenorNivelParaSacrificarException;
import fiuba.algo3.tp2.vista.ContenedorPrincipal;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

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
			
				try {
					this.jugador.colocarCarta((Monstruo) ContenedorPrincipal.cartaSeleccionada);
					Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/cartas/"+monstruo.getNombre()+".jpg");
					imagenCarta.setImage(imagen);
					imagenCarta.setOnMouseClicked(new ClickSobreCartaMonstruo(jugador, contenedorPrincipal, monstruo));
					ContenedorPrincipal.cartasEnManoJugadorActivo.getChildren().remove(monstruo);
					if (monstruo.esNormal() || monstruo.esPoderoso() || monstruo.esDragonDefinitivo()) {
						jugador.llevarMonstruosMuertosAlCementerio();
						contenedorPrincipal.setContenedorCentral();
					}
					ContenedorPrincipal.consola.limpiar();
				}
				catch (SeNecesitanDosMonstruosDeMenorNivelParaSacrificarException excepcion) {
					ContenedorPrincipal.consola.setText(excepcion.getMessage());
				}
				catch (SeNecesitaUnMonstruoDeMenorNivelParaSacrificarException excepcion) {
					ContenedorPrincipal.consola.setText(excepcion.getMessage());
				}
				catch (NoHayTresDragonesBlancosParaInvocarDragonDefinitivoException excepcion) {
					ContenedorPrincipal.consola.setText(excepcion.getMessage());
				}
					
				ContenedorPrincipal.cartaSeleccionada = null;
				contenedorPrincipal.setContenedorAbajo();
			 }else
				ContenedorPrincipal.consola.setText("La carta debe ser del\ntipo Monstruo para\ncolocarla en ese lugar..");
		}
	}

}
