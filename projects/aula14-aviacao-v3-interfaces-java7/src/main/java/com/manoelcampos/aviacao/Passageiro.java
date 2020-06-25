package com.manoelcampos.aviacao;

import java.time.LocalDate;

/**
 * Veja a documentação da classe {@link Piloto} antes desta.
 * Tudo que se aplica a ela, é aplicado à classe Passageiro.
 * 
 * @author Manoel Campos da Silva Filho <http://github.com/manoelcampos>
 */
public class Passageiro implements IPessoaFisica {
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
