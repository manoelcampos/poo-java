
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
