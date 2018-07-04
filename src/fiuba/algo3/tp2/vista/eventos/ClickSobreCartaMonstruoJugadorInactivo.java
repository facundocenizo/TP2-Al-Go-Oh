package fiuba.algo3.tp2.vista.eventos;

import fiuba.algo3.tp2.cartas.Monstruo;
import fiuba.algo3.tp2.vista.ContenedorPrincipal;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ClickSobreCartaMonstruoJugadorInactivo implements EventHandler<MouseEvent> {
	
	private Monstruo monstruo;
	
	public ClickSobreCartaMonstruoJugadorInactivo(Monstruo monstruo) {
		this.monstruo = monstruo;
	}

	
	@Override
	public void handle(MouseEvent event) {
		if (monstruo.estaBocaAbajo()) {
			ContenedorPrincipal.consola.setText("No es posible ver \ndescripcion.");
			return;
		}
		ContenedorPrincipal.consola.setText("Nombre de la carta:\n" + monstruo.nombre + "\nATK: " + monstruo.darPuntosDeAtaque() + "\nDEF: " + monstruo.darPuntosDeDefensa());
	}

}
