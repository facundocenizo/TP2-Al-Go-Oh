package fiuba.algo3.tp2.vista.eventos;

import fiuba.algo3.tp2.cartas.Monstruo;
import fiuba.algo3.tp2.juego.Jugador;
import fiuba.algo3.tp2.vista.ContenedorPrincipal;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

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
		
		ContenedorPrincipal.consola.setText("Nombre de la carta:\n" + monstruo.nombre + "\nATK: " + monstruo.darPuntosDeAtaque() + "\nDEF: " + monstruo.darPuntosDeDefensa());


		Button botonVoltearCarta = new Button("Voltear carta");
        BotonVoltearCarta voltearCarta =
            new BotonVoltearCarta(monstruo, contenedorPrincipal, jugador);
        botonVoltearCarta.setOnAction(voltearCarta);
        botonVoltearCarta.setMinSize(200, 7);
        botonVoltearCarta.setFont(Font.font("Courier New",FontWeight.BOLD, 15));
        
        
 
        Button botonCambiarModo = new Button("Cambiar modo");
        BotonCambiarModo cambiarModo =
            new BotonCambiarModo(monstruo, contenedorPrincipal, jugador);
        botonCambiarModo.setOnAction(cambiarModo);
        botonCambiarModo.setMinSize(200, 7);
        botonCambiarModo.setFont(Font.font("Courier New",FontWeight.BOLD, 15));
        
        Button botonAtacar = new Button("Atacar");
        BotonAtacar atacar =
            new BotonAtacar(monstruo, contenedorPrincipal);
        botonAtacar.setOnAction(atacar);
        botonAtacar.setMinSize(200, 7);
        botonAtacar.setFont(Font.font("Courier New",FontWeight.BOLD, 15));
        
        ContenedorPrincipal.contenedorIzquierdo.getChildren().addAll(botonVoltearCarta, botonCambiarModo, botonAtacar);
        ContenedorPrincipal.contenedorIzquierdo.setAlignment(Pos.CENTER);
        ContenedorPrincipal.cartaSeleccionada = null;
        
        
		
	}

}
