package com.manoelcampos.aviacao;

import java.util.ArrayList;
import java.util.List;

/**
 * Como apresentado no PDF na raiz da pasta,
 * o preço da passagem aérea é calculada de forma
 * diferente para voos nacionais e internacionais.
 * Para voos nacionais é dado um desconto, enquanto
 * em voos internacionais é incluído um acréscimo
 * no preço de cada passagem vendida.
 * No entanto, o preço base da passagem é sempre
 * calculado pela distância do voo multiplicada pelo preço
 * que a companhia aérea estipula por quilômetro.
 * 
 * <p>Como a fórmula acima deve ser utilizada para o cálculo do preço
 * da passagem em qualquer tipo de voo, criamos
 * um método {@link #calcularPrecoPassagem()} nesta superclasse
 * e tal método será sobrescrito nas classes filhas, utilizando
 * o conceito de override (um tipo de polimorfismo dinâmico).
 * Veja as classes {@link VooNacional} e {@link VooInternacional}
 * para mais detalhes.
 * </p>
 * 
 * <p>Esta classe Voo ainda possui um problema:
 * podemos instanciar um voo genérico, no lugar
 * de um voo específico como VooNacional e VooInternacional.
 * Não faz sentido para o contexto apresentado no PDF
 * criarmos um voo genérico. Voos só podem ser atualmente nacionais 
 * ou internacionais na nossa companhia.
 * Criar um objeto genérico Voo indica que não estaremos
 * calculando nenhum desconto ou acréscimo, mas
 * apenas o preço da distância percorrida.
 * 
 * Veja no método main como é possível instanciar Voo.
 * Para evitar tal problema, veja a versão 2 do projeto.
 * </p>
 * 
 * @author Manoel Campos da Silva Filho <http://github.com/manoelcampos>
 */
public class Voo {
    private String numero;
    private String aeroportoOrigem;
    private String aeroportoDestino;
    private double distanciaKm;
    private double precoPorKm;
    private Aviao aviao;
    private List<Passageiro> passageiros;
    
    public Voo(){
        passageiros = new ArrayList<>();
    }
    
    /**
     * Realiza o cálculo base do preço da passagem de um voo de qualquer tipo.
     * Tal método é sobrescrito (override) em classes filhas para concluir
     * o cálculo do preço de acordo com o tipo de voo,
     * como {@link VooNacional} ou {@link VooInternacional}.
     * 
     * @return o preço base para cálculo da passagem nos tipos específicos de voo
     */
    public double calcularPrecoPassagem(){
        return getDistanciaKm()*getPrecoPorKm();
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the aeroportoOrigem
     */
    public String getAeroportoOrigem() {
        return aeroportoOrigem;
    }

    /**
     * @param aeroportoOrigem the aeroportoOrigem to set
     */
    public void setAeroportoOrigem(String aeroportoOrigem) {
        this.aeroportoOrigem = aeroportoOrigem;
    }

    /**
     * @return the aeroportoDestino
     */
    public String getAeroportoDestino() {
        return aeroportoDestino;
    }

    /**
     * @param aeroportoDestino the aeroportoDestino to set
     */
    public void setAeroportoDestino(String aeroportoDestino) {
        this.aeroportoDestino = aeroportoDestino;
    }

    /**
     * @return the distanciaKm
     */
    public double getDistanciaKm() {
        return distanciaKm;
    }

    /**
     * @param distanciaKm the distanciaKm to set
     */
    public void setDistanciaKm(double distanciaKm) {
        this.distanciaKm = distanciaKm;
    }

    /**
     * @return the precoPorKm
     */
    public double getPrecoPorKm() {
        return precoPorKm;
    }

    /**
     * @param precoPorKm the precoPorKm to set
     */
    public void setPrecoPorKm(double precoPorKm) {
        this.precoPorKm = precoPorKm;
    }

    /**
     * @return the aviao
     */
    public Aviao getAviao() {
        return aviao;
    }

    /**
     * @param aviao the aviao to set
     */
    public void setAviao(Aviao aviao) {
        this.aviao = aviao;
    }

    /**
     * @return the passageiros
     */
    public List<Passageiro> getPassageiros() {
        return passageiros;
    }

    /**
     * @param passageiros the passageiros to set
     */
    public void setPassageiros(List<Passageiro> passageiros) {
        this.passageiros = passageiros;
    }
    
    public static void main(String[] args) {
        /*Veja que é possível instanciar um Voo, apesar
        e não fazer sentido no nosso contexto.
        Um voo precisa ser nacional ou internacional, 
        senão não estaremos calculando acréscimos ou descontos
        no preço da passagem.*/
        Voo voo = new Voo();
        voo.setDistanciaKm(100);
        voo.setPrecoPorKm(2);
        System.out.println("Distância do Voo: " + voo.getDistanciaKm());
        System.out.println("Preço por KM: " + voo.getPrecoPorKm());
        System.out.println("Preço atual da passagem: " + voo.calcularPrecoPassagem());
    }
}
