
/**
 * Write a description of class Empresa here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Empresa
{
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private String endereco;
    private String cidade;    
    private String telefone;
    private String site;
    private boolean matriz;

    /**
     * Define quem é o Funcionario que gerencia a Empresa.
     * (primeiramente, veja comentários no atributo Empresa na classe Funcionario)
     * 
     * Como o tipo do atributo gerente é uma classe e não primitivo,
     * ele representa um relacionamento entre as classes Empresa e Funcionario
     * (nesta direção: Empresa --> Funcionario).
     * 
     * Como detalhado na classe Funcionario,
     * o relacionamento entre objetos Empresa e Funcionario 
     * ocorre quando armazenamos um objeto Funcionario
     * no atributo gerente de um objeto Empresa.
     * Isto normalmente ocorre por meio de um setter.
     * No caso da classe Empresa, incluímos um construtor que
     * pergunta quem é o gerente no momento de criar uma Empresa.
     * Mas internamente, ele apenas chama o método setGerente para isso.
     * 
     * Como a classe Funcionario já possui um atributo Empresa,
     * definindo um relacionamento Funcionario --> Empresa,
     * com este atributo gerente dentro de Empresa estamos definindo
     * outra associação entre Empresa --> Funcionario.
     * Assim, no BlueJ ele mostra duas setas representando 
     * as associações nas duas direçãos.
     * 
     * A maioria das ferramentas mostra apenas uma seta com pontas duplas,
     * indicando que temos uma associação bi-direcional.
     * No entanto, para criar tal associação, precisamos tando incluir
     * um atributo do tipo Funcionario dentro de Empresa como
     * um atributo do tipo Empresa dentro de Funcionario.
     * 
     * Nem todas as associações precisam ser duplas e a direção é definida de acordo
     * com as necessidades. Se por exemplo, não precisassemos saber quem é o gerente de uma empresa,
     * poderíamos ter apenas a associação Funcionario --> Empresa, adicionando um atributo do tipo 
     * Empresa dentro da classe Funcionario. Assim, nossa associação seria uni-direcional.
     */
    private Funcionario gerente;
    
    public Empresa(){
        
    }
    
    public Empresa(Funcionario gerente){
        setGerente(gerente);
    }
    
    /**
     * Define quem é o gerente da empresa.
     * @param gerente funcionário a ser definido como gerente.
     */
    public void setGerente(Funcionario gerente){
        /*Se for tentando armazenar um funcionário que não existe (null),
        mostra uma mensagem de erro e finaliza a execução do método.
        Como este método não dá um returno (o tipo de retorno é void),
        ao incluir a instrução return; (sem nenhum valor depois de return),
        estamos indicando que desejamos sair da função, não executando
        nenhuma linha de código depois do return.
        Quando temos uma variável cujo tipo é uma classe,
        dizemos que tal variável é uma referência para um objeto
        que está armazenado em memória.
        Assim, uma variável de uma classe apenas contém o endereço
        de memória onde o objeto está.
        Se tal referência for null, significa que esta variável
        não faz referência a nenhum objeto existente.
        Assim, se tentarmos chamar um método ou acessar um atributo
        de uma variável cujo valor é null, receberemos um erro Null Pointer Exception.
        Para evitar que tais erros ocorram, estamos verificando se o gerente é null
        para então finalizar a execução da função, mostrando uma mensagem de erro
        amigável para o usuário.
        */
        if(gerente == null){
            System.out.println("O gerente não pode ser nulo.");
            return;
        }
        
        /* Neste projeto da loja virtual, definimos que um Funcionario só 
        pode ser gerente de uma única loja.
        Assim, na primeira condição verificamos se o gerente não está vinculado
        a empresa alguma (a empresa dele é null).
        Neste caso, poderemos então definir o Funcionario como gerente.
        Na segunda condição neste if, estamos verificando se o gerente (getGerente())
        desta empresa (this) é o próprio gerente que foi informado no setter.
        Isto indica que, por exemplo, o Manoel é o gerente desta empresa
        e alguém está tentando definir novamente o Manoel como gerente.
        Neste caso, estamos tentando trocar 6 por meia dúzia e não há problema algum
        em fazer isso. Desta forma, nesta condição, o código no if também será executado.
        Sem esta condição, se tentarmos definir o Manoel como gerente da empresa da qual ele já é
        gerente, o programa iria exibir a mensagem no else, indicando que o funcionário já é gerente
        de outra empresa. Mas na verdade, ele não é gerente de outra, mas sim da mesma empresa.
        Logo, para evitar essa mensagem indesejável e possivelmente confusa,
        incluímos esta segunda condição no if.

        Lembre-se que a palavra reservada this significa o objeto atual de uma determinada classe.
        Se temos um código dentro da classe Empresa que está utilizando this, 
        ele significa então "esta empresa".
        Como sabemos que os métodos são chamados a partir dos objetos (pelo menos os métodos
        que fizemos até agora), se este método setGerente for chamado a partir de um objeto
        empresa1, o this então significa "esta empresa", ou seja, a empresa1.
         */
        if(gerente.getEmpresa() == null || this.getGerente() == gerente){            
            this.gerente = gerente;
            gerente.setEmpresa(this);
            gerente.setCargo("Gerente");
        }
        else {
            System.out.println(
                "Este funcionário já é gerente de outra empresa.");
        }  
    }
    
    public Funcionario getGerente(){
        return gerente;
    }
    
    public void setMatriz(boolean matriz){
        this.matriz = matriz;
    }
    
    /**
     * Getter que informa o valor do atributo matriz.
     * Se a empresa for uma matriz, retorna true,
     * se for uma filial, retorna false.
     * 
     * Observe que o padrão para nomes de getters cujo atributo é do tipo
     * boolean (lógico), onde os valores possíveis são apenas verdadeiro (true)
     * ou falso (false) é: isNomeDoAtributo.
     */
    public boolean isMatriz(){
        return matriz;
    }
}
