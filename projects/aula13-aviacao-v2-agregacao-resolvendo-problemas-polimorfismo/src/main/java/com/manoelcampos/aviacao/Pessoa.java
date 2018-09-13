package com.manoelcampos.aviacao;

/**
 * Observe que definimos a classe Pessoa como abstrata, 
 * mas ela não possui nenhum método abstrato.
 * Fizemos isso apenas para impedir que uma Pessoa seja instanciada.
 * Se você tentar, verá que não é possível mais.
 * Isto é util pois a classe Pessoa não tem todos os dados
 * necessários para realizar um cadastro.
 * Nós não cadastramos pessoas diretamente no sistema,
 * mas sim pilotos e passageiros.
 * Como esta duas classes usam agregação com PessoaFisica,
 * precisamos instanciar objetos de tal classe
 * para instanciar Pilotos e Passageiros.
 * E como uma mesma instância de PessoaFisica pode
 * ser usada para um Passageiro e também um Piloto,
 * precisamos instanciar PessoaFisica.
 * Mas instanciar Pessoa não faz muito sentido.
 * A pessoa não tem dados essenciais
 * como CPF, sexo e data de nascimento que estão
 * na PessoaFisica. Por isso, definimos ela como abstrata.
 * 
 * @author Manoel Campos da Silva Filho <http://github.com/manoelcampos>
 */
public abstract class Pessoa {
    private String nome;
    private String email;
    
    public Pessoa(String nome){
        setNome(nome);
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    protected String removerSimbolos(String cnpj_ou_cpf) {
        // Remove caracteres não numéricos do CNPJ
        cnpj_ou_cpf = cnpj_ou_cpf.replaceAll("\\D", "");
        return cnpj_ou_cpf;
    }

    /**
     * Calcula um dígito verificador de um CPF ou CNPJ utilizando o algoritmo módulo 11.
     *
     * @param somaAlgarismos soma de um determinado número de algarismos de um CPF ou CNPJ,
     *                       que será usada para calcular um dígito verificador
     * @return o dígito verificador calculado
     */
    protected int calculaDigito(int somaAlgarismos) {
        int dig = 11 - (somaAlgarismos % 11);
        return dig > 9 ? 0 : dig;
    }

    /**
     * Soma uma determinada sequência de algarismos de um CPF ou CNPJ.
     * Tal some é utilizada para posteriormente calcular um dígito verificador.
     * @param cnpj cnpj para fazer a soma de alguns algarismos
     * @param inicio posição inicial de onde os algarismos serão somados
     * @param totalAlgarismos total de algarismos para somar
     * @return a soma dos algarismos indicados
     */
    protected int somaAlgarismos(String cnpj, int inicio, int totalAlgarismos) {
        int soma = 0;
        int algarismo;
        char[] vetor = cnpj.toCharArray();
        for (int i = 0; i < totalAlgarismos; i++) {
            /*Na linha abaixo estamos obtendo o código ASCII do caractere
            (algarismo do CPNJ) e subtraindo 48 para obter tal
            caractere como inteiro, sem precisar utilizar funções
            como Integer.valueOf(). Como o CNPJ é String,
            se em uma posição temos o valor '0', este valor é char
            e assim não podemos fazer contas utilizando tal valor.
            O código ASCII do caractere '0' é 48. Logo, se subtraírmos
            48 de tal código, obtemos 0 (que é o valor inteiro correspondente
            ao caractere '0').*/
            algarismo = vetor[i + inicio] - 48;
            soma += algarismo * (totalAlgarismos + 1 - i);
        }
        return soma;
    }

    @Override
    public String toString() {
        return nome;
    }


}
