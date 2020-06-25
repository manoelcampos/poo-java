package com.manoelcampos.aviacao;

import java.time.LocalDate;

/**
 * A partir do Java 8, interfaces podem ter métodos não abstratos,
 * ou seja, métodos que tem uma implementação.
 * Estes são chamados de default methods (métodos padrões).
 * Criar um método com uma implementação dentro de uma interface
 * não é como criar um método qualquer.
 * Como já dito na versão anterior do projeto, os elementos em interfaces são todos públicos.
 * Isto é válido até o Java 8. 
 * Não confunda a interface por si com os elementos dentro dela; a interface pode
 * ter as mesmas visibilidades que uma classe.
 * A partir do Java 9 é possível ter métodos não abstratos privados em uma interface.
 * 
 * Então, para criar um método default, precisamos colocar a palavra default
 * no lugar do modificador de acesso (uma vez que incluir o public é redundante até o Java 8).
 * 
 * Como a interface não pode ter atributos a não ser constantes,
 * não temos como incluir o atributo pessoaFisica dentro da interface.
 * Se fizermos isso, ele será uma constante não poderá ser modificado.
 * Então, como apresentado na versão anterior, os métodos definidos
 * na interface precisam acessar uma instância de PessoaFisica
 * para a partir dela acessarem os atributos como nome, cpf, email, etc.
 * Desta forma, definimos apenas um método abstrato na interface,
 * o {@link #getPessoaFisica()} que será implementado por cada
 * classe que implementa a interface, neste caso
 * o {@link Piloto} e {@link Passageiro}.
 * 
 * Apesar de o método {@link #getPessoaFisica()} não ter implementação
 * na interface, isso não quer dizer que não podemos chamá-lo nos outros
 * métodos que definimos aqui.
 * Parece estranho: como um método que não possui uma implementação pode
 * ser chamado dentro de outro método?
 * A resposta é simples: nós não temos como instanciar a interface,
 * mas apenas alguma classe que implementa tal interface.
 * Por exemplo, quando chamarmos um método como o {@link #getNome()}
 * a partir de um objeto da classe {@link Piloto}, neste momento
 * haverá uma implementação para o método {@link #getPessoaFisica()}
 * que será então chamado dentro do {@link #getNome()}.
 * 
 * Você pode verificar no método main da classe {@link Piloto} que o {@link #getNome()} funciona normalmente,
 * chamando a implementação do método {@link #getPessoaFisica()} na classe Piloto.
 * 
 * @author Manoel Campos da Silva Filho <http://github.com/manoelcampos>
 */
public interface IPessoaFisica {
    PessoaFisica getPessoaFisica();
    
    default String getNome() {
        return getPessoaFisica().getNome();
    }

    default void setNome(String nome) {
        getPessoaFisica().setNome(nome);
    }

    default String getEmail() {
        return getPessoaFisica().getEmail();
    }

    default void setEmail(String email) {
        getPessoaFisica().setEmail(email);
    }

    default String getCpf() {
        return getPessoaFisica().getCpf();
    }

    default void setCpf(String cpf) {
        getPessoaFisica().setCpf(cpf);
    }

    default char getSexo() {
        return getPessoaFisica().getSexo();
    }

    default void setSexo(char sexo) {
        getPessoaFisica().setSexo(sexo);
    }

    default String getPassaporte() {
        return getPessoaFisica().getPassaporte();
    }

    default void setPassaporte(String passaporte) {
        getPessoaFisica().setPassaporte(passaporte);
    }

    default LocalDate getDataNascimento() {
        return getPessoaFisica().getDataNascimento();
    }

    default void setDataNascimento(LocalDate dataNascimento) {
        getPessoaFisica().setDataNascimento(dataNascimento);
    }    
}