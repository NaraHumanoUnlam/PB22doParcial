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
	private Double tiempoTotal;
	
	
	
	public TallerMecanico() {
		this.tiempoTotal = 0.0;
	}

	public Cliente atenderCliente(Cliente cliente) throws NoHayClientesException {
		Reloj horaLleagada = new Reloj();
		if(cliente != null) {
			this.clientesAtendidos.add(cliente);
			this.clientesNoAtendidos.remove(cliente);
			cliente.setTiempoSalida(horaLleagada.ahora()/MILISEGUNDOS);
			cliente.setTiempoEspera(cliente.getTiempoEntrada() - cliente.getTiempoSalida());
			agregartiempoTotal(cliente.getTiempoEspera());
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
	
	
	
	public Cliente obtenerPrimerCliente() {
		Cliente cliente = null;
		
		for (Cliente val : this.clientesAtendidos) {
            cliente = val;
            break;
        }
		
		//otro metodo: this.clientesAtendidos.stream().findFirst().get();
		
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
	
	public Double obtenerTiempoEsperaMedioNoAtendidos() {
		Double tiempo = 0.0;
		if(clientesEnEspera.size()>0) {
			agregartiempoTotal(0l);
			System.out.println(clientesEnEspera.size());
			tiempo = (double) (this.tiempoTotal/clientesEnEspera.size());
		}
		return tiempo;
	}
	
	private Double agregartiempoTotal(Long tiempoEspera) {
		for (Iterator iterator = clientesEnEspera.iterator(); iterator.hasNext();) {
			Cliente cliente = (Cliente) iterator.next();
			return this.tiempoTotal=(tiempoEspera*1.0 + cliente.getTiempoEspera());
		}
		return tiempoTotal;
	
	}

}
