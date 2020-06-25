package com.manoelcampos.aviacao;

/**
 *
 * @author Manoel Campos da Silva Filho <http://github.com/manoelcampos>
 */
public class PessoaJuridica extends Pessoa {
    private String cnpj;
    private String areaAtuacao;

    public PessoaJuridica(String nome, String cnpj) {
        super(nome);
        setCnpj(cnpj);
    }

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
     * @return the areaAtuacao
     */
    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    /**
     * @param areaAtuacao the areaAtuacao to set
     */
    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }
}
