package br.com.manoelcampos.loja.pessoas;

/**
 *
 * @author Manoel Campos da Silva Filho <http://github.com/manoelcampos>
 */
public class Vendedor extends Funcionario {

    public Vendedor(PessoaFisica pessoaFisica) {
        super(pessoaFisica);
    }

    @Override
    public double getSalarioTotal() {
        return super.getSalarioTotal() * 1.1;
    }
    
    public static void main(String[] args) {
        Funcionario v1 = new Vendedor(null);
        Funcionario v2 = new Funcionario(null);
        v1.setSalarioBase(1000);
        v2.setSalarioBase(1000);
        imprimirFuncionario(v2);
    }

    private static void imprimirFuncionario(Funcionario v1) {
        System.out.println("Funcionario - Salario Base: " +  v1.getSalarioBase());
        System.out.println("Funcionario - Salario Total: " +  v1.getSalarioTotal());
    }

}
