package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.Juego;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.cartas.Carta;
import fiuba.algo3.tp2.cartas.Magica;
import fiuba.algo3.tp2.cartas.Monstruo;
import fiuba.algo3.tp2.cartas.Trampa;
import fiuba.algo3.tp2.vista.eventos.ClickSobreCarta;
import fiuba.algo3.tp2.vista.eventos.ClickSobreEspacioCartaCampo;
import fiuba.algo3.tp2.vista.eventos.ClickSobreEspacioMagicaTrampa;
import fiuba.algo3.tp2.vista.eventos.ClickSobreEspacioMonstruo;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ContenedorPrincipal extends BorderPane {
	private BarraDeMenu barraMenu;
    private Juego juego;
    private Stage stage;
    private Scene siguienteEscena;
    private Consola consola;
    public static HBox zonaMonstruosJugadorActivo;
    public static HBox zonaMonstruosJugadorInactivo;
    public static HBox zonaMagicaYTrampaJugadorActivo;
    public static Carta cartaSeleccionada;
    
    public ContenedorPrincipal(Stage stage, Scene siguienteEscena, Juego juego, BarraDeMenu barraMenu) {
      	
    	this.juego = juego;
        this.stage = stage;
        this.barraMenu = barraMenu;
        this.siguienteEscena = siguienteEscena;
        this.consola = new Consola();
        this.cartaSeleccionada = null;
        
        Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/fondoNegro3.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
        
        ContenedorPrincipal.zonaMonstruosJugadorActivo = new HBox();   
        ContenedorPrincipal.zonaMonstruosJugadorInactivo = new HBox();        
    	ContenedorPrincipal.zonaMagicaYTrampaJugadorActivo = new HBox();
    }
    
    public void setContenedorPrincipal() {
    	this.setContenedorCentral();
    	this.setContenedorIzquierdo();
    	this.setContenedorDerecho();
    	this.setContenedorAbajo();
    	this.setContenedorArriba();
    }

	private void setContenedorIzquierdo() {
		
		Button botonTerminarTurno = new Button("Terminar turno");
        BotonTerminarTurno terminarTurno =
            new BotonTerminarTurno(this);
        botonTerminarTurno.setOnAction(terminarTurno);
        
        VBox contenedorIzquierdo = new VBox();
        contenedorIzquierdo.getChildren().addAll(botonTerminarTurno, this.consola);
        
		this.setLeft(contenedorIzquierdo);
		
	}

	private void setContenedorArriba() {
		HBox contenedorHorizontalArriba = new HBox();
    	
    	VBox salud = new VBox();
    	Text vida = new Text("" + juego.getJugadorInactivo().darVida());
    	vida.setFill(Color.LIMEGREEN);
    	vida.setFont(Font.font("Tahoma", FontWeight.BOLD, 40));
    	Text nombreJugador = new Text(""+ juego.getJugadorInactivo().darNombre());
    	nombreJugador.setFill(Color.RED);
    	nombreJugador.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
    	salud.getChildren().addAll(vida, nombreJugador);
    	salud.setSpacing(-10);
		
    	contenedorHorizontalArriba.setSpacing(70);
    	contenedorHorizontalArriba.getChildren().addAll(juego.getJugadorInactivo().darImagen(), salud);
		
		VBox contenedorVerticalArriba = new VBox();
		contenedorVerticalArriba.getChildren().addAll(this.barraMenu, contenedorHorizontalArriba);
		
		this.setTop(contenedorVerticalArriba);
	}

	private void setContenedorAbajo() {
		HBox contenedorAbajo = new HBox();
    	
    	VBox salud = new VBox();
    	Text vida = new Text("" + juego.getJugadorActivo().darVida());
    	vida.setFill(Color.LIMEGREEN);
    	vida.setFont(Font.font("Tahoma", FontWeight.BOLD, 82));
    	Text nombreJugador = new Text(""+ juego.getJugadorActivo().darNombre());
    	nombreJugador.setFill(Color.RED);
    	nombreJugador.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
    	salud.getChildren().addAll(vida, nombreJugador);
    	salud.setSpacing(-15);
    	
    	VBox descripcionCarta = new VBox();
    	Text texto1 = new Text("Descripcion de la carta: ");
    	texto1.setFill(Color.RED);
    	texto1.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
    	Text textoDescripcion = new Text("");
    	textoDescripcion.setFill(Color.RED);
    	textoDescripcion.setFont(Font.font("Tahoma", FontWeight.BOLD, 12));
    	
    	HBox cartasEnManoJugadorActivo = new HBox();    	
    	for (Carta carta: juego.getJugadorActivo().darCartasDeLaMano()) {
    		ImageView unaImagenCarta = new ImageView("file:" + 
    	            "src/fiuba/algo3/tp2/vista/imagenes/cartas/" +
    				carta.getNombre()
    	            + ".jpg");
    		unaImagenCarta.setOnMouseClicked(new ClickSobreCarta(textoDescripcion, carta, consola));
    		cartasEnManoJugadorActivo.getChildren().add(unaImagenCarta);
    	}
    	
    	cartasEnManoJugadorActivo.setAlignment(Pos.TOP_LEFT);
    	descripcionCarta.getChildren().addAll(texto1,textoDescripcion);
    	contenedorAbajo.setSpacing(70);
    	contenedorAbajo.getChildren().addAll(cartasEnManoJugadorActivo, descripcionCarta, salud, juego.getJugadorActivo().darImagen());
    	contenedorAbajo.setAlignment(Pos.TOP_RIGHT);
		this.setBottom(contenedorAbajo);
	}

	private void setContenedorDerecho() {
		ImageView mazo = espacioMazo();
    	ImageView cementerio = espacioCartaCementerio();
    	ImageView cartaCampo = espacioCartaCampo();
    	
    	VBox mazoCementerioYCampoJugadorActivo = new VBox();	
    	mazoCementerioYCampoJugadorActivo.getChildren().addAll(cartaCampo, cementerio, mazo);
    	mazoCementerioYCampoJugadorActivo.setSpacing(10);
    	mazoCementerioYCampoJugadorActivo.setPadding(new Insets(70));
    	mazoCementerioYCampoJugadorActivo.setAlignment(Pos.BOTTOM_CENTER);
    	this.setRight(mazoCementerioYCampoJugadorActivo);
	}
	
	private ImageView espacioMazo() {
    	ImageView imagenCarta = new ImageView("file:src/fiuba/algo3/tp2/vista/imagenes/cartas/bocaAbajo.jpg");
    	return imagenCarta;
    }
    
    private ImageView espacioCartaCampo() {
    	ImageView imagenCarta = new ImageView("file:src/fiuba/algo3/tp2/vista/imagenes/cartas/espacioCartaCampo.jpg");
    	imagenCarta.setOnMouseClicked(new ClickSobreEspacioCartaCampo(imagenCarta));
    	return imagenCarta;
    }
    
    private ImageView espacioCartaCementerio() {
    	ImageView imagenCarta = new ImageView("file:src/fiuba/algo3/tp2/vista/imagenes/cartas/espacioCementerio.jpg");
	   	return imagenCarta;
    }

	private void setContenedorCentral() {
		ContenedorPrincipal.zonaMonstruosJugadorActivo = this.setZonaMonstruos(juego.getJugadorActivo());
		ContenedorPrincipal.zonaMonstruosJugadorActivo.setSpacing(100);
        ContenedorPrincipal.zonaMonstruosJugadorActivo.setAlignment(Pos.CENTER);
        
		ContenedorPrincipal.zonaMonstruosJugadorInactivo = this.setZonaMonstruos(juego.getJugadorInactivo());
        ContenedorPrincipal.zonaMonstruosJugadorInactivo.setSpacing(100);
        ContenedorPrincipal.zonaMonstruosJugadorInactivo.setAlignment(Pos.CENTER);
        
		this.setZonaMagicaYTrampaJugadorActivo();
        ContenedorPrincipal.zonaMagicaYTrampaJugadorActivo.setSpacing(100);
        ContenedorPrincipal.zonaMagicaYTrampaJugadorActivo.setAlignment(Pos.CENTER);
		
        HBox contenedorSeparador = new HBox();
    	ImageView imagenSeparador = new ImageView("file:src/fiuba/algo3/tp2/vista/imagenes/logo.png");
    	imagenSeparador.setFitHeight(80);
    	imagenSeparador.setFitWidth(240);
    	contenedorSeparador.getChildren().add(imagenSeparador);
    	contenedorSeparador.setSpacing(200);
    	contenedorSeparador.setAlignment(Pos.CENTER);
        
		VBox tablero = new VBox();
    	tablero.setAlignment(Pos.CENTER);
    	tablero.getChildren().addAll(ContenedorPrincipal.zonaMonstruosJugadorInactivo, contenedorSeparador, ContenedorPrincipal.zonaMonstruosJugadorActivo, ContenedorPrincipal.zonaMagicaYTrampaJugadorActivo);
    	
        Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/fondoNegro3.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        tablero.setBackground(new Background(imagenDeFondo));
    	this.setCenter(tablero);
	}

	private void setZonaMagicaYTrampaJugadorActivo() {
		for (Magica unaMagica: juego.getJugadorActivo().getMagicas()) {
			ImageView unaImagenMagica = new ImageView("file:" + 
		            "src/fiuba/algo3/tp2/vista/imagenes/cartas/" +
		            unaMagica.getNombre()
		            + ".jpg");
			unaImagenMagica.setOnMouseClicked(new ClickSobreCartaMagicaTrampa());
			ContenedorPrincipal.zonaMagicaYTrampaJugadorActivo.getChildren().add(unaImagenMagica);
		}
		for (Trampa unaTrampa: juego.getJugadorActivo().getTrampas()) {
			ImageView unaImagenTrampa = new ImageView("file:" + 
		            "src/fiuba/algo3/tp2/vista/imagenes/cartas/" +
		            unaTrampa.getNombre()
		            + ".jpg");
			unaImagenTrampa.setOnMouseClicked(new ClickSobreCartaMagicaTrampa());
			ContenedorPrincipal.zonaMagicaYTrampaJugadorActivo.getChildren().add(unaImagenTrampa);
		}
		int cantidadDeMagicasYTrampas = ContenedorPrincipal.zonaMagicaYTrampaJugadorActivo.getChildren().size();
		if (cantidadDeMagicasYTrampas < 5) {
			for (int i = 0; i < 5 - cantidadDeMagicasYTrampas; i++) {
				ContenedorPrincipal.zonaMagicaYTrampaJugadorActivo.getChildren().add(this.espacioCartaMagicaTrampa());
			}
		}
	}
	
	private ImageView espacioCartaMagicaTrampa() {
    	ImageView imagenCarta = new ImageView("file:src/fiuba/algo3/tp2/vista/imagenes/cartas/espacioMagicaTrampa.jpg");
    	imagenCarta.setOnMouseClicked(new ClickSobreEspacioMagicaTrampa(imagenCarta));
    	return imagenCarta;
    }

	private HBox setZonaMonstruos(Jugador unJugador) {
		HBox unaZonaMonstruos = new HBox();
		for (Monstruo unMonstruo: unJugador.getMonstruos()) {
			ImageView unaImagenMonstruo = new ImageView("file:" + 
		            "src/fiuba/algo3/tp2/vista/imagenes/cartas/" +
					unMonstruo.getNombre()
		            + ".jpg");
			unaImagenMonstruo.setOnMouseClicked(new ClickSobreCartaMonstruo());
			unaZonaMonstruos.getChildren().add(unaImagenMonstruo);
		}
		int cantidadDeMonstruos = unaZonaMonstruos.getChildren().size();
		if (cantidadDeMonstruos < 5) {
			for (int i = 0; i < 5 - cantidadDeMonstruos; i++) {
				unaZonaMonstruos.getChildren().add(this.espacioCartaMonstruo());
			}
		}
		return unaZonaMonstruos;
	}
	
	private ImageView espacioCartaMonstruo() {
    	ImageView imagenCarta = new ImageView("file:src/fiuba/algo3/tp2/vista/imagenes/cartas/espacioMonstruo.jpg");
    	imagenCarta.setOnMouseClicked(new ClickSobreEspacioMonstruo(imagenCarta));
    	return imagenCarta;
    }

	public void terminarTurno() {
		this.juego.terminarTurno();
		this.juego.siguienteTurno();
	}

}
