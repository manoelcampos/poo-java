
/**
 * A estrutura básica de declaração de uma classe em Java é:
 * public class NomeDaClasse {
 * }
 * 
 * Por convenção da UML (Unified Modeling Language, Linguagem de Modelagem Unificada),
 * nomes de classes devem ter cada palavra com inicial maiúscula.
 * Veja alguns exemplos:
 * - Fornecedor
 * - PessoaFisica
 * - Cliente
 */
public class Cliente
{
    /**
     * As características de uma classe são definidas pelo
     * que chamamos em POO de atributos ou campos.
     * Um atributo nada mais é do que uma variável.
     * Assim, sua declaração segue a estrutura:
     *  tipo nomeDoAtributo;
     *  
     * Nomes de atributos devem iniciar com minúscula e intercalar maiúsculas.
     * Assim como na declaração de qualquer variável, apesar
     * de ser possível declarar atributos de um mesmo tipo todos em uma mesma linha,
     * isto não é uma boa prática de programação.
     * 
     * Os atributos devem ser declarados um em cada linha, para permitir que seja
     * incluída documentação individual para cada um.
     * 
     * A documentação de elementos como classes e atributos em Java é feita 
     * incluíndo-se um comentário começando com / e dois asteriscos e terminando com * e /,
     * como é o caso deste comentário aqui.
     * 
     * Observe que antes da declaração do atributo foi utilizada a palavra private
     * para indicar que cada atributo é privado. 
     * Isto indica que o valor do atributo não pode ser alterado indiscriminadamente
     * por qualquer um. Veremos mais sobre esse assunto posteriormente.
     * 
     * Como os atributos são por convenção declarados como privados, para conseguirmos
     * obter e alterar o valor de um atributo de um objeto, precisamos incluir métodos
     * para isso, como é mostrado no interior da classe.
     */
    private String nome;
    private double renda;
    private String cpf;
    private String endereco;
    private String dataNascimento;
    private char sexo;
    private String celular;
    private String telefoneResidencial;    
    private String email;
    
    /**
     * O código abaixo apresenta uma função em Java.
     * Funções são blocos de código reutilizáveis, delimitados por chaves,
     * que permitem executar uma determinada tarefa.
     * São reutilizáveis porque permitem que tal código seja executado
     * múltiplas vezes sempre que necessário.
     * 
     * Uma função é um bloco de código que executa um trecho de código
     * bem específico para resolver um determinado problema e pode
     * retornar um valor como resposta.
     * Se criarmos por exemplo uma função para calcular o desconto 
     * de um determinado produto a partir do percentual, tal função
     * deve retornar como resposta o valor em reais do desconto 
     * a ser concedido no produto.
     * 
     * A estrutura de uma função é:
     *      TipoDeRetorno nomeDaFuncao(parâmetros opcionais){
     *          //código da função aqui
     *      }
     *      
     * O nome de funções segue a mesma regra de atributos:
     * inicia com minúsculas e intercala maiúsculas.
     *      
     * Funções podem ou não ter parâmetros, que são informações
     * que a função solicita para ela poder executar sua tarefa.
     * Por exemplo, podemos criar uma função que verifica se um
     * determinado email é válido ou não. Para tal função executar
     * esta tarefa, é necessário que informemos a ela qual o email que
     * desejamos verificar sua validade. A função então receberá o email
     * informado, fará as verificações necessárias e retornará como
     * resposta se o email é válido ou não (um valor lógico/booleano neste caso).
     * 
     * A função abaixo é responsável apenas por informar qual o valor 
     * do atributo renda de um cliente. Assim, quando a função é chamada (executada),
     * dizemos que ela retorna a renda. Quando usamos esta função, estamos pedindo a ela
     * que nos informe qual a renda do cliente, como se estivéssemos fazendo uma pergunta ou pedido
     * à função. Ou seja, ao chamar esta função, estamos perguntando a ela qual a renda de um cliente.
     * Também podemos dizer que estamos pedindo à função que nos diga qual a renda de um determinado cliente.
     * 
     * Funções que obtém o valor de um atributo tem a seguinte estrutura:
     *      TipoDoAtributo getNomeDoAtributo(){
     *          return atributo;
     *      }
     *      
     * Por convenção, o nome de tais funções deve ser formado pela palavra get 
     * seguida do nome do atributo. O tipo de retorno destas funções em específico 
     * deve ser o mesmo do atributo, pois a finalidade de tais funções
     * é retornar o valor de um determinado atributo.
     * Tais funções não recebem parâmetros, pois estamos apenas perguntando
     * a elas qual o valor de um determinado atributo. A função
     * tem que apenas responder informando tal valor, sem nos fazer nenhuma
     * pergunta para poder atender nosso pedido. 
     * Funções em Java são definidas apenas dentro de classes 
     * (em Java 8 existe outra possibilidade que não vem ao caso agora).
     * Se chamarmos uma função para ela nos informar qual o valor de um determinado
     * atributo, a função tem acesso total ao atributo declarado dentro da classe,
     * pois a função também foi declarada dentro da classe.
     * Desta forma, ela não precisa de nenhuma informação adicional para nos 
     * retornar o valor do atributo.
     * 
     */
    public double getRenda(){
        return renda;
    }
    
    /**
     * Como desejamos que o atributo renda possa ser alterado,
     * precisamos então criar outra função para permitir isso.
     * Tal função segue a seguinte estrutura básica:
     * 
     *      void setNomeDoAtributo(TipoDoAtributo nomeDoAtributo){
     *          this.nomeDoAtributo = nomeDoAtributo;
     *      }
     *      
     *  Assim como as funções usadas para retornar o valor de um atributo,
     *  as usadas para alterar tais valores devem ter um nome específico,
     *  iniciando com a palavra set, seguida do nome do atributo.
     *  Tais funções são encarregadas de alterar o valor de um determinado
     *  atributo de acordo com o que desejarmos.
     *  Deste modo, quando chamarmos tais funções, precisamos
     *  informar para elas qual o valor que queremos que seja armazenado
     *  no atributo. Isto é o que chamamos de parâmetros (como explicado na função getRenda).
     *  Os parâmetros são apenas variáveis declaradas dentro dos parênteses da função.
     *  Toda função, mesmo que não tenha parâmetros, precisa ter parênteses após seu nome.
     *  
     *  Uma função que obtém o valor de um atributo precisar ter um tipo de retorno, pois
     *  ela deve dar uma resposta com a informação solicitada.
     *  Já uma função que altera o valor de um atributo normalmente apenas recebe o valor a 
     *  ser armazenado no atributo e não dá nenhuma resposta, nenhuma confirmação.
     *  Ela simplesmente faz o que precisa fazer e não informa por meio de uma resposta
     *  de a operação foi executada ou não.
     *  Para indicar que tal função não retorna um valor (uma resposta), é preciso colocar
     *  void no tipo de retorno (antes do nome da função).
     *  
     *  Se uma função não consegue executar suas operações por algum motivo,
     *  normalmente utiliza-se outros mecanismos para comunicar 
     *  a quem chamou a função que a operação não foi realizada com sucesso. 
     *  Tais mecanismos serão visto ao longo do curso.
     *  
     *  No código da função abaixo, vemos que a função faz algo a mais do que simplesmente
     *  receber um valor e armazenar tal valor no atributo renda: ela verifica se o valor
     *  informado é válido (se é positivo) e só então armazena o valor.
     *  Caso o valor seja inválido, ela exibe uma mensagem.
     *  Esta exibição de mensagens não é a forma correta de informar que a função
     *  não foi executada com sucesso. É apenas uma forma inicial para podermos 
     *  ver quando o valor informado for incorreto.
     *  
     *  Uma função que é responsável por alterar o valor de um atributo
     *  precisa receber o valor a ser armazenado em tal atributo por meio de um parâmetro.
     *  Este parâmetro é apenas uma variável. Ele é chamado de parâmetro pois
     *  é uma variável que a função solicitará que seja informado um valor pra ela 
     *  no momento em que a função for chamada. Ou seja, a função solicita informações
     *  por meio dos parâmetros definidos nela.
     *  
     *  Funções que então alteram o valor de um atributo precisam pegar o valor 
     *  recebido em seu único parâmetro e armazenar tal valor no respectivo atributo.
     *  Observe que, por convenção, como o nome do parâmetro deve ter o mesmo 
     *  nome do atributo, que neste caso chama renda, se incluírmos
     *  uma instrução como: 
     *      renda = renda;
     *  na intenção de obter o valor do parâmetro renda (à esquerda) e armazenar
     *  no atributo renda (à direita), na verdade, a linha de código apresentada 
     *  não vai causar o efeito esperado. Isto porque como o atributo e o parâmetro
     *  tem o mesmo nome, com a linha acima, não temos como distinguir um do outro.
     *  Com tal linha, o que na verdade estamos fazendo é pegar o valor do parâmetro
     *  renda e armazenar no próprio parâmetro renda. Ou seja, estamos trocando seis por
     *  meia dúzia.
     *  
     *  O Java considera que naquela linha, renda se refere ao parâmetro renda.
     *  Isto se explica pelo fato de que o parâmetro renda é o que estaria mais próximo
     *  da linha apresentada acima (uma vez que o atributo é declarado lá no topo da classe).
     *  Assim, para fazer indicar que desejamos acessar o atributo renda, precisamos
     *  neste caso usar this.renda. Então, a instrução de atribuição fica como
     *  this.renda = renda;
     *  
     *  this significa este/isto. Tal palavra é usada para nos referirmos ao objeto atual.
     *  Neste caso então, this representa o objeto cliente no qual estamos tentando alterar 
     *  seu atributo renda.
     *  
     *  Uma forma de evitar tal confusão inicial é declarar o parâmetro com um nome diferente
     *  do atributo, como por exemplo novaRenda. Assim, poderíamos fazer renda = novaRenda
     *  e não teríamos que usar this. Apesar de isto ser mais simples, não é o convencional.
     *  A maioria dos códigos que encontrarem vai utilizar o atribruto e parâmetro com o mesmo nome.
     */
    public void setRenda(double renda){
        if(renda >= 0) {
            this.renda = renda;
        } else {
            System.out.println("A renda não pode ser negativa!");
        }
    }
  
}
