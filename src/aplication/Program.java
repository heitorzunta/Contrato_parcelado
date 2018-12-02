package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Contrato;
import model.entities.Prestacao;
import model.services.PayPal;
import model.services.ServicoContrato;

public class Program {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
	
		
		 System.out.println("Entre com os dados do contrato");
		 System.out.print("Número: ");
		 int numero = sc.nextInt();
		 System.out.print("Data (dd/MM/yyyy): ");
		 sc.nextLine();
		 Date data = sdf.parse(sc.nextLine());
		 System.out.print("Valor de contrato: ");
		 double valorTotal = sc.nextDouble();
		 System.out.println("Entre com o número de parcelas: ");
		 int prestacao = sc.nextInt();
		
		 Contrato contrato = new Contrato(numero, data, valorTotal);
		 ServicoContrato servicoDeContrato = new ServicoContrato(new PayPal());
		 servicoDeContrato.processoParcela(contrato, prestacao);
		 
		 System.out.println("Prestações: ");
		 for(Prestacao p: contrato.getPrestacoes()) {
			 System.out.println(p);
		 }
		
		sc.close();
	}		
}
