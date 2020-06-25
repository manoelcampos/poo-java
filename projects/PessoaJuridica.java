
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

    /**
     * Soma uma determinada sequência de algarismos de um CPF ou CNPJ.
     * Tal some é utilizada para posteriormente calcular um dígito verificador.
     * 
     * @param cnpj cnpj para fazer a soma de alguns algarismos
     * @param inicio posição inicial de onde os algarismos serão somados
     * @param totalAlgarismos total de algarismos para somar
     * @return a soma dos algarismos indicados
     */
    private int somaAlgarismos(String cnpj, int inicio, int totalAlgarismos) {
        int soma = 0;
        int algarismo;
        char []vetor = cnpj.toCharArray();
        for (int i = 0; i < totalAlgarismos; i++) {
            /*Na linha abaixo estamos obtendo o código ASCII do caractere
            (algarismo do CPNJ) e subtraindo 48 para obter tal
            caractere como inteiro, sem precisar utilizar funções
            como Integer.valueOf(). Como o CNPJ é String,
            se em uma posição temos o valor '0', este valor é char
            e assim não podemos fazer contas utilizando tal valor.
            O código ASCII do caractere '0' é 48. Logo, se subtraírmos
            48 de tal código, obtemos 0 (que é o valor inteiro correspondente
            ao caractere '0').*/
            algarismo = vetor[i+inicio] - 48;
            soma += algarismo * (totalAlgarismos + 1 - i);
        }

        return soma;
    }    

    /**
     * Calcula um dígito verificador de um CPF ou CNPJ utilizando o algoritmo módulo 11.
     * 
     * @param somaAlgarismos soma de um determinado número de algarismos de um CPF ou CNPJ,
     *                       que será usada para calcular um dígito verificador
     * @return o dígito verificador calculado
     */
    private int calculaDigito(int somaAlgarismos) {
        int dig = 11 - (somaAlgarismos % 11);
        return dig > 9 ? 0 : dig;
    }

    public boolean isCnpjValido(String cnpj) {
        // Remove caracteres não numéricos do CPF
        cnpj = cnpj.replaceAll("\\D", "");

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
     * Péssimo exemplo de validação de CNPJ obtido em
     * http://www.guj.com.br/t/validar-cnpj/129994/7,
     * apesar de ter um pequeno truque bem inteligente
     * para converter char para inteiro subtraindo 48, 
     * dispensando o uso de Integer.valueOf() para a conversão.
     */
    private boolean isCnpjValidoAdaptado(String cnpj) {
        if (!cnpj.substring(0, 1).equals("")) {
            try {
                cnpj = cnpj.replace('.', ' ');// onde há ponto coloca espaço
                cnpj = cnpj.replace('/', ' ');// onde há barra coloca espaço
                cnpj = cnpj.replace('-', ' ');// onde há traço coloca espaço
                cnpj = cnpj.replaceAll(" ", "");// retira espaço
                int soma = 0, dig;
                String cnpj_calc = cnpj.substring(0, 12);
                if (cnpj.length() != 14) {
                    return false;
                }
                char[] chr_cnpj = cnpj.toCharArray();
                /* Primeira parte */
                for (int i = 0; i < 4; i++) {
                    if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                        soma += (chr_cnpj[i] - 48) * (6 - (i + 1));
                    }
                }
                for (int i = 0; i < 8; i++) {
                    if (chr_cnpj[i + 4] - 48 >= 0 && chr_cnpj[i + 4] - 48 <= 9) {
                        soma += (chr_cnpj[i + 4] - 48) * (10 - (i + 1));
                    }
                }
                dig = 11 - (soma % 11);
                cnpj_calc += (dig == 10 || dig == 11) ? "0" : Integer.toString(dig);

                /* Segunda parte */
                soma = 0;
                for (int i = 0; i < 5; i++) {
                    if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                        soma += (chr_cnpj[i] - 48) * (7 - (i + 1));
                    }
                }
                for (int i = 0; i < 8; i++) {
                    if (chr_cnpj[i + 5] - 48 >= 0 && chr_cnpj[i + 5] - 48 <= 9) {
                        soma += (chr_cnpj[i + 5] - 48) * (10 - (i + 1));
                    }
                }
                dig = 11 - (soma % 11);
                cnpj_calc += (dig == 10 || dig == 11) ? "0" : Integer.toString(dig);

                return cnpj.equals(cnpj_calc);
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }   

    public static void main(String[] args) {
        PessoaJuridica p = new PessoaJuridica();
        System.out.println("isCnpjValido 10.742.006/0001-98: " + p.isCnpjValido("10.742.006/0001-98"));
    }
}
