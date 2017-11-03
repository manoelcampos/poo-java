
    /**
     * Verifica se um CPF é válido.
     * 
     * Pode-se testar com CNPJ de qualquer empresa ou instituição como o IFTO,
     * cujo CNPJ é 10.742.006/0001-98.
     * 
     * @param cnpj O CNPJ a ser verificado
     * @return true se o CNPJ for válido, false caso contrário.
     */
    boolean CnpjValido(String cnpj)
    {
        cnpj = cnpj.replaceAll("\\.", "");
        cnpj = cnpj.replaceAll("-", "");
        cnpj = cnpj.replaceAll("/", "");
        if (cnpj.length() != 14){
            return false;
        }
        
       int soma = 0, aux, dig;
       String cnpj_calc = cnpj.substring(0,12);

       if ( cnpj.length() != 14 )
         return false;

       char[] chr_cnpj = cnpj.toCharArray();

       for( int i = 0; i < 4; i++ )
         if ( chr_cnpj[i]-48 >=0 && chr_cnpj[i]-48 <=9 )
           soma += (chr_cnpj[i] - 48) * (6 - (i + 1)) ;
       for( int i = 0; i < 8; i++ )
         if ( chr_cnpj[i+4]-48 >=0 && chr_cnpj[i+4]-48 <=9 )
           soma += (chr_cnpj[i+4] - 48) * (10 - (i + 1)) ;
       dig = 11 - (soma % 11);

       cnpj_calc += ( dig == 10 || dig == 11 ) ?
                      "0" : Integer.toString(dig);

       soma = 0;
       for ( int i = 0; i < 5; i++ )
         if ( chr_cnpj[i]-48 >=0 && chr_cnpj[i]-48 <=9 )
           soma += (chr_cnpj[i] - 48) * (7 - (i + 1)) ;
       for ( int i = 0; i < 8; i++ )
         if ( chr_cnpj[i+5]-48 >=0 && chr_cnpj[i+5]-48 <=9 )
           soma += (chr_cnpj[i+5] - 48) * (10 - (i + 1)) ;
       dig = 11 - (soma % 11);
       cnpj_calc += ( dig == 10 || dig == 11 ) ?
                      "0" : Integer.toString(dig);

       return cnpj.equals(cnpj_calc);
    }