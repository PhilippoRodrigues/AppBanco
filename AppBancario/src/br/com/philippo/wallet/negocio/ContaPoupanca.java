package br.com.philippo.wallet.negocio;

import br.com.philippo.wallet.modelo.ContaBancaria;

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
			String depositoInicial, float total) {
		super(id, agencia, numConta, saldo);
		this.getTaxaRendimentos();
		this.setResgate(resgate);
		this.depositoInicial = depositoInicial;
		this.getTotal();
	}

	public ContaPoupanca(String agencia, String numConta, float saldo, float resgate,
			String depositoInicial) {
		super(agencia, numConta, saldo);
		this.getTaxaRendimentos();
		this.setResgate(resgate);
		this.depositoInicial = depositoInicial;
		this.getTotal();

	}

	// MÉTODOS

	public float getTotal() {
		 return ((this.getTaxaRendimentos()/100) * this.getSaldo()) + this.getSaldo() - this.getResgate();
	}
	
	private float taxaRendimentos() {
		this.rendimentos = 0.065f * 100;
		
		return this.rendimentos;
	}

	public float getTaxaRendimentos() {
		return taxaRendimentos();
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

	public void exibir() {
		System.out.println();
		System.out.printf("ContaPoupança - ");
		super.exibir();
		System.out.println(this);
	}

	@Override
	public String toString() {
		return String.format(
				"%s - Rendimento: %.2f - Resgate: %.2f - Depósito inicial: %s - Total: %.2f", 
				super.toString(),
				this.getTaxaRendimentos(),
				this.getResgate(), 
				this.getDepositoInicial(),
				this.getTotal());
	}
}
