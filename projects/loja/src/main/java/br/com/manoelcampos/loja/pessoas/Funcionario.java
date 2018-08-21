package br.com.manoelcampos.loja.pessoas;

import br.com.manoelcampos.loja.geral.Empresa;
import java.util.ArrayList;
import java.util.List;

/**
 * Ver comentários na classe {@link Cliente}.
 * @author manoelcampos
 */
public class Funcionario
{
    private String cargo;
    private String matricula;
    private double salarioBase;
    private Empresa empresa;
    private PessoaFisica pessoaFisica;

    public Funcionario(PessoaFisica pessoaFisica){
        this.pessoaFisica = pessoaFisica;
    }

    public String getCargo() {
        return cargo;
    }

    public String getMatricula() {
        return matricula;
    }

    public double getSalarioBase() {
        return salarioBase;
    }
    
    public double getSalarioTotal(){
        return getSalarioBase();
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }
    
    public void setCargo(String cargo){
        this.cargo = cargo;
    }
    
    public Empresa getEmpresa(){
        return empresa;
    }
    
    public void setEmpresa(Empresa empresa){
        this.empresa = empresa;
    }

    /**
     * @param salarioBase the salarioBase to set
     */
    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }
}
