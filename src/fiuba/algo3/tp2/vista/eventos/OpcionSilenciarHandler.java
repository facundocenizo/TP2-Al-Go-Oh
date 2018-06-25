package fiuba.algo3.tp2.vista.eventos;

import fiuba.algo3.tp2.vista.BarraDeMenu;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;

public class OpcionSilenciarHandler implements EventHandler<ActionEvent>{

    BarraDeMenu barraMenu;
    AudioClip musica;

    public OpcionSilenciarHandler(BarraDeMenu barraMenu, AudioClip musica) {
        this.barraMenu = barraMenu;
        this.musica = musica;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        musica.stop();
        barraMenu.reproduciendoMusica(false);
    }

}
