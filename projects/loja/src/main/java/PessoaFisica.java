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
    
    public void setCpf(String cpf) { 
        if(cpf == null || cpf.trim().isEmpty()){
            System.out.println("O CPF é obrigatório"); 
        } else if(!isCpfValido(cpf)) {
            System.out.println("O CPF é inválido"); 
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
     * Calcula um dígito verificador de um CPF ou CNPJ utilizando o algoritmo módulo
     * 11
     * 
     * @param totalAlgarismos número de algarismos a serem usados para calcular um
     *                        dígito do CPF
     * @return o dígito verificador calculado
     */
    private int calculaDigito(String cpf, int totalAlgarismos) {
        int soma = 0;
        int algarismo;
        for (int i = 0; i < totalAlgarismos; i++) {
            algarismo = Character.getNumericValue(cpf.charAt(i));
            soma += (totalAlgarismos + 1 - i) * algarismo;
        }

        int dig = 11 - (soma % 11);
        /*
         * O código abaixo é o mesmo que: 
         * if(dig > 9) 
         *   return 0; 
         * else return dig;
         */
        return dig > 9 ? 0 : dig;
    }

    /**
     * Verifica se um CPF é válido ou não, utilizando o algorítmo denominado Módulo
     * 11, como descrito em
     * https://pt.wikipedia.org/wiki/Dígito_verificador#Módulo_11.
     * 
     * @param cpf CPF a ser validado
     * @return true se o CPF for válido, false caso contrário.
     */
    public boolean isCpfValido(String cpf) {
        // Remove caracteres não numéricos do CPF
        cpf = cpf.replaceAll("\\D", "");

        if (cpf.length() != 11) {
            return false;
        }

        int d1 = calculaDigito(cpf, 9);
        int d2 = calculaDigito(cpf, 10);

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
}
