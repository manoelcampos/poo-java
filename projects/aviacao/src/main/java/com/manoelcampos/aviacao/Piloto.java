package com.manoelcampos.aviacao;

import java.time.LocalDate;

/**
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
    public String getNome(){
        return pessoaFisica.getNome();
    }

    @Override
    public String getCpf() {
        return pessoaFisica.getCpf();
    }

    @Override
    public char getSexo() {
        return pessoaFisica.getSexo();
    }

    @Override
    public LocalDate getDataNascimento() {
        return pessoaFisica.getDataNascimento();
    }
    
}
