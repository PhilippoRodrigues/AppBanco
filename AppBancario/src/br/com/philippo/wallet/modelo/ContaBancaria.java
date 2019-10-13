package br.com.philippo.wallet.modelo;

import java.util.Locale;

import br.com.philippo.wallet.negocio.ContaCorrente;
import br.com.philippo.wallet.negocio.ContaPoupanca;

public abstract class ContaBancaria {
	
	private int id;
	private float saldo;
	private String numConta, agencia;
	
	protected static int contasBancarias;
	
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
	
	public float getSaldo() {
		return saldo;
	}
	
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
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

	public String obterTipo() {
		if(this instanceof ContaCorrente) {
			return "Conta-Corrente";
		}else if(this instanceof ContaPoupanca) {
			return "Conta-Poupança";
		}else {
			return "Investimento";
		}
	}

	public static void setContasBancarias(int contasBancarias) {
		ContaBancaria.contasBancarias = contasBancarias;
	}

	public static int obterContasBancarias() {
		return contasBancarias;
	}
	
	//Impressão
	
	public void exibir() {
		System.out.println();
	}
	
	@Override
	public String toString() {
		return String.format(new Locale("pt", "BR"), "Agencia: %s - " +
				" Número da Conta: %s - " +
				" Saldo: %.2f",
				this.getAgencia(),
				this.getNumConta(),
				this.getSaldo());
	}

	//HashCode e Equals

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaBancaria other = (ContaBancaria) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
