
/**
 * A relação entre Venda e Produto é N..N, pois uma Venda
 * pode ter vários produtos (1..N) e um Produto pode
 * ser vendido várias vezes (1..N).
 * Ou seja, uma relação é definida como N..N quando
 * temos uma associação bi-direcional entre duas classes,
 * onde cada lado da associação é 1..N.
 * Como já sabemos, no BlueJ ele mostra associações bi-direcionais como duas associações
 * separadas.
 * 
 * Sempre que tivermos uma associação N..N, para implementar a mesma
 * precisamos criar uma terceira classe no meio das duas classes envolvidas
 * e assim relacionar tais classes com esta nova classe.
 * 
 * Por este motivo é que foi criada esta classe ItemVenda,
 * ela representa a associação N..N entre Venda e Produto.
 * Ao criar tal classe, ela deve ter então um atributo de cada uma das
 * classes da associação N..N.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class ItemVenda
{
    private Venda venda;

    /**
     * Observe que na primeira versão deste código,
     * tínhamos o produto e a quantidade dentro da venda.
     * Com isto, só conseguíamos vender um único produto por venda.
     * Mesmo que pudessemos vender várias unidades daquele produto,
     * não conseguíamos vender mais de um produto diferente.
     * 
     * Ao criar a classe ItemVenda, temos então
     * os produtos e suas respectivas quantidades
     * que foram vendidos em uma determinada Venda.
     * 
     * Sem essa classe ItemVenda, não conseguiríamos
     * resolver este problema.
     * Se tivessemos a quantidade vendida e o produto declarados dentro
     * da venda como Produto produto e int quantidade,
     * teríamos a quantidade para um único produto.
     * 
     * Você poderia imaginar que seria fácil resolver
     * criando uma lista de produtos e uma lista de quantidades dentro da Venda,
     * como:
     * 
     * List<Produto> produtos;
     * List<Integer> quantidades;
     * 
     * Apesar se possivelmente conseguir fazer isso funcionar,
     * você está tornando a solução muito complexa.
     * Por exemplo, criando estas duas listas, 
     * não temos como garantir automaticamente
     * que o número de elementos na lista produtos
     * seja igual ao da lista quantidades.
     * Se tivermos 10 produtos, precisamos ter 10 quantidades:
     * uma quantidade para cada um dos produtos.
     * 
     * Para garantir isso, precisaríamos escrever código.
     * Mesmo que existam 10 produtos e suas 10 quantidades,
     * não há totais garantias de que as quantidades estão
     * na mesmo ordem dos produtos, ou seja:
     * que a 1ª quantidade refere-se ao 1º produto e assim por diante.
     * Mais uma vez, precisaria escrever código para ter essa garantia.
     * Por fim, se incluírmos mais informações para um produto sendo vendido,
     * como por exemplo, o desconto concedido para um produto específico
     * em uma determinada venda, teríamos que criar outra
     * lista List<Double> descontos, complicando mais ainda a solução.
     * 
     * Assim, a solução de criar uma terceira classe para uma associação N..N é a mais 
     * simples e menos confusa possível, permitindo a evolução naturla do código
     * sem que o mesmo se torna uma completa confusão.
     * Com esta classe ItemVenda, se precisarmos adicionar
     * o desconto para um produto em uma determinada Venda,
     * basta incluir um atributo double desconto.
     * Desta forma, como um ItemVenda é referente a um único produto
     * de uma determinada Venda, o valor de quantidade e desconto
     * estarão relacionados a tal Produto específico de tal Venda.
     */
    private Produto produto;
    private int quantidade;    
    
    public int getQuantidade(){ return quantidade; }
    public void setQuantidade(int quantidade){ this.quantidade = quantidade; }
    
    public Produto getProduto(){ return produto; }
    public void setProduto(Produto produto){ this.produto = produto; }
    
}
