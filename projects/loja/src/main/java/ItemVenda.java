
public class ItemVenda
{
    private Venda venda;

    private Produto produto;
    private int quantidade;  
    private double percentualDesconto;
    
    public int getQuantidade(){ 
        return quantidade; 
    }
    
    public void setQuantidade(int quantidade){ this.quantidade = quantidade; }
    
    public Produto getProduto(){ return produto; }
    public void setProduto(Produto produto){ this.produto = produto; }
    
}
