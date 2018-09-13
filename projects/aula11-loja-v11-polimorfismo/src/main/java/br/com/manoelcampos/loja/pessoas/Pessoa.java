package br.com.manoelcampos.loja.pessoas;

import br.com.manoelcampos.loja.geral.Cidade;


/**
 * Write a description of class Pessoa here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Pessoa
{
    private String nome;
    private Cidade cidade;
    private String endereco;
    private String telefone;
    
    public Pessoa(){}
    
    public Pessoa(String nome, Cidade cidade){ 
        setNome(nome);
        setCidade(cidade); 
    }

    public String getNome(){ return nome; }
    
    public void setNome(String nome){  
        if(nome == null || nome.trim().isEmpty()){
            System.out.println("O nome é obrigatório"); 
        } else {
            this.nome = nome;
        }
    }

    /**
     * @return the cidade
     */
    public Cidade getCidade() {
        return cidade;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
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
