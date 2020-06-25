
/**
 * Write a description of class Pessoa here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Pessoa
{
    private String nome;
    private Cidade cidade;
    private String endereco;
    private String telefone;
    
    public String getNome(){ return nome; }
    
    public void setNome(String nome){  
        if(nome == null || nome.trim().isEmpty()){
            System.out.println("O nome é obrigatório"); 
        } else {
            this.nome = nome;
        }
    }

    /**
     * @return the cidade
     */
    public Cidade getCidade() {
        return cidade;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
