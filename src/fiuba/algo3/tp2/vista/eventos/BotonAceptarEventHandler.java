package fiuba.algo3.tp2.vista.eventos;

import java.util.List;

import fiuba.algo3.tp2.vista.ContenedorJugadores;
import fiuba.algo3.tp2.vista.ContenedorPrincipal;
import fiuba.algo3.tp2.Juego;
//import fiuba.algo3.tp2.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.media.AudioClip;

public class BotonAceptarEventHandler implements EventHandler<ActionEvent>{

	private TextField texto;
    private Label etiqueta;
    private List<String> nombresJugadores;
    private Juego juego;
    private Scene proximaEscena;
    private Stage stage;
    private Text jugador;
    private ContenedorPrincipal contenedorPrincipal;
    private ContenedorJugadores contenedorJugadores;

    public BotonAceptarEventHandler(TextField texto, Label etiqueta, Text jugador, List<String> nombresJugadores,
			Juego juego, Scene proxima, Stage stage, ContenedorPrincipal contenedor, ContenedorJugadores contenedorJugadores) {
		this.texto = texto;
		this.etiqueta = etiqueta;
		this.nombresJugadores = nombresJugadores;
		this.juego = juego;
		this.stage = stage;
		this.jugador = jugador;
		this.contenedorPrincipal = contenedor;
		proximaEscena = proxima;
		this.contenedorJugadores = contenedorJugadores;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
    	
    	
    	
    	if (texto.getText().trim().equals("")){
            etiqueta.setText("Debe ingresar un texto");
            etiqueta.setTextFill(Color.web("#FF0000")); // Rojo
            AudioClip audioIncorrecto = new AudioClip("file:src/fiuba/algo3/tp2/vista/sonidos/incorrecto.mp3");
            audioIncorrecto.play();
        }
    	else if (nombresJugadores.contains(texto.getText())){
    		etiqueta.setText("Ese nombre ya esta en uso. Elija otro");
        	etiqueta.setTextFill(Color.web("#FF0000"));
        	AudioClip audioIncorrecto = new AudioClip("file:src/fiuba/algo3/tp2/vista/sonidos/incorrecto.mp3");
	    	audioIncorrecto.play();
    	}
    	else {
    		Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/imagenJugadorDos.jpg");
            BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
            contenedorJugadores.setBackground(new Background(imagenDeFondo));
            
        	nombresJugadores.add(texto.getText());
        	
        	AudioClip audioBoton = new AudioClip("file:src/fiuba/algo3/tp2/vista/sonidos/boton2.mp3");
			audioBoton.play();
        	if (nombresJugadores.size() == 2){
        		
            	juego.getJugadorActivo().setNombre(nombresJugadores.get(0));
        		juego.getJugadorInactivo().setNombre(nombresJugadores.get(1));
        		contenedorPrincipal.setContenedorPrincipal();
        		stage.setScene(proximaEscena);
        		stage.setFullScreenExitHint("");
                stage.setFullScreen(true);
        	}
			texto.setText("");
			texto.setFocusTraversable(false);
			texto.setPromptText("Ingrese su nombre");
			etiqueta.setText("");
			jugador.setText("Jugador Dos");
	        jugador.setFill(Color.BLACK);
			}
    }
}
