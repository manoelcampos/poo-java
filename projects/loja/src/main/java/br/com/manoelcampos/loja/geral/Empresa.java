package br.com.manoelcampos.loja.geral;


import br.com.manoelcampos.loja.pessoas.Funcionario;
import br.com.manoelcampos.loja.pessoas.PessoaJuridica;


public class Empresa extends PessoaJuridica
{
    private boolean matriz;    
    private Funcionario gerente;
    
    public Empresa(){

    }
    
    public Empresa(Funcionario gerente){
        setGerente(gerente);
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
