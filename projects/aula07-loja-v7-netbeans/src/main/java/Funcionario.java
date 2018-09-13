
/**
 * Funcionario é uma classe filha de PessoaFisica
 * e neta de Pessoa, assim como a Cliente.
 * Tudo que foi tido sobre a classe Cliente vale para a Funcionario.
 * Então, podemos dizer que Cliente e Funcionario são classes irmãs.
 * No entanto, diferente da biologia, onde os irmãos podem
 * ter comportamentos e aparência (características) diferentes,
 * onde um irmão herda coisas que outro não herdou,
 * na POO, todos os irmãos herderão tudo aquilo que 
 * a classe mãe e superiores tiverem para disponibilizar
 * (tudo que for public ou protected).
 * 
 * Na biologia, gêmos podem ter comportamentos e aparência diferentes,
 * um pode ter herdado algo que o outro não herdou.
 * Mesmo gêmeos idênticos tendo a mesma aparência, eles podem ter herdado
 * diferentes comportamentos de cada um dos pais.
 * 
 * Na POO, os irmãos vão herdar todos os comportamentos e características
 * que a classe mãe e superiores tem a oferecer. A herança não é seletiva
 * como na biologia.
 * 
 * No entanto, cada classe irmã pode definir seus próprios comportamentos
 * e características. Por exemplo, o Funcionario pode ter os atributos matrícula
 * e cargo que o Cliente não tem. 
 * 
 * A questão é que, se na biologia os irmãos são sempre diferentes
 * de alguma forma, na programação não necessariamente.
 * Podemos ter as classes Cliente e Funcionario que são filhas de PessoaFisica,
 * herdando tudo que a classe mãe tem a oferecer, mas que poderiam
 * não ter nada de diferente, que seja específico de cada uma.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Funcionario extends PessoaFisica
{
    private String cargo;
    private String matricula;
    private double salario;
    private Empresa empresa;
        
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
