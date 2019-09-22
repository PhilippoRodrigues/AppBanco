//package teste;
//
//import negocio.ContaCorrente;
//import negocio.ContaPoupanca;
//import negocio.Documentacao;
//import negocio.Investimento;
//import negocio.Titular;
//
//
//public class TesteTitular {
//
//	public static void main(String[] args) {
//		
//		Titular titular = new Titular();
//		
//		titular.setNomeBanco("XX");
//		titular.setAgencia(9999);
//		titular.setNumConta(12345);
//		titular.setDataAberturaConta("02/01/2019");
//
//		Documentacao doc1 = new Documentacao("123.456.789-19", "Rua São José, 90", "20349-312", "2222-2222");
//		
//		ContaCorrente cc1 = new ContaCorrente(1000.00f, 15000.00f);
//		//ContaCorrente cc2 = new ContaCorrente(2000.00f, 90.00f);
//		
//		ContaPoupanca cp1 = new ContaPoupanca("02/01/2019", 1000.00f, 15000.00f);
//		
//		Investimento inv1 = new Investimento(10000.00f, 0.0f, "LFT");
//		
//		
//		titular.associa(doc1);
//		
//		titular.adiciona(cc1);
//
//		//titular.adiciona(cc2);
//		
//		titular.adiciona(cp1);
//
//		titular.adiciona(inv1);
//		
//		titular.exibir();
//		
//	}
//
//}
