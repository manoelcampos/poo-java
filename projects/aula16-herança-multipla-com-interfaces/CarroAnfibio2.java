interface Barco{
  default void mover(){
    System.out.println("Girando hélice"); 
  }
}

class Carro{
  public void mover(){
    System.out.println("Movendo rodas");
  }
}

/**
 * Podemos sobrescrever totalmente o método mover,
 * que causaria conflito, para prover uma
 * implementação totalmente independente das em
 * Carro e Barco.
 */
public class CarroAnfibio2 extends Carro implements Barco {
  @Override
  public void mover(){
    System.out.println("Sobrescrevendo totalmente o método mover na classe " + getClass().getName());
    System.out.println("Assim as implementações em Barco e Carro serão ignoradas.");
  }  

  public static void main(String args[]){
     CarroAnfibio2 ca = new CarroAnfibio2();
     ca.mover();
  }
}
