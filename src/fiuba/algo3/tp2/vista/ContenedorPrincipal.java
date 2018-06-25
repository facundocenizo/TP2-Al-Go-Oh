package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.Juego;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ContenedorPrincipal extends BorderPane
{
    BarraDeMenu barraMenu;
    Juego juego;
    Stage stage;
    ScrollPane scrollPane;
    Scene siguienteEscena;

    public ContenedorPrincipal(Stage stage, Scene siguienteEscena, Juego juego, BarraDeMenu barraMenu)
    {
        this.juego = juego;
        this.stage = stage;
        this.barraMenu = barraMenu;
        this.siguienteEscena = siguienteEscena;
    }

    public void inicializar()
    {
        setMenu();
    
    }


    private void setMenu()
    {
        this.setTop(barraMenu);
    }


    public BarraDeMenu getBarraDeMenu()
    {
        return barraMenu;
    }

    public Stage getStage(){
        return stage;
    }

    public Scene getSiguienteEscena(){
        return siguienteEscena;
    }

   
}

