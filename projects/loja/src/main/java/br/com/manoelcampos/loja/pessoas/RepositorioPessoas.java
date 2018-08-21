package br.com.manoelcampos.loja.pessoas;

import br.com.manoelcampos.loja.geral.Cidade;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Esta classe é uma primeira versão a ser utilizada
 * para demonstrar como criar uma classe genérica (ou seja, utilizando
 * polimorfismo paramêtrico). 
 * 
 * A classe ainda não faz uso de tal recurso. Está sendo apenas criada
 * a estrutura básica para isso.
 * 
 * @author Manoel Campos da Silva Filho <http://github.com/manoelcampos>
 */
public class RepositorioPessoas <T extends Pessoa> {
    /**
     * Recebe uma lista de pessoas e processa tal lista, agrupando
     * as pessoas de uma mesma cidade em sublistas.
     * Esta é uma operação que não temos como fazer usando linguagens como SQL.
     * Em SQL, o máximo que conseguimos é saber o total de pessoas por cidade,
     * ou a idade da pessoa mais velha por cidade, ou a média de idade das
     * pessoas por cidade, etc. 
     * A não ser que estejamos usando algum framework para agilizar
     * o processo de desenvolvimento, temos que escrever código caso
     * desejarmos obter as pessoas agrupadas por cidade.
     * 
     * @param pessoas lista de pessoas de várias cidades
     * @return uma mapa ({@link Map}) que é um tipo de cada que é como uma tabela
     * de banco de dados contendo duas colunas: a primeira coluna é como a chave primária 
     * (Primary Key, PK) e a segunda contém os dados associados a tal chave.
     */
    public Map<Cidade, List<T>> pessoasPorCidade(List<T> pessoas){
        //Usa o recurso de streams do Java 8 para fazer o mesmo que fazia antes
        //com 9 linhas de código
        return pessoas.stream().collect(Collectors.groupingBy(T::getCidade));
    }
    
    
    /**
     * Incluir aqui o código para testar o método {@link #pessoasPorCidade(java.util.List)}.
     * O método main deve:
     * - criar várias cidades;
     * - criar uma lista de pessoas dessas várias cidades;
     * - usar o método {@link #pessoasPorCidade(java.util.List)} para
     *   receber a lista de pessoas e retornar um mapa agrupando tais pessoas por cidade;
     * - por fim, deve-se percorrer o mapa e imprimir o nome da cidade e o nome
     *   de cada pessoa associada àquela cidade.
     * 
     * <p>
     * Como referência para o uso de {@link Map}, veja
     * o curso da Caelum em https://www.caelum.com.br/apostila-java-orientacao-objetos/collections-framework/.
     * É recomendável que leia o material inteiro. Se quiser ler apenas o conteúdo referente ao {@link Map},
     * veja a introdução, seção 15.1 e 15.11.
     * Você deve ler também o tutorial em https://www.devmedia.com.br/hashmap-java-trabalhando-com-listas-key-value/29811,
     * que apresenta todos os detalhes necessários para manipular um Map que você precisará pra este 
     * exercício.
     * </p>
     * @param args 
     */
    public static void main(String[] args) {
        RepositorioPessoas rp = new RepositorioPessoas<>();

        Cidade palmas = new Cidade("Palmas");
        Cidade gurupi = new Cidade("Gurupi");
        Cidade paraiso = new Cidade("Paraiso");

        List<PessoaFisica> pessoasFisicas = new ArrayList<>();
        pessoasFisicas.add(new PessoaFisica("Manoel", palmas));
        pessoasFisicas.add(new PessoaFisica("Breno", gurupi));
        pessoasFisicas.add(new PessoaFisica("Maria", palmas));
        pessoasFisicas.add(new PessoaFisica("Raysa", paraiso));
        pessoasFisicas.add(new PessoaFisica("Olga", paraiso));

        Map<Cidade, List<PessoaFisica>> mapa = rp.pessoasPorCidade(pessoasFisicas);
        for (Cidade cidade : mapa.keySet()) {
            List<PessoaFisica> pessoasCidade = mapa.get(cidade);
            System.out.println("Cidade: " + cidade);
            System.out.println("\tPessoas: " + pessoasCidade);
        }
        
        List<Pessoa> pessoas2 = new ArrayList<>();
        pessoas2.add(new Pessoa("Manoel", palmas));
        pessoas2.add(new PessoaFisica("João", palmas));
        pessoas2.add(new PessoaJuridica());
        
        Pessoa pessoa = new Pessoa("Breno", palmas);
        PessoaFisica pf = new PessoaFisica("Olga", paraiso);
        pessoa = pf;
        //pf = pessoa;
        
        rp.imprimirPessoas(pessoas2);
        rp.imprimirPessoas(pessoasFisicas);
        
        //pessoas2 = pessoasFisicas;
    }
    
    public void imprimirPessoas(List<T> pessoas){
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa);
        }
    }
}













