package br.com.manoelcampos.loja.geral;

import java.util.List;
import java.util.ArrayList;

public class Estado
{
    private String nome;
    private String uf;

    private List<Cidade> cidades;
    
    public Estado(){
        cidades = new ArrayList<>();
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setUf(String uf){
        this.uf = uf;
    }
    
    public List<Cidade> getCidades(){
        return cidades;
    }
      
    public void addCidade(Cidade cidade){
        cidades.add(cidade);
        cidade.setEstado(this);
    }
}
