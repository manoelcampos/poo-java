package com.manoelcampos.aviacao;

import java.time.LocalDate;

/**
 * Interfaces até o Java 7 são como classes com todos os métodos abstratos.
 * Métodos e classes abstratas foram apresentados na versão anterior deste projeto.
 * Atributos declarados em interfaces só podem ser constantes.
 * Nesta versão do Java, tudo que incluírmos em uma interface é
 * por padrão público. Assim, é totalmente desnecessário incluir
 * a palavra public. 
 * 
 * Em um classe, se a palavra public for omitida, isto indica
 * que a visibilidade é package (a visibilidade padrão).
 * No caso de interfaces é diferente. Colocando ou não a palavra
 * public, os elementos de uma interface em Java 7 são todos public.
 * 
 * No caso de constantes, sabemos que elas devem ser declaradas
 * normalmente como public static final NOME = valor;
 * 
 * Em uma interface, só precisamos escrever NOME = valor
 * para declarar uma interface. O public static final fica implícito (e logo é redundante), 
 * uma vez que só podemos ter atributos constantes em uma interface.
 * 
 * No caso dos métodos, como eles são todos por padrão public abstract no Java 7,
 * tais modificadores (as palavras reservadas public e abstract) não precisam ser incluídos.
 * 
 * A forma de criar métodos abstratos apresentada na versão anterior do projeto
 * funciona perfeitamente em interfaces. Poderíamos
 * definir o método getNome() como public abstract String getNome(),
 * mas somente String getNome() é o suficiente, como explicado acima.
 * 
 * Como uma interface até o Java 7 só possui métodos abstratos,
 * classes podem implementar tal interface, definindo implementações
 * para tais métodos. Assim, uma classe implementa uma inteface,
 * ela não estende uma interface (isto ocorre com herança entre classes).
 * Veja a classe {@link Passageiro} para mais detalhes.
 * 
 * Uma interface define um contrato que as classes que a implementa precisam
 * seguir. Este contrato define os métodos que a classe precisa obrigatoriamente
 * ter (implementar). Assim, é gerantido que uma classe que implementa uma interface
 * terá todos os métodos definidos na interface, ao menos
 * que tal classe seja abstrata (isso foi explicado em detalhes quando falamos
 * de classes abstratas, onde o que foi dito a respeito de métodos abstratos se aplica totalmente à interfaces; 
 * veja a classe {@link Voo} para detalhes).
 * Se a classe for abstrata, ela não tem obrigatoriedade de implementar todos os métodos
 * da interface. Se ela for uma classe concreta, terá obrigatoriamente que implementar
 * qualquer método da interface que não tenha sido implementado pelas 
 * superclasses.
 * 
 * Esta interface IPessoaFisica foi definida para resolver o problema
 * apresentado na versão anterior do projeto.
 * Uma vez que trocamos a herança de Passageiro com PessoaFisica e Piloto com PessoaFisica
 * por agregação, ficou mais complicado usar as classes Passageiro e Piloto
 * (veja mais detalhes na versão 1 deste projeto), pois
 * tais classes não tinham mais métodos herdados de Pessoa e PessoaFisica,
 * como getNome() e getCpf().
 * Para resolvermos este problema, introduzimos tais métodos na classe Passageiro.
 * No entanto, nada nos obriga a incluir os mesmos métodos na classe Piloto.
 * Assim, poderíamos acabar, por exemplo, em uma situação onde o Passageiro tem getNome()
 * e o Piloto não tem. Sendo que os são pessoas, não faz
 * sentido um ter o método getNome() e o outro não.
 * 
 * Para resolver este problema podemos utilizar interfaces.
 * Criamos esta interface que definirá um contrato a ser implementado
 * pelas classes Piloto e Passageiro, definindo os métodos
 * que tais classes obrigatoriamente precisam ter.
 * Tais métodos são definidos como abstratos na interface
 * e suas implementações serão definidas pelas classes citadas.
 * 
 * Veja o código de tais classes para mais detalhes.
 * 
 * @author Manoel Campos da Silva Filho <http://github.com/manoelcampos>
 */
public interface IPessoaFisica {
    String getNome();
    void setNome(String nome);
    String getEmail();
    void setEmail(String email);
    
    String getCpf();
    void setCpf(String cpf);
    char getSexo();
    void setSexo(char sexo);
    String getPassaporte();
    void setPassaporte(String passaporte);
    LocalDate getDataNascimento();
    void setDataNascimento(LocalDate dataNascimento);
}
