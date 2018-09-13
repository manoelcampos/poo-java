package com.manoelcampos.aviacao;

import java.time.LocalDate;

/**
 * Para resolver o problema apresentado na classe {@link Passageiro},
 * vamos criar os mesmos getters e setters que existem em {@link Pessoa}
 * e {@link PessoaFisica}, para assim, podermos voltar a usar a classe Piloto
 * como se existisse um relacionamento de herança entre ela e a {@link PessoaFisica}
 * (que por sua vez herda de {@link Pessoa}).
 * Alguns destes métodos são getNome(), setNome(), getCpf(), setCpf(), etc.
 * Veja o código do método main para detalhes.
 * 
 * <p>Apesar de todo o trabalho adicional, trouxemos de volta a simplificidade
 * de usar um Piloto. Para que o Passageiro tenha esta mesma simplificidade,
 * teremos que repetir a inclusão dos mesmos methodos que criamos
 * aqui.</p>
 * 
  * <p>Se apenas copiarmos todos os métodos introduzidos aqui,
 * desde getNome() até o setDataNascimento() e colarmos na classe
 * Passageiro, vai funcionar sem um único erro.
 * Porém, isto vai contra tudo o que falamos em praticamente
 * todas as aulas sobre evitar duplicação de código ao máximo.
 * Estaremos não apenas duplicando algumas linhas de código, mas
 * um enorme conjunto de métodos inteiros.</p>
 * 
 * <p>Adicionalmente, além do re-trabalho, esta abordagem não garante que
 * os mesmos métodos de Pessoa e PessoaFisica existirão tanto no Piloto quanto
 * no Passageiro. Um programador pode incluir ou copiar apenas alguns dos métodos
 * citados na classe Passageiro. Por exemplo, ele pode não incluir
 * o getCpf() ou setCpf(). Desta forma, o Piloto teria tais métodos
 * e o Passageiro não, o que seria muito estranho e confuso.
 * Se o Passageiro e Piloto são pessoas físicas, como pode
 * o Piloto ter tais métodos e o Passageiro não?
 * 
 * Para resolver o problema, veja a próxima versão deste projeto.
 * </p>
 * 
 * @author Manoel Campos da Silva Filho <http://github.com/manoelcampos>
 */
public class Piloto {
    private PessoaFisica pessoaFisica;
    
    public Piloto(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }
    
    public String getNome() {
        return pessoaFisica.getNome();
    }

    public void setNome(String nome) {
        pessoaFisica.setNome(nome);
    }

    public String getEmail() {
        return pessoaFisica.getEmail();
    }

    public void setEmail(String email) {
        pessoaFisica.setEmail(email);
    }
    
    public String getCpf() {
        return pessoaFisica.getCpf();
    }

    public void setCpf(String cpf) { 
        pessoaFisica.setCpf(cpf);
    }

    public char getSexo() {
        return pessoaFisica.getSexo();
    }

    public void setSexo(char sexo) {
        pessoaFisica.setSexo(sexo);
    }

    public String getPassaporte() {
        return pessoaFisica.getPassaporte();
    }

    public void setPassaporte(String passaporte) {
        pessoaFisica.setPassaporte(passaporte);
    }

    public LocalDate getDataNascimento() {
        return pessoaFisica.getDataNascimento();
    }

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
