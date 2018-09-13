public class Cliente
{
    private String nome;
    private double renda;
    private String cpf;
    private String endereco;
    private String dataNascimento;
    private char sexo;
    private String celular;
    private String telefoneResidencial;    
    private String email;
    
    /**
     * Construtores são métodos especiais que permitem 
     * criar objetos de uma determinada classe.
     * O processo de criação de um objeto é chamado de instanciação.
     * 
     * A estrutura de um construtor deve obrigatoriamente ser
     * 
     * NomeDaClasse(parâmetros opcionais){
     * }
     * 
     * Observe que mesmo sendo um método, ele não tem um tipo
     * de retorno, nem mesmo void.
     */
    public Cliente(){
        
    }
    
    /**
     * Podemos ter quantos construtores desejarmos em uma classe.
     * Cada construtor é responsável por criar e inicializar os atributos
     * do objeto criado de uma maneira diferente.
     * Por exemplo, podemos ter construtores que não inicializam
     * nenhum atributo (que é o caso do construtor acima).
     * Caso tenhamos vários construtores, estes devem ser diferentes
     * no total, tipo e/ou ordem dos parâmetros.
     * Este construtor cria um Cliente e já inicializa
     * os atributos nome, cpf e sexo com os valores passados por parâmetro.
     * 
     * No caso dos construtores que possuem parâmetros para inicializar os atributos,
     * dentro do código dos construtores, tais atributos não devem
     * ser inicializados diretamente, por meio de uma instrução
     * de atribuição como this.cpf = cpf, como mostrado abaixo.
     * Eles devem ser inicializados utilizando-se o setter do atributo.
     * Ao utilizar a instrução exemplificada acima para inicializar o atributo
     * cpf, estamos duplicando a mesma linha de código existente no método setCpf,
     * mas deixando de executar qualquer validação que tal setter possua.
     * 
     * Assim, no código abaixo, a inicialização do atributo nome
     * está sendo feita utilizando-se o setNome, mas do cpf e sexo
     * não estão sendo feitas utilizando os respectivos setters.
     * O código então deve ser alterado para chamar tais setters no lugar 
     * de atribuir um valor diretamente para tais atributos.
     */
    public Cliente(String nome, String cpf, char sexo){
        setNome(nome);
        this.cpf = cpf;
        this.sexo = sexo;
    }
  
    /**
     * Os métodos que obtém o valor de um atributo são chamados de getters.
     */
    public String getNome(){ return nome; }
    
    /**
     * Os métodos que alteram o valor de um atributo são chamados de setters.
     */
    public void setNome(String nome){  
        if(nome == null || nome.trim().isEmpty()){
            System.out.println("O nome é obrigatório"); 
        } else {
            this.nome = nome;
        }
    }
    
    public String getCpf(){ 
        return cpf; 
    }
    
    public void setCpf(String cpf) { 
        if(cpf == null || cpf.trim().isEmpty()){
            System.out.println("O CPF é obrigatório"); 
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
        } else {
            this.nome = nome;
        }
        this.sexo = sexo;
    }

    public double getRenda(){
        return renda;
    }

    public void setRenda(double renda){
        if(renda >= 0) {
            this.renda = renda;
        } else {
            System.out.println("A renda não pode ser negativa!");
        }
    }
  
}
