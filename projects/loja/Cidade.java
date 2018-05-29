import java.util.ArrayList;

/**
 * A classe Cidade contém apenas os atributos que definimos como essenciais
 * para o nosso sistema da loja.
 * Dados como quem é o prefeito, qual a população ou área não são necessários
 * para o nosso modelo de cidade.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cidade
{
    private String nome;
    private Estado estado;    
    private ArrayList<Empresa> empresas;
    
    public String getNome(){ return nome; }
    
    public void setNome(String nome){ this.nome = nome; }
    
    public Estado getEstado(){ return estado; }
    
    public void setEstado(Estado estado){ this.estado = estado; }
    
    public ArrayList<Empresa> getEmpresas(){
        return empresas;
    }

    public void addEmpresa(Empresa empresa){
        empresas.add(empresa);
    }
    
}

