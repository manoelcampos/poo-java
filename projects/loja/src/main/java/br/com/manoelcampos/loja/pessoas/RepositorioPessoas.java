package br.com.manoelcampos.loja.pessoas;

import br.com.manoelcampos.loja.geral.Cidade;
import java.util.*;

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
public class RepositorioPessoas {
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
    public Map<Cidade, List<Pessoa>> pessoaPorCidade(List<Pessoa> pessoas){
        /*
        No caso deste método, a chave do mapa retornado (declarado abaixo) são Cidades.
        Para cada Cidade terá associada a ela a lista de Pessoas que moram 
        naquela cidade. Imagine o mapa como um vetor que, no lugar das posições
        serem definidas por números (índices inteiros), são definidas 
        por qualquer classe que desejarmos. Neste caso, as posições são definidas
        por objetos da classe Cidade. Imaginando que este mapa é um vetor cujos
        índices são do tipo Cidade e não int, seria como no lugar de fazer
        mapa[i] (onde i é um número inteiro), fazemos mapa[cidade] (onde cidade
        é um objeto da classe Cidade) para acessarmos os dados
        armazenados na posição indicada pela cidade informada.
        No entanto, como mapa não é um vetor, no lugar de fazer mapa[cidade]
        fazemos mapa.get(cidade)        
        */
        Map<Cidade, List<Pessoa>> mapa = new HashMap<>();
        
        /*
        Para construirmos nosso mapa contendo a sublista de pessoas agrupadas por cidade,
        temos que primeiro pegar a cidade de cada cliente na lista com todos os clientes
        e adicionar tais cidades ao mapa. 
                */
        for (Pessoa pessoa : pessoas) {
            /*
            A cada cidade devemos associar inicialmente uma lista vazia
            que será preenchida com as pessoas pertencentes àquela cidade.
            Para adicionar tal lista à uma cidade do mapa, 
            usamos o método put (numa List usamos add), indicando
            qual a cidade queremos adicionar e qual a lista de pessoas (neste caso uma lista inicialmente vazia).
            Um mapa não permite que haja chaves duplicadas. Assim, se uma cidade
            for adicionada como chave e tentarmos adicionar a mesma cidade novamente,            
            o registro anterior daquele cidade será alterado com a nova informação fornecida
            no segundo parâmetro do método put. 
            */
            mapa.put(pessoa.getCidade(), new ArrayList<>());
        }
        
        /*
        Agora que já temos todas as cidades no mapa, contendo uma lista
        vazia para adicionar as pessoas de cada cidade,
        podemos então começar a adicionar as pessoas a respectiva
        lista de pessoas da cidade.
         */
        for (Pessoa pessoa : pessoas) {
            /*
            Primeiramente temos que pegar a lista de pessoas associada
            à cidade da pessoa atual de dentro do mapa.
            Lembre que antes deste for, a lista de todas as cidades
            estará vazia.
            */
            List<Pessoa> pessoasCidade = mapa.get(pessoa.getCidade());
            
            /*
            De posse da lista de pessoas da cidade da pessoa atual,
            apenas adicionamos tal pessoa a lista da cidade a qual ela
            corresponde. Como a lista já está associada à cidade no mapa,
            não precisamos atualizar o mapa. Atualizando a lista,
            o mapa verá que a lista de pessoas de uma determinada cidade mudou.
            */
            pessoasCidade.add(pessoa);
        }

        //Por fim, retornanmos o mapa com uma sublista de pessoas para cada cidade encontrada.
        return mapa;
    }
    
    /**
     * Incluir aqui o código para testar o método {@link #pessoaPorCidade(java.util.List)}.
     * O método main deve:
     * - criar várias cidades;
     * - criar uma lista de pessoas dessas várias cidades;
     * - usar o método {@link #pessoaPorCidade(java.util.List)} para
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
     * execício.
     * </p>
     * @param args 
     */
    public static void main(String[] args) {
        
    }
}
