package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.cartas.Carta;
import fiuba.algo3.tp2.cartas.CartaCampo;
import fiuba.algo3.tp2.cartas.Magica;
import fiuba.algo3.tp2.cartas.Monstruo;
import fiuba.algo3.tp2.cartas.Trampa;
import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.vista.eventos.BotonTerminarTurno;
import fiuba.algo3.tp2.vista.eventos.ClickSobreCartaDeLaMano;
import fiuba.algo3.tp2.vista.eventos.ClickSobreCartaCampo;
import fiuba.algo3.tp2.vista.eventos.ClickSobreCartaMagica;
import fiuba.algo3.tp2.vista.eventos.ClickSobreCartaMonstruo;
import fiuba.algo3.tp2.vista.eventos.ClickSobreCartaMonstruoJugadorInactivo;
import fiuba.algo3.tp2.vista.eventos.ClickSobreCartaTrampa;
import fiuba.algo3.tp2.vista.eventos.ClickSobreEspacioCartaCampo;
import fiuba.algo3.tp2.vista.eventos.ClickSobreEspacioMagicaTrampa;
import fiuba.algo3.tp2.vista.eventos.ClickSobreEspacioMonstruo;
import fiuba.algo3.tp2.vista.eventos.ClickSobreEspacioMonstruoJugadorInactivo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

public class ContenedorPrincipal extends BorderPane {
	private BarraDeMenu barraMenu;
    public static Juego juego;
    private Stage stage;
    private Scene siguienteEscena;
    public static Consola consola;
    public static HBox zonaMonstruosJugadorActivo;
    public static HBox zonaMonstruosJugadorInactivo;
    public static HBox zonaMagicaYTrampaJugadorActivo;
    public static HBox cartasEnManoJugadorActivo;
    public static VBox mazoCementerioYCampoJugadorActivo;
    public static Carta cartaSeleccionada;
    public static VBox contenedorIzquierdo;
    
    public ContenedorPrincipal(Stage stage, Scene siguienteEscena, Juego juego, BarraDeMenu barraMenu) {
    	ContenedorPrincipal.juego = juego;
        this.stage = stage;
        this.barraMenu = barraMenu;
        this.siguienteEscena = siguienteEscena;
        ContenedorPrincipal.consola = new Consola();
        ContenedorPrincipal.cartaSeleccionada = null;
        
        ContenedorPrincipal.zonaMonstruosJugadorActivo = new HBox();
        ContenedorPrincipal.zonaMonstruosJugadorInactivo = new HBox();
        ContenedorPrincipal.zonaMagicaYTrampaJugadorActivo = new HBox();
        ContenedorPrincipal.cartasEnManoJugadorActivo = new HBox();
        ContenedorPrincipal.mazoCementerioYCampoJugadorActivo = new VBox();
        ContenedorPrincipal.contenedorIzquierdo = new VBox();
        
        Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/fondoNegro3.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
    }
    
    public void setContenedorPrincipal() {
    	ContenedorPrincipal.consola.limpiar();
    	this.setContenedorCentral();
    	this.setContenedorIzquierdo();
    	this.setContenedorDerecho();
    	this.setContenedorAbajo();
    	this.setContenedorArriba();
    }

	public void setContenedorIzquierdo() {
		Button botonTerminarTurno = new Button("TERMINAR TURNO");
        BotonTerminarTurno terminarTurno =
            new BotonTerminarTurno(this);
        botonTerminarTurno.setOnAction(terminarTurno);
        botonTerminarTurno.setMinSize(200, 60);
        botonTerminarTurno.setFont(Font.font("Courier New",FontWeight.BOLD, 20));
        
        VBox contenedorIzquierdo = new VBox();
        contenedorIzquierdo.getChildren().addAll(ContenedorPrincipal.consola, botonTerminarTurno);
        contenedorIzquierdo.setSpacing(10);
        
        ContenedorPrincipal.contenedorIzquierdo = contenedorIzquierdo;
        this.setLeft(ContenedorPrincipal.contenedorIzquierdo);
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
    	ImageView imagenJugadorInactivo = juego.getJugadorInactivo().darImagen();
    	imagenJugadorInactivo.setFitHeight(50);
    	imagenJugadorInactivo.setFitWidth(170);
    	contenedorHorizontalArriba.getChildren().addAll(imagenJugadorInactivo, salud);
		
		VBox contenedorVerticalArriba = new VBox();
		contenedorVerticalArriba.getChildren().addAll(this.barraMenu, contenedorHorizontalArriba);
		
		this.setTop(contenedorVerticalArriba);
	}

	public void setContenedorAbajo() {
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
    		unaImagenCarta.setOnMouseClicked(new ClickSobreCartaDeLaMano(textoDescripcion, carta, this));
    		cartasEnManoJugadorActivo.getChildren().add(unaImagenCarta);
    	}
    	
    	cartasEnManoJugadorActivo.setAlignment(Pos.TOP_LEFT);
    	ContenedorPrincipal.cartasEnManoJugadorActivo = cartasEnManoJugadorActivo;
    	descripcionCarta.getChildren().addAll(texto1,textoDescripcion);
    	contenedorAbajo.setSpacing(70);
    	ScrollPane scrollCartas = new ScrollPane();
    	scrollCartas.setContent(ContenedorPrincipal.cartasEnManoJugadorActivo);
    	scrollCartas.setMaxSize(440,135);
    	scrollCartas.setMinSize(0,135);
    	scrollCartas.setHvalue(1);
    	
    	ImageView imagenJugadorActivo = juego.getJugadorActivo().darImagen();
    	imagenJugadorActivo.setFitHeight(120);
    	imagenJugadorActivo.setFitWidth(170);
    	contenedorAbajo.getChildren().addAll(scrollCartas, descripcionCarta, salud, imagenJugadorActivo);
    	contenedorAbajo.setAlignment(Pos.TOP_RIGHT);
		this.setBottom(contenedorAbajo);
	}

	public void setContenedorDerecho() {
		ImageView mazo = espacioMazo();
    	ImageView cementerio = espacioCartaCementerio();
    	ImageView cartaCampo = espacioCartaCampo();
    	
    	VBox mazoCementerioYCampoJugadorActivo = new VBox();	
    	mazoCementerioYCampoJugadorActivo.getChildren().addAll(cartaCampo, cementerio, mazo);
    	mazoCementerioYCampoJugadorActivo.setSpacing(10);
    	mazoCementerioYCampoJugadorActivo.setPadding(new Insets(70));
    	mazoCementerioYCampoJugadorActivo.setAlignment(Pos.BOTTOM_CENTER);
    	
    	ContenedorPrincipal.mazoCementerioYCampoJugadorActivo = mazoCementerioYCampoJugadorActivo;
    	this.setRight(mazoCementerioYCampoJugadorActivo);
	}
	
	private ImageView espacioMazo() {
    	ImageView imagenCarta = new ImageView("file:src/fiuba/algo3/tp2/vista/imagenes/cartas/mazo.jpg");
    	return imagenCarta;
    }
    
    private ImageView espacioCartaCampo() {
    	ImageView imagenCartaCampo = new ImageView("file:src/fiuba/algo3/tp2/vista/imagenes/cartas/espacioCartaCampo.jpg");
    	imagenCartaCampo.setOnMouseClicked(new ClickSobreEspacioCartaCampo(ContenedorPrincipal.juego.getJugadorActivo(), imagenCartaCampo, this));	
    	for (CartaCampo unaCartaCampo: juego.getJugadorActivo().getCartaCampo()) {
    		imagenCartaCampo = new ImageView("file:" + "src/fiuba/algo3/tp2/vista/imagenes/cartas/" 
    						+ unaCartaCampo.getNombre()
    						+ ".jpg");
    		imagenCartaCampo.setOnMouseClicked(new ClickSobreCartaCampo(ContenedorPrincipal.juego.getJugadorActivo(), imagenCartaCampo, this, unaCartaCampo));
    	}
    	return imagenCartaCampo;
    }
    
    private ImageView espacioCartaCementerio() {
    	ImageView imagenCarta = new ImageView("file:src/fiuba/algo3/tp2/vista/imagenes/cartas/cementerio.jpg");
	   	return imagenCarta;
    }
    
    public void actualizarContenedorCentralZonaMonstruosJugadorInactivo(HBox zonaMonstruosJugadorInactivo) {
        zonaMonstruosJugadorInactivo.setSpacing(100);
        zonaMonstruosJugadorInactivo.setAlignment(Pos.CENTER);
    	
    	HBox contenedorSeparador = new HBox();
    	ImageView imagenSeparador = new ImageView("file:src/fiuba/algo3/tp2/vista/imagenes/logo.png");
    	imagenSeparador.setFitHeight(80);
    	imagenSeparador.setFitWidth(240);
    	contenedorSeparador.getChildren().add(imagenSeparador);
    	contenedorSeparador.setSpacing(200);
    	contenedorSeparador.setAlignment(Pos.CENTER);
        
		VBox tablero = new VBox();
    	tablero.setAlignment(Pos.CENTER);
    	tablero.getChildren().addAll(zonaMonstruosJugadorInactivo, contenedorSeparador, ContenedorPrincipal.zonaMonstruosJugadorActivo, ContenedorPrincipal.zonaMagicaYTrampaJugadorActivo);
    	
        Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/fondoNegro3.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        tablero.setBackground(new Background(imagenDeFondo));
        this.setCenter(tablero);
    }
    public void actualizarContenedorCentralZonaMonstruosJugadorActivo(HBox zonaMonstruosJugadorActivo) {
        zonaMonstruosJugadorActivo.setSpacing(100);
        zonaMonstruosJugadorActivo.setAlignment(Pos.CENTER);
    	
    	HBox contenedorSeparador = new HBox();
    	ImageView imagenSeparador = new ImageView("file:src/fiuba/algo3/tp2/vista/imagenes/logo.png");
    	imagenSeparador.setFitHeight(80);
    	imagenSeparador.setFitWidth(240);
    	contenedorSeparador.getChildren().add(imagenSeparador);
    	contenedorSeparador.setSpacing(200);
    	contenedorSeparador.setAlignment(Pos.CENTER);
        
		VBox tablero = new VBox();
    	tablero.setAlignment(Pos.CENTER);
    	tablero.getChildren().addAll(ContenedorPrincipal.zonaMonstruosJugadorInactivo, contenedorSeparador,zonaMonstruosJugadorActivo, ContenedorPrincipal.zonaMagicaYTrampaJugadorActivo);
    	
        Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/fondoNegro3.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        tablero.setBackground(new Background(imagenDeFondo));
        this.setCenter(tablero);
    }

	public void setContenedorCentral() {
		ContenedorPrincipal.zonaMonstruosJugadorActivo = this.setZonaMonstruosJugadorActivo();
		ContenedorPrincipal.zonaMonstruosJugadorActivo.setSpacing(100);
        ContenedorPrincipal.zonaMonstruosJugadorActivo.setAlignment(Pos.CENTER);
        
		ContenedorPrincipal.zonaMonstruosJugadorInactivo = this.setZonaMonstruosJugadorInactivo();
        ContenedorPrincipal.zonaMonstruosJugadorInactivo.setSpacing(100);
        ContenedorPrincipal.zonaMonstruosJugadorInactivo.setAlignment(Pos.CENTER);
        
		ContenedorPrincipal.zonaMagicaYTrampaJugadorActivo = this.setZonaMagicaYTrampaJugadorActivo();
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

	private HBox setZonaMagicaYTrampaJugadorActivo() {
		HBox zonaMagicaYTrampaJugadorActivo = new HBox();
		for (Magica unaMagica: juego.getJugadorActivo().getMagicas()) {
			ImageView unaImagenMagica = new ImageView("file:" + 
		            "src/fiuba/algo3/tp2/vista/imagenes/cartas/" +
		            unaMagica.getNombre()
		            + ".jpg");
			unaImagenMagica.setOnMouseClicked(new ClickSobreCartaMagica(this, unaMagica));
			zonaMagicaYTrampaJugadorActivo.getChildren().add(unaImagenMagica);
		}
		for (Trampa unaTrampa: juego.getJugadorActivo().getTrampas()) {
			ImageView unaImagenTrampa = new ImageView("file:" + 
		            "src/fiuba/algo3/tp2/vista/imagenes/cartas/" +
		            unaTrampa.getNombre()
		            + ".jpg");
			unaImagenTrampa.setOnMouseClicked(new ClickSobreCartaTrampa(unaTrampa, this));
			zonaMagicaYTrampaJugadorActivo.getChildren().add(unaImagenTrampa);
		}
		int cantidadDeMagicasYTrampas = zonaMagicaYTrampaJugadorActivo.getChildren().size();
		if (cantidadDeMagicasYTrampas < 5) {
			for (int i = 0; i < 5 - cantidadDeMagicasYTrampas; i++) {
				zonaMagicaYTrampaJugadorActivo.getChildren().add(this.espacioCartaMagicaTrampa());
			}
		}
		return zonaMagicaYTrampaJugadorActivo;
	}
	
	private ImageView espacioCartaMagicaTrampa() {
    	ImageView imagenCarta = new ImageView("file:src/fiuba/algo3/tp2/vista/imagenes/cartas/espacioMagicaTrampa.jpg");
    	imagenCarta.setOnMouseClicked(new ClickSobreEspacioMagicaTrampa(juego.getJugadorActivo(), imagenCarta, this));
    	return imagenCarta;
    }

	public ImageView espacioCartaMonstruoJugadorActivo() {
    	ImageView imagenCarta = new ImageView("file:src/fiuba/algo3/tp2/vista/imagenes/cartas/espacioMonstruo.jpg");
    	imagenCarta.setOnMouseClicked(new ClickSobreEspacioMonstruo(juego.getJugadorActivo(), imagenCarta, this));
    	return imagenCarta;
    }
	
	private HBox setZonaMonstruosJugadorActivo() {
		HBox zonaMonstruosJugadorActivo = new HBox(); 
		for (Monstruo unMonstruo: ContenedorPrincipal.juego.getJugadorActivo().getMonstruos()) {
			ImageView unaImagenMonstruo = new ImageView("file:" + 
		            "src/fiuba/algo3/tp2/vista/imagenes/cartas/" +
					unMonstruo.getNombre()
		            + ".jpg");
			Image imagenCarta;
			if(unMonstruo.estaBocaAbajo()) {
				imagenCarta = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/cartas/bocaAbajo.jpg");
				unaImagenMonstruo.setImage(imagenCarta);
			}
			else {
				imagenCarta = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/cartas/" + unMonstruo.getNombre() + ".jpg");
				unaImagenMonstruo.setImage(imagenCarta);		
			}
			if (unMonstruo.estaEnModoAtaque()) {
				unaImagenMonstruo.setRotate(0);
			}
			else unaImagenMonstruo.setRotate(90);
			unaImagenMonstruo.setOnMouseClicked(new ClickSobreCartaMonstruo(ContenedorPrincipal.juego.getJugadorActivo(), this, unMonstruo));
			zonaMonstruosJugadorActivo.getChildren().add(unaImagenMonstruo);
		}
		int cantidadDeMonstruos = zonaMonstruosJugadorActivo.getChildren().size();
		if (cantidadDeMonstruos < 5) {
			for (int i = 0; i < 5 - cantidadDeMonstruos; i++) {
				zonaMonstruosJugadorActivo.getChildren().add(this.espacioCartaMonstruoJugadorActivo());
			}
		}
		return zonaMonstruosJugadorActivo;
	}
	
	public static ImageView espacioCartaMonstruoJugadorInactivo() {
    	ImageView imagenCarta = new ImageView("file:src/fiuba/algo3/tp2/vista/imagenes/cartas/espacioMonstruo.jpg");
    	imagenCarta.setOnMouseClicked(new ClickSobreEspacioMonstruoJugadorInactivo());
    	return imagenCarta;
    }
	
	private HBox setZonaMonstruosJugadorInactivo() {
		HBox zonaMonstruosJugadorInactivo = new HBox(); 
		for (Monstruo unMonstruo: ContenedorPrincipal.juego.getJugadorInactivo().getMonstruos()) {
			ImageView unaImagenMonstruo = new ImageView("file:" + 
		            "src/fiuba/algo3/tp2/vista/imagenes/cartas/" + unMonstruo.getNombre() + ".jpg");
			Image imagenCarta;
			if(unMonstruo.estaBocaAbajo()) {
				imagenCarta = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/cartas/bocaAbajo.jpg");
				unaImagenMonstruo.setImage(imagenCarta);
			}
			else {
				imagenCarta = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/cartas/" + unMonstruo.getNombre() + ".jpg");
				unaImagenMonstruo.setImage(imagenCarta);
			}
			if (unMonstruo.estaEnModoAtaque()) {
				unaImagenMonstruo.setRotate(0);
			}
			else unaImagenMonstruo.setRotate(90);
			unaImagenMonstruo.setOnMouseClicked(new ClickSobreCartaMonstruoJugadorInactivo(unMonstruo));
			zonaMonstruosJugadorInactivo.getChildren().add(unaImagenMonstruo);
		}
		int cantidadDeMonstruos = zonaMonstruosJugadorInactivo.getChildren().size();
		if (cantidadDeMonstruos < 5) {
			for (int i = 0; i < 5 - cantidadDeMonstruos; i++) {
				zonaMonstruosJugadorInactivo.getChildren().add(ContenedorPrincipal.espacioCartaMonstruoJugadorInactivo());
			}
		}
		return zonaMonstruosJugadorInactivo;
	}

	public void terminarTurno() {
		ContenedorPrincipal.juego.terminarTurno();
		ContenedorPrincipal.juego.siguienteTurno();
		if (ContenedorPrincipal.juego.hayGanador()) {
			ContenedorVictoria.recibirGanador(juego.darNombreGanador(), juego.darMotivoGanador());
			stage.setScene(siguienteEscena);
            stage.setFullScreenExitHint("");
            stage.setFullScreen(true);
		}
		else this.setContenedorPrincipal();
	}

}
