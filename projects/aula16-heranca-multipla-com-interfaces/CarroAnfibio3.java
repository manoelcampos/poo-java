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
 * Mas ainda podemos escolher qual das duas implementações
 * queremos usar, sobrescrevendo o método na classe filha
 * e chamando a versão do método na superclasse ou na interface.
 */
public class CarroAnfibio3 extends Carro implements Barco {
  @Override
  public void mover(){
    //Aqui estamos usando a versão do método mover disponível na interface Barco
    Barco.super.mover();
  }  

  public static void main(String args[]){
     CarroAnfibio3 ca = new CarroAnfibio3();
     ca.mover();
  }
}
