package fiuba.algo3.tp2.vista;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.vista.ContenedorPrincipal;
import fiuba.algo3.tp2.vista.eventos.BotonAceptarEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ContenedorJugadores extends VBox{
	
	Stage stage;
	Juego juego;
	ContenedorPrincipal contenedorPrincipal;
	Scene proximaEscena;
	
	public ContenedorJugadores(Stage stage, Scene proximaEscena, Juego juego, ContenedorPrincipal contenedor){
		super();
		this.stage = stage;
		this.proximaEscena = proximaEscena;
		this.contenedorPrincipal = contenedor;
		
		this.setAlignment(Pos.CENTER);
		Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/imagenJugadorUno.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
        
        Button botonAceptar = new Button();
        botonAceptar.setText("Aceptar");
        botonAceptar.setStyle("-fx-base: #001234");
        
        Text jugador = new Text("Jugador Uno");
        jugador.setFill(Color.ANTIQUEWHITE);
        jugador.setFont(Font.font("Tahoma", FontWeight.BOLD, 32));
        
		TextField texto = new TextField();
		texto.setPromptText("Ingrese su nombre");
		texto.setMaxWidth(200);
		texto.requestFocus();
		
		
        Label etiqueta = new Label();
        VBox contenedorIngreso = new VBox(jugador, texto, botonAceptar, etiqueta);
        contenedorIngreso.setSpacing(30);
        contenedorIngreso.setPadding(new Insets(100));

        contenedorIngreso.setMinSize(100, 200);
        contenedorIngreso.setAlignment(Pos.BOTTOM_LEFT);
        contenedorIngreso.setMinSize(100, 200);
       	contenedorIngreso.setMinHeight(800);
        
        List<String> nombresJugadores = new ArrayList<String>();
        
        BotonAceptarEventHandler botonAceptarEventHandler =
        new BotonAceptarEventHandler(texto, etiqueta, jugador, nombresJugadores, juego, proximaEscena, stage, contenedorPrincipal ,this);
        botonAceptar.setOnAction(botonAceptarEventHandler);
        texto.setOnAction(botonAceptarEventHandler);
        
        this.getChildren().add(contenedorIngreso);
	}

}
