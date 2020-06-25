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
 * A classe CarroAnfibio1 extende a classe Carro e implementa a 
 * interface Barco. Tanto Carro quanto Barco tem um método mover
 * que possuem uma implementação e tem a mesma assinatura (nome e parâmetros).
 * Assim, a classe CarroAnfibio1 herdaria o mesmo método duas vezes,
 * o que ocorreria o tal problema do diamante da morte.
 * 
 * No Java 8, o compilador vai incluir por padrão na subclasse o método da superclasse
 * e não da interface para evitar tal erro.
 * Assim, ao compilar este arquivo e rodar, verá que 
 * é executado o método mover em Carro.
 */
public class CarroAnfibio1 extends Carro implements Barco {
  public static void main(String args[]){
     CarroAnfibio1 ca = new CarroAnfibio1();
     ca.mover();
  }
}
