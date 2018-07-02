package fiuba.algo3.tp2.vista;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Consola extends HBox{

	private Text texto;
	public Consola() {

        setMinSize(200, 200);
        setMaxSize(200, 200);
		
        this.setStyle("-fx-background-color: grey; ");
        this.texto = new Text();

        texto.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));

		this.texto.setText("                                                                                   ");
		this.getChildren().add(texto);
	}
	
	public void setText(String unTexto) {
		this.texto.setText(unTexto);
	}
}
