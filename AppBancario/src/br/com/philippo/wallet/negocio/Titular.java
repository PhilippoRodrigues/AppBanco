package br.com.philippo.wallet.negocio;

import java.util.HashSet;
import java.util.Set;

import br.com.philippo.wallet.auxiliar.Constante;
import br.com.philippo.wallet.modelo.ContaBancaria;

public class Titular {
	
	private int id;
	private String nomeBanco,dataAberturaConta, nome;
	public Documentacao documentacao;
	public Set <ContaBancaria> tiposConta;
	private int[] quantidadeContasBancarias;
	
	
	//Construtor
	
	public Titular() {
		tiposConta = new HashSet<ContaBancaria>();
	}
	
	public Titular(int id) {
		this();
		this.setId(id);
	}
	
	public Titular(String nome, String nomeBanco, String dataAberturaConta) { 
		this.setNome(nome);
		this.setNomeBanco(nomeBanco);
		this.setDataAberturaConta(dataAberturaConta);
	}
	
	public Titular(String nome, String nomeBanco, String dataAberturaConta, Documentacao documentacao) { 
		this.setNome(nome);
		this.setNomeBanco(nomeBanco);
		this.setDataAberturaConta(dataAberturaConta);
		this.setDocumentacao(documentacao);
	}
	
	public Titular(int id, String nome, String nomeBanco, String dataAberturaConta, Documentacao documentacao) { 
		this.setId(id);
		this.setNome(nome);
		this.setNomeBanco(nomeBanco);
		this.setDataAberturaConta(dataAberturaConta);
		this.setDocumentacao(documentacao);
	}

	public Titular(int id, String nome, String nomeBanco, String dataAberturaConta, Documentacao documentacao, Set<ContaBancaria> tiposConta) { 
		this.setId(id);
		this.setNome(nome);
		this.setNomeBanco(nomeBanco);
		this.setDataAberturaConta(dataAberturaConta);
		this.setDocumentacao(documentacao);
		this.setTiposConta(tiposConta);
	}

	//Get e set
	
	public Documentacao getDocumentacao() {
		return documentacao;
	}
	
	public void setDocumentacao(Documentacao documentacao) {
		this.documentacao = documentacao;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNomeBanco() {
		return nomeBanco;
	}

	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}

	public String getDataAberturaConta() {
		return dataAberturaConta;
	}

	public void setDataAberturaConta(String dataAberturaConta) {
		this.dataAberturaConta = dataAberturaConta;
	}

	public Set<ContaBancaria> getTiposConta() {
		return tiposConta;
	}

	public void setTiposConta(Set<ContaBancaria> tiposConta) {
		this.tiposConta = tiposConta;
	}
	
	private boolean validar() {
		return this.getTiposConta().size() == ContaBancaria.obterContasBancarias(); //uma variável static pode ser chamada
																				   //diretamente pela classe em outra classe?
	}

	public void associa(Documentacao documentacao) {
		this.documentacao = documentacao;
	}
	
	public void adiciona(ContaBancaria contaBancaria) {
		this.getTiposConta().add(contaBancaria);
	}
	
	
	//Impressão 
	
	private void contabiliza(ContaBancaria contaBancaria) {		
		
			if(contaBancaria instanceof ContaCorrente) {
				this.quantidadeContasBancarias[0]++;
			} 
			else if(contaBancaria instanceof ContaPoupanca) {
				this.quantidadeContasBancarias[1]++;
			}else if(contaBancaria instanceof Investimento) {
				this.quantidadeContasBancarias[2]++;
			}
		}
	
	private void showContabiliza() {
		
		System.out.println("Contabiliza: ");
		
		for(int i = 0; i < quantidadeContasBancarias.length; i++) {
			System.err.println("- " + 								
					Constante.CONTASBANCARIAS[i] + 
					": " + 
					this.quantidadeContasBancarias[i]);
		}
	}
	
	public void exibir() {
		
		if(this.validar()) {

			quantidadeContasBancarias = new int[Constante.CONTASBANCARIAS.length];
			
			System.out.println();
			System.out.printf("Titular\n");
			
			System.out.println();
			System.out.println(this);
			System.out.println();
			
			documentacao.exibir();
			
			for(ContaBancaria cb: this.tiposConta) {
				this.contabiliza(cb);
				
				cb.exibir();
			}
			
			this.showContabiliza();

		} else {
			System.err.println("Inválido");
		}
		
	}
	
	@Override
	public String toString() {
		return String.format("Nome: %s - Banco: %s - "
				+ "Data da abertura da conta: %s - Documentação: %s",
				this.getNome(),
				this.getNomeBanco(),
				this.getDataAberturaConta(),
				this.getDocumentacao()
				);
	}
}
