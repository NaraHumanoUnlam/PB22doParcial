package ar.unlam.pb2.segundoparcial;

@SuppressWarnings("serial")
public class NoHayClientesException extends Exception{
	public NoHayClientesException(String mensaje) {
		super(mensaje);
	}

}
