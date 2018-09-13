
import br.com.manoelcampos.loja.geral.Empresa;
import br.com.manoelcampos.loja.vendas.Venda;
import br.com.manoelcampos.loja.pessoas.Cliente;
import br.com.manoelcampos.loja.pessoas.Funcionario;
import br.com.manoelcampos.loja.pessoas.PessoaFisica;


public class Principal {
    /**
     * Executa uma aplicação que mostra como resolver
     * um dos problemas que podem surgir com o uso de herança:
     * quando temos, por exemplo, uma pessoa que pode ter múltiplos
     * papéis dentro de um sistemas. Este é o caso
     * de um funcionário que pode ser cadastrado como cliente.
     * Utilizando herança totalmente, se a pessoa já estiver
     * cadastrada como funcionário, ao cadastrá-la como cliente,
     * precisaremos duplicar todos os dados pessoais como
     * nome e CPF. Tais problemas foram relatados na versão anterior do projeto.
     * 
     * Esta versão apresenta a solução para tal problema com o uso 
     * de herança apenas entre as classes Pessoa, PessoaFisica e PessoaJuridica.
     * Desta forma, as classes Funcionario, Cliente e Empresa não herdarão
     * mais de PessoaFisica e PessoaJuridica.
     * 
     * Veja comentários nas classes Cliente e Funcionario para mais detalhes.
     * @param args 
     */
    public static void main(String[] args) {
        Empresa empresa = new Empresa();
        empresa.setNome("Lojas Mais");
        
        empresa.setCnpj("493848934");
        
        System.out.println(
            "Nome: " + empresa.getNome() + 
            " CNPJ: " + empresa.getCnpj() + "\n");
        
        /*
         * Como Funcionario e Cliente não herdam mais de PessoaFisica,
         * para criar um objeto destas classes, precisamos
         * primeiro criar um objeto da classe PessoaFisica.
         * Agora como não temos herança, o Cliente e Funcionario
         * não herdam mais nada de PessoaFisica e Pessoa.
         * Com herança, ao criar um Cliente, sabemos que
         * ele terá tudo que foi herdado de Pessoa e PessoaFisica,
         * mas no momento de instanciar um Cliente, só precisamos
         * declarar uma única variável Cliente e utilizar
         * apenas a classe Cliente. Podemos até esquecer que 
         * Pessoa e PessoaFisica existem, pois quando vamos
         * atribuir, por exemplo, o nome ao cliente,
         * apenas chamamos o método setNome(), como se este
         * método tivesse sido declarado diretamente na classe Cliente.
         * 
         * Como removemos a relação de herança do Cliente e Funcionario
         * com PessoaFisica, agora precisamos criar primeiramente um objeto
         * PessoaFisica para depois criar um cliente e informar
         * qual PessoaFisica aquele cliente representa (está relacionado).
         * 
         * Abaixo estamos então criando a PessoaFisica Manoel
         */
        PessoaFisica pessoaFisica = new PessoaFisica();
        pessoaFisica.setNome("Manoel Campos da Silva Filho");
        pessoaFisica.setCpf("11111111111");
        pessoaFisica.setEndereco("504 Sul");
        
        /*
         * Depois que criamos a PessoaFisica, podemos então criar
         * um Funcionario ou Cliente e indicar qual é a PessoaFisica
         * que ele representa. Estamos então criando um Funcionario
         * e dizendo que ele representa a PessoaFisica Manoel,
         * criada logo acima.
         * 
         * Em seguida, apenas precisamos definir os valores dos atributos
         * específicos do Funcionario ou Cliente.
         * No caso abaixo, estamos definindo o cargo do Funcionario.
         */
        Funcionario funcionario = new Funcionario(pessoaFisica);
        funcionario.setCargo("Vendedor");
        
        /*
         * No momento de cadastrar o Manoel (que já é Funcionario)
         * como Cliente, não precisamos criar outra PessoaFisica
         * e nem indicar novamente todos os dados de Pessoa e PessoaFisica,
         * pois o Manoel já existe como PessoaFisica (pois criamos ele 
         * para podermos cadastrá-lo como Funcionario).
         * Assim, apenas reutilizamos o cadastro (objeto) da PessoaFisica
         * para cadastrar o Cliente.
         * Só precisamos então definir os atributos que são específicos
         * do cliente (neste caso a renda).
         */
        Cliente cliente = new Cliente(pessoaFisica);
        cliente.setRenda(1000);
        
        /**
         * Observe que agora como Cliente e Funcionario não herdam de PessoaFisica,
         * eles não tem métodos como getNome(), setNome(), getCpf() e setCpf().
         * Assim, para podermos obter dados como o nome ou cpf, precisamos
         * primeiro obter a PessoaFisica vinculada ao Cliente ou Funcionario
         * e então a partir daí obter o nome, cpf ou qualquer outro
         * dado de Pessoa ou PessoaFisica.
         * 
         * Como temos uma variável pessoaFisica logo acima,
         * no lugar de usar cliente.getPessoaFisica().getNome()
         * poderíamos simplesmente usar pessoaFisica().getNome().
         * Mas a primeira linha é pra mostra que, caso não tivessemos 
         * uma variável pessoaFisica, a forma de obter os dados
         * de PessoaFisica de um Cliente seria somente da primeira forma.
         */
        System.out.println("------------------Dados do Cadastro Inicial-----------------");
        System.out.println("Nome do cliente: " + cliente.getPessoaFisica().getNome());
        System.out.println("CPF do cliente: " + cliente.getPessoaFisica().getCpf());
        System.out.println("Endereçco do cliente: " + cliente.getPessoaFisica().getEndereco());
        
        System.out.println("\nNome do funcionário: " + funcionario.getPessoaFisica().getNome());
        System.out.println("CPF do funcionário: " + funcionario.getPessoaFisica().getCpf());
        System.out.println("Endereçco do funcionário: " + funcionario.getPessoaFisica().getEndereco());
        

        /*
         * Desta forma, se alterarmos qualquer dado no objeto pessoaFisica,
         * tais alterações serão visualizadas tanto pelo objeto
         * cliente quanto pelo objeto funcionario, pois os dois estão
         * vinculados ao mesmo objeto pessoaFisica.
         * 
         * Abaixo estamos fazendo exatamente isso, estamos
         * alterando o endereço da pessoaFisica (ou seja, em um só lugar, 
         * não precisamos alterar no cliente e depois no funcionario)
         * e podemos ver que tanto o objeto cliente quanto o funcionario
         * visualizam tal alteração. Assim, não temos dados duplicados.
         */
        pessoaFisica.setEndereco("704 Sul");
        
        System.out.println("\n----Dados do Cadastro Depois de Alterado na PessoaFisica----");
        System.out.println("Nome do cliente: " + cliente.getPessoaFisica().getNome());
        System.out.println("CPF do cliente: " + cliente.getPessoaFisica().getCpf());
        System.out.println("Endereçco do cliente: " + cliente.getPessoaFisica().getEndereco());
        
        System.out.println("\nNome do funcionário: " + funcionario.getPessoaFisica().getNome());
        System.out.println("CPF do funcionário: " + funcionario.getPessoaFisica().getCpf());
        System.out.println("Endereçco do funcionário: " + funcionario.getPessoaFisica().getEndereco());
        
        Venda venda = new Venda();
    }
}
