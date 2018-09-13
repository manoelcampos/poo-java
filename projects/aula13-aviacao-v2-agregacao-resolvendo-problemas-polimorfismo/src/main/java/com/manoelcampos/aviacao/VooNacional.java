package com.manoelcampos.aviacao;

/**
 * 
 * @author Manoel Campos da Silva Filho <http://github.com/manoelcampos>
 */
public class VooNacional extends Voo{

    /**
     * Calcula um desconto a ser dado no preço da passagem nacional.
     * O método é chamado dentro do método {@link Voo#calcularPrecoPassagem()} da classe {@link Voo}.
     * @return um valor negativo para indicar que é desconto
     */
    @Override
    protected double ajuste() {
        return getPassageiros().size() * -0.10;
    }
    
}
