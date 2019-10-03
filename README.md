# AppBanco
Aplicação para gravar dados das contas bancárias do usuário

Funções gerais do código:

1- Login do usuário;
2- Cadastramento do titular;
3- Cadastramento das documentações relativas ao titular;
4- Cadastramento das contas bancárias (conta-corrente, conta-poupança, conta-investimento);
5- Associação entre documentaçao e titular;
6- Inclusão das contas bancárias cadastradas ao respectivo titular;
7- Exibição do relatório dos dados do titular e das contas bancárias associadas a ele.
8- Exclusão das contas-bancárias;
9- Exclusão do titular;
10- Armazenamento de todos os dados inseridos dentro do Banco de Dados.

Funções da classe ContaCorrente:

1- Cadastramento da agência e número da conta;
2- Simular o saldo;
3- Simular o valor do contra-cheque;
4- Saber se tem direito a financiamento e cheque especial, de acordo com o valor do contra-cheque;
5- Obter o valor do cheque especial e/ou do financiamento, de acordo com uma porcentagem que está inclusa no método de cálculo;
6- Exibir as informações de cadastro de uma nova conta-corrente, em uma nova tela.

Funções da classe ContaPoupanca:

1- Cadastramento da agência e número da conta;
2- Cadastramento da data do depósito inicial;
3- Simular saldo da poupança;
4- Simular resgate de algum valor;
5- Exibição do total, de acordo com o cálculo do do saldo, do resgate, e dos rendimentos, que estão inclusos no método o imposto de resgate e a taxa de rendimentos;
6- Exibir as informações de cadastro de uma nova conta-poupança, em uma nova tela.

Funções da classe Investimento:

1- Cadastramento da agência e número da conta;
2- Simular o saldo;
3- Selecionar o tipo de investimento;
4- Simular a quantia inicial investida;
5- Simular resgate de algum valor;
6- Exibir o total, de acordo com o cálculo do do saldo, do resgate e dos rendimentos, com cada tipo possuindo uma taxa diferente de resgate e de rendimento;
7- Exibir as informações de cadastro de uma nova conta-investimento, em uma nova tela.

Funções da classe Documentacao:

1- Cadastro do Rg;
2- Cadastro do CPF;
3- Cadastro do endereço;
4- Cadastro do CEP;
5- Cadastro do telefone;
6- Exibir as informações de cadastro de uma nova documentação, em uma nova tela.

Funções da classe Titular:

1- Cadastro do nome do titular;
2- Cadastro do nome do banco;
3- Cadastro da criação da titularidade;
4- Inclusão de alguma documentação ao titular;
5- Inclusão de uma ou mais contas bancárias ao titular;
6- Relatório dos dados do titular e das contas associadas.
