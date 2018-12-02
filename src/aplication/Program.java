package aplication;

import model.services.PayPal;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	PayPal paypal = new PayPal();
	
	System.out.println(paypal.taxaOnline(206.00));
	System.out.println(paypal.juros(200.0, 3));
	}
}
