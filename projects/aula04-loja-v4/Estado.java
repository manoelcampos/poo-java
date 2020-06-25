import java.util.List;
import java.util.ArrayList;

/**
 * Um estado percente a um país. Assim como criamos
 * a classe Estado, poderíamos ir adiante e criar uma classe
 * Pais (lembre que não é aconselhável usar acentos)
 * para indicar a qual país o estado percente.
 * No entanto, não fizemos isso pois nosso sistema não tem
 * essa necessidade. A nossa loja só vende dentro do Brasil,
 * pelo menos por enquanto (lembre-se do princípio YAGNI).
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Estado
{
    private String nome;
    private String uf;
    /**
     * Observe que já tínhamos criado um relacionamento Cidade --> Estado, indicando
     * que, a partir da Cidade, podemos saber a qual Estado ela pertence. No
     * entanto, aqui na classe Estado, estamos criando outro relacionamento no
     * sentido contrário: de Estado para Cidade, para permitir, a partir do Estado,
     * sabermos quais as cidades que o compoem. Desta forma, estamos criando um
     * relacionamento bi-direcional Cidade <--> Estado, que no BlueJ é mostrado como
     * dois relacionamentos individuais (cada um em um sentido).
     * 
     * Relacionamentos bi-direcionais só devem ser criados se o seu sistema precisar
     * disto. No nosso caso, definimos que é necessário saber, a partir de um
     * Estado, quais são as cidades que ele possui. No entanto, a criação deste
     * relacionamento é um pouco mais complicada que os outros já criados. Para
     * criar os outros, nós intuitivamente inferimos uma informação que na análise
     * de sistema é chamado de Cardinalidade ou Multiplicidade. Tal conceito indica
     * a quantidade mínima e máxima de objetos envolvidos em uma associação entre
     * duas classes. Observe que o conceito se aplica aos objetos na associação e
     * não às classes. O relacionamento entre duas classes é definido ao criar as
     * classes, mas um relacionamento só acontece no momento que criamos objetos de
     * tais classes e os relacionamos.
     * 
     * A cardinalidade deve indicar, por exemplo, que em um relacionamento entre
     * Cidade --> Estado, podemos ter 1 objeto Cidade relacionado com 1 único objeto
     * Estado, pois uma cidade pertence a no mínimo e no máximo 1 estado. O outro
     * lado porém, entre Estado --> Cidade, a cardinalidade é diferente: um Estado
     * pode ter várias Cidades, o que chamamos de N Cidades.
     * 
     * Assim, a cardinalidade entre Estado --> Cidade é 1 para N (representada como
     * 1..N). No BlueJ, não temos como representar visualmente as cardinalidades das
     * associações. Normalmente, apenas as chamadas ferramentas CASE para a
     * linguagem UML possuem tal recurso.
     * 
     * A cardinalidade de uma associação pode não ser óbvia. Se não foi você quem
     * desenvolveu o diagrama de classes e tais cardinalidades não foram
     * representadas, é preciso solicitar à equipe ou o responsável pela elaboração
     * do diagrama para incluí-las. No caso de Estado --> Cidade, a cardinalidade é
     * obviamente 1..N. Nos relacionamentos 1..1 como Cidade --> Estado, tivemos que
     * apenas incluir um atributo Estado dentro da classe Cidade. Assim, a lógica é:
     * inclui-se um atributo do tipo da classe de destino (onde a seta chega),
     * dentro da classe de origem (de onde a seta parte). Já os relacionamentos 1..N
     * são mais complexos.
     * 
     * Para podermos armazenar as cidades que um estado possui, poderíamos usar um
     * vetor, assim, teríamos que declarar o atributo como Cidade[] cidades. Observe
     * que os colchetes definem que temos um vetor de Cidade. Note também que, neste
     * caso, utilizamos o plural para definir o nome do atributo, para deixar claro
     * que ele pode conter várias cidades.
     * 
     * No entanto, o uso de vetores em Java não é algo aconselhável. Eles devem ser
     * usados apenas se você estiver chamando funções que te obrigam usar vetores,
     * ou se você tiver precupações com desempenho. Um dos problemas de usar vetores
     * é que, em algum momento, precisamos definir o total de elementos do vetor.
     * Uma vez definido, o tamanho do vetor não tem como ser alterado. Se você criar
     * um vetor contendo 10 posições e precisar adicionar mais um elemento no vetor,
     * a única solução é criar um vetor com 11 posições, copiar os dados do vetor
     * antigo para o novo e apagar o vetor antigo.
     * 
     * Em outro caso, deve-se utilizar um tipo como o List. O List representa uma
     * lista de objetos e assim como no mundo real podemos ter diferentes formas de
     * criar listas, como usando folhas de papel ou aplicativos no celular, em
     * linguagens de programação normalmente também temos diferentes tipos de lista.
     * Os tipos mais básicos de listas utilizam vetores internamente. No entanto,
     * tais listas resolvem os problemas apresentados anteriormente para vetores: se
     * precisarmos de adicionar uma nova posição em um vetor, não precisaremos nós
     * mesmos escrever o código para executar os passos descritos acima para
     * manipular o vetor para criarmos uma nova posição. As listas já fornecem
     * métodos prontos que fazem todo o trabalho pra gente. Assim, não temos que nos
     * preocupar com nenhum dos detalhes discutidos acima sobre vetores.
     * 
     * Mas como você pode observar abaixo, apesar de List ser um tipo como qualquer
     * outro, a declaração do atributo cidades não foi feita simplesmente como List
     * cidade, mas sim como List<Cidade> cidades.
     * A primeira forma até funciona, mas já não é usada desde o advento do Java 5.
     * Usando apenas List cidades, estamos informando que temos uma variável chamada
     * cidades, que é uma lista, mas não estamos indicando ao compilador Java
     * que tipo de objetos queremos nesta lista. 
     * Olhando o nome da variável, fica claro que tal lista é uma lista
     * de cidades, mas o compilador não tem esse racioncínio.
     * Além disso, o nome da variável poderia ser qualquer um, assim, o compilador
     * definitivamente não pode utilizar tal nome para tentar descobrir que tipo
     * de elementos podem ser inseridos na lista.
     * Desta forma, se utilizarmos apenas List cidades,
     * corremos o risco de nossa lista ser poluída com elementos que não
     * sejam cidades.
     * Assim, a partir do Java 5, um recurso chamado Generics
     * foi introduzido, que nos permite indicar que tipo de elementos
     * vamos permitir na nossa lista, colocando o classe de tais elementos
     * entre < e >. Assim, List<Cidade> indica que nossa lista
     * só armazena cidades.
     * 
     * Observe que para usar o tipo List, tivemos que fazer o
     * import java.util.List. Temos que importar um classe
     * sempre tal classe não estiver dentro do pacote java.lang 
     * (String e outras classes estão neste pacote, assim, não precisamos importar)
     * e quando estivermos usando uma classe de um pacote qualquer,
     * mas o arquivo onde estamos usando tal classe não pertence a tal pacote.
     * 
     * Bem, depois que declaramos a lista, ela não está pronta pra uso.
     * Precisamos de mais um passo, como descrito no construtor abaixo.
     */
    private List<Cidade> cidades;
    
    public Estado(){
        /*
         * Quando declaramos uma variável de uma determinada classe, precisamos
         * instanciar um objeto de tal classe e armazenar em tal variável antes de
         * usá-la. Do mesmo modo, para usarmos a lista, precisamos instanciá-la
         * primeiro. A forma de instanciar um objeto é new NomeDaClasse(possíveis
         * parâmetros aqui). Assim, a forma óbvia de instanciar a lista seria new
         * List<Cidade>(). Observe que o tipo do atributo cidades não é apenas List, mas
         * sim List<Cidade>. Ela não é apenas uma lista, mas uma lista de cidades. No
         * entanto, a forma que usamos para instanciar a lista foi new
         * ArrayList<Cidade>().
         * 
         * Ou seja, pela primeira vez, temos uma variável de um tipo e estamos usando
         * outro tipo para instanciar a mesma. Se tentarmos fazer new List<Cidade>(), o
         * compilador acusará que List é um tipo abstrato e não pode ser usado. Veremos
         * mais sobre isso posteriormente. Então você deve estar se perguntando porque
         * não declaramos o atributo como ArrayList<Cidade> e assim a declaração e
         * instanciação seriam iguais. Apesar de isso funcionar perfeitamente, não é o
         * aconselhável na POO. Uma vez que podemos ter diferentes tipos de lista (como
         * listas de papel, apps de lista no celular no mundo real), na POO podemos ter
         * diferentes implementações de uma lista. ArrayList é uma classe que provê uma
         * dessas implementações. Ela é uma lista que utiliza um vetor internamente e é
         * a mais utilizada. Outro tipo de lista é o LinkedList, que não utiliza um
         * vetor, assim, ela não precisar fazer todo aquele processo descrito acima para
         * aumentar o tamanho de um vetor quando ele está cheio. Cada tipo de lista tem
         * suas vantagens e desvantagens, assim como listas de papel e apps de lista no
         * celular. Explicar isso está fora do escopo do curso (é algo para uma
         * disciplina de estruturas de dados). Um dos motivos de declararmos o atributo
         * como List<Cidade> e instanciar como ArrayList<Cidade>() é que, somente o construtor
         * sabe que a lista é um ArrayList. Em qualquer outro lugar que precisarmos
         * usar a lista (como no getCidades()), utilizaremos o tipo List<Cidade>.
         * Assim, se posteriormente descobrirmos que o ArrayList não é o mais adequado
         * para o nosso contexto, podemos trocar o tipo unica e exclusivamente 
         * aqui no construtor, e qualquer parte do nosso sistema que use tal lista
         * de cidades não notará qualquer alteração, pois todos
         * os tipos de lista (como ArrayList e LinkedList) funcionam externamente
         * da mesma forma. Apenas internamente que eles são diferentes.
         * Mas quando usamos tais classes, não vemos essas diferenças.
         * 
         * Lembre-se que para usar ArrayList é precisa
         * fazer import java.util.ArrayList;
         */
        cidades = new ArrayList<Cidade>();
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
     * Por fim, quando temos uma lista, não é comum termos um setter, 
     * mas sim métodos para adicionar e remover elementos
     * da lista.
     * Este método recebe uma única cidade e adiciona tal cidade
     * à lista de cidades.
     * 
     * Lembre-se que, se não instanciarmos a lista de cidades
     * no construtor, ao tentarmos adicionar uma cidade à lista,
     * será gerado o erro NullPointerException, pois estamos
     * tentando usar uma lista que não foi criada ainda.
     */
    public void addCidade(Cidade cidade){
        cidades.add(cidade);
    }
    
}
