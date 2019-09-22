package negocio;

import modelo.ContaBancaria;

public class ContaPoupanca extends ContaBancaria {

	private float rendimentos, resgate;
	private String depositoInicial;

	// Construtor

	public ContaPoupanca(int id) {
		super(id);
	}

	public ContaPoupanca(String agencia, String numConta, float saldo) {
		super(agencia, numConta, saldo);
	}

	public ContaPoupanca(int id, String agencia, String numConta, float saldo, float rendimentos, float resgate,
			String depositoInicial) {
		super(id, agencia, numConta, saldo);
		this.setRendimentos(rendimentos);
		this.setResgate(resgate);
		this.depositoInicial = depositoInicial;
	}

	public ContaPoupanca(String agencia, String numConta, float saldo, float rendimentos, float resgate,
			String depositoInicial) {
		super(agencia, numConta, saldo);
		this.setRendimentos(rendimentos);
		this.setResgate(resgate);
		this.depositoInicial = depositoInicial;

	}

	// MÉTODOS

	@Override
	public float saldoFinal() {
		return super.getSaldo() - this.getResgate() - this.getCobrancaResgate() + this.getRendimentos();
	}

	@Override
	public String extrato() {
		String extrato = "Extrato bancário do mês atual";
		extrato = "Valor dos Rendimentos do mês: R$ %.2f%n" + this.getRendimentos();
		extrato = "Valor dos Resgates realizados: R$ %.2f%n" + this.getResgate();
		extrato = "Saldo: R$ %.2f%n" + this.getSaldo();

		return extrato;
	}

////	@Override
//	public void setPagamento(float pagamento) {
//		if(super.getPagamento() > this.getSaldoPoupanca()) {
//			System.out.println("Pagamento inválido. Saldo insuficiente."); 
//		}
//	}

//	public float getCalculoRendimentos() {
//		return calculoRendimentos();
//	}

	// Coloquei em comentário por enquanto

//	public float getRendimentos() {
//		 return (this.rendimentos()/100) * super.saldo();
//	}
//	
//	private float rendimentos() {
//		this.rendimentos = 0.065f * 100;
//		
//		return this.rendimentos;
//	}

	public float getRendimentos() {
		return rendimentos;
	}

	public void setRendimentos(float rendimentos) {
		this.rendimentos = rendimentos;
	}

	public float getCobrancaResgate() {
		return cobrancaResgate();
	}

	private float cobrancaResgate() {
		return this.resgate * (impostoResgate() / 100);
	}

	private float impostoResgate() {
		return 0.07f * 100;
	}

	public float getResgate() {
		return this.resgate;
	}

	public void setResgate(float resgate) {
		this.resgate = resgate;
	}

	public String getDepositoInicial() {
		return depositoInicial;
	}

	public void setDepositoInicial(String depositoInicial) {
		this.depositoInicial = depositoInicial;
	}

//	public void exibir() {
//		System.out.println();
//		System.out.printf("ContaPoupança - ");
//		super.exibir();
//		System.out.println(this);
//	}

	@Override
	public String toString() {
		return String.format(
				"%s - Rendimento: %.2f - Resgate: %.2f - Depósito inicial: %s", 
				super.toString(),
				this.getRendimentos(),
				this.getResgate(), 
				this.getDepositoInicial());
	}
}
