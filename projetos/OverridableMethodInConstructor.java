/**
 * Testa as classes Funcionario e Gerente mostrando o
 * problema de chamar um método que pode ser modificado em uma
 * subclasse a partir do construtor da super classe.
 * 
 * Tal problema é referente ao Warning no NetBeans: "calling overridable method in constructor". 
 * O códibo abaixo apresenta os motivos de ferramentas como o NetBeans nos alertarem
 * quando usamos um método em um construtor onde tal método pode ser modificado em uma subclasse.
 * 
 * @author Manoel Campos da Silva Filho
 */
public class OverridableMethodInConstructor {
    public static void main(String args[]){
        /* Primeiro criamos um Funcionário regular,
         * que receberá salário mínimo de R$ 1000,00.
         * Ao imprimir o funcionário João, podemos ver que 
         * os dados são mostrados como esperado.
         */
        Funcionario funcionario = new Funcionario("João");
        System.out.println(funcionario);
        
        /** 
         * Agora criamos um Gerente, que é uma sub-classe de Funcionário.
         * De acordo com o que esperamos, um gerente padrão deve
         * ganhar um percentual de bônus sobre o salário mínimo definido
         * para os funcionários.
         * Todo gerente começa ganhando 10% sobre o salário mínimo,
         * como definido no construtor da classe Gerente.
         * 
         * Desta forma, o gerente Manoel deveria ganhar R$ 1100,00,
         * mas ao imprimir tal gerente, vemos que seu salário é de apenas R$ 1000,00,
         * mesmo que no construtor do Gerente tenhamos definido o percentual como 10%
         * e tenhamos modificado o método setSalario no Gerente para adicionar tal 
         * percentual ao salário.
         * 
         * Este é o problema que o NetBeans nos alerta.
         * Quando instanciamos um objeto de uma subclasse,
         * primeiro o construtor da superclasse é chamado para executar o código
         * que inicializa os atributos definidos na super classe.
         * Nossa super classe é Funcionário e a subclasse Gerente.
         * Assimm, ao criar um Gerente, primeiro este é inicializado como um Funcionário.
         * No entanto, dentro do construtor do Funcionário, temos a chamada do método setSalario.
         * Como este método foi modificado na subclasse Gerente, o construtor de Funcionário 
         * (por ter sido chamado para criar um Gerente), vai executar o método modificado no Gerente
         * e não o método original (pois se o método tem um comportamente diferente para gerentes,
         * tal método no Gerente é que deve ser executado).
         * Porém, quando o método setSalario é chamado no construtor de Funcionário,
         * apesar de ser chamada a versão do método definida no Gerente, os atributos
         * do gerente ainda não foram inicializados para que o método funcione como esperado.
         * O atributo percentualBonus definido somente no Gerente só é inicializado
         * depois que o construtor do Funcionário finaliza.
         * Assim, o valor do bônus será zero.
         * Por isso, mesmo o setSalario no gerente calculando o salário 
         * utilizando o percentual de bônus, como este não foi inicializado ainda,
         * não haverá diferença alguma no salário.
         * 
         * Somente depois de o construtor do Funcionário terminar, e o construtor do Gerente ser executado, 
         * é que o bônus é atribuído.
         * Isto fica bem claro com o print colocado dentro do método setSalario na classe Gerente, que mostra
         * o valor do bônus.
         * 
         * Outro print dentro do método setPercentualBonus da classe Gerente
         * mostra que somente depois que o salário do gerente é calculado, que o bônus de 10% 
         * é atribuído.
         */
        Gerente gerenteFilial = new Gerente("Manoel");
        System.out.println(gerenteFilial);

        /**
         * Este outro exemplo mostra que, para a Gerente Raysa, mesmo
         * definindo o bônus como 20%, o salário continua sem incluir tal bônus.
         */
        Gerente gerenteMatriz1 = new Gerente("Raysa");
        gerenteMatriz1.setPercentualBonus(20);
        System.out.println(gerenteMatriz1);

        /**
         * Por fim, este exemplo mostra que, apenas depois de redefinir
         * novamente o salário do Gerente Breno é que o bônus é incluído.
         * 
         * Todo este código mostra os problemas de se permitir alterar um método (fazer override) em uma
         * subclasse e ao mesmo tempo chamar tal método no construtor da super classe.
         * 
         * Para resolver tal problema temos algumas opções:
         * - colocar a palavra final na declaração da super classe, impedindoq que sejam criadas sub-classes: esta é uma solução
         *   que pode ser inviável para a maioria dos casos, uma vez que você realmente precisará criar sub-classes.
         * - colocar a palavra final na declaração do método que está sendo chamado no construtor da super-classe: isto vai impedir
         *   que o método seja modificado em sub-classes como Gerente. Normalmente esta é a solução mais simples.
         *   No entanto, fazendo isso você não teria mais como calcular o salário do gerente considerando o bônus.
         *   Porém, para resolver isto é muito simples: você não deve calcular o salário + bônus dentro do setSalario
         *   no Gerente (tal método nem vai existir mais lá). Você poderia alterar o nome do atributo para salarioMinimo,
         *   ter um setSalarioMinimo no Funcionario e um novo método getSalarioBruto().
         *   Tal método no Funcionário retornaria apenas o salário mínimo.
         *   No Gerente este método seria modificado para fazer o cálculo que estava sendo feito no setSalario no Gerente.
         *   Assim, como o getSalarioBruto() não seria chamado no construtor, não teríamos problemas.
         *   Além do mais, atributos normalmente não devem armazenar resultados de cálculos que dependam de outros atributos
         *   (a não ser que os cálculos sendo realizados sejam muito complexos e demandem bastante tempo de processamento
         *   e assim, precisem ser armazenadas para aumentar o desempenho do sistema).
         *   Se um atributo x é calculado a partir dos atributos y e z como x = x + y * z,
         *   problemas como o apresentado aqui podem ocorrer pois você definiu uma dependência da ordem
         *   em que tais atributos devem ser definidos: se for atribuído um valor para x antes de y e z,
         *   o valor final de x não será o esperado. 
         *   Quem for usar sua classe não saberá imediatamente que existe essa ordem de dependência entre os atributos.
         *   Normalmente ele só descobrirá quando erros como o mostrado aqui ocorrerem.
         *   Você até pode criar um construtor que obrigado que x, y e z sejam definidos ao criar objetos da classe.
         *   Mas mesmo dentro do construtor o mesmo problema pode ocorrer: se você receber os valores para x, y e z
         *   e atribuir primeiro o valor do parâmetro x ao atributo x, terá exatamente o mesmo problema.
         * 
         *   Assim, a melhor maneira é realizar qualquer cálculo necessário nos getters e não nos setters.
         *   Em POO, deve-se inicializar todos os atributos necessários de um objeto antes de começar a usá-lo.
         *   No caso do exemplo do Gerente, deve-se definir o salário e o bônus (caso não sejam definidos por padrão
         *   ou precise-se realmente alterar tais valores). Somente depois que os atributos obrigatórios são inicializados
         *   é que o objeto estará pronto para uso. A partir daí, podemos então começar a usar o objeto
         *   chamado seus outros métodos que não sejam setters, como no caso do getter para obter os salário bruto.
         */
        Gerente gerenteMatriz2 = new Gerente("Breno");
        gerenteMatriz2.setPercentualBonus(20);
        gerenteMatriz2.setSalario(1000);
        System.out.println(gerenteMatriz2);
    }
}

/**
 * Representa um funcionário de uma empresa, cujo
 * um salário mínimo é definido para qualquer funcionário criado.
 * 
 * O salário mínimo é definido automaticamente dentro do construtor
 * da classe.
 */
class Funcionario {
    private String nome;
    private double salario;

    /**
     * Cria um funcionário e define o salário mínimo.
     * Todos os funcionários terão inicialmente o mesmo
     * salário.
     */
    public Funcionario(String nome){
        setNome(nome);
        setSalario(1000);
    }

    /**
     * Define um salário diferente do padrão
     * para um funcionário.
     */
    public void setSalario(double salario){
        this.salario = salario;
    }

    public double getSalario(){
        return salario;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    /**
     * Permite fazer um print em um funcionário e assim exibir os dados
     * que desejarmos desse funcionário em uma só vez.
     * Assim, sempre que precisarmos imprimir um funcionário,
     * podemos utilizar uma única linha de código para isso.
     */
    public String toString(){
        return String.format("%s %s. Salário: %.2f\n", getClass().getSimpleName(), nome, salario);
    }
}

/**
 * Representa um gerente da empresa, cujo salário mínimo 
 * é inicialmente igual ao dos outros funcionários, mas
 * com um percentual de bônus definido para cada gerente.
 */
class Gerente extends Funcionario {
    /**
     * Percentual de bônus a ser adicionado ao salário do gerente,
     * numa escala de 0 a 100.
     */
    private double percentualBonus;

    /**
     * Cria um Gerente, definindo que o percentual de bônus 
     * que ele ganhará sobre o salário mínimo definido 
     * para todos os funcionários será de 10%.
     */
    public Gerente(String nome){
        super(nome);
        this.setPercentualBonus(10);
    }

    public void setPercentualBonus(double percentualBonus){
        System.out.printf("Bônus para %s %s definido como %.0f%%\n", getClass().getSimpleName(), getNome(), percentualBonus);        
        this.percentualBonus = percentualBonus;
    }
    
    /**
     * Define um salário diferente do padrão
     * para um gerente, sendo que tal salário será acrescido
     * do percentual de bônus.
     */
    public void setSalario(double salario){
        System.out.printf("Calculando salário do %s %s com bônus %.0f\n", getClass().getSimpleName(), getNome(), percentualBonus);
        super.setSalario(salario + salario*percentualBonus/100);
    }    
}
