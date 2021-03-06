package fiuba.algo3.tp2.vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.media.AudioClip;

public class BotonEntrarEventHandler implements EventHandler<ActionEvent>{

    Stage stage;
    Scene proximaEscena;

    public BotonEntrarEventHandler(Stage stage, Scene proximaEscena) {
        this.stage = stage;
        this.proximaEscena = proximaEscena;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        stage.setScene(proximaEscena);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
        AudioClip audioBoton = new AudioClip("file:src/fiuba/algo3/tp2/vista/sonidos/boton.mp3");
        audioBoton.play();
    }
    
}
