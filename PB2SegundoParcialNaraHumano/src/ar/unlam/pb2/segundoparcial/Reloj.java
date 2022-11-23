package ar.unlam.pb2.segundoparcial;

import java.util.Calendar;

public class Reloj {
	public static long ahora() {
		return Calendar.getInstance().getTimeInMillis();
	}
}
