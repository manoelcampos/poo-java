package com.manoelcampos.aviacao;

/**
 *
 * @author Manoel Campos da Silva Filho <http://github.com/manoelcampos>
 */
public class Aviao {
    private String marca;
    private String modelo;
    private int totalPoltronas;
    private CompanhiaAerea companhiaAerea;

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the totalPoltronas
     */
    public int getTotalPoltronas() {
        return totalPoltronas;
    }

    /**
     * @param totalPoltronas the totalPoltronas to set
     */
    public void setTotalPoltronas(int totalPoltronas) {
        this.totalPoltronas = totalPoltronas;
    }

    /**
     * @return the companhiaAerea
     */
    public CompanhiaAerea getCompanhiaAerea() {
        return companhiaAerea;
    }

    /**
     * @param companhiaAerea the companhiaAerea to set
     */
    public void setCompanhiaAerea(CompanhiaAerea companhiaAerea) {
        this.companhiaAerea = companhiaAerea;
    }
}
