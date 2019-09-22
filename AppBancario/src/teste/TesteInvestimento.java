package teste;

import negocio.Investimento;

public class TesteInvestimento {

	public static void main(String[] args) {

		Investimento inv = new Investimento(10000.00f, 0.0f, "LFT");
		
		inv.setTipo("LFT");
		inv.setQuantiaInicialInv(10000.00f);
		inv.setResgateInv(1000.00f);
		inv.getRendimentosInv();
		inv.getQuantiaFinalInv();
		
		inv.extrato();
	//	inv.exibir();
	}

}
