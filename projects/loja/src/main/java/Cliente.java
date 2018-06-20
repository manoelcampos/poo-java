public class Cliente extends PessoaFisica
{
    private double renda;
    private String celular;
    private String email;

    public Cliente(){
    }
    
    public Cliente(String nome, String cpf, char sexo){
        setNome(nome);
        setCpf(cpf);
        setSexo(sexo);
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
