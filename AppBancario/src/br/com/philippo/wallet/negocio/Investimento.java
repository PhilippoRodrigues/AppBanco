package br.com.philippo.wallet.negocio;

import br.com.philippo.wallet.modelo.ContaBancaria;

public class Investimento extends ContaBancaria {

	private String tipo;
	private float resgateInv, quantiaInicialInv, impostoResgateInv, quantiaFinalInv;

	public Investimento(int id) {
		super(id);
	}

	public Investimento(String agencia, String numConta, float saldo) {
		super(agencia, numConta, saldo);
	}

	public Investimento(String agencia, String numConta, float saldo, String tipo, float resgateInv,
			float quantiaInicialInv) {
		super(agencia, numConta, saldo);
		this.tipo = tipo;
		this.resgateInv = resgateInv;
		this.quantiaInicialInv = quantiaInicialInv;
		this.getImpostoResgateInv();
		this.getTaxaRendimentoInv();
		this.getRendimentosInv();
		this.getQuantiaFinalInv();
	}

	public Investimento(int id, String agencia, String numConta, float saldo, String tipo, float resgateInv,
			float quantiaInicialInv, float impostoResgateInv, float taxaRendimentoInv, float rendimentosInv,
			float quantiaFinalInv) {
		super(id, agencia, numConta, saldo);
		this.tipo = tipo;
		this.resgateInv = resgateInv;
		this.quantiaInicialInv = quantiaInicialInv;
		this.getImpostoResgateInv();
		this.getTaxaRendimentoInv();
		this.getRendimentosInv();
		this.getQuantiaFinalInv();
	}
	
	// MÉTODOS

	public String getTipo() {
		return tipo();
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String tipo() {
		if ("CDB".equals(tipo)) {
			return "CDB";
		} else if ("CDB-DI".equals(tipo)) {
			return "CDB-DI";
		} else {
			return "LFT";
		}
	}

	// Quantias

	public float getQuantiaInicialInv() {
		return quantiaInicialInv;
	}

	public void setQuantiaInicialInv(float quantiaInicialInv) {
		this.quantiaInicialInv = quantiaInicialInv;
	}

	public float getQuantiaFinalInv() {
		return this.quantiaFinalInv();
	}

	private float quantiaFinalInv() {
		float quantiaFinalInv = this.getQuantiaInicialInv() + this.getRendimentosInv() - this.getCobrancaResgateInv()
				- this.getResgateInv();

		return quantiaFinalInv;
	}

	// Rendimento

	public float getRendimentosInv() {
		return calculoRendimentosInv();
	}

	private float calculoRendimentosInv() {
		float rendimentoInv = 0.0f;
		if (getTipo() == "CDB") {
			rendimentoInv = getQuantiaInicialInv() * (this.getTaxaRendimentoInv() / 100);
		} else if (getTipo() == "CDB-DI") {
			rendimentoInv = getQuantiaInicialInv() * (this.getTaxaRendimentoInv() / 100);
		} else if (getTipo() == "LFT") {
			rendimentoInv = getQuantiaInicialInv() * (this.getTaxaRendimentoInv() / 100);
		}

		return rendimentoInv;
	}

	public float getTaxaRendimentoInv() {
		float taxaRendimentoInv = 0.0f;
		if (getTipo() == "CDB") {
			return taxaRendimentoInv = 0.08f * 100;
		} else if (getTipo() == "CDB-DI") {
			return taxaRendimentoInv = 0.09f * 100;
		} else if (getTipo() == "LFT") {
			return taxaRendimentoInv = 0.075f * 100;
		}
		return taxaRendimentoInv;
	}

	// Resgate

	public float getImpostoResgateInv() {
		if (getTipo() == "CDB-DI" || getTipo() == "LFT") {
			impostoResgateInv = 0.27f * 100;
		} else {
			impostoResgateInv = 0.13f * 100;
		}
		return impostoResgateInv;
	}

	public float getResgateInv() {
		return resgateInv;
	}

	public float getCobrancaResgateInv() {
		return cobrancaResgateInv();
	}

	private float cobrancaResgateInv() {
		return this.resgateInv * (getImpostoResgateInv() / 100);
	}

	public void setResgateInv(float resgateInv) {
		this.resgateInv = resgateInv;
	}

	public void exibir() {
		System.out.printf("Investimentos - ");
		super.exibir();
		System.out.println(this);
	}

	@Override
	public String toString() {
		return String.format(
				"%s - "
				+ "Tipo: %s - "
				+ "Valor do resgate do investimento: %.2f - "
				+ "Valor inicial do investimento: %.2f - "
				+ "Imposto do resgate realizado: %.2f - "
				+ "Taxa de rendimento do investimento: %.2f - "
				+ "Rendimentos: %.2f",
				super.toString(),
				this.getTipo(),
				this.getResgateInv(),
				this.getQuantiaInicialInv(),
				this.getImpostoResgateInv(),
				this.getTaxaRendimentoInv(),
				this.getRendimentosInv());
	}
}
