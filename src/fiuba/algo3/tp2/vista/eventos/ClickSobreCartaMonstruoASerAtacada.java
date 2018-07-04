package fiuba.algo3.tp2.vista.eventos;

import fiuba.algo3.tp2.cartas.Monstruo;
import fiuba.algo3.tp2.vista.ContenedorPrincipal;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ClickSobreCartaMonstruoASerAtacada implements EventHandler<MouseEvent> {

	private Monstruo atacante;
	private Monstruo atacado;
	private ContenedorPrincipal contenedorPrincipal;
	
	public ClickSobreCartaMonstruoASerAtacada(Monstruo atacante, Monstruo atacado, ContenedorPrincipal contenedorPrincipal) {
		this.atacante = atacante;
		this.atacado = atacado;
		this.contenedorPrincipal = contenedorPrincipal;
	}
	
	@Override
	public void handle(MouseEvent event) {
		ContenedorPrincipal.juego.getJugadorActivo().atacar(atacante, atacado);
		contenedorPrincipal.terminarTurno();
	}

}
