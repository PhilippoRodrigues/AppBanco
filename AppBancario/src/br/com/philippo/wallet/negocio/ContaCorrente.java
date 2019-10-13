package br.com.philippo.wallet.negocio;

import java.util.Locale;

import br.com.philippo.wallet.modelo.ContaBancaria;

public class ContaCorrente extends ContaBancaria {

	private float contraCheque;
	private boolean chequeEspecial, financiamento;

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
		this.getValorChequeEspecial();
		this.getFinanciamento();
		this.getValorFinanciamento();
	}

	public ContaCorrente(int id, String agencia, String numConta, float saldo, float contraCheque, boolean chequeEspecial,
			float valorChequeEspecial, boolean financiamento, float valorFinanciamento) { 
		super(id, agencia, numConta, saldo);
		this.setContraCheque(contraCheque);
		this.getChequeEspecial();
		this.getValorChequeEspecial();
		this.getFinanciamento();
		this.getValorFinanciamento();
	}

	

	// Métodos
	
	public float getContraCheque() {
		return contraCheque;
	}

	public void setContraCheque(float contraCheque) {
		this.contraCheque = contraCheque;
	}

	// ChequeEspecial

	 public float getValorChequeEspecial() {
			return this.getChequeEspecial() ? this.getContraCheque() * 0.4f : 0.00f;
		}

	public boolean getChequeEspecial() {
		return this.getContraCheque() >= 15000.00f;
	}

	// Financiamento

	public float getValorFinanciamento() {
		return this.getFinanciamento() ? this.getContraCheque() * 0.5f : 0.00f;
	}

	public boolean getFinanciamento() {
		return this.getContraCheque() >= 20000.00f;
	}

	public void exibir() {
		System.out.println();
		System.out.printf("Conta Corrente - ");
		super.exibir();
		System.out.println();
		System.out.println(this);
	}

	@Override
	public String toString() {
		return String.format(
				new Locale("pt", "BR"), 
				"%s - Contra-Cheque: %.2f - Cheque Especial: %s - "
				+ "Valor do Cheque Especial: %.2f - Financiamento: %s - Valor do financiamento: %.2f", 
				super.toString(), 
				this.getContraCheque(),
				this.getChequeEspecial() ? "Sim" : "Não",
				this.getValorChequeEspecial(),
				this.getFinanciamento() ? "Sim" : "Não",
				this.getValorFinanciamento());
	}
}
