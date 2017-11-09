
public class Empresa
{
    private int codigo;
    String endereco;
    String cidade;
    String telefone;
    String email;
    String cnpj;
    boolean matriz;
    Funcionario gerente;
    
    Empresa(Funcionario gerente){
        setGerente(gerente);
    }
    
    void setGerente(Funcionario gerente){
        this.gerente = gerente;
    }
    
    Funcionario getGerente(){
        return gerente;
    }
    
    String getEndereco(){
        return endereco;
    }
    
    void setEndereco(String endereco){
        this.endereco = endereco;
    }
    
    boolean isMatriz(){
        return matriz;
    }
    
    boolean isFilial(){
        //returna true se a empresa não for matriz
        return !matriz;
    }
    
    void setMatriz(boolean matriz){
        this.matriz = matriz;
    }
}
