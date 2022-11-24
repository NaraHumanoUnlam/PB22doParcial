package ar.unlam.pb2.segundoparcial;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Objects;

public class Cliente {
	private final Integer MILISEGUNDOS = 60000;
	private String nombre;
	private Integer numeroMovil;
	private Long tiempoEntrada;
	private Long tiempoSalida;
	private Long tiempoEspera;
	
	public Cliente(String nombre, Integer numeroMovil) {
		Calendar today = Calendar.getInstance();
		this.nombre = nombre;
		this.numeroMovil = numeroMovil;
		this.tiempoEntrada = obtenerHoraEntrada();
		this.tiempoEspera = 0l;
	}

	private Long obtenerHoraEntrada() {
		Reloj horaLleagada = new Reloj();
		return  (horaLleagada.ahora() / MILISEGUNDOS);
	}

	public Long getTiempoEntrada() {
		return tiempoEntrada;
	}

	public void setTiempoEntrada(Long tiempoEntrada) {
		this.tiempoEntrada = tiempoEntrada;
	}

	public Long getTiempoSalida() {
		return tiempoSalida;
	}

	public void setTiempoSalida(Long l) {
		this.tiempoSalida = l;
	}
	

	public Long getTiempoEspera() {
		return tiempoEspera;
	}

	public void setTiempoEspera(Long tiempoEspera) {
		this.tiempoEspera = tiempoEspera;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, numeroMovil);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(nombre, other.nombre) && Objects.equals(numeroMovil, other.numeroMovil);
	}

	public void agregarTiempoEsperaMinutos(Integer i) {
		
		this.tiempoEspera += i;
		
	}
	
	
	

	
	
	
	
}
