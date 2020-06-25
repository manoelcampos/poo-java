package com.manoelcampos.aviacao;

/**
 * Veja a documentação da interface {@link Passageiro} antes desta.
 * Tudo que foi dito lá vale para esta classe.
 * 
 * @author Manoel Campos da Silva Filho <http://github.com/manoelcampos>
 */
public class Piloto implements IPessoaFisica {

    private PessoaFisica pessoaFisica;

    public Piloto(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    @Override
    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
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
