package modelo;

import negocio.ContaCorrente;
import negocio.ContaPoupanca;

public abstract class ContaBancaria {
	
	private int id;
	private float deposito, pagamento, saldo, realizarTransferencia, receberTransferencia;
	private String numConta, agencia;
	
	protected static int contasBancarias;
	
	public ContaBancaria() {
		
	}
	
	public ContaBancaria(int id) {
		this.setId(id);
	}
	
	public ContaBancaria(String agencia, String numConta, float saldo) {
		this.agencia = agencia;
		this.numConta = numConta;
		this.saldo = saldo;
		
		contasBancarias++;
	}
	
	public ContaBancaria(int id, String agencia, String numConta, float saldo) {
		this.id = id;
		this.agencia = agencia;
		this.numConta = numConta;
		this.saldo = saldo;
		
		contasBancarias++;
	}
	
	//Métodos
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNumConta() {
		return numConta;
	}

	public void setNumConta(String numConta) {
		this.numConta = numConta;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public float getDeposito() {
		return deposito;
	}

	public void setDeposito(float deposito) {
		this.deposito = deposito;
	}
	
	public float getRealizarTransferencia() {
		return realizarTransferencia;
	}
	
	public void setRealizarTransferencia(float realizarTransferencia) {
		this.realizarTransferencia = realizarTransferencia;
	}
	
	public float getReceberTransferencia() {
		return receberTransferencia;
	}
	
	public void setReceberTransferencia(float receberTransferencia) {
		this.receberTransferencia = receberTransferencia;
	}
	
	public float getSaldo() {
		return saldo;
	}
	
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public String obterTipo() {
		if(this instanceof ContaCorrente) {
			return "Conta-Corrente";
		}else if(this instanceof ContaPoupanca) {
			return "Conta-Poupança";
		}else {
			return "Investimento";
		}
	}
//	public Documentacao getDocumentacao() {
//		return documentacao;
//	}
//	
//	public static void setContasBancarias(int contasBancarias) {
//		ContaBancaria.contasBancarias = contasBancarias;
//	}

	public float getPagamento() {
		return this.pagamento;
	}
	
//	public String aviso() {
//		while (this.pagamento > this.getSaldo()) {
//			aviso = "Pagamento inválido. Saldo insuficiente.";
//		}
//		return aviso;
//	}
	
	public void setPagamento(float pagamento) {
		
		this.pagamento = pagamento;
		
//		if(this.getPagamento() > this.getSaldo()) {
//			System.out.println("Pagamento inválido. Saldo insuficiente."); 
//		}else {
//		}
		
	}
	
	public abstract float saldoFinal(); 
	
	public abstract String extrato();

	public static int obterContasBancarias() {
		return contasBancarias;
	}
	
	
//	//Impressão
//	
//	public void exibir() {
//		System.out.println();
//	}
	
	@Override
	public String toString() {
		return String.format("Agencia: %s - " +
				" Número da Conta: %s - " +
				" Saldo: %.2f",
				getAgencia(),
				getNumConta(),
				getSaldo());
	}

}
