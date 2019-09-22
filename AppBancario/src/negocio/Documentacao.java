package negocio;

public class Documentacao {
	
	private int id;
	private String rg, cpf, endereco, cep, telefone;
	
	public Documentacao(int id) {
		this.setId(id);
	}

	public Documentacao(String rg, String cpf, String endereco, String cep, String telefone) {
		this.rg = rg;
		this.cpf = cpf;
		this.endereco = endereco;
		this.cep = cep;
		this.telefone = telefone;
	}
	
	public Documentacao(int id, String rg, String cpf, String endereco, String cep, String telefone) {
		this.id = id;
		this.rg = rg;
		this.cpf = cpf;
		this.endereco = endereco;
		this.cep = cep;
		this.telefone = telefone;
	}
	

	//MÉTODOS
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

//	public void exibir() {
//		System.out.printf("Documentação: ");
//		System.out.println();
//		System.out.println(this);
//	}
	
	@Override
	public String toString() {
		return String.format("RG: %s - CPF: %s - Endereço: %s - CEP: %s Telefone: %s",
				this.getRg(),
				this.getCpf(),
				this.getEndereco(),
				this.getCep(),
				this.getTelefone());
	}

}
