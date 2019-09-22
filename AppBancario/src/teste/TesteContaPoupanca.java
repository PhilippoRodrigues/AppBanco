package teste;

import negocio.ContaPoupanca;

public class TesteContaPoupanca {

	public static void main(String[] args) {

		ContaPoupanca cp1 = new ContaPoupanca("02/01/2019", 1000.00f, 15000.00f);
		
		cp1.setDepositoInicial("02/01/2019");
		cp1.setResgate(50.00f);
		cp1.setDeposito(200.00f);
		cp1.setPagamento(200.00f);
		cp1.setRealizarTransferencia(500.00f);
		cp1.setReceberTransferencia(500.00f);
		
		cp1.extrato();
		
		System.out.println();
		System.out.println();
		
	//	cp1.exibir();
	}

}
