package fiuba.algo3.tp2.vista.eventos;

import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.cartas.Monstruo;
import fiuba.algo3.tp2.vista.ContenedorPrincipal;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class ClickSobreCartaMonstruo implements EventHandler<MouseEvent> {
	
	private Monstruo monstruo;
	private Jugador jugador;
	private ContenedorPrincipal contenedorPrincipal;
	
	public ClickSobreCartaMonstruo(Jugador jugador, ContenedorPrincipal contenedorPrincipal, Monstruo monstruo) {
		this.jugador = jugador;
		this.contenedorPrincipal = contenedorPrincipal;
		this.monstruo = monstruo;
	}

	@Override
	public void handle(MouseEvent event) {
		contenedorPrincipal.setContenedorIzquierdo();
		
		ContenedorPrincipal.consola.setText("ATK: " + monstruo.darPuntosDeAtaque() + "\nDEF: " + monstruo.darPuntosDeDefensa());


		Button botonVoltearCarta = new Button("Voltear carta");
        BotonVoltearCarta voltearCarta =
            new BotonVoltearCarta(monstruo, contenedorPrincipal, jugador);
        botonVoltearCarta.setOnAction(voltearCarta);
 
        Button botonCambiarModo = new Button("Cambiar modo");
        BotonCambiarModo cambiarModo =
            new BotonCambiarModo();
        botonCambiarModo.setOnAction(cambiarModo);
        
        Button botonAtacar = new Button("Atacar");
        BotonAtacar atacar =
            new BotonAtacar(monstruo, contenedorPrincipal);
        botonAtacar.setOnAction(atacar);
        
        ContenedorPrincipal.contenedorIzquierdo.getChildren().addAll(botonVoltearCarta, botonCambiarModo, botonAtacar);
        ContenedorPrincipal.cartaSeleccionada = null;
        
        
		
	}

}
