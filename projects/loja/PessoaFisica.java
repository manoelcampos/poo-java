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
     * Calcula 
     * @param totalAlgarismos número de algarismoa
     *        a serem usados para calcular um dígito do CPF
     */
    private int calculaDigito(String cpf, int totalAlgarismos){
        int dig = 0;
        int digito;
        for (int i = 0; i < totalAlgarismos; i++) {
            digito = Integer.valueOf(cpf.substring(i, i+1));
            dig = dig + (totalAlgarismos+1 - i) * digito;
        }

        int resto =  dig % 11;
        if (resto >= 2){
            dig = 11 - resto;
        }
        
        return dig;
    }
    
    public boolean isCpfValido(String cpf) {
        //Remove caracteres não numéricos do CPF
        cpf = cpf.replaceAll("\\D", "");

        if (cpf.length() != 11){
            return false;
        }

        int d1 = calculaDigito(cpf, 9);
        int d2 = calculaDigito(cpf, 10);

        //Converte os dígitos calculados de int para String e une (concatena) os dois numa só String.
        String digVerificadorCalculado = String.valueOf(d1) + String.valueOf(d2);
        //Copia os 2 últimos dígitos do CPF informado, para comparar com os dígitos calculados
        String digVerificadorExistente = cpf.substring(cpf.length()-2, cpf.length());

        //Compara os 2 últimos dígitos do CPF com os 2 calculados. Se forem iguais, o CPF é válido.
        return digVerificadorExistente.equals(digVerificadorCalculado);
    }       
}
