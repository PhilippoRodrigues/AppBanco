package teste;

import negocio.ContaCorrente;
import negocio.Documentacao;

public class TesteContaCorrente {
	
	public static void main(String[] args) {
		
		ContaCorrente cc = new ContaCorrente(5000.00f, 15000.00f);
		
		cc.setPagamento(350.00f);
		cc.setDeposito(650.00f);
		cc.setRealizarDocTed(200.00f);
		cc.setReceberDocTed(200.00f);
		cc.setRealizarTransferencia(100.00f);
		cc.setReceberTransferencia(100.00f);
		
//		System.out.printf("Valor do cheque especial: R$ %.2f%n", cc.getValorChequeEspecial());
//		System.out.printf("Valor do financiamento: R$ %.2f%n", cc.getValorFinanciamento());
		
		System.out.println();
		cc.extrato();
		System.out.println();
		
	//	cc.exibir();
		
	}

}
