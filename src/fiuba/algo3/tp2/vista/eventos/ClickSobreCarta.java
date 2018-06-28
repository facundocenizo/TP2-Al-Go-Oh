package fiuba.algo3.tp2.vista.eventos;

import fiuba.algo3.tp2.Carta;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class ClickSobreCarta
    implements EventHandler<MouseEvent>
{
    private Carta carta;
    private Text texto;
    
    
	public ClickSobreCarta(Text texto, Carta carta) {
		   this.carta = carta;
		   this.texto = texto;
	}

	@Override
	public void handle(MouseEvent arg0) {
		this.texto.setText(this.carta.getDescripcion());
	}
}