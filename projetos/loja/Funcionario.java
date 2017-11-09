public class Funcionario
{
    private String nome; 
    String cidade;
    String matricula;
    String cpf;
    String cargo;

    Funcionario(){
        this.cidade = "Palmas";
    }

    Funcionario(String nome, String cidade){
       setCidade(cidade);
       setNome(nome);
       this.cpf = "00000000000";
       this.matricula = "0";
    }    
    
    void setCidade(String cidade){
        this.cidade = cidade;
    }
    
    void setNome(String nome){
        this.nome = nome;
    }
    
    String getNome(){
        return nome;
    }
}
