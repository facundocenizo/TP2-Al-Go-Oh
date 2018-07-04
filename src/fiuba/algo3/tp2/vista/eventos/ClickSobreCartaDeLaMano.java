package fiuba.algo3.tp2.vista.eventos;

import fiuba.algo3.tp2.cartas.Carta;
import fiuba.algo3.tp2.vista.ContenedorPrincipal;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class ClickSobreCartaDeLaMano
    implements EventHandler<MouseEvent>
{
    private Carta carta;
    private Text texto;
    private ContenedorPrincipal contenedorPrincipal;
    
	public ClickSobreCartaDeLaMano(Text texto, Carta carta, ContenedorPrincipal contenedorPrincipal) {
		   this.carta = carta;
		   this.texto = texto;
		   this.contenedorPrincipal = contenedorPrincipal;
	}

	@Override
	public void handle(MouseEvent arg0) {
		this.contenedorPrincipal.setContenedorIzquierdo();
		
		this.texto.setText(this.carta.getDescripcion());
		ContenedorPrincipal.consola.setText("Seleccionaste: \n" + carta.getNombre() + ".\nAhora selecciona un lugar \nen el campo \ndonde colocar la carta.");

		ContenedorPrincipal.cartaSeleccionada = carta;
	}
}