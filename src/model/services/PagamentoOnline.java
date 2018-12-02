package model.services;

public interface PagamentoOnline {

	double juros(double montante, Integer mes);
	double taxaOnline(double montante);
	
}
