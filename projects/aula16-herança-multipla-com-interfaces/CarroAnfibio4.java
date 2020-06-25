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
 * Por fim, se quisermos usar as duas implementações ao mesmo tempo,
 * sem ter o método duplicado, também é possível no Java 8.
 * Para isto, sobrescrevemos o método mover na subclasse
 * e chamamos individualmente cada uma das versões de mover
 * na superclasse e na interface.
 */
public class CarroAnfibio4 extends Carro implements Barco {
  @Override
  public void mover(){
    // chama a implementação do método na superclasse Carro
    super.mover(); 
    
    /* Chama a implementação do método na interface Barco.
    Observe que no caso da interface, precisamos indicar explicitamente
    o nome da mesma, até porque uma classe pode implementar
    múltiplas interfaces.*/
    Barco.super.mover(); 
  }  

  public static void main(String args[]){
     CarroAnfibio4 ca = new CarroAnfibio4();
     ca.mover();
  }
}
