
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
    /**
     * Na classe cidade, definimos
     * o estado a qual ela percente utilizando uma
     * classe Estado para isto.
     * Pelos mesmos motivos que inserimos um atributo chamado cidade
     * do tipo Cidade (e não String) dentro de Empresa.
     * Ao adicionar este atributo estado, estamos
     * criando um relacionamento Cidade --> Estado,
     * indicando que uma Cidade pertence a um Estado.
     */
    private Estado estado;
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setEstado(Estado estado){
        this.estado = estado;
    }
}

