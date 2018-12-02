package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contrato;
import model.entities.Prestacao;

public class ServicoContrato {

	private PagamentoOnline pagamentoOnline;
	
	public ServicoContrato(PagamentoOnline pagamentoOnline) {
		this.pagamentoOnline = pagamentoOnline;
	}


	public PagamentoOnline getPagamentoOnline() {
		return pagamentoOnline;
	}


	public void setPagamentoOnline(PagamentoOnline pagamentoOnline) {
		this.pagamentoOnline = pagamentoOnline;
	}

	public void processoParcela(Contrato contrato, Integer prestacao) {
		
		double montante = contrato.getValorTotal()/prestacao;
		
		for(int i=1; i<=prestacao; i++) {
			Date mesParcela  = adicionarMes(contrato.getData(), i);
			double valorPrestacao = montante + pagamentoOnline.juros(montante, i);
			double valorTotalPrestacao = valorPrestacao + pagamentoOnline.taxaOnline(valorPrestacao);
			
			contrato.addPrestacao(new Prestacao(mesParcela, valorTotalPrestacao));
		}
		
	}
	
	public Date adicionarMes(Date data, int mes) {
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(data);
		calendario.add(calendario.MONTH, mes);
		return calendario.getTime();
		
	}
	
}
