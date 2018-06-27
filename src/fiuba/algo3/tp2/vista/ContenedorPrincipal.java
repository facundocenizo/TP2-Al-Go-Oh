package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.Juego;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
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
        

        Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/fondoNegro3.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
        
      
    }

    public void inicializar()
    {
        //inicializarContenedorIzquierda();
        //inicializarContenedorDerecha();
    	
    	//detalles jugador de arriba (vida, alguna imagen)
        inicializarContenedorSuperior();
        
        //detalles de jugador de abajo 
        inicializarContenedorInferior();
        
        inicializarContenedorCentral();
        

    }


    private void inicializarContenedorCentral() {

    	
    	HBox contenedorZonaMagicaTrampas1 = new HBox(new Label("zona1"));
    	
    	
    	HBox contenedorZonaMonstruos1 = new HBox(new Label("zona2"));
    	
    	
    	HBox contenedorZonaMonstruos2 = new HBox(new Label("zona3"));
    	
    	
    	HBox contenedorZonaMagicaTrampas2 = new HBox(new Label("zona4"));
    	
    	
    	VBox tablero = new VBox(contenedorZonaMagicaTrampas1,contenedorZonaMonstruos1,
    								contenedorZonaMonstruos2,contenedorZonaMagicaTrampas2);
    	tablero.setSpacing(100);
    	
        this.setCenter(tablero);
		
	}


/*	private void inicializarContenedorDerecha() {
    	VBox vbox = new VBox();
    	vbox.getChildren().addAll(new Label("derecha"));//aca agregar mas cosas
    	
    	this.setRight(vbox);
	}

	private void inicializarContenedorIzquierda() {
    	VBox vbox = new VBox();
    	vbox.getChildren().addAll(new Label("izquierda"));//aca agregar mas cosas
    	
    	this.setLeft(vbox);
	}
*/
	private void inicializarContenedorInferior() {
    	HBox hbox = new HBox();
    	
    	ImageView imagenJugadorUno = new ImageView("file:" + 
	            "src/fiuba/algo3/tp2/vista/imagenes/" +
	            "imagenJugadorUno.jpg");
    	imagenJugadorUno.setFitHeight(100);
    	imagenJugadorUno.setFitWidth(250);
    	
    	
    	Text vida = new Text("VIDA");  //jugador1.vida
    	vida.setFill(Color.LIMEGREEN);
    	vida.setFont(Font.font("Tahoma", FontWeight.BOLD, 82));
        	
    	Text cartaSeleccionada = new Text("Carta Seleccionada: ");
    	cartaSeleccionada.setFill(Color.BROWN);
    	cartaSeleccionada.setFont(Font.font("Tahoma", FontWeight.BOLD, 32));
    	
    	ImageView imagenCarta = new ImageView("file:" + 
	            "src/fiuba/algo3/tp2/vista/imagenes/cartas/" +
	           "bocaAbajo.png");
    	imagenCarta.setFitHeight(100);
    	imagenCarta.setFitWidth(65);
    	
    	Text descripcionCarta = new Text("Descripcion de la carta: ");
    	descripcionCarta.setFill(Color.WHITE);
    	descripcionCarta.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
    	
    	hbox.setSpacing(70);
		hbox.getChildren().addAll(imagenJugadorUno, vida, cartaSeleccionada, imagenCarta, descripcionCarta);//aca agregar mas cosas
		
		this.setBottom(hbox);
	}

	private void inicializarContenedorSuperior() {
		HBox hbox = new HBox();
    	ImageView imagenJugadorDos = new ImageView("file:" + 
	            "src/fiuba/algo3/tp2/vista/imagenes/" +
	            "imagenJugadorDos.jpg");
    	imagenJugadorDos.setFitHeight(100);
    	imagenJugadorDos.setFitWidth(250);
    	
    	Text vida = new Text("VIDA");  //jugador2.vida
    	vida.setFill(Color.LIMEGREEN);
    	vida.setFont(Font.font("Tahoma", FontWeight.BOLD, 82));
        	
    	Text cartaSeleccionada = new Text("Carta Seleccionada: ");
    	cartaSeleccionada.setFill(Color.BROWN);
    	cartaSeleccionada.setFont(Font.font("Tahoma", FontWeight.BOLD, 32));
    	
    	ImageView imagenCarta = new ImageView("file:" + 
	            "src/fiuba/algo3/tp2/vista/imagenes/cartas/" +
	           "bocaAbajo.png");
    	imagenCarta.setFitHeight(100);
    	imagenCarta.setFitWidth(65);
    	
    	Text descripcionCarta = new Text("Descripcion de la carta: ");
    	descripcionCarta.setFill(Color.WHITE);
    	descripcionCarta.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
    	
    	
    	hbox.setSpacing(70);
		hbox.getChildren().addAll(imagenJugadorDos, vida, cartaSeleccionada, imagenCarta, descripcionCarta);//aca agregar mas cosas
		
		VBox vbox = new VBox();
		vbox.getChildren().addAll(this.barraMenu, hbox);//aca agregar mas cosas
		
		this.setTop(vbox);
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

