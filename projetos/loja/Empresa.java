
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
    
    Empresa(){
        this.cidade = "Palmas";
        this.cnpj = "00000000000000";
    }
    
    Empresa(Funcionario gerente){
        setGerente(gerente);
        gerente.setNome("João");
    }
    
    void setGerente(Funcionario gerente){
        if(gerente.getNome().isEmpty()) {
            System.out.println("O gerente deve ter um nome.");
        }
        else {
            this.gerente = gerente;
        }
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
