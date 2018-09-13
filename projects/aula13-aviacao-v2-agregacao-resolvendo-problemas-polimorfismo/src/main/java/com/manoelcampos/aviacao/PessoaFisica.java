package com.manoelcampos.aviacao;

import java.time.LocalDate;

/**
 *
 * @author Manoel Campos da Silva Filho <http://github.com/manoelcampos>
 */
public class PessoaFisica extends Pessoa {
    private String cpf;
    private char sexo;
    private String passaporte;
    private LocalDate dataNascimento;

    public PessoaFisica(String nome, char sexo) {
        super(nome);
        setSexo(sexo);
    }

    public PessoaFisica(String nome, char sexo, String cpf) {
        super(nome);
        setSexo(sexo);
        setCpf(cpf);
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Altera o CPF.
     * @param cpf CPF a ser armazenado
     * @throws IllegalArgumentException quando o CPF for inválido ou vazio
     */
    public void setCpf(String cpf) { 
        if(cpf.trim().isEmpty()){
            throw new IllegalArgumentException("O CPF é obrigatório");
        } else if(!isCpfValido(cpf)) {
            throw new IllegalArgumentException("O CPF é inválido");
        } else {
            this.cpf = cpf;
        }
    }

    /**
     * Verifica se um CPF é válido ou não, utilizando o algorítmo denominado Módulo
     * 11, como descrito em
     * https://pt.wikipedia.org/wiki/Dígito_verificador#Módulo_11.
     * 
     * @param cpf CPF a ser validado
     * @return true se o CPF for válido, false caso contrário.
     */
    public boolean isCpfValido(String cpf) {
        // Remove caracteres não numéricos do CPF
        cpf = removerSimbolos(cpf);

        if (cpf.length() != 11) {
            return false;
        }

        int soma1 = somaAlgarismos(cpf, 0, 9);
        int d1 = calculaDigito(soma1);

        int soma2 = somaAlgarismos(cpf, 0, 10);
        int d2 = calculaDigito(soma2);

        // Converte os dígitos calculados de int para String e une (concatena) os dois
        // numa só String.
        String digVerificadorCalculado = String.valueOf(d1) + String.valueOf(d2);
        // Copia os 2 últimos dígitos do CPF informado, para comparar com os dígitos
        // calculados
        String digVerificadorExistente = cpf.substring(cpf.length() - 2, cpf.length());

        // Compara os 2 últimos dígitos do CPF com os 2 calculados.
        // Se forem iguais, o CPF é válido.
        return digVerificadorExistente.equals(digVerificadorCalculado);
    }

    /**
     * @return the sexo
     */
    public char getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the passaporte
     */
    public String getPassaporte() {
        return passaporte;
    }

    /**
     * @param passaporte the passaporte to set
     */
    public void setPassaporte(String passaporte) {
        this.passaporte = passaporte;
    }

    /**
     * @return the dataNascimento
     */
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @param dataNascimento the dataNascimento to set
     */
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
