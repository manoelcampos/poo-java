
import com.manoelcampos.aviacao.Passageiro;
import com.manoelcampos.aviacao.PessoaFisica;
import com.manoelcampos.aviacao.Piloto;
import com.manoelcampos.aviacao.Voo;
import com.manoelcampos.aviacao.VooNacional;

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
        //Não compila pois Voo é uma classe abstrata
        //Voo voo = new Voo();
        
        Voo voo = new VooNacional();
        //voo.ajuste();
        
        Piloto piloto = new Piloto(new PessoaFisica("Manoel", 'm'));
        piloto.getNome();
        
        Passageiro passageiro = new Passageiro(new PessoaFisica("João", 'm'));
        passageiro.getNome();
    }
    
}
