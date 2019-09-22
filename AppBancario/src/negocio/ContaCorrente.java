package negocio;

import modelo.ContaBancaria;

public class ContaCorrente extends ContaBancaria {

	private float realizarDocTed, receberDocTed, taxaDocTed, contraCheque;
	private boolean chequeEspecial, financiamento;

	// protected Titular titular;

	// private valorChequeEspecial, valorFinanciamento;

	// Construtor

	public ContaCorrente(int id) {
		super(id);
	}
	
	public ContaCorrente(String agencia, String numConta, float saldo) {
		super(agencia, numConta, saldo);
		contasBancarias++;
	}

	public ContaCorrente(String agencia, String numConta, float saldo, float contraCheque, boolean chequeEspecial,
			boolean financiamento) { 
		super(agencia, numConta, saldo);
		this.setContraCheque(contraCheque);
		this.getChequeEspecial();
		this.getFinanciamento();
	}

	public ContaCorrente(int id, String agencia, String numConta, float saldo, float contraCheque, boolean chequeEspecial,
			boolean financiamento) { 
		super(id, agencia, numConta, saldo);
		this.setContraCheque(contraCheque);
		this.getChequeEspecial();
		this.getFinanciamento();
	}

	

	// Métodos

	public float getContraCheque() {
		return contraCheque;
	}

	public void setContraCheque(float contraCheque) {
		this.contraCheque = contraCheque;
	}

	// DocTed

	public float getRealizarDocTed() {
		return this.realizarDocTed;
	}

	public void setRealizarDocTed(float realizarDocTed) {
		this.realizarDocTed = realizarDocTed;
	}

	public float getTaxaDocTed() {
		return this.taxaDocTed();
	}

	public float taxaDocTed() {
		if (this.getRealizarDocTed() > 0.0f) {
			this.taxaDocTed = 10.0f;
		} else {
			this.taxaDocTed = 0.0f;
		}
		return this.taxaDocTed;
	}

	public void setTaxaDocTed(float taxaDocTed) {
		this.taxaDocTed = taxaDocTed;
	}

	public void setReceberDocTed(float receberDocTed) {
		this.receberDocTed = receberDocTed;
	}

	public float getReceberDocTed() {
		return this.receberDocTed;
	}

	// Extrato

	@Override
	public String extrato() {
		String extrato = "Extrato bancário do mês atual:";
		extrato = "Valor Doc/Ted realizado: R$ %.2f%n" + this.getRealizarDocTed();
		extrato = "Valor da taxa do Doc/Ted: R$ %.2f%n" + this.getTaxaDocTed();
		extrato = "Valor do Doc/Ted recebido: R$ %.2f%n" + this.getReceberDocTed();
		extrato = "Saldo atual: R$ %.2f%n" + this.saldoFinal();
		extrato = "Cheque especial: " + this.getChequeEspecial();
		extrato = "Financiamento: " + this.getFinanciamento();

		return extrato;

		// System.out.printf();
		// System.out.printf("Valor do cheque especial: R$ %.2f%n",
		// this.getValorChequeEspecial());
		// System.out.println(");
		// System.out.printf("Valor dos Resgates realizados: R$ %.2f%n",
		// this.getValorFinanciamento());
	}

	// SaldoCC

	@Override
	public float saldoFinal() {
		return super.getSaldo() - // Preciso alocar o resultado em uma variável para o método funcionar?
				getRealizarTransferencia() - getPagamento() + getReceberTransferencia() + getDeposito();
	}

	// ChequeEspecial

	// Precisa reformular

	// public float getValorChequeEspecial() {
//			return this.getContraCheque() * 0.4f;
//		}

	public boolean getChequeEspecial() {
		return this.getContraCheque() >= 15000.00f;
	}

	// Financiamento

	// Precisa reformular

//	public float getValorFinanciamento() {
//		return super.getContraCheque() * 0.5f;
//	}

	public boolean getFinanciamento() {
		return this.getContraCheque() >= 20000.00f;
	}

//	public Titular getTitular() {
//		return titular;
//	}
//	
//	public void setTitular(Titular titular) {
//		this.titular = titular;
//	}

//	public void exibir() {
//		System.out.println();
//		System.out.printf("Conta Corrente - ");
//		super.exibir();
//		System.out.println();
//		System.out.println(this);
//	}

	@Override
	public String toString() {
		return String.format("%s - %.2f - %s - %s", 
				super.toString(), 
				this.contraCheque,
				this.getChequeEspecial() ? "Sim" : "Não", 
				this.getFinanciamento() ? "Sim" : "Não");
	}
}
