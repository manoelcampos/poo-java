package com.manoelcampos.aviacao;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Manoel Campos da Silva Filho <http://github.com/manoelcampos>
 */
public abstract class Voo {
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
    
    public final double calcularPrecoPassage(){
        return distanciaKm*precoPorKm + ajuste();
    }

    /**
     * Retorna um acréscimo ou desconto a ser incorporado
     * no processo da passagem.
     * 
     * @return um valor positivo se for dado um acréscimo ou um
     *         valor negativo se for dado um desconto.
     */
    protected abstract double ajuste();
    
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


}
