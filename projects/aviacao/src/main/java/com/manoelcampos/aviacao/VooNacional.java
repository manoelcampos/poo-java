package com.manoelcampos.aviacao;

/**
 *
 * @author Manoel Campos da Silva Filho <http://github.com/manoelcampos>
 */
public class VooNacional extends Voo{
    @Override
    protected double ajuste() {
        return getPassageiros().size() * -0.10;
    }    
    
}
