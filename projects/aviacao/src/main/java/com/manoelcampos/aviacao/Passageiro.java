package com.manoelcampos.aviacao;

/**
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


}
