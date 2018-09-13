/**
 * Devido precisarmos que um Cliente seja cadastrado como 
 * Funcionario ou vice-versa, o Cliente e Funcionario não herdam
 * mais de PessoaFisica. Veja mais detalhes na classe {@link Principal}.
 * Assim, para que o Cliente e Funcionario continuem tendo acesso 
 * aos dados da PessoaFisica (e consequentemente da Pessoa, pois PessoaFisica
 * ainda herda de Pessoas), precisamos criar uma associação normal
 * entre Cliente -> PessoaFisica e Funcionario -> PessoaFisica, 
 * incluindo um atributo pessoaFisica dentro da classe Cliente e Funcionario.
 * 
 * @author manoelcampos
 */
public class Cliente
{
    private double renda;
    private String celular;
    private String email;
    /**
     * Por meio deste atributo é que teremos acesso 
     * aos dados de PessoaFisica e Pessoa do Cliente.
     */
    private PessoaFisica pessoaFisica;
    
    /**
     * Como um Cliente deve obrigatoriamente estar relacionado a 
     * uma PessoaFisica, alteramos o construtor padrão
     * adicionando um parâmetro pessoaFisica (assim ele 
     * deixa de ser um construtor padrão). 
     * Desta forma, ao instanciar um cliente, precisaremos
     * dizer quem é a PessoaFisica que representa tal Cliente.
     * @param pessoaFisica 
     */
    public Cliente(PessoaFisica pessoaFisica){
        this.pessoaFisica = pessoaFisica;
    }
    
    public Cliente(PessoaFisica pessoaFisica, double renda){
        /**
         * Este construtor também recebeu um parâmetro pessoaFisica.
         * Assim, se chamarmos ele, teremos que indicar
         * qual é a PessoaFisica que representará tal Cliente
         * e qual a renda do cliente.
         * Como no outro construtor já temos a linha que pega um objeto PessoaFisica
         * por meio do parâmetro pessoaFisica e
         * armazena no atributo de mesmo nome, aqui neste construtor teríamos que
         * copiar e colar a linha this.pessoaFisica = pessoaFisica;
         * Como duplicação de código é algo que deve ser evitado a todo custo,
         * para evitar isso precisamos apenas lembrar que um construtor nada mais é que 
         * um método especial. Desta forma, um construtor pode chamar outro construtor.
         * Um método é chamado colocando-se seu nome, parênteses e os devidos parâmetros.
         * Se seguissemos esta lógica, para chamar o construtor anterior
         * precisaríamos incluir a linha Cliente(pessoaFisica);
         * Mas no caso de chamar construtores há algumas diferenças
         * em relação a chamar um método comum:
         * 1) no lugar de colocar o nome do construtor, colocamos this() e os
         *    devidos parâmetros dentro dos parênteses;
         * 2) um construtor só pode ser chamado desta forma dentro de outro construtor;
         * 3) tal chamada obrigatoriamente deve ser a primeira linha dentro do 
         *    construtor que está chamando o outro.
         */
        this(pessoaFisica);
        setRenda(renda);
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

    /**
     * @return the pessoaFisica
     */
    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }
}
