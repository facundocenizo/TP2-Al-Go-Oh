package fiuba.algo3.tp2.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Consola extends VBox{

	private Text texto;
	public Consola() {

		setAlignment(Pos.CENTER);
		
		Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/fondoNegro3.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
	
        this.texto = new Text();

        texto.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));

		this.texto.setText("                                                                                   ");
		this.getChildren().add(texto);
	}
	
	public void setText(String unTexto) {
		this.texto.setFill(Color.WHITE);
		this.texto.setText(unTexto);
	}
}
