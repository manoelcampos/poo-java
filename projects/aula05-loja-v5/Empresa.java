
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
    
    private Cidade cidade;    
    private String telefone;
    private String site;
    private boolean matriz;
    
  
    private Funcionario gerente;
    
    public Empresa(){

    }
    
    public Empresa(Funcionario gerente){
        setGerente(gerente);
    }
    
    public void setCidade(Cidade cidade){
        this.cidade = cidade;
    }
    
    public void setGerente(Funcionario gerente){
        if(gerente == null){
            System.out.println("O gerente não pode ser nulo.");
            return;
        }

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
    
    public boolean isMatriz(){
        return matriz;
    }
}
