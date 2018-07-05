package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.vista.eventos.BotonSalirEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ContenedorVictoria extends VBox{
	
        private static Text etiqueta = new Text("");
        private static AudioClip audioViejo;

        public ContenedorVictoria(Stage stage, AudioClip audio) {

            super();
            audioViejo = audio;
            
           

            this.setAlignment(Pos.CENTER);
            this.setSpacing(300);
            this.setPadding(new Insets(150, 50, 50, 50));
           	Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/ganaste.jpg");
            BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
            this.setBackground(new Background(imagenDeFondo));

            Button botonAceptar = new Button();
            botonAceptar.setText("Aceptar Victoria!");
            botonAceptar.setMinSize(300, 170);
            botonAceptar.setFont(Font.font("Courier New",FontWeight.BOLD, 72));
            botonAceptar.setStyle("-fx-base: #123400");
            
            etiqueta.setFont(Font.font("Courier New",FontWeight.BOLD, 50));
            etiqueta.setFill(Color.WHITE);
            
            BotonSalirEventHandler botonVictoria = new BotonSalirEventHandler();
            botonAceptar.setOnAction(botonVictoria);
	        
            this.getChildren().addAll(etiqueta, botonAceptar);
            stage.setFullScreenExitHint("");
            stage.setFullScreen(true);
            stage.show();
        }
        
        public static void recibirGanador(String ganador, String motivo){
        	etiqueta.setText("Ganador: " + ganador + "\nMotivo: " + motivo);
        	audioViejo.stop();
        	AudioClip audioVictoria = new AudioClip("file:src/fiuba/algo3/tp2/vista/sonidos/musicaFin.mp3");
        	//audioVictoria.play();
        }
}