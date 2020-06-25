package com.manoelcampos.aviacao;

/**
 *
 * @author Manoel Campos da Silva Filho <http://github.com/manoelcampos>
 */
public class VooInternacional extends Voo{

    /**
     * Calcula um acréscimo a ser dado no preço da passagem internacional.
     * O método é chamado dentro do método {@link Voo#calcularPrecoPassagem()} da classe {@link Voo}.
     * @return um valor positivo para indicar que é acréscimo
     */
    @Override
    protected double ajuste() {
        double totalPoltronasLivres = getAviao().getTotalPoltronas() - getPassageiros().size();
        return totalPoltronasLivres * 0.10;
    }
    
}
