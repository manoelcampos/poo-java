public class Funcionario extends PessoaFisica
{
    private String cargo;
    private String matricula;
    private double salario;
    private Empresa empresa;

    public String getCargo() {
        return cargo;
    }

    public String getMatricula() {
        return matricula;
    }

    public double getSalario() {
        return salario;
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
