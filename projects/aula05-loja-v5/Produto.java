
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
    /**
     * Indica a quantidade do produto que há em estoque.
     * Para este atributo, não temos um setter que altera seu
     * val seu valor diretamente.
     * A alteração do estoque do produto normalmente
     * ocorre pela adição ou removão de uma determinada
     * quantidade de tal estoque.
     * Por exemplo, ao usar um setter para remover uma quantidade do estoque,
     * precisaríamos primeiro obter o valor atual do estoque,
     * substrair a quantidade desejada e depois atribuir o novo
     * valor usando o setter, como:
     * 
     * produto.setEstoque(produto.getEstoque() - quantidade);
     * 
     * Observe que tal linha é extensa e sucesctível a erros.
     * A quantidade solicitada pode não estar disponível e assim
     * o estoque ficará negativo.
     * 
     * Neste caso, o setter não foi adicionado e os métodos
     * addEstoque e removeEstoque foram incluídos no lugar.
     * Tais métodos tornam mais fácil a manipulação do estoque.
     * Eles são utilizados dentro da classe venda, tornando o código
     * dentro da venda bastante simples e claro.
     * Além disso, o controle de estoque é responsabilidade da classe
     * Produto (ela que possui o atributo estoque).
     * Assim, seguindo o Princípio da Responsabilidade Única (Single Responsibility Principle, SRP)
     * dos princípios SOLID, cada classe deve ter apenas uma responsabilidade.
     * A responsabilidade da classe Produto é controlar produtos, incluindo o seu estoque.
     * A responsabilidade da classe Venda é controlar vendas, não controlar estoque de produtos.
     * Se tivessemos apenas um setEstoque na classe Produto,
     * ao realizar uma venda, a venda teria que se encarregar de incluir a lógica
     * para reduzir o estoque, fazendo algo como produto.setEstoque(produto.getEstoque() - quantidadeVendida).
     * 
     * Desta forma, estaríamos trazendo lógica que deveria estar dentro do Produto
     * para dentro da Venda, tornando o código da venda mais complexo.
     * Por fim, o código apresentando não está fazendo nenhuma validação.
     * Se fossemos inclur isto, o código ficaria ainda mais extenso. 
     * Logo, todo esse código deve estar aqui dentro do Produto.
     */
    private int estoque;
    
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
     * Remove uma quantidade no estoque, fazendo as verificações necessárias.
     * Usando tal função no lugar de um setter, podemos remover facilmente
     * uma quantidade do estoque como produto.removeEstoque(5), que
     * verificará se há pelo menos 5 itens no estoque e os removerá.
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
