package com.manoelcampos.aviacao;

/**
 *
 * @author Manoel Campos da Silva Filho <http://github.com/manoelcampos>
 */
public class VooInternacional extends Voo{
    @Override
    protected double ajuste() {
        return (getAviao().getTotalPoltronas() - getPassageiros().size())*0.10;
    }
    
}
