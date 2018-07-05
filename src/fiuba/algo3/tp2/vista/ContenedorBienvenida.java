package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.vista.eventos.BotonEntrarEventHandler;
import fiuba.algo3.tp2.vista.eventos.BotonReproducirHandler;
import fiuba.algo3.tp2.vista.eventos.BotonSalirEventHandler;
import fiuba.algo3.tp2.vista.eventos.BotonSilenciarHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ContenedorBienvenida extends VBox
{
    Stage stage;
	private Button botonSilenciar;
	private Button botonReproducir;
    
	public ContenedorBienvenida(Stage stage, AudioClip musica, Scene proximaEscena) {
		 super();
	        this.stage = stage;
	        this.setAlignment(Pos.BOTTOM_LEFT);
	        this.setSpacing(50);
	        
	        Image imagen = new Image("file:" + 
	            "src/fiuba/algo3/tp2/vista/imagenes/" +
	            "imagenInicio.jpg");
	        BackgroundImage imagenDeFondo =
	            new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT,
	            BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
	            BackgroundSize.DEFAULT);
	        this.setBackground(new Background(imagenDeFondo));
	        
	        ImageView logo = new ImageView("file:" + 
		            "src/fiuba/algo3/tp2/vista/imagenes/" +
		            "logo.png");
	        logo.setFitHeight(150);
	        logo.setFitWidth(400);
	        
	        Button botonEntrar = new Button();
	        botonEntrar.setText("Jugar!");
	        botonEntrar.setMinSize(200, 120);
	        botonEntrar.setFont(Font.font("Courier New",FontWeight.BOLD, 56));
	        botonEntrar.setStyle("-fx-base: #1234");
	        botonEntrar.defaultButtonProperty().bind(botonEntrar.focusedProperty());
	        
	        Button botonSalir = new Button();
	        botonSalir.setText("Salir :(");
	        botonSalir.setFont(Font.font("", 20));
	        botonSalir.setStyle("-fx-base: #1234");
	        botonSalir.defaultButtonProperty().bind(botonSalir.focusedProperty());
	        botonSalir.setMinSize(180, 40);
	        
	        Button botonSilenciar = new Button();
	        botonSilenciar.setText("Silenciar musica");
	        botonSilenciar.setFont(Font.font("", 16));
	        botonSilenciar.setStyle("-fx-base: #1234");
	        botonSilenciar.defaultButtonProperty().bind(botonSilenciar.focusedProperty());
	        botonSilenciar.setMinSize(180, 40);
	        this.botonSilenciar =botonSilenciar;
	        
	        Button botonReproducir = new Button();
	        botonReproducir.setText("Reproducir musica");
	        botonReproducir.setFont(Font.font("", 16));
	        botonReproducir.setStyle("-fx-base: #1234");
	        botonReproducir.defaultButtonProperty().bind(botonReproducir.focusedProperty());
	        botonReproducir.setMinSize(180, 40);
	        botonReproducir.setDisable(true);
	        this.botonReproducir=botonReproducir;
	        
	        BotonEntrarEventHandler botonEntrarHandler =
	           new BotonEntrarEventHandler(stage, proximaEscena);
	        botonEntrar.setOnAction(botonEntrarHandler);
	   
	        BotonSalirEventHandler botonSalirHandler = new BotonSalirEventHandler();
	        botonSalir.setOnAction(botonSalirHandler);
	        
	        BotonSilenciarHandler botonSilenciarHandler = new BotonSilenciarHandler(musica,this);
	        botonSilenciar.setOnAction(botonSilenciarHandler);
	        
	        BotonReproducirHandler botonReproducirHandler = new BotonReproducirHandler(musica,this);
	        botonReproducir.setOnAction(botonReproducirHandler);
	        
	        this.getChildren().addAll(logo, botonEntrar, botonSilenciar,botonReproducir, botonSalir);
	        this.setPadding(new Insets(30));
	        this.setSpacing(20);
	}

	public void musicaEstaReproduciendo(boolean estaReproduciendo) {
		this.botonSilenciar.setDisable(!estaReproduciendo);
		this.botonReproducir.setDisable(estaReproduciendo);
	}
	
}

