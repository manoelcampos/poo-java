package com.manoelcampos.aviacao;

/**
 *
 * @author Manoel Campos da Silva Filho <http://github.com/manoelcampos>
 */
public class VooNacional extends Voo{

    @Override
    public double calcularPrecoPassage() {
        double desconto = getPassageiros().size() * 0.10;
        return super.calcularPrecoPassage() - desconto;
    }
    
}
