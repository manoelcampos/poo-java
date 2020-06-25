package br.com.manoelcampos.loja.geral;

import java.util.List;
import java.util.ArrayList;

public class Cidade
{
    private String nome;
    private Estado estado;    
    private List<Empresa> empresas;
    
    public Cidade(){ this.empresas = new ArrayList<>();}
    
    public String getNome(){ return nome; }
    
    public void setNome(String nome){ this.nome = nome; }
    
    public Estado getEstado(){ return estado; }
    
    public void setEstado(Estado estado){ this.estado = estado; }
    
    public List<Empresa> getEmpresas(){
        return empresas;
    }

    public void addEmpresa(Empresa empresa){
        empresas.add(empresa);
    }
}

