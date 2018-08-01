package br.com.manoelcampos.loja.vendas;

import br.com.manoelcampos.loja.pessoas.Funcionario;
import br.com.manoelcampos.loja.pessoas.Cliente;
import java.util.List;
import java.util.ArrayList;

public class Venda
{
    private double valorTotal;
    private String data;
    private double percentualDesconto;
    private List<ItemVenda> itens;
    private Cliente cliente;
    private Funcionario funcionario;
    
    public Venda(){
        this.itens = new ArrayList<>();
    }
    
    /**
     * Adiciona um item à Venda,
     * que representa as informações de um Produto
     * em específico sendo vendido.
     * @param item item a ser adicionada à venda
     */
    public void addItem(ItemVenda item){
        this.itens.add(item);
    }
    
    public double getValorTotal(){ return valorTotal; }

    public void setValorTotal(double valorTotal){ 
        this.valorTotal = valorTotal; 
    }

    /**
     * Confirma a venda, reduzindo o estoque de cada um dos produtos vendidos.
     */
    public void confirmar(){
        for(ItemVenda item: itens){
           /*
            Aqui antes tínhamos a linha item.getProduto().removeEstoque(item.getQuantidade());
            Como incluímos uma nova versão para o método removeEstoque na classe Produto,
            que recebe um item de venda no lugar da quantidade do produto a ser removida,
            pudemos simplificar a linha como pode ver abaixo.
            Sempre que pudermos passar um objeto inteiro por parâmetro para
            um método, devemos fazé-lo. como é o caso abaixo onde passamos
            o item de venda inteiro no lugar de apenas a quantidade do item
            a ser removida do estoque.
            Fazendo isso, temos um código mais orientado a objetos,
            pois estamos sempre passando com objetos para métodos
            no lugar de passar dados de tipos primitivos como
            int, double e String (apesar de String ser uma classe,
            ela funciona em muito como um tipo primitivo, não obrigando
            o uso de new para criar uma String).
            
            O método que recebe uma quantidade no lugar do item de venda
            pode ser útil em outros lugares fora da venda, como
            em uma classe de inventário, que permite ajustar
            o estoque de um produto registrado no sistema
            com a quantidade de fato verificada que existe 
            nas dependências da empresa.
            
            No entanto, fique atento que receber dados de tipos primitivos
            no lugar de objetos inteiros pode trazer problemas.
            Um exemplo é se chamarmos a linha abaixo:
            
            item.getProduto().removeEstoque(item.getId());
            
            Esta linha pega o ID (código) do item de venda e passa para o método
            removerEstoque como se o ID representasse uma quantidade.
            Como existe uma versão do método que aceita um inteiro,
            o compilador não acusa nenhum erro, apesar de a linha
            não fazer sentido para o nosso sistema.
            Como o ID é int e o parâmetro quantidade do método removeEstoque
            também é, nada impede que nos enganemos e incluamos uma linha
            incorreta como a mostrada acima.
            Por isso é importante sempre buscar passar objetos no lugar de tipos primitivos.
            */ 
           item.getProduto().removeEstoque(item);
        }
    }
}
