package br.com.manoelcampos.loja.pessoas;

import br.com.manoelcampos.loja.geral.Cidade;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Manoel Campos da Silva Filho <http://github.com/manoelcampos>
 */
public class Teste {
    public void imprimirPessoas(List<Pessoa> pessoas){
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa);
        }
    }
    
    public static void main(String[] args) {
        Teste teste = new Teste();
        
        List<Pessoa> pessoas2 = new ArrayList<>();
        pessoas2.add(new Pessoa("Manoel", null));
        pessoas2.add(new PessoaFisica("João", null));
        pessoas2.add(new PessoaJuridica());
        
        Pessoa p1 = new Pessoa("Breno", null);
        Pessoa p2 = new PessoaFisica("Olga", null);
        
        List<PessoaFisica> pessoasFisicas = new ArrayList<>();
        pessoasFisicas.add(new PessoaFisica("Manoel", null));
        pessoasFisicas.add(new PessoaFisica("Breno", null));
        
        teste.imprimirPessoas(pessoas2);
        teste.imprimirPessoas(pessoasFisicas);
        
        //pessoas2 = pessoasFisicas;
    }    
}
