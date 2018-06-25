package fiuba.algo3.tp2;

public class Juego {
	private boolean hayGanador;
    
	public Juego() {
		this.hayGanador = false;
		
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		LadoDelCampo lado1 = new LadoDelCampo();
		LadoDelCampo lado2 = new LadoDelCampo();
		lado1.setOtroLado(lado2);
		lado2.setOtroLado(lado1);
		
		lado1.setJugador(jugador1);
		lado2.setJugador(jugador2);
		
		jugador1.setLado(lado1);
		jugador2.setLado(lado2);
		
		
		ManejadorTurnos manejadorTurnos = new ManejadorTurnos(jugador1,jugador2);
		manejadorTurnos.jugar();
			
		
		
	}
	
	
	
	
}
