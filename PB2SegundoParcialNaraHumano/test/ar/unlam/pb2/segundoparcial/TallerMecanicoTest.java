package ar.unlam.pb2.segundoparcial;

import org.junit.Assert;
import org.junit.Test;
import java.util.Calendar;
import java.util.HashSet;

public class TallerMecanicoTest {

	@Test
	public void queClienteSeCreeYSeAñadaAListaTaller() throws NoHayClientesException {

		Cliente cliente = new Cliente("Gonzalez Gaston", 1113587412);
		TallerMecanico nuevoTaller = new TallerMecanico();
		
		Assert.assertNotNull(nuevoTaller.atenderCliente(cliente));
		
	}
	
	@Test
	public void queClienteSeCreeYTallerAtiendeUnCLiente() throws NoHayClientesException{
		
		Cliente cliente = new Cliente("Gonzalez Gaston", 1113587412);
		TallerMecanico nuevoTaller = new TallerMecanico();
		
		nuevoTaller.atenderCliente(cliente);
		Cliente ve = cliente;
		Cliente vo = nuevoTaller.obtenerPrimerCliente();
		Assert.assertEquals(ve, vo);
		
	}
	
	@Test (expected = NoHayClientesException.class)
	public void queClienteSeCreeYLanzaLaExcepcionDeNoHayClientes() throws NoHayClientesException{
		
		TallerMecanico nuevoTaller = new TallerMecanico();
		
		nuevoTaller.atenderCliente(null);
		
	}
	
	@Test
	public void queClienteSeCreeYObtenerTiempoDeEsperaMedio() throws NoHayClientesException{
		Calendar calendar = Calendar.getInstance();
		Cliente cliente = new Cliente("Gonzalez Gaston", 1113587412);
		Cliente cliente2 = new Cliente("Perez Gaston", 1113587413);
		
		TallerMecanico nuevoTaller = new TallerMecanico();
		nuevoTaller.atenderCliente(cliente);
		nuevoTaller.aniadirNoAtendidos(cliente2);
		Double ve = 0.0;
		Double vo = nuevoTaller.obtenerTiempoEsperaMedioNoAtendidos();

	}
	
	@Test
	public void queClienteSeCreeYseObtieneCantidadClientesEnEspera() throws NoHayClientesException{
		Cliente cliente = new Cliente("Gonzalez Gaston", 1113587412);
		TallerMecanico nuevoTaller = new TallerMecanico();
		
		nuevoTaller.aniadirEnEspera(cliente);
	
		Integer ve = 1;
		Integer vo = nuevoTaller.obtenerClientesEnEspera();
		Assert.assertEquals(ve, vo);
		
	}
	
	@Test
	public void queClienteSeCreeYObtenerClientesAtendidos() throws NoHayClientesException{
		Cliente cliente = new Cliente("Gonzalez Gaston", 1113587412);
		TallerMecanico nuevoTaller = new TallerMecanico();
		
		nuevoTaller.atenderCliente(cliente);
		Integer ve = 1;
		Integer vo = nuevoTaller.obtenerCantidadClientesAtendidos();
		Assert.assertEquals(ve, vo);
		
	}
}
