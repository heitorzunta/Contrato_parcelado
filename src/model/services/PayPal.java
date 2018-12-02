package model.services;

public class PayPal implements PagamentoOnline {
	
	public static final double JUROS = 0.01;
	public static final double TAXA  = 0.02;
	
	public double juros(double montante, Integer mes) {
		return montante*JUROS*mes;
	}
	public double taxaOnline(double montante) {
		return montante*TAXA;
	}

}
