
/**
 * Write a description of class Empresa here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Empresa
{
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private String endereco;
    /**
     * Na versão anterior, estavamos armazenando o nome da cidade como String,
     * para sabermos em qual cidade a empresa está situada.
     * No entanto, utilizar String para armazenar determinados dados
     * pode gerar alguns problemas como:
     * 1) Se na interface da aplicação o usuário tiver que digitar o nome
     *    da cidade, ele pode digitar o nome incorretamente, usar ou não usar acentos,
     *    abreviar o nome da cidade, etc.
     *    Por exemplo, um usuário poderia digitar o nome da mesma cidade como
     *    Paraíso enquanto outro poderia digitar Paraíso do Tocantins.
     *    Isto traria problemas, por exemplo, ao gerar um relatório com o total
     *    de empresas por cidade.
     *    No entanto, tal problema é fácil de resolver, adicionando uma lista
     *    na interface da aplicação, onde o usuário apenas escolhe o nome da cidade.
     * 2) Apesar do problema anterior poder ser facilmente resolvido,
     *    o próprio desenvolvedor poderia inserir uma lista que possui nomes
     *    errados. Assim, uma vez que várias empresas foram cadastradas 
     *    como sendo de uma destas cidades cujo nome está errado,
     *    para corrigir, será preciso alterar o cadastro de todas estas empresas
     *    envolvidas. 
     * 3) Mesmo que os problemas acima aindam podem ser resolvidos, 
     *    armazenar o nome da cidade na Empresa ainda tem problemas como
     *    dificultar a identificação de informações adicionais da cidade,
     *    como a qual estado ela pertence. Alguém poderia sugerir que a sigla
     *    do estado fosse colocada juntamente com o nome da cidade.
     *    Porém, se temos um sistema que exibe as cidades de todo o país,
     *    o usuário terá uma lista absurdamente longa para procurar a cidade
     *    desejada nela. 
     * 
     * Com os problemas apresentados, como estamos utilizando POO,
     * devemos lembrar que Cidade pode ser representada como um objeto, ou seja,
     * podemos criar uma classe Cidade.
     * Ao fazer isso, a Empresa não armazena mais o nome da cidade, mas sim
     * uma referência para um objeto da classe Cidade.
     * A mesma cidade pode ser reutilizada no cadastro de diferentes empresas,
     * funcionários, clientes ou qualquer classe que necessite de um relacionamento
     * com cidade.
     * Se alterarmos o nome da cidade, estaremos fazendo isso em um único lugar:
     * dentro de um objeto da classe cidade, que pode estar sendo utilizado
     * em relacionamentos com diversos outros objetos.
     * Desta forma, como não temos o nome da cidade armazenado em nenhuma outra classe
     * exceto a própria Cidade, se alterarmos tal nome, todos os objetos relacionados
     * com tal objeto cidade podem ver automaticamente tal alteração.
     */
    private Cidade cidade;    
    private String telefone;
    private String site;
    private boolean matriz;
    
  
    private Funcionario gerente;
    
    public Empresa(){

    }
    
    public Empresa(Funcionario gerente){
        setGerente(gerente);
    }
    
    public void setCidade(Cidade cidade){
        this.cidade = cidade;
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
