package br.com.manoelcampos.loja.pessoas;

/**
 * Aqui estamos definindo que a classe PessoaFisica 
 * extende Pessoa, ou seja, PessoaFisica é filha
 * de Pessoa. Pessoa é super classe de PessoaFisica.
 * Adicionalmente, como temos uma "árvore genealógica" (uma hierarquia de classes)
 * entre Cliente, PessoaFisica e Pessoa, podemos dizer que Cliente é filha
 * de PessoaFisica e neta de Pessoa.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PessoaFisica extends Pessoa
{
    private String cpf;
    private char sexo;
    private String dataNascimento;

    public String getCpf(){ 
        return cpf; 
    }
    
    /**
     * Altera o CPF
     * @param cpf CPF a ser armazenado
     * @throws IllegalArgumentException quando o CPF for inválido ou vazio
     */
    public void setCpf(String cpf) { 
        if(cpf.trim().isEmpty()){
            throw new IllegalArgumentException("O CPF é obrigatório");
        } else if(!isCpfValido(cpf)) {
            throw new IllegalArgumentException("O CPF é inválido");
        } else {
            this.cpf = cpf;
        }

    }
    
    public char getSexo(){
        return sexo;
    }
    
    public void setSexo(char sexo){
        //O valor '\0' para variáveis char significa que a variável está vazia
        if(sexo == '\0' || sexo == ' '){
            System.out.println("Sexo é obrigatório"); 
        }
        else if(sexo != 'm' && sexo != 'f' && sexo != 'M' && sexo != 'F'){
            System.out.println("Sexo inválido"); 
        }
        else this.sexo = sexo;
    }    

    /**
     * Verifica se um CPF é válido ou não, utilizando o algorítmo denominado Módulo
     * 11, como descrito em
     * https://pt.wikipedia.org/wiki/Dígito_verificador#Módulo_11.
     * 
     * Antes esta função era confusa e extensa. O processo de validação do CPF
     * envolve calcular o valor do primeiro e do segundo dígito, para então comparar
     * tais resultados com os dígitos informados pelo usuário. Tal cálculo do
     * dígito, apesar de ser um código de algumas linhas, é confuso para quem nunca
     * viu como é feito o processo de validação do CPF. Além disso, tal cálculo
     * precisa ser feito duas vezes, uma vez para cada dígito. Desta forma,
     * utilizamos um processo de refatoração para remover o código que calcula um
     * dígito para outro método chamado calculaDigito, fora do método isCpfValido.
     * Com isto, evitamos qualquer repetição de código e tornamos o código do método
     * isCpfValido menor e muito mais legível.
     * 
     * Ao criar o método calcularDigito, definimos sua visibilidade como private,
     * para indicar que ele não será acessível fora da classe. Isto porque, o método
     * é apenas parte do processo de validação do CPF. Ele chamado fora deste
     * processo não tem utilidade alguma. Desta forma, colocando o método como
     * private estamos aplicando o conceito de encapsulamento, escondendo tal método
     * dentro da classe. Assim, as outras classes nem saberão que ele existe. Apenas
     * o método isCpfValido é que estará visível externamente para outras classes.
     * 
     * @param cpf CPF a ser validado
     * @return true se o CPF for válido, false caso contrário.
     */
    public boolean isCpfValido(String cpf) {
        // Remove caracteres não numéricos do CPF
        cpf = removerSimbolos(cpf);

        if (cpf.length() != 11) {
            return false;
        }

        int soma1 = somaAlgarismos(cpf, 0, 9);
        int d1 = calculaDigito(soma1);
        
        int soma2 = somaAlgarismos(cpf, 0, 10);
        int d2 = calculaDigito(soma2);

        // Converte os dígitos calculados de int para String e une (concatena) os dois
        // numa só String.
        String digVerificadorCalculado = String.valueOf(d1) + String.valueOf(d2);
        // Copia os 2 últimos dígitos do CPF informado, para comparar com os dígitos
        // calculados
        String digVerificadorExistente = cpf.substring(cpf.length() - 2, cpf.length());

        // Compara os 2 últimos dígitos do CPF com os 2 calculados. 
        // Se forem iguais, o CPF é válido.
        return digVerificadorExistente.equals(digVerificadorCalculado);
    }   
    
    public static void main(String[] args) {
        PessoaFisica pf = new PessoaFisica();
        //try == tentar
        try {
            pf.setCpf(null);
            System.out.println("CPF: " + pf.getCpf());
        //catch == capturar (capturar o erro)
        } catch(IllegalArgumentException erro){
            System.out.println(erro.getMessage());
        } catch(NullPointerException erro){
            System.out.println("O CPF não pode ser vazio.");
        }
        
        pf.setNome("Manoel");
        System.out.println("Nome: " + pf.getNome());
    }
}










