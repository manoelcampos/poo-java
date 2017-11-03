
/**
 * Write a description of class Cliente here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cliente
{
    String nome;
    String endereco;
    String cidade;
    String cpf;
    char sexo;
    float renda;
    String email;
    
    /*
     * Um construtor é um método especial
     * que não tem um tipo de retorno (nem mesmo void).
     * 
     * Ele é usado para inicializar os objetos criados,
     * por exemplo, definindo valores para alguns
     * de seus atributos.
     * 
     * Podemos ter mais de um construtor.
     * Quando um objeto é criado, algum(ns) desses construtores é chamado.
     * 
     * Ele deve ter exatamente o mesmo nome da classe
     * (com inicial maiúscula).
     * 
     * Um construtor que não possui parâmetros é 
     * chamado de construtor padrão.
    */    
    Cliente(){
        cidade = "Palmas";
    }
    
    Cliente(String nome, String cpf, String cidade){
        setNome(nome);
        setCpf(cpf);
        setCidade(cidade);
    }    
    
    void setNome(String nome){
        if(!nome.equals("")) {
            this.nome = nome;
        }
    }
    
    private void setCidade(String cidade){
        this.cidade = cidade;
    }
    
    void setEndereco(String endereco){
        this.endereco = endereco;
    }
    
    void setCpf(String cpf){
        if(cpfValido(cpf)){
            this.cpf = cpf;
        }
    }
    
    boolean cpfValido (String cpf)
    {
        cpf = cpf.replaceAll("\\.", "");
        cpf = cpf.replaceAll("-", "");
        if (cpf.length() != 11){
            return false;
        }

        int d1, d2;
        int digito1, digito2, resto;
        int digitoCPF;
        String nDigResult;
        d1 = d2 = 0;
        digito1 = digito2 = resto = 0;
        for (int nCount = 1; nCount < cpf.length() -1; nCount++) {
            digitoCPF = Integer.valueOf (cpf.substring(nCount -1, nCount)).intValue();
            //multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4 e assim
            //por diante.
            d1 = d1 + ( 11 - nCount ) * digitoCPF;
            //para o segundo digito repita o procedimento incluindo o primeiro digito
            //calculado no passo anterior.
            d2 = d2 + ( 12 - nCount ) * digitoCPF;
        }
        //Primeiro resto da divisão por 11.
        resto = (d1 % 11);
        //Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o
        //resultado anterior.
        if (resto <2)
            digito1 = 0;
        else
            digito1 = 11 - resto;
        d2 += 2 * digito1;
        //Segundo resto da divisão por 11.
        resto = (d2 % 11);
        //Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos
        //o resultado anterior.
        if (resto <2)
            digito2 = 0;
        else
            digito2 = 11 - resto;
        //Digito verificador do CPF que está sendo validado.
        String nDigVerific = cpf.substring (cpf.length()-2, cpf.length());
        //Concatenando o primeiro resto com o segundo.
        nDigResult = String.valueOf(digito1) + String.valueOf(digito2);
        //comparar o digito verificador do cpf com o primeiro resto + o segundo resto.
        return nDigVerific.equals(nDigResult);
    }    
}
