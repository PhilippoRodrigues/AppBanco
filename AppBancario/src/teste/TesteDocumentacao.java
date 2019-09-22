package teste;


import negocio.Documentacao;

public class TesteDocumentacao {

	public static void main(String[] args) {
		
		Documentacao doc1 = new Documentacao("123.456.789-19", "Rua São José, 90", "20349-312", "2222-2222");


		doc1.setRg("12344-5");
		doc1.setCpf("123.456.789-19");
		doc1.setEndereco("Rua São José, 90");
		doc1.setCep("20192-340");
		doc1.setTelefone("2222-2222");
		

//		doc1.exibir(); // já cria e chama o objeto (mas somente caso eu não precise usar esse objeto em outra classe).
		
	}

}
