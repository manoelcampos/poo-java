
/**
 * Write a description of class Funcionario here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Funcionario
{
    private String nome;
    private String cargo;
    private String matricula;
    private String dataNascimento;
    private String cpf;
    private double salario;
    private char   sexo;
    
    /**
     * Define a Empresa para qual o funcionário trabalho.
     * Como o tipo do atributo é uma classe e não um tipo primitivo,
     * estamos criando um relacionamento entre a classe Funcionario
     * (onde estamos) e a classe Empresa (classe que representa o atributo empresa).
     * Um relacionamento entre duas classes indica que objetos de tais classes
     * podem estar relacionados. 
     * 
     * Assim, quando criarmos um objeto Funcionario, podemos
     * definir uma relação com um objeto Empresa, para indicar
     * a qual empresa o Funcionario trabalha.
     * 
     * Ao incluírmos o atributo empresa dentro da classe Funcionario,
     * estamos apenas definindo o relacionamento entre as classes.
     * Para que, ao criar um objeto Funcionario, este possa se relacionar
     * com um objeto Empresa, precisamos de código para isto.
     * 
     * A forma mais básica de permitir que dois objetos se relacionem
     * é incluir um setter para o atributo representando tal relacionamento.
     * Como já temos um método setEmpresa, a partir do momento que chamarmos
     * ele, estaremos relacionando um objeto Funcionario com um objeto Empresa.
     * 
     * Os relacionamentos entre classes possuem uma direção, que nas ferramentas
     * de análise e desenvolvimento de sistemas, tal direção é representada por uma seta.
     * Observando o diagrama de classes no BlueJ, podemos ver que há uma seta partindo
     * da classe Funcionario para Empresa. A direção da seta foi definida desta forma
     * pois é a partir do Funcionario que teremos acesso à Empresa onde ele trabalha.
     * 
     * O Funcionario é que tem um atributo do tipo Empresa, logo, a direção da seta parte
     * de Funcionario. Esta direção é chamada em POO de navegação, ela indica qual a direção
     * em que conseguimos navegar dentro de uma associação.
     * 
     * A navegação pode ser em uma única direção (por exemplo somente de Funcionario para Empresa)
     * ou dupla (de Empresa para Funcionario também). Veja os comentários na classe Empresa
     * para mais detalhes.
     */
    private Empresa empresa;
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setCargo(String cargo){
        this.cargo = cargo;
    }
    
    public Empresa getEmpresa(){
        return empresa;
    }
    
    public void setEmpresa(Empresa empresa){
        this.empresa = empresa;
    }
    
}
