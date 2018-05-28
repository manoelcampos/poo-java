
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
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setEstado(Estado estado){
        this.estado = estado;
    }
}

