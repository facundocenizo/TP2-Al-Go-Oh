package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.Juego;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
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
        
        inicializarContenedorSuperior();
        inicializarContenedorInferior();
        
        inicializarContenedorCentral();
        
        inicializarContenedorIzquierda();
        inicializarContenedorDerecha();

    }


    private void inicializarContenedorCentral() {

    	HBox contenedorZonaMagicaTrampasSuperior = inicializarZonaMagicaTrampaSuperior();
    	HBox contenedorZonaMonstruosSuperior = inicializarZonaMonstruosSuperior();
    	HBox contenedorZonaMonstruosInferior = inicializarZonaMonstruosInferior();
    	HBox contenedorZonaMagicaTrampasInferior = inicializarZonaMagicaTrampaInferior();
    	
    	
    	VBox tablero = new VBox(contenedorZonaMagicaTrampasSuperior,contenedorZonaMonstruosSuperior,
    							contenedorZonaMonstruosInferior,contenedorZonaMagicaTrampasInferior);
    	tablero.setSpacing(20);
        this.setCenter(tablero);
		
	}


    private HBox inicializarZonaMonstruosInferior() {
    	HBox zona = new HBox();
		
		ImageView imagenCarta1 = espacioCartaMonstruo();
    	ImageView imagenCarta2 = espacioCartaMonstruo();
    	ImageView imagenCarta3 = espacioCartaMonstruo();
    	ImageView imagenCarta4 = espacioCartaMonstruo();
    	ImageView imagenCarta5 = espacioCartaMonstruo();
    	
    	zona.setSpacing(100);
    	zona.setAlignment(Pos.CENTER);
    	zona.getChildren().addAll(imagenCarta1, imagenCarta2, imagenCarta3, imagenCarta4, imagenCarta5);//aca agregar mas cosas
		
		return zona;
	}

	private HBox inicializarZonaMonstruosSuperior() {
    	HBox zona = new HBox();
		
		ImageView imagenCarta1 = espacioCartaMonstruo();
    	ImageView imagenCarta2 = espacioCartaMonstruo();
    	ImageView imagenCarta3 = espacioCartaMonstruo();
    	ImageView imagenCarta4 = espacioCartaMonstruo();
    	ImageView imagenCarta5 = espacioCartaMonstruo();
    	
    	zona.setSpacing(100);
    	zona.setAlignment(Pos.CENTER);
    	zona.getChildren().addAll(imagenCarta1, imagenCarta2, imagenCarta3, imagenCarta4, imagenCarta5);//aca agregar mas cosas
		
		return zona;
	}

	private HBox inicializarZonaMagicaTrampaSuperior() {
		HBox zona = new HBox();
		
		ImageView imagenCarta1 = espacioCartaMagicaTrampa();
    	ImageView imagenCarta2 = espacioCartaMagicaTrampa();
    	ImageView imagenCarta3 = espacioCartaMagicaTrampa();
    	ImageView imagenCarta4 = espacioCartaMagicaTrampa();
    	ImageView imagenCarta5 = espacioCartaMagicaTrampa();
    	
    	zona.setSpacing(100);
    	zona.setAlignment(Pos.CENTER);
    	zona.getChildren().addAll(imagenCarta1, imagenCarta2, imagenCarta3, imagenCarta4, imagenCarta5);//aca agregar mas cosas
		
		return zona;
	}
    private HBox inicializarZonaMagicaTrampaInferior() {
		HBox zona = new HBox();
		
		ImageView imagenCarta1 = espacioCartaMagicaTrampa();
    	ImageView imagenCarta2 = espacioCartaMagicaTrampa();
    	ImageView imagenCarta3 = espacioCartaMagicaTrampa();
    	ImageView imagenCarta4 = espacioCartaMagicaTrampa();
    	ImageView imagenCarta5 = espacioCartaMagicaTrampa();
    	
    	zona.setSpacing(100);
    	zona.setAlignment(Pos.CENTER);
    	zona.getChildren().addAll(imagenCarta1, imagenCarta2, imagenCarta3, imagenCarta4, imagenCarta5);//aca agregar mas cosas
		
		return zona;
	}
    public ImageView espacioCarta() {
    	return new ImageView();
    }
    public ImageView espacioCartaMagicaTrampa() {
    	ImageView imagenCarta = new ImageView("file:src/fiuba/algo3/tp2/vista/imagenes/cartas/cartasReducidas/magica.png");
    	return imagenCarta;
    }
    public ImageView espacioCartaCementerio() {
    	ImageView imagenCarta = new ImageView("file:src/fiuba/algo3/tp2/vista/imagenes/cartas/cartasReducidas/cementerio.png");
		
    	return imagenCarta;
    }
    public ImageView espacioCartaMonstruo() {
    	ImageView imagenCarta = new ImageView("file:src/fiuba/algo3/tp2/vista/imagenes/cartas/cartasReducidas/monstruo.png");
    	
    	return imagenCarta;
    }
    public ImageView espacioMazo() {
    	ImageView imagenCarta = new ImageView("file:src/fiuba/algo3/tp2/vista/imagenes/cartas/cartasReducidas/bocaAbajo.jpg");
		
    	return imagenCarta;
    }
    
    public ImageView espacioCartaCampo() {
    	ImageView imagenCarta = new ImageView("file:src/fiuba/algo3/tp2/vista/imagenes/cartas/cartasReducidas/cartaCampo.png");
		
    	return imagenCarta;
    }
    

		private void inicializarContenedorDerecha() {
		VBox vbox = new VBox();
    	ImageView mazo = new ImageView("file:src/fiuba/algo3/tp2/vista/imagenes/cartas/cartasReducidas/mazo.jpg");
    	ImageView cementerio = new ImageView("file:src/fiuba/algo3/tp2/vista/imagenes/cartas/cartasReducidas/cementerio.png");
    	ImageView cartaCampo = new ImageView("file:src/fiuba/algo3/tp2/vista/imagenes/cartas/cartasReducidas/cartaCampo.jpg");
    	
    	vbox.getChildren().addAll(cartaCampo, cementerio, mazo);//aca agregar mas cosas
    		

    	vbox.setSpacing(10);
    	vbox.setPadding(new Insets(70));
    	vbox.setAlignment(Pos.CENTER_LEFT);
    	this.setRight(vbox);
	}

	private void inicializarContenedorIzquierda() {
		VBox vbox = new VBox();
    	ImageView mazo = new ImageView("file:src/fiuba/algo3/tp2/vista/imagenes/cartas/cartasReducidas/mazo.jpg");
    	ImageView cementerio = new ImageView("file:src/fiuba/algo3/tp2/vista/imagenes/cartas/cartasReducidas/cementerio.png");
    	ImageView cartaCampo = new ImageView("file:src/fiuba/algo3/tp2/vista/imagenes/cartas/cartasReducidas/cartaCampo.jpg");
    	
    	vbox.getChildren().addAll(mazo, cementerio, cartaCampo);//aca agregar mas cosas

    	vbox.setSpacing(10);
    	vbox.setPadding(new Insets(70));
    	vbox.setAlignment(Pos.CENTER_RIGHT);
    	this.setLeft(vbox);
	}

	
	
	
	
	
	
	
	
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
//    	hbox.getChildren().addAll(imagenJugadorUno, vida, cartaSeleccionada, imagenCarta, descripcionCarta);//aca agregar mas cosas
    	hbox.getChildren().addAll(cartaSeleccionada, imagenCarta,descripcionCarta, vida, imagenJugadorUno);//aca agregar mas cosas
    	hbox.setAlignment(Pos.TOP_RIGHT);
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
	
   
}

