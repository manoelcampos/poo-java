
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
        this.cnpj = cnpj;
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
}
