
/**
 * Write a description of class Pessoa here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Pessoa
{
    private String nome;
    
    public String getNome(){ return nome; }
    
    public void setNome(String nome){  
        if(nome == null || nome.trim().isEmpty()){
            System.out.println("O nome é obrigatório"); 
        } else {
            this.nome = nome;
        }
    }
}
