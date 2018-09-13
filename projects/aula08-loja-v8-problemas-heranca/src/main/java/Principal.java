
public class Principal {
    /**
     * Executa um exemplo mostrando que, quando
     * temos um Funcionario que também é Cliente,
     * utilizando herança desde Pessoa até 
     * tais classes, não temos como compartilhar
     * dados do cadastro do Funcionario para fazer
     * o cadastro do Cliente.
     * Esta é uma das limitações da herança.
     * 
     * @param args 
     */
    public static void main(String[] args) {
        /*
         * Como Empresa herda de PessoaJuridica e Pessoa,
         * o código abaixo mostra que podemos instanciar
         * um objeto empresa da classe Empresa e teremos
         * acesso a tudo que foi herdado das classes superiores
         * (superclasses) Pessoa e PessoaJuridica.
         * Por exemplo, o método setNome() foi herdado de Pessoa
         * e o setCnpj() foi herdado de PessoaJuridica.
         */
        Empresa empresa = new Empresa();
        empresa.setNome("Lojas Mais");
        empresa.setCnpj("493848934");
        System.out.println(
                "Empresa: " + empresa.getNome() + 
                " CNPJ: " + empresa.getCnpj() + "\n");
        
        /*
         * Aqui estamos criando um funcionário e definindo os valores
         * de seus atributos.
         */
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Manoel Campos");
        funcionario.setCpf("11111111111");
        funcionario.setEndereco("103 Sul");
        funcionario.setCargo("Vendedor");
        
        /*
         * Apesar da pessoa acima ser um funcionário,
         * ela pode atuar como um cliente, pois um funcionário
         * também pode comprar na loja. Neste caso, ele assume o papel
         * de cliente.
         * No entanto, mesmo que já tenhamos criado o funcionário
         * e preenchido todos os seus dados, para cadastrá-lo como cliente
         * precisaremos preencher todos os dados novamente.
         * Com isto, não temos duplicação de código (pois abaixo
         * estamos apenas chamando funções e estas foram feitas para 
         * serem chamadas quantas vezes forem necessárias),
         * mas temos duplicação de dados.
         * 
         * O código abaixo ao menos utiliza os dados do funcionário para
         * realizar o cadastro do cliente (obtendo o nome e CPF do funcionário
         * e usando estes mesmos dados no cadastro do cliente).
         */
        Cliente cliente = new Cliente();
        cliente.setNome(funcionario.getNome());
        cliente.setCpf(funcionario.getCpf());
        cliente.setRenda(1000);
        
        /**
         * No entanto, as linhas abaixo mostram que é possível 
         * atualizar qualquer um daqueles dados no cliente
         * e o funcionário ficará com dados desatualizados,
         * como pode ser visto nos prints abaixo.
         * 
         * Ter dados duplicados é tão problemático quanto ter código duplicado.
         * Como saberemos quais dados exibidos abaixo para o Manoel são 
         * os corretos? Os dados no cadastro dele como funcionário
         * ou no cadastro dele como cliente?
         */
        cliente.setNome("Manoel Campos da Silva Filho");
        cliente.setEndereco("704 Sul");
        
        System.out.println("Nome do funcionário: " + funcionario.getNome());
        System.out.println("CPF do funcionário: " + funcionario.getCpf());
        System.out.println("Endereço do funcinário: " + funcionario.getEndereco());

        System.out.println("\nNome do cliente: " + cliente.getNome());
        System.out.println("CPF do cliente: " + cliente.getCpf());
        System.out.println("Endereço do cliente: " + cliente.getEndereco());
    }
}
