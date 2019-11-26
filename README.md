# AppBanco

<< <b>Estou implementando recursos de Front-end aos poucos</b> :3 >>

Aplicação para gravar dados das contas bancárias do usuário

<h4><b>Funções gerais do código:</b></h4>
<ol>
<li>Login do usuário;</li>
<li>Cadastramento do titular;</li>
<li>Cadastramento das documentações relativas ao titular;</li>
<li>Cadastramento das contas bancárias (conta-corrente, conta-poupança, conta-investimento);</li>
<li>Associação entre documentaçao e titular;</li>
<li>Inclusão das contas bancárias cadastradas ao respectivo titular;</li>
<li>Exibição do relatório dos dados do titular e das contas bancárias associadas a ele.</li>
<li>Exclusão das contas-bancárias;</li>
<li>Exclusão do titular;</li>
<li>Armazenamento de todos os dados inseridos dentro do Banco de Dados.</li>
  </ol>

<h4><b>Funções da classe ContaCorrente:</b></h4>

<ol>
<li>Cadastramento da agência e número da conta;</li>
<li>Simular o saldo;</li>
<li>Simular o valor do contra-cheque;</li>
<li>Saber se tem direito a financiamento e cheque especial, de acordo com o valor do contra-cheque;</li>
<li>Obter o valor do cheque especial e/ou do financiamento, de acordo com uma porcentagem que está inclusa no método de cálculo;</li>
<li>Exibir as informações de cadastro de uma nova conta-corrente, em uma nova tela.</li>
 </ol>

<h4><b>Funções da classe ContaPoupanca:</b></h4>

<ol>
<li>Cadastramento da agência e número da conta;</li>
<li>Cadastramento da data do depósito inicial;</li>
<li>Simular saldo da poupança;</li>
<li>Simular resgate de algum valor;</li>
<li>Exibição do total, de acordo com o cálculo do do saldo, do resgate, e dos rendimentos, que estão inclusos no método o imposto de resgate e a taxa de rendimentos;</li>
<li>Exibir as informações de cadastro de uma nova conta-poupança, em uma nova tela.</li>
</ol>

<h4><b>Funções da classe Investimento:</b></h4>

<ol>
<li>Cadastramento da agência e número da conta;</li>
<li>Simular o saldo;</li>
<li>Selecionar o tipo de investimento;</li>
<li>Simular a quantia inicial investida;</li>
<li>Simular resgate de algum valor;</li>
<li>Exibir o total, de acordo com o cálculo do do saldo, do resgate e dos rendimentos, com cada tipo possuindo uma taxa diferente de resgate e de rendimento;</li>
<li>Exibir as informações de cadastro de uma nova conta-investimento, em uma nova tela.</li>
</ol>

<h4><b>Funções da classe Documentacao:</b></h4>

<ol>
<li>Cadastro do Rg;</li>
<li>Cadastro do CPF;</li>
<li>Cadastro do endereço;</li>
<li>Cadastro do CEP;</li>
<li>Cadastro do telefone;</li>
<li>Exibir as informações de cadastro de uma nova documentação, em uma nova tela.</li>
</ol>
  
<h4><b>Funções da classe Titular:</b></h4>

<ol>
<li>Cadastro do nome do titular;</li>
<li>Cadastro do nome do banco;</li>
<li>Cadastro da criação da titularidade;</li>
<li>Inclusão de alguma documentação ao titular;</li>
<li>Inclusão de uma ou mais contas bancárias ao titular;</li>
<li>Relatório dos dados do titular e das contas associadas.</li>
</ol>
