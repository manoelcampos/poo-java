package br.com.manoelcampos.loja.geral;

import java.util.List;
import java.util.ArrayList;

public class Cidade
{
    private String nome;
    private Estado estado;    
    private List<Empresa> empresas;
    
    /**
     * Construtor padrão (que não recebe nenhum parâmetro) para instanciar uma Cidade .
     * Este é um método que usa polimorfismo estático (sobrecarga de método)
     * pois possui diferentes versões. Assim, dizemos que este é um método
     * sobrecarregado.
     */
    public Cidade(){ this.empresas = new ArrayList<>();}

    /**
     * Construtor para instanciar uma Cidade, já indicando o nome dela.
     * Este é um método que usa polimorfismo estático (sobrecarga de método)
     * pois possui diferentes versões. Assim, dizemos que este é um método
     * sobrecarregado.
     * @param nome nome da cidade
     */
    public Cidade(String nome){ 
        this();
        setNome(nome);
    }
    
    /**
     * Construtor para instanciar uma Cidade, já indicando o nome e estado dela.
     * Este é um método que usa polimorfismo estático (sobrecarga de método)
     * pois possui diferentes versões. Assim, dizemos que este é um método
     * sobrecarregado.
     * @param nome nome da cidade
     * @param estado estado a qual a cidade pertence
     */
    public Cidade(String nome, Estado estado){ 
        this(nome);
        setEstado(estado);
    }
    
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

