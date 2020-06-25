public class Cliente
{
    private String nome;
    private double renda;
    private String cpf;
    private String endereco;
    private String dataNascimento;
    private char sexo;
    private String celular;
    private String telefoneResidencial;    
    private String email;
       
    public Cliente(){
        
    }
    
    public Cliente(String nome, String cpf, char sexo){
        setNome(nome);
        this.cpf = cpf;
        this.sexo = sexo;
    }
  
    public String getNome(){ return nome; }
    
    public void setNome(String nome){  
        if(nome == null || nome.trim().isEmpty()){
            System.out.println("O nome é obrigatório"); 
        } else {
            this.nome = nome;
        }
    }
    
    public String getCpf(){ 
        return cpf; 
    }
    
    public void setCpf(String cpf) { 
        if(cpf == null || cpf.trim().isEmpty()){
            System.out.println("O CPF é obrigatório"); 
        } else {
            this.cpf = cpf;
        }

    }
    
    public char getSexo(){
        return sexo;
    }
    
    public void setSexo(char sexo){
        //O valor '\0' para variáveis char significa que a variável está vazia
        if(sexo == '\0' || sexo == ' '){
            System.out.println("Sexo é obrigatório"); 
        }
        else if(sexo != 'm' && sexo != 'f' && sexo != 'M' && sexo != 'F'){
            System.out.println("Sexo inválido"); 
        } else {
            this.nome = nome;
        }
        this.sexo = sexo;
    }

    public double getRenda(){
        return renda;
    }

    public void setRenda(double renda){
        if(renda >= 0) {
            this.renda = renda;
        } else {
            System.out.println("A renda não pode ser negativa!");
        }
    }
  
}
