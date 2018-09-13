import java.util.List;
import java.util.ArrayList;

public class Venda
{
    private double valorTotal;
    private String data;
    private double percentualDesconto;
    private List<ItemVenda> itens;
    private Cliente cliente;
    
    public Venda(){
        this.itens = new ArrayList<>();
    }
    
    /**
     * Adiciona um item à Venda,
     * que representa as informações de um Produto
     * em específico sendo vendido.
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
           item.getProduto().removeEstoque(item.getQuantidade());
        }
    }
}
