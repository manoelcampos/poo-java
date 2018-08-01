package br.com.manoelcampos.loja.pessoas;

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
     * O atributo peso não faz sentido numa loja virtual, foi incluído apenas
     * como demonstração de um atributo inteiro.
     */
    private int pesoGramas;
    
    /**
     * Por meio deste atributo é que teremos acesso 
     * aos dados de PessoaFisica e Pessoa do Cliente.
     */
    private PessoaFisica pessoaFisica;
    
    /**
     * Construtor para instanciar um Cliente, já indicando qual a {@link PessoaFisica} relacionada a ele.
     * Este é um método que usa polimorfismo estático (sobrecarga de método)
     * pois possui diferentes versões. Assim, dizemos que este é um método
     * sobrecarregado.
     * @param pessoaFisica {@link PessoaFisica}  que representa o Cliente
     */    
    public Cliente(PessoaFisica pessoaFisica){
        this.pessoaFisica = pessoaFisica;
    }
    
    /**
     * Construtor para instanciar um Cliente, já indicando a renda do cliente e qual a {@link PessoaFisica} relacionada a ele.
     * Este é um método que usa polimorfismo estático (sobrecarga de método)
     * pois possui diferentes versões. Assim, dizemos que este é um método
     * sobrecarregado.
     * @param pessoaFisica {@link PessoaFisica}  que representa o Cliente
     * @param renda renda do cliente
     */    
    public Cliente(PessoaFisica pessoaFisica, double renda){
        this(pessoaFisica);
        setRenda(renda);
    }
    
    /**
     * Construtor para instanciar um Cliente, já indicando o peso (em gramas) do cliente e qual a {@link PessoaFisica} relacionada a ele.
     * Este é um método que usa polimorfismo estático (sobrecarga de método)
     * pois possui diferentes versões. Assim, dizemos que este é um método
     * sobrecarregado.
     * @param pessoaFisica {@link PessoaFisica}  que representa o Cliente
     * @param pesoGramas  peso (em gramas) do cliente
     */    
    public Cliente(PessoaFisica pessoaFisica, int pesoGramas){
       this(pessoaFisica); 
        setPesoGramas(pesoGramas);
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
    
    /**
     * @return the pesoGramas
     */
    public int getPesoGramas() {
        return pesoGramas;
    }

    /**
     * @param pesoGramas the pesoGramas to set
     */
    public void setPesoGramas(int pesoGramas) {
        this.pesoGramas = pesoGramas;
    }
    
    /**
     * Mostra o uso das versões sobrecarregadas (overloaded) dos
     * construtores da classe Cliente.
     * @param args 
     */
    public static void main(String[] args) {
        //Cria uma PessoaFisica informando o CPF
        PessoaFisica pf = new PessoaFisica("11111111111");
        
        /*
        Cria um cliente usando a versão do construtor que recebe apenas uma pessoa física.
        O compilador sabe que é esta a versão do construtor a ser chamada pois
        estamos passando um objeto pessoa física por parâmetro.
        */
        Cliente cliente1 = new Cliente(pf);

        /*
        Cria um cliente usando a versão do construtor que recebe uma pessoa física
        e a renda do cliente.
        O compilador sabe que é esta a versão do construtor a ser chamada pois
        estamos passando um objeto pessoa física e em seguida um número real.
        Assim, a versão que espera um número real é aquela que solicita a renda
        do cliente. Se simplesmente tocarmos o tipo da variável renda de double
        para int, teremos um problema pois acharemos que estamos passando um valor
        para ser armazenado no atributo renda, enquanto estaremos chamando 
        o construtor que recebe um valor para ser armazenado no atributo
        pesoGramas. Com isto, o valor que esperávamos que fosse armazenado na renda
        será incorreta e inesperadamente armazenado no atributo pesoGramas.
        Basta alterar o tipo da variável renda para int e rodar o programa
        para ver o problema: no lugar da renda aparecer como 2000 e o peso como 0,
        os valores aparecerão incorretamente invertidos.
        
        Logo, é preciso entender que o compilador vai saber qual método deve chamar
        de acordo com a quantidade e tipo de parâmetros passados.
        */
        double renda = 2000;
        Cliente cliente2 = new Cliente(pf, renda);
        System.out.println("Cliente 2");
        System.out.println("\tRenda: " +  cliente2.getRenda());
        System.out.println("\tPeso em Gramas: " +  cliente2.getPesoGramas());
        
        int pesoGramas = 80000;
        Cliente cliente3 = new Cliente(pf, pesoGramas);
        System.out.println("\nCliente 3");
        System.out.println("\tRenda: " +  cliente3.getRenda());
        System.out.println("\tPeso em Gramas: " +  cliente3.getPesoGramas());
        
    }

    
}
