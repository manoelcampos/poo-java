package com.manoelcampos.aviacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Veja a documentação da interface {@link IPessoaFisica} antes desta.
 * 
 * Com o uso dos métodos default das interfaces do Java 8, removemos
 * a duplicação de código dos métodos como {@link #getNome()}
 * e {@link #setNome(java.lang.String)} que são herdados
 * da interface. A classe {@link Piloto} não terá estes métodos implementados
 * em duplicidade com a classe Passageiro.
 * 
 * O único método que tivemos que implementar da interface foi o
 * {@link #getPessoaFisica()}. Este método infelizmente
 * é o mesmo código que temos na classe {@link Piloto}.
 * Porém, não temos como resolver tal duplicação.
 * No entanto, considerando que o método apenas retorna o valor
 * do atributo e não requer nenhum código adicional (como cálculos
 * ou verificações), isto é algo aceitável.
 * 
 * Uma solução seria criar um IPessoaFisica como uma classe abstrata,
 * mas provavelmente você nem encontraria um nome adequado para tal classe,
 * uma vez que já temos uma classe {@link PessoaFisica}.
 * Seria também extremamente confuso ter duas classes para representar
 * pessoas físicas, sendo uma classe concreta e outra abstrata.
 * 
 * Então se poderíamos resolver o problema apresentado na versão anterior do projeto
 * (de garantirmos que o Passageiro e Piloto terão um mesmo conjunto básico
 * de métodos, como getNome, setNome, getCpf, setCpf, etc)
 * com o uso de uma classe abstrata (por mais que ficasse confuso),
 * qual a vantagem de interfaces além de evitar tal confusão?
 * 
 * O ponto principal é a chamada herança múltipla, que se tornou
 * um assunto bastante controverso depois do Java 8.
 * Como o Java (pelo menos até a versão 11) só permite que uma classe
 * extenda uma única outra classe, então temos o que é chamado de herança
 * simples. Assim, por definição, o Java não permite herança múltipla de classes.
 * O que é possível a partir do Java 8 é herdar métodos implementados
 * em diferentes interfaces. Então, isto é herança múltipla de interfaces
 * apenas. Ou seja, não podemos fazer uma classe herdar de mais de uma classe.
 * Apenas linguagens como C++ possuem tal recurso, além do recurso de interfaces.
 * 
 * No código abaixo, é mostrado que a classe Passageiro está implementando
 * 3 interfaces: IPessoaFisica, Comparable e Cloneable.
 * 
 * A {@link Comparable} (Comparável) é uma interface que possui um único
 * método abstrato a ser implementado: o {@link #compareTo(java.lang.Object)}.
 * Este método permite comparar se um objeto é maior, menor ou igual a outro,
 * assim como fazemos com números 
 * (mas sem usar os operadores de igual, maior e menor e sim o método indicado).
 * Tal método é essencial se desejarmos, por exemplo, ordenar 
 * objetos em uma lista. Veja a documentação no método compareTo abaixo
 * para mais detalhes.
 * No caso da interface Comparable, podemos usar generics para indicar
 * que queremos comparar apenas um Passageiro com outro Passageiro.
 * 
 * No caso da interface Cloneable, ela define o método {@link #clone()}
 * que deve ser implementando pelas classes que implementam tal interface.
 * Veja os comentários no método abaixo.
 * 
 * Então, além das vantagens de usar interfaces apresentadas nos slides
 * na pasta do projeto, com elas podemos fazer uma classe
 * implementar múltiplas interfaces, enquanto não temos
 * como fazer uma classe extender múltiplas interfaces.
 * 
 * Um detalhe importante é que uma classe pode ao mesmo tempo
 * extender outra classe e implementar uma ou mais interfaces.
 * No entanto, o extends deve vir sempre antes do implements,
 * senão o código não compila.
 * 
 * @author Manoel Campos da Silva Filho <http://github.com/manoelcampos>
 */
public class Passageiro implements IPessoaFisica, Comparable<Passageiro>, Cloneable {
    private int id;
    private int numeroFidelidade;
    private String categoriaFidelidade;
    private PessoaFisica pessoaFisica;
    
    
    public Passageiro(PessoaFisica pessoaFisica){
        this.pessoaFisica = pessoaFisica;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the numeroFidelidade
     */
    public int getNumeroFidelidade() {
        return numeroFidelidade;
    }

    /**
     * @param numeroFidelidade the numeroFidelidade to set
     */
    public void setNumeroFidelidade(int numeroFidelidade) {
        this.numeroFidelidade = numeroFidelidade;
    }

    /**
     * @return the categoriaFidelidade
     */
    public String getCategoriaFidelidade() {
        return categoriaFidelidade;
    }

    /**
     * @param categoriaFidelidade the categoriaFidelidade to set
     */
    public void setCategoriaFidelidade(String categoriaFidelidade) {
        this.categoriaFidelidade = categoriaFidelidade;
    }

    @Override
    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    /**
     * Incluímos este método pois esta classe implementa
     * a interface {@link Comparable}, de onde tal método veio.
     * 
     * Para que a comparação de objetos funcione, a implementação de
     * tal método precisa seguir alguns critérios.
     * Isso é uma exceção, normalmente a classe define por ela mesma
     * como um método de uma interface será implementado.
     * 
     * Neste caso, o método deve retornar 0 se a instância atual (this)
     * for igual ao outro passageiro passado por parâmetro;
     * -1 se a instância atual for menor que o outro passageiro;
     * e 1 se a instância atual for maior que o outro passageiro.
     * 
     * O método pode indicar se um passageiro é igual, menor ou maior que outro
     * com base em algum dos atributos da classe.
     * O programador é quem vai decidir qual atributo usará para
     * fazer esta comparação, de acordo com as necessidades do sistema.
     * 
     * No nosso caso, usamos o atributo {@link #numeroFidelidade}.
     * Como ele é um número inteiro, podemos usar o método
     * {@link Integer#compare(int, int)} para comparar os números
     * de fidalidade dos dois passageiros.
     * Desta forma, não precisamos nos preocupar em escrever if's
     * para fazer o método retornar os valores indicados acima.
     * O próprio método compare da classe Integer vai fazer isso por nós.
     * Assim, não teremos como fazer nosso método retornar valores 
     * diferentes do esperado. Se fizermos isso, a comparação
     * simplemente não vai funcionar corretamente.
     * Se estivermos ordenando passageiros em uma lista e a implementação
     * deste método estiver incorreta, os passageiros serão ordenados
     * de forma diferente do esperado.
     * 
     * O método main abaixo inclui uma lista de passageiros e mostra
     * como ordená-los usando o método sort da classe Collections.
     * Observe que em nenhum momento chamamos o método compareTo.
     * Ele é chamado internamente pelo método sort.
     * 
     * @param outroPassageiro o outro passageiro com quem queremos comparar o passageiro atual (this)
     * @return 0 se os passageiros forem iguais; -1 se o atual (this) for menor que o outro passageiro;
     *         1 se o atual (this) for maior que o outro passageiro.
     */
    @Override
    public int compareTo(Passageiro outroPassageiro) {
        /*Observe que estamos comparando os passageiros com base no número de fidadelidade,
        que é inteiro. Assim, usamos a classe Integer para isso, pois ela tem um método compare.
        Devemos usar as seguintes classes de acordo com o tipo do atributo que 
        usarmos para a comparação:
        
        - Character para atributos do tipo char
        - Double para atributos do tipo double
        - Float para atributos do tipo float
        - Boolean para atributos do tipo Boolean
        
        No caso de Strings, podemos chamar o método compareTo diretamente a partir
        do atributo, como por exemplo:
        return getCpf().compareTo(outroPassageiro.getCpf()) se não quisermos diferenciar maiúsculas de minúsculas
        return getCpf().compareToIgnoreCase(outroPassageiro.getCpf()) se quisermos.*/
        
        return Integer.compare(this.numeroFidelidade, outroPassageiro.numeroFidelidade);
    }
    
    /**
     * O método clone foi herdado da interface {@link Cloneable}, mas ele é um método
     * diferente de qualquer outro método em interfaces.
     * Ele já vem com uma implementação padrão (que é definida na classe {@link Object}),
     * mas tal implementação não é acessível de qualquer lugar pois o método
     * é definido como protected. Veja que alteramos a visiblidade para public para 
     * que o método clone funcione.
     * 
     * Diferente do método compareTo da interface {@link Comparable},
     * não temos que incluir qualquer implementação neste método.
     * Isto é uma exceção, uma particularidade confusa da interface {@link Cloneable}.
     * 
     * O método é definido como protegido para que nós incluamos o clone
     * apenas para as classes que desejarmos, uma vez que essa operação
     * é computacionalmente cara e complexa. 
     * Este é um assunto mais avançado. Caso deseje mais detalhes,
     * sugiro o artigo https://www.devmedia.com.br/o-que-e-deep-copy-e-shallow-copy-em-java/28670
     * 
     * O método main abaixo mostra como clonar um objeto, criando
     * uma cópia do mesmo.
     * 
     * @return
     * @throws CloneNotSupportedException 
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    public static void main(String[] args) {
        /*Cria uma PessoaFisica e ao mesmo tempo um novo passageiro que representa tal PessoaFisica.
        Se precisarmos usar esta mesma PessoaFisica para criar um Piloto (por exemplo),
        temos que declarar a PessoaFisica separadamente e passá-la para
        o construtor de Passageiro, como, por exemplo:

        PessoaFisica pf = new PessoaFisica("Manoel Campos", 'M', "11111111111");
        Passageiro passageiro = new Passageiro(pf);
        */
        Passageiro passageiro = new Passageiro(new PessoaFisica("Manoel Campos", 'M', "11111111111"));
        passageiro.getPessoaFisica().setPassaporte("1234");
        System.out.println("Passageiro");
        /*Observe que neste caso, como não temos de fato uma variável declarada
        para armazenar o objeto PessoaFisica criado, não temos outra forma
        de acessar os dados de Pessoa e PessoaFisica a não ser acessando a PessoaFisica
        a partir do passageiro e depois utilizando os métodos desejados.*/
        System.out.println("Nome: " + passageiro.getPessoaFisica().getNome());
        System.out.println("Sexo: " + passageiro.getPessoaFisica().getSexo());
        System.out.println("CPF: " + passageiro.getPessoaFisica().getCpf());
        System.out.println("Passaporte: " + passageiro.getPessoaFisica().getPassaporte());
        
        
        Passageiro passageiro1 = new Passageiro(new PessoaFisica("Manoel", 'M', "11111111111"));
        passageiro1.setNumeroFidelidade(10);
        
        Passageiro passageiro2 = new Passageiro(new PessoaFisica("João", 'M', "22222222222"));
        passageiro2.setNumeroFidelidade(2);
        
        Passageiro passageiro3 = new Passageiro(new PessoaFisica("Maria", 'F', "33333333333"));
        passageiro3.setNumeroFidelidade(1);

        List<Passageiro> passageiros = new ArrayList<>();
        passageiros.add(passageiro1);
        passageiros.add(passageiro2);
        passageiros.add(passageiro3);
        
        System.out.println("\nPassageiros antes da ordenação");
        for (Passageiro p : passageiros) {
            System.out.println("\tNome: " + p.getNome() + " Nº Fidelidade: " + p.getNumeroFidelidade());
        }
        
        Collections.sort(passageiros);
        
        /*
        A interface List possui um método sort, mas neste caso, ela pede
        um objeto da interface Comparator.
        Isto permite que ordenemos a lista por meio do campo
        que desejarmos e não apenas pelo campo definido
        no método compareTo da classe Passageiro, dando
        flexibilidade.
        
        No entanto, como uma interface não é uma classe concreta
        para podermos instanciar, até o Java 7, a única forma
        de usar tal método era criando o que chamamos de classe anônima:
        uma classe sem nome que é declarada no mesmo momento em que
        instanciamos um objeto de uma outra classe ou interface.
        Apesar da flexibilidade de podermos trocar
        a qualquer momento o campo pelo qual os objetos serão ordenados,
        observe como o código abaixo é bem mais complicado no Java 7.
        */
        
        /*
        passageiros.sort(new Comparator<Passageiro>() {
            @Override
            public int compare(Passageiro p1, Passageiro p2) {
                return p1.getCpf().compareTo(p2.getCpf());
            }
        });
        */
        
        /*
        No Java 8 podemos simplificar imensamente este código em apenas uma linha.
        Veja os dois examplos abaixo: um ordenando por um atributo String ou qualquer outro
        que não seja um tipo primitivo; o outro ordenando por um atributo inteiro.
        Estes recursos são chamados de Expressões Lambda e fazem parte
        de um outro paradigma de programação chamado
        Programação Funcional, que não é abordado no curso.
        */
        //passageiros.sort(Comparator.comparing(Passageiro::getCpf));
        //passageiros.sort(Comparator.comparingInt(Passageiro::getId));
        
        System.out.println("\nPassageiros depois da ordenação");
        for (Passageiro p : passageiros) {
            System.out.println("\tNome: " + p.getNome() + " Nº Fidelidade: " + p.getNumeroFidelidade());
        }
    }    
}
