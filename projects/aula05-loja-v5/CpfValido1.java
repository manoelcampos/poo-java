    /**
     * Verifica se um CPF é válido.
     * Obtido de http://www.guj.com.br/t/validar-cpf/56329 como um exemplo de péssimo código
     * (e ele já foi melhorado levemente).
     * 
     * @param cpf CPF a ser verificado
     * @return true se o CPF for válido, false caso contrário.
     */
    
    /*
    public boolean isCpfValido (String cpf) {
        cpf = cpf.replaceAll("\\D", "");

        if (cpf.length() != 11){
            return false;
        }

        int d1 = 0, d2 = 0;
        int digito;
        for (int i = 0; i < cpf.length()-2; i++) {
            digito = Integer.valueOf(cpf.substring(i, i+1));

            d1 = d1 + (10 - i) * digito;
            d2 = d2 + (11 - i) * digito;
        }

        int resto = (d1 % 11);
        d1 = 0;
        if (resto >= 2){
            d1 = 11 - resto;
        }

        d2 += 2 * d1;

        resto = (d2 % 11);
        d2 = 0;
        if (resto >= 2) {
            d2 = 11 - resto;
        }

        String digVerificadorCalculado = String.valueOf(d1) + String.valueOf(d2);
        String digVerificadorExistente = cpf.substring(cpf.length()-2, cpf.length());

        return digVerificadorExistente.equals(digVerificadorCalculado);
    }
    
    */
