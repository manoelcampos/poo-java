/**
 * Duplicação de código é um dos maiores problemas que temos discutido nas aulas.
 * Analisando as classes Cliente e Funcionario, pudemos perceber que tínhamos
 * uma série de atributos duplicados, especificamente o cpf, sexo, nome e a dataNascimento.
 * Poderíamos pensar que não há duplicação de código, pois são apenas variáveis.
 * No entanto, com a duplicação de tais atributos, vem a duplicação de código de fato,
 * como os getters e setters associados a eles. No caso do cpf, como temos um método
 * extenso para verificar se o cpf é válido, teríamos que duplicar tal método
 * nas classes Cliente e Funcionario. Uma solução para evitar tal duplicação
 * seria criar uma classe chamada, por exemplo, Util e incluir o método isCpfValido
 * e o calculaDigito nesta classe, para assim poder utilizar tal classe dentro
 * do Cliente e do Funcionario para validar o CPF.
 * Apesar de esta solução funcionar, não é algo adequado.
 * 
 * Na engenharia de software temos um conceito chamado coesão, que indica
 * que o código precisa ser coeso. Ou seja, os elementos dentro de um mesmo código,
 * como uma classe, precisam ter afinidade uns com os outros.
 * Tais elementos precisam estar de fato relacionados, fazerem sentido de estarem juntos.
 * Elementos que tem essa relação precisam ser coesos, próximos.
 * Assim, se temos um atributo cpf e um método para validar tal cpf,
 * este método precisa estar na mesma classe onde o cpf foi definido.
 * 
 * Para resolver esse problema, utilizamos o conceito de herança da
 * POO, para criar uma hierarquia de classes e fazer classes filhas
 * herdarem características e comportamentos de uma classe mãe.
 * 
 * Na biologia, um filho herda características e comportamentos de um pai
 * e de uma mãe. O que ele herda é seletivo, definido pela genética.
 * Assim, um filho nunca herda tudo do pai e tudo da mãe.
 * 
 * Ter uma mãe e um pai é o que chamamos em POO de Herança Múltipla.
 * Em Java, uma classe filha só tem uma mãe, não tem um pai,
 * o que é chamado de Herança Simples.
 * 
 * Apesar de existirem recursos como Interfaces (que possivelmente veremos
 * em aulas futuras) e algumas novidades nesse sentido no Java 8,
 * o Java não permite que de fato possamos definir que uma classe herde
 * de duas ou mais classes. O que temos são alguns recursos 
 * parecidos com isso, mas que não são de fato totais implementações
 * de herança múltipla. Isto inclusive é um assunto controverso
 * e muitas vezes apresentado de forma incorreta em questões
 * de concurso, que com a devida fundamentação teórica, cabe recurso.
 * 
 * C++ é uma das poucas linguagens que de fato permitem que uma classe 
 * tenha, digamos, um pai e uma mãe. 
 * 
 * Em Java, para indicar que uma classe é filha de outra, basta
 * incluir "extends NomeDaClasseMae" no final da primeira linha da declaração da classe
 * que será a filha. Neste caso, a classe filha é a Cliente e a mãe PessoaFisica.
 * A partir daí, no diagrama de classes na tela inicial do BlueJ, você verá que tem uma
 * seta com um triângulo, partindo da classe filha para a mãe.
 * 
 * Com isto, agora a classe filha herdará tudo aquilo que for public
 * e protected na classe mãe, inclusive de quaisquer outros classes 
 * na "árvore genealógica", como a classe avó, bisavó e daí pra cima (caso haja).
 * 
 * Herdar significa que a classe filha terá acesso à esses elementos
 * declarados como public e protected. Atributos por exemplo não serão herdados,
 * pois eles são definidos como private.
 * Apesar disso, o cliente terá atributos nome, cpf e sexo (definidos nas classes
 * PessoaFisica e Pessoa). Para confirmar isso, basta instanciar um cliente
 * e dar dois cliques nele no BlueJ.
 * 
 * O cliente terá tais atributos, não não temos como acessá-los diretamente,
 * mesmo que estejamos dentro da classe cliente. 
 * Isto porque, por exemplo, o atributo cpf foi definido como privado
 * na classe PessoaFisica. Assim, para o Cliente acessar tal atributo,
 * é obrigatório o uso do getter, setter e qualquer outro método, 
 * definido na classe PessoaFisica, que faça acesso a tal atributo.
 * 
 * A classe Cliente (onde colocamos o extends) é chamada de classe filha.
 * A classe que estamos estendendo é chamada de classe mãe ou super classe.
 * Extender uma classe significa que a classe filha herdará elementos da classe
 * mãe e outras na hierarquia superior (árvore genealógica),
 * mas que normalmente incluirá atributos e métodos adicionais,
 * específicos do Cliente.
 * 
 */
public class Cliente extends PessoaFisica
{
    private double renda;
    private String endereco;
    private String dataNascimento;
    private String celular;
    private String telefoneResidencial;    
    private String email;
       
    public Cliente(){

    }
    
    public Cliente(String nome, String cpf, char sexo){
        /*
        Observe que não podemos fazer this.nome = nome;
        O compilador acusará que o atributo nome é privado na classe Pessoa
        e que não podemos acessá-lo diretamente. 
        Apesar de o cliente ter um nome, para acessar tal atributo,
        precisamos usar o getter ou setter.
        O mesmo ocorrer para o CPF e sexo que foram definidos como privados
        na classe PessoaFisica.
        */
        setNome(nome);
        setCpf(cpf);
        setSexo(sexo);
    }
  
    public double getRenda(){
        return renda;
    }

    public void setRenda(double renda){
        if(renda >= 0) {
            this.renda = renda;
        } else {
            System.out.println("A renda não pode ser negativa!");
        }
    }
}
