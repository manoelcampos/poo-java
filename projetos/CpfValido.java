    /**
     * Verifica se um CPF é válido.
     * @param cpf CPF a ser verificado
     * @return true se o CPF for válido, false caso contrário.
     */
    boolean cpfValido (String cpf) {
        cpf = cpf.replaceAll("\\.", "");
        cpf = cpf.replaceAll("-", "");

        if (cpf.length() != 11){
            return false;
        }

        int d1 = 0, d2 = 0;
        int digitoCPF;
        for (int nCount = 1; nCount < cpf.length() -1; nCount++) {
            digitoCPF = Integer.valueOf (cpf.substring(nCount -1, nCount)).intValue();
            /*Multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4 e assim
            por diante.*/
            d1 = d1 + ( 11 - nCount ) * digitoCPF;
            /*Para o segundo digito repita o procedimento incluindo o primeiro digito
            calculado no passo anterior.*/
            d2 = d2 + ( 12 - nCount ) * digitoCPF;
        }

        //Primeiro resto da divisão por 11.
        int resto = (d1 % 11);
        /*Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o
        resultado anterior.*/
        int digito1 = 0;
        if (resto >= 2){
            digito1 = 11 - resto;
        }
        d2 += 2 * digito1;

        //Segundo resto da divisão por 11.
        resto = (d2 % 11);
        /*Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos
        o resultado anterior.*/
        int digito2 = 0;
        if (resto >= 2) {
            digito2 = 11 - resto;
        }

        //Digito verificador do CPF que está sendo validado.
        String nDigVerific = cpf.substring (cpf.length()-2, cpf.length());
        //Concatenando o primeiro resto com o segundo.
        String nDigResult = String.valueOf(digito1) + String.valueOf(digito2);
        //Comparar o digito verificador do cpf com o primeiro resto + o segundo resto.
        return nDigVerific.equals(nDigResult);
    }