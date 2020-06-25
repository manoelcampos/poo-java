package com.manoelcampos.aviacao;

import java.time.LocalDate;

/**
 * Veja a documentação da interface {@link IPessoaFisica} antes desta.
 * 
 * A classe Piloto agora implementa a interface {@link IPessoaFisica}.
 * Como ela é uma classe concreta, ela é obrigada a implementar 
 * qualquer método herdado da interface que ainda não tenha sido implementado.
 * Como a classe Piloto não herda de nenhuma classe, isso quer dizer
 * que ela, por ser concreta, terá que obrigatoriamente implementar
 * todos os métodos abstratos da interface {@link IPessoaFisica}.
 * 
 * Com isto, é definido um contrato que a classe Piloto deve implementar.
 * Como a classe {@link Passageiro} também implementa a mesma interface,
 * garantimos que as duas classes tem um mesmo conjunto básico de métodos.
 * Se o piloto tem getNome(), o passageiro agora também terá.
 * 
 * O grande problema do uso de interfaces do Java 7 aqui é que, apesar
 * de agora termos garantido um contrato a ser implementado pelas
 * duas classes citadas, o código de todos os métodos implementados
 * da interface estão duplicados entre Passageiro e Piloto.
 * Eles tem exatamente o mesmo código, sem mudar uma única letra.
 * Desta forma, resolvemos um problema e introduzimos outro.
 * Duplicação de código é algo que falamos constantemente 
 * que deve ser evitado ao máximo.
 * 
 * Para resolver este problema, vamos usar os novos recursos das
 * interfaces do Java 8 na próxima versão do projeto.
 * 
 * @author Manoel Campos da Silva Filho <http://github.com/manoelcampos>
 */
public class Piloto implements IPessoaFisica {

    private PessoaFisica pessoaFisica;

    public Piloto(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }
    
    @Override
    public String getNome() {
        return pessoaFisica.getNome();
    }

    @Override
    public void setNome(String nome) {
        pessoaFisica.setNome(nome);
    }

    @Override
    public String getEmail() {
        return pessoaFisica.getEmail();
    }

    @Override
    public void setEmail(String email) {
        pessoaFisica.setEmail(email);
    }

    @Override
    public String getCpf() {
        return pessoaFisica.getCpf();
    }

    @Override
    public void setCpf(String cpf) {
        pessoaFisica.setCpf(cpf);
    }

    @Override
    public char getSexo() {
        return pessoaFisica.getSexo();
    }

    @Override
    public void setSexo(char sexo) {
        pessoaFisica.setSexo(sexo);
    }

    @Override
    public String getPassaporte() {
        return pessoaFisica.getPassaporte();
    }

    @Override
    public void setPassaporte(String passaporte) {
        pessoaFisica.setPassaporte(passaporte);
    }

    @Override
    public LocalDate getDataNascimento() {
        return pessoaFisica.getDataNascimento();
    }

    @Override
    public void setDataNascimento(LocalDate dataNascimento) {
        pessoaFisica.setDataNascimento(dataNascimento);
    }

     public static void main(String[] args) {
        //Veja que de qualquer forma temos que passar uma PessoaFisica ao criar um Piloto
        Piloto piloto = new Piloto(new PessoaFisica("Breno", 'M', "22222222222"));
        /*No entanto, agora podemos chamar getters
        e setters referentes aos atributos em Pessoa e PessoaFisica
        diretamente, sem precisar fazer, por exemplo,
        piloto.getPessoaFisica().setPassaporte("1234");
        */
        piloto.setPassaporte("1234");
        System.out.println("Piloto");
        /*Ao obter ou alterar os dados referentes à Pessoa e PessoaFisica,
        agora parece que estamos usando herança desde Pessoa até Piloto.*/
        System.out.println("Nome: " + piloto.getNome());
        System.out.println("Sexo: " + piloto.getSexo());
        System.out.println("CPF: " + piloto.getCpf());
        System.out.println("Passaporte: " + piloto.getPassaporte());
    }
}
