
public class Empresa
{
    private int codigo;
    private String endereco;
    private String cidade;
    String telefone;
    String email;
    String cnpj;
    Funcionario gerente;
    boolean matriz;
    
    Empresa(){
        this.cidade = "Palmas";
    }
    
    Empresa(Funcionario gerente){
        setGerente(gerente);
        gerente.setNome("José");
    }
    
    Funcionario getGerente(){
        return gerente;
    }
    
    void setGerente(Funcionario gerente){
        this.gerente = gerente;
    }
    
    boolean isMatriz(){
        return matriz;
    }
    
    void setMatriz(boolean matriz){
        this.matriz = matriz;
    }
    
    String getEndereco(){
        return endereco;
    }
    
    void setEndereco(String endereco){
        this.endereco = endereco;
    }
}
