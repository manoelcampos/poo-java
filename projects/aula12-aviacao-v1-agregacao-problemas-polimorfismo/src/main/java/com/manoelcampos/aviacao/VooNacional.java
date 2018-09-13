package com.manoelcampos.aviacao;

/**
 * A classe VooNacional é como a {@link VooInternacional}.
 * Tudo que foi dito para uma vale para a outra.
 * A única diferença é que no VooNacional, é calculado
 * um desconto para a passagem e não um acréscimo.
 * 
 * @author Manoel Campos da Silva Filho <http://github.com/manoelcampos>
 */
public class VooNacional extends Voo{

    @Override
    public double calcularPrecoPassagem() {
        double desconto = getPassageiros().size() * 0.10;
        return super.calcularPrecoPassagem() - desconto;
    }
    
}
