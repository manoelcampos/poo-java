package com.manoelcampos.aviacao;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Manoel Campos da Silva Filho <http://github.com/manoelcampos>
 */
public class CompanhiaAerea extends PessoaJuridica{
    private String numeroAutorizacaoAnac;
    private List<Aviao> avioes;

    public CompanhiaAerea(String nome, String cnpj) {
        super(nome, cnpj);
        this.avioes = new ArrayList<>();
    }

    /**
     * @return the numeroAutorizacaoAnac
     */
    public String getNumeroAutorizacaoAnac() {
        return numeroAutorizacaoAnac;
    }

    /**
     * @param numeroAutorizacaoAnac the numeroAutorizacaoAnac to set
     */
    public void setNumeroAutorizacaoAnac(String numeroAutorizacaoAnac) {
        this.numeroAutorizacaoAnac = numeroAutorizacaoAnac;
    }

    /**
     * @return the avioes
     */
    public List<Aviao> getAvioes() {
        return avioes;
    }

    /**
     * @param avioes the avioes to set
     */
    public void addAviao(Aviao aviao) {
        aviao.setCompanhiaAerea(this);
        this.avioes.add(aviao);
    }

}
