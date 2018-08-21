package com.manoelcampos.aviacao;

import java.time.LocalDate;

/**
 *
 * @author Manoel Campos da Silva Filho <http://github.com/manoelcampos>
 */
public interface IPessoaFisica {
    String getNome();
    String getCpf();
    char getSexo();
    LocalDate getDataNascimento();
}
