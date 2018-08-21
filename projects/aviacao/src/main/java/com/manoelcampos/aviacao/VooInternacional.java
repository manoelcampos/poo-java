package com.manoelcampos.aviacao;

/**
 *
 * @author Manoel Campos da Silva Filho <http://github.com/manoelcampos>
 */
public class VooInternacional extends Voo{

    @Override
    public double calcularPrecoPassage() {
        double acrescimo = (getAviao().getTotalPoltronas() - getPassageiros().size  ())*0.10;
        return super.calcularPrecoPassage() - acrescimo;
    }
    
}
