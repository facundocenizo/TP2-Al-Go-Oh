package fiuba.algo3.tp2.vista.eventos;

import fiuba.algo3.tp2.cartas.Carta;
import fiuba.algo3.tp2.vista.Consola;
import fiuba.algo3.tp2.vista.ContenedorPrincipal;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class ClickSobreCarta
    implements EventHandler<MouseEvent>
{
    private Carta carta;
    private Text texto;
    private Consola consola;
    
	public ClickSobreCarta(Text texto, Carta carta, Consola consola) {
		   this.carta = carta;
		   this.texto = texto;
		   this.consola = consola;
		   
	}

	@Override
	public void handle(MouseEvent arg0) {
		this.texto.setText(this.carta.getDescripcion());
		this.consola.setText("Seleccionaste: \n" + carta.getNombre() + "\nahora selecciona un lugar \nen el campo..");

		ContenedorPrincipal.cartaSeleccionada = carta;
	}
}