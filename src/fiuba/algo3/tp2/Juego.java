package fiuba.algo3.tp2;

public class Juego {
    private Jugador jugador1;
    private Jugador jugador2;
	public Juego() {
			
		inicializarJugadores(this.jugador1,this.jugador2);
		String nombreGanador = empezarJuego(this.jugador1,this.jugador2);
		
		System.out.println("Ha ganado: " + nombreGanador);
		
	}
	
	private void inicializarJugadores(Jugador jugador1, Jugador jugador2) {
		
		jugador1 = new Jugador();
		jugador2 = new Jugador();
		
		LadoDelCampo lado1 = new LadoDelCampo();
		LadoDelCampo lado2 = new LadoDelCampo();
		lado1.setOtroLado(lado2);
		lado2.setOtroLado(lado1);
		
		lado1.setJugador(jugador1);
		lado2.setJugador(jugador2);
		
		jugador1.setLado(lado1);
		jugador2.setLado(lado2);
		
	}
	
	private String empezarJuego(Jugador jugador1, Jugador jugador2){
		ManejadorTurnos manejadorTurnos = new ManejadorTurnos(this.jugador1,this.jugador2);
		return manejadorTurnos.jugar();
	}
	
}
