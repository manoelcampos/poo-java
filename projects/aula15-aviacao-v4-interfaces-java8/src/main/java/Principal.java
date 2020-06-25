
import com.manoelcampos.aviacao.VooInternacional;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Manoel Campos da Silva Filho <http://github.com/manoelcampos>
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VooInternacional voo = new VooInternacional();
        voo.setDistanciaKm(100);
        voo.setPrecoPorKm(2);
        /*
         * Veja como como a classe Principal não é filha de Voo
         * nem está no mesmo pacote, não temos como chamar o método voo.ajuste().
         * Este é o objetivo, pois o método é chamado apenas internamente
         * dentro do método calcularPrecoPassagem().
         */
        System.out.println("Voo Internacional. Preço atual da Passagem: " + voo.calcularPrecoPassagem());
    }
    
}
