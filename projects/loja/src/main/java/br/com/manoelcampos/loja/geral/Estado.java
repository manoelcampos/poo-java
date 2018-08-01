package br.com.manoelcampos.loja.geral;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Estado
{
    private String nome;
    private String uf;

    private List<Cidade> cidades;
    
    /**
     * Construtor padrão (que não recebe nenhum parâmetro) para instanciar um Estado.
     * Este é um método que usa polimorfismo estático (sobrecarga de método)
     * pois possui diferentes versões. Assim, dizemos que este é um método
     * sobrecarregado.
     */
    public Estado(){
        cidades = new ArrayList<>();
    }
    
    /**
     * Construtor para instanciar um Estado, já indicando o nome e UF dele.
     * Este é um método que usa polimorfismo estático (sobrecarga de método)
     * pois possui diferentes versões. Assim, dizemos que este é um método
     * sobrecarregado.
     * @param nome nome do estado
     * @param uf sigla do estado (Unidade Federativa) 
     */
    public Estado(String nome, String uf){
        this();
        setNome(nome);
        setUf(uf);
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
      
    /**
     * Adiciona uma única cidade na lista de Cidades do estado.
     * Este é um método que usa polimorfismo estático (sobrecarga de método)
     * pois possui diferentes versões. Assim, dizemos que este é um método
     * sobrecarregado.
     * @param cidade Cidade a ser adicionada.
     */
    public void addCidade(Cidade cidade){
        cidades.add(cidade);
        cidade.setEstado(this);
    }
    
    /**
     * Adiciona uma lista de cidades às Cidades do estado.
     * Este é um método que usa polimorfismo estático (sobrecarga de método)
     * pois possui diferentes versões. Assim, dizemos que este é um método
     * sobrecarregado.
     * @param cidades lista de Cidades a serem adicionadas nas cidades do estado.
     */
    public void addCidade(List<Cidade> cidades){
        for (Cidade cidade : cidades) {
            addCidade(cidade);
        }
    }
    
    /**
     * Adiciona uma quantidade indeterminada de cidades às Cidades do estado.
     * Este é um método que usa polimorfismo estático (sobrecarga de método)
     * pois possui diferentes versões. Assim, dizemos que este é um método
     * sobrecarregado.
     * @param cidades Cidades a serem adicionadas nas cidades do estado, que pode
     * ser um vetor de cidades ou cidades individuais (como cidade1, cidade2, cidadeN).
     */
    public void addCidade(Cidade... cidades){
        List<Cidade> lista = Arrays.asList(cidades);
        addCidade(lista);
    }
    
    /**
     * Método para podermos "testar" a implementação
     * dos métodos sobrecarregados addCidade (das diferentes versões deste método).
     * @param args 
     */
    public static void main(String[] args) {
        Estado tocantins = new Estado("Tocantins", "TO");

        Cidade palmas = new Cidade("Palmas", tocantins);
        Cidade paraiso = new Cidade("Paraíso", tocantins);
        Cidade porto = new Cidade("Porto Nacional", tocantins);
        Cidade gurupi = new Cidade("Gurupi", tocantins);
        Cidade araguaina = new Cidade("Araguaína", tocantins);
        Cidade dianopolis = new Cidade("Dianópolis", tocantins);
        Cidade guarai = new Cidade("Guaraí", tocantins);

        /*
        Aqui estamos chamando o método addCidade passando uma única
        Cidade. Como temos 3 versões de tal método, o compilador
        sabe que a versão a ser chamada será aquela que pede
        apenas um único parâmetro Cidade.
        */
        tocantins.addCidade(palmas);
        
        /*
        Aqui estamos criando uma lista de Cidades e chamando o método addCidade passando tal
        lista. Como temos 3 versões de tal método, o compilador
        sabe que a versão a ser chamada será aquela que pede
        uma Lista de Cidades.
        */
        List<Cidade> cidades = new ArrayList<>();
        cidades.add(paraiso);
        cidades.add(porto);
        cidades.add(gurupi);
        tocantins.addCidade(cidades);
        
        /*
        Aqui estamos chamando o método addCidade passando 3 cidades. 
        Como temos 3 versões de tal método, o compilador
        sabe que a versão a ser chamada será aquela que pede
        uma quantidade indefinida de Cidades.
        Tal versão é que que possui o parâmetro cidades
        declarado como Cidade... cidades (observe os 3 pontos que
        definiem que podemos passar quantas cidades desejarmos, inclusive
        um vetor de cidades no lugar das cidades individualmente
        separadas por vírgula).
        */
        tocantins.addCidade(araguaina, dianopolis, guarai);
        
        /*
        Por fim, vamos conferir a lista de todas as cidades
        adicionadas ao estado por meio das chamadas
        das 3 versões do método addCidade.
        */
        System.out.println("Estado: " + tocantins.getNome());
        for (Cidade cidade : tocantins.getCidades()) {
            System.out.println("\tCidade: " + cidade.getNome());
        }
        
        /*
        Mostra que não podemos adicionar qualquer objeto que não seja 
        uma Cidade à lista de Cidades.
        Se descomentar esta linha abaixo, o código não compila
        pois estamos tentando adicionar um Produto na lista de Cidades.
        Como usamos generics (polimorfismo paramétrico) ao declara 
        cidades, a lista só aceita objetos Cidade.
        */
        //cidades.add(new Produto());
        
        /*
        O código abaixo cria agora uma lista de Produtos,
        utilizando generics para indicar que a lista só aceita
        objetos Produto.
        Com generics (polimorfismo paramétrico),
        temos normalmente apenas uma versão de um método
        que funciona para qualquer tipo de dado.
        No caso da lista, o método que adiciona uma cidade à lista de cidades
        é o mesmo que permite adicionar um produto à lista de produtos.
        Não temos métodos diferentes (como no caso do polimorfismo ad hoc)
        para diferentes tipos de dados.
        Temos apenas uma versão do método add que funciona para adicionar
        qualquer tipo de elemento à uma lista.
        No entanto, com generics, se indicamos que a lista é de Produtos,
        o método add neste caso não permitirá adicionar qualquer outro 
        objeto que não seja um Produto.
        Se você alterar o tipo List para ArrayList na declaração da lista
        de cidades e produtos, segurar o control em qualquer linha
        que tenha cidades.add, verá que é aberto o código do método add
        do ArrayList.
        Se fizer o mesmo para produtos.add abaixo, verá que é NetBeans
        direciona para o mesmo código anterior, provando que a mesma versão
        do método add usado para adicionar uma cidade à lista de cidades 
        é a mesma para adicionar um produto à lista de produtos.
        */
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Arroz", 10));
        produtos.add(new Produto("Feijão", 50));
        System.out.println("\nProdutos");
        for (Produto produto : produtos) {
            System.out.println("\tProduto: " + produto.getDescricao() + " Estoque: " + produto.getEstoque());
        }
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the uf
     */
    public String getUf() {
        return uf;
    }
}
