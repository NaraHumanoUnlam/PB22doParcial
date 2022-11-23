package ar.unlam.pb2.segundoparcial;


import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class TallerMecanico {
	private final Integer MILISEGUNDOS = 60000;
	private Set<Cliente> clientesEnEspera = new LinkedHashSet<Cliente>();
	private LinkedHashSet<Cliente> clientesAtendidos = new LinkedHashSet<Cliente>();
	private Set<Cliente> clientesNoAtendidos = new LinkedHashSet<Cliente>();
	private Long tiempoEspera;
	
	public Cliente atenderCliente(Cliente cliente) throws NoHayClientesException {
		Reloj horaLleagada = new Reloj();
		if(cliente != null) {
			this.clientesAtendidos.add(cliente);
			cliente.setTiempoSalida(horaLleagada.ahora()/MILISEGUNDOS);
			this.tiempoEspera = cliente.getTiempoEntrada() - cliente.getTiempoSalida();
			
		}else {
			throw new NoHayClientesException("No hay Clientes para atender");
		}
		
		return  cliente;
	}

	public HashSet<Cliente> getClientesAtendidos() {
		
		return this.clientesAtendidos;
	}

	public void aniadirNoAtendidos(Cliente cliente2) {
		
		this.clientesNoAtendidos.add(cliente2);
		
	}

	public Double obtenerTiempoEsperaMedioNoAtendidos() {
		Double tiempo = 0.0;
		if(clientesEnEspera.size()>0) {
			tiempo = (double) (this.tiempoEspera/clientesEnEspera.size());
		}
		return tiempo;
	}
	
	public Cliente obtenerPrimerCliente() {
		Cliente cliente = null;
		
		for (Cliente val : this.clientesAtendidos) {
            cliente = val;
            break;
        }
		
		return cliente;
	}

	public void aniadirEnEspera(Cliente cliente) {
		this.clientesEnEspera.add(cliente);
		
	}

	public Integer obtenerClientesEnEspera() {
		
		return this.clientesEnEspera.size();
	}

	public Integer obtenerCantidadClientesAtendidos() {
		
		return this.clientesAtendidos.size();
	}

}
