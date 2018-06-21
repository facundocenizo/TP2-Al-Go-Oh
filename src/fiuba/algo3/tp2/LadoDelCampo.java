package fiuba.algo3.tp2;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.tp2.excepciones.ZonaDeTrampaYMagicasLlenaException;
import fiuba.algo3.tp2.excepciones.ZonaMonstruosLlenaException;

public class LadoDelCampo {
	
	private LadoDelCampo otroLado;
	private Cementerio cementerio;
	private MazoCartas mazoCartas;
	private List<Monstruo> zonaMonstruos;
	private List<Trampa> cartasTrampa;
	private List<Magica> cartasMagicas;
	
	public LadoDelCampo(LadoDelCampo otroLado) {
		this.otroLado = otroLado;
		this.cementerio = new Cementerio();
		this.mazoCartas = new MazoCartas();
		this.zonaMonstruos = new ArrayList<Monstruo>();
		this.cartasTrampa = new ArrayList<Trampa>();
		this.cartasMagicas = new ArrayList<Magica>();
	}
	
	public Carta sacarCarta() {
		return mazoCartas.sacarCarta();
	}
	
	public void colocarMonstruo(Monstruo monstruo) {
		if (zonaMonstruos.size()>4) {
			throw new ZonaMonstruosLlenaException();
		}
		zonaMonstruos.add(monstruo);
	}
	
	public void colocarTrampa(Trampa trampa) {
		if (cartasTrampa.size()+cartasMagicas.size()>4) {
			throw new ZonaDeTrampaYMagicasLlenaException();
		}
		cartasTrampa.add(trampa);
	}
	
	public void colocarMagica(Magica magica) {
		if (cartasTrampa.size()+cartasMagicas.size()>4) {
			throw new ZonaDeTrampaYMagicasLlenaException();
		}
		cartasMagicas.add(magica);
	}
	
	public void matarATodosLosMonstruos() {
		for (Monstruo monstruo: zonaMonstruos) {
			monstruo.morir();
		}
	}
	
	public void llevarMonstruosMuertosAlCementerio() {
		for (Monstruo monstruo: zonaMonstruos) {
			if (monstruo.estaMuerta()) {
				cementerio.agregarCarta(monstruo);
				zonaMonstruos.remove(monstruo);
			}
		}
	}
	
	

}
