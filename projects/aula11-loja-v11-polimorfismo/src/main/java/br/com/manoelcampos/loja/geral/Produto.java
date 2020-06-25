package br.com.manoelcampos.loja.geral;

import br.com.manoelcampos.loja.vendas.ItemVenda;


/**
 * Write a description of class Produto here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Produto
{
    private double valor;
    private int codigo;
    
    private String descricao;
    private String marca;
    private String modelo;
    
    private int estoque;
    
    public Produto(){}
    
    public Produto(String descricao, int estoque){
        setDescricao(descricao);
        addEstoque(estoque);
    }
    
    /**
     * Adiciona uma quantidade no estoque, fazendo as verificações necessárias.
     * Com o uso de tal método no lugar de um setter, fica bem mais fácil
     * adicionar uma quantidade ao estoque, como por exemplo
     * produto.addEstoque(10), que adicionará 10 items do produto ao estoque
     * atual.
     * 
     * @param quantidade um valor positivo indicando a quantidade a ser adicionada.
     */
    public void addEstoque(int quantidade){
        if(quantidade < 0)
           System.out.println("A quantidade não pode ser negativa");
        else estoque += quantidade;
    }
    
    /**
     * Remove do estoque a quantidade indicada por um item de venda, fazendo as verificações necessárias.
     * Usando tal função no lugar de um setter, podemos remover facilmente
     * uma quantidade do estoque como produto.removeEstoque(5), que
     * verificará se há pelo menos 5 itens no estoque e os removerá.
     * 
     * <p>
     * Este é um método que usa polimorfismo estático (sobrecarga de método)
     * pois possui diferentes versões. Assim, dizemos que este é um método
     * sobrecarregado.
     * </p>
     * 
     * @param item item de venda cuja quantidade será removida do estoque
     */
    public void removeEstoque(ItemVenda item){
        removeEstoque(item.getQuantidade());
    }
    
    /**
     * Remove uma quantidade no estoque, fazendo as verificações necessárias.
     * Usando tal função no lugar de um setter, podemos remover facilmente
     * uma quantidade do estoque como produto.removeEstoque(5), que
     * verificará se há pelo menos 5 itens no estoque e os removerá.
     * 
     * <p>
     * Este é um método que usa polimorfismo estático (sobrecarga de método)
     * pois possui diferentes versões. Assim, dizemos que este é um método
     * sobrecarregado.
     * </p>
     * 
     * @param quantidade um valor positivo indicando a quantidade a ser removida.
     */
    public void removeEstoque(int quantidade){
        if (quantidade < 0){
            System.out.println("A quantidade não pode ser negativa");
            return;
        }

        if(estoque >= quantidade){
            estoque -= quantidade;
        }
        else {
            System.out.println(
                "Estoque insuficiente. Há apenas " + 
                estoque + " unidades disponíveis");
        }
    }    
    
    public String getDescricao(){ return descricao; } 
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public int getEstoque(){ return estoque; }
}
