package negocio;

import java.util.ArrayList;
import java.util.List;

import auxiliar.Constante;
import modelo.ContaBancaria;

public class Titular {
	
	private int id;
	private String nomeBanco,dataAberturaConta, nome;
//	public Documentacao documentacao;
	public List <ContaBancaria> tiposConta;
	private int[] quantidadeContasBancarias;
	
	
	//Construtor
	
	public Titular(int id) {
		this.setId(id);
	}
	
	public Titular(String nome, String nomeBanco, String dataAberturaConta) { 
		this.setNome(nome);
		this.setNomeBanco(nomeBanco);
		this.setDataAberturaConta(dataAberturaConta);
	}
	
	public Titular(int id, String nome, String nomeBanco, String dataAberturaConta) { 
		this.setId(id);
		this.setNome(nome);
		this.setNomeBanco(nomeBanco);
		this.setDataAberturaConta(dataAberturaConta);
	}

	public Titular() {
		tiposConta = new ArrayList<ContaBancaria>();
	}


	//Get e set
	
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

	public List<ContaBancaria> getTiposConta() {
		return tiposConta;
	}

	public void setTiposConta(List<ContaBancaria> tiposConta) {
		this.tiposConta = tiposConta;
	}
	
	private boolean validar() {
		return this.getTiposConta().size() == ContaBancaria.obterContasBancarias(); //uma variável static pode ser chamada
																				   //diretamente pela classe em outra classe?
	}

//	public void associa(Documentacao documentacao) {
//		this.documentacao = documentacao;
//	}
	
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
			
			//documentacao.exibir();
			
//			for(ContaBancaria cb: this.tiposConta) {
//				this.contabiliza(cb);
//				
//				cb.exibir();
//			}
			
			this.showContabiliza();

		} else {
			System.err.println("Inválido");
		}
		
	}
	

	@Override
	public String toString() {
		return String.format("Nome: %s - Banco: %s - "
				+ "Data da abertura da conta: %s \n",
				this.nome,
				this.nomeBanco,
				this.dataAberturaConta
				);
	}
}
