package br.com.manoelcampos.loja.pessoas;


import java.time.LocalDate;

/**
 * Write a description of class PessoaJuridica here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PessoaJuridica extends Pessoa
{
    private String cnpj;
    private String razaoSocial;
    private String inscricaoEstadual;
    private String inscricaoMunicipal;
    private String site;
    private LocalDate dataFundacao;

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        if (cnpj.trim().isEmpty()) {
            throw new IllegalArgumentException("O CNPJ é obrigatório");
        } else if (!isCnpjValido(cnpj)) {
            throw new IllegalArgumentException("O CNPJ é inválido");
        } else {
            this.cnpj = cnpj;
        }
    }

    /**
     * Verifica se um CNPJ é válido. Código adaptado de um péssimo exemplo de
     * validação de CNPJ obtido em http://www.guj.com.br/t/validar-cnpj/129994/7,
     * 
     * @param cnpj CNPJ a ser validado
     * @return true se o CNPJ for válido, false otherwise
     */
    public boolean isCnpjValido(String cnpj) {
        cnpj = removerSimbolos(cnpj);

        if (cnpj.length() != 14) {
            return false;
        }

        int soma1 = somaAlgarismos(cnpj, 0, 4) + somaAlgarismos(cnpj, 4, 8);
        int d1 = calculaDigito(soma1);

        int soma2 = somaAlgarismos(cnpj, 0, 5) + somaAlgarismos(cnpj, 5, 8);
        int d2 = calculaDigito(soma2);

        String digVerificadorCalculado = Integer.toString(d1) + Integer.toString(d2);
        String digVerificadorExistente = cnpj.substring(cnpj.length() - 2, cnpj.length());
        return digVerificadorExistente.equals(digVerificadorCalculado);
    }

    /**
     * @return the razaoSocial
     */
    public String getRazaoSocial() {
        return razaoSocial;
    }

    /**
     * @param razaoSocial the razaoSocial to set
     */
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    /**
     * @return the inscricaoEstadual
     */
    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    /**
     * @param inscricaoEstadual the inscricaoEstadual to set
     */
    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    /**
     * @return the inscricaoMunicipal
     */
    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    /**
     * @param inscricaoMunicipal the inscricaoMunicipal to set
     */
    public void setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

    /**
     * @return the site
     */
    public String getSite() {
        return site;
    }

    /**
     * @param site the site to set
     */
    public void setSite(String site) {
        this.site = site;
    }

    /**
     * @return the dataFundacao
     */
    public LocalDate getDataFundacao() {
        return dataFundacao;
    }

    /**
     * @param dataFundacao the dataFundacao to set
     */
    public void setDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
    }
    
    public static void main(String[] args) {
        PessoaJuridica p = new PessoaJuridica();
        String cnpj = "10.742.006/0001-98";
        System.out.println("Cnpj Válido "+cnpj+": " + p.isCnpjValido(cnpj));
    }
}
