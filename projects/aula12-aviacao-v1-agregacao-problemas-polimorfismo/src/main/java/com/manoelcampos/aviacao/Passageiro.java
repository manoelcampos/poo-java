package com.manoelcampos.aviacao;

/**
 * Como neste projeto o piloto pode ser um passageiro e o passageiro um piloto,
 * não podemos utilizar herança em todos os relacionamentos.
 * Usamos herança entre Pessoa e PessoaFisica.
 * 
 * <p>De Passageiro para PessoaFisica usamos agregação.
 * O mesmo fizemos de Piloto para PessoaFisica.
 * Desta forma, um Passageiro que também é Piloto (ou vice-versa)
 * pode utilizar uma mesma instância de PessoaFisica, sem precisarmos
 * cadastrar os dados de PessoaFisica de forma duplicada 
 * para o Passageiro e depois o Piloto.</p>
 * 
 * <p>Se usarmos herança desde Pessoa até Piloto e Passageiro,
 * quando criamos um Piloto ou Passageiro, podemos esquecer
 * que as classes nos níveis superiores da hierarquia (PessoaFisica e Pessoa)
 * existem. Para quem está instanciando uma classe filha como Passageiro
 * parece que não existem as classes superiores.
 * É como se os métodos e atributos acessados estivessem todos
 * na classe Passageiro.
 * Desta forma, é muito simples usar uma classe quando há herança.</p>
 * 
 * <p>No entanto, quando trocamos a relação de herança entre Passageiro e Piloto com
 * PessoaFisica por agregação, tudo ficou mais difícil.
 * A implementação das classes ficou mais complicada e o uso também.
 * Mas isto foi necessário para permitir ter um piloto que também é passageiro
 * (obviamente em momentos diferentes) e vice-versa.</p>
 * 
 * <p>Para instanciar um Passageiro, temos que passar uma instância
 * de PessoaFisica por parâmetro, como pode ser visto no método main abaixo.
 * Se desejarmos obter ou alterar um atributo de Pessoa ou PessoaFisica 
 * a partir de uma instância de Passageiro, 
 * temos que acessar a PessoaFisica primeiro e a partir dela,
 * acessar um método como getNome() ou setNome().
 * Com isto, o uso do Passageiro e Piloto fica bem mais complicado.
 * Veja na classe {@link Piloto} como o problema foi resolvido.
 * </p>
 *
 * @author Manoel Campos da Silva Filho <http://github.com/manoelcampos>
 */
public class Passageiro {
    private int numeroFidelidade;
    private String categoriaFidelidade;
    private PessoaFisica pessoaFisica;
    
    public Passageiro(PessoaFisica pessoaFisica){
        this.pessoaFisica = pessoaFisica;
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

    /**
     * @return the pessoaFisica
     */
    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
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
    }


}
