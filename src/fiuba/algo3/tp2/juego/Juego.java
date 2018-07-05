package fiuba.algo3.tp2.juego;

import java.util.ArrayList;

public class Juego implements ObservadorDeJugador {
    
    private EstadoDeJuego estado;
    
    public Juego() {
    	this.estado = new EnJuego(this.inicializarJugadores());
	}
    
    private ArrayList<Jugador> inicializarJugadores() {
    	Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		jugador1.aniadirObservador(this);
		jugador2.aniadirObservador(this);
		
		LadoDelCampo lado1 = new LadoDelCampo();
		LadoDelCampo lado2 = new LadoDelCampo();
		lado1.setOtroLado(lado2);
		lado2.setOtroLado(lado1);
		
		lado1.setJugador(jugador1);
		lado2.setJugador(jugador2);
		
		jugador1.setLado(lado1);
		jugador2.setLado(lado2);
		
		jugador1.agregarCartasALaMano();
		jugador2.agregarCartasALaMano();
		
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador1);
		jugadores.add(jugador2);
		
		return jugadores;
    }
    
    public String darNombreGanador( ) {
    	return this.estado.darNombreGanador();
    }
    
    public String darMotivoGanador() {
    	return this.estado.darMotivoGanador();
    }
    
    public boolean hayGanador() {
    	return this.estado.hayGanador();
    }
    
    public Jugador siguienteTurno() {    	
    	return this.estado.siguienteTurno();
    }
    
    public void terminarTurno() {
		this.estado.terminarTurno();
	}
    
    public Jugador getJugadorActivo() {
    	return estado.getJugadorActivo();
    }

    public Jugador getJugadorInactivo() {
    	return estado.getJugadorInactivo();
    }

	@Override
	public void actualizar(Jugador jugador, String motivo) {
		this.estado = new PartidaTerminada(jugador, motivo);
	}    
}
