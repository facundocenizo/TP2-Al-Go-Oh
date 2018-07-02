package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.vista.BarraDeMenu;
import fiuba.algo3.tp2.vista.ContenedorJugadores;
import fiuba.algo3.tp2.vista.ContenedorPrincipal;
import fiuba.algo3.tp2.Juego;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import javafx.scene.media.AudioClip;

	public class Aplicacion extends Application {

	    public static void main(String[] args) {
	        launch(args);
	    }

	    @Override
	    public void start(final Stage stage) throws Exception {
	    	
	    	AudioClip audioIntro = new AudioClip("file:src/fiuba/algo3/tp2/vista/sonidos/musicaInicio.mp3");
	        audioIntro.setCycleCount(2);
	        audioIntro.play();
	        BarraDeMenu barraMenu = new BarraDeMenu(stage, audioIntro);
	    	
	        Juego juego = new Juego();
	        stage.setTitle("Al-Go-Oh!");
	       
	        
	        
	        ContenedorPrincipal contenedorPrincipal = 
	        		new ContenedorPrincipal(stage, null, juego, barraMenu);
	        

	        ScrollPane scroll = new ScrollPane();
	        scroll.setContent(contenedorPrincipal);
	        
	        Scene escenaJuego = 
	        		new Scene(scroll, 640, 480);
	        
	        ContenedorJugadores contenedorJugadores = 
	        		new ContenedorJugadores(stage, escenaJuego,juego, contenedorPrincipal);
	        Scene escenaJugadores = 
	        		new Scene(contenedorJugadores, 640, 480);
	        
      
	   

	        ContenedorBienvenida contenedorBienvenidos = 
	        		new ContenedorBienvenida(stage, audioIntro, escenaJugadores);
    
	        Scene escenaBienvenidos = 
	        		new Scene(contenedorBienvenidos, 800, 600);
	        	        
	        stage.setScene(escenaBienvenidos);
	        stage.setFullScreen(true);
	        stage.setFullScreenExitHint("");

	        stage.show();
	        
	    }

}

