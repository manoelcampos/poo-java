package com.manoelcampos.aviacao;

import java.util.ArrayList;
import java.util.List;

/**
 * Para resolver um problema da sobrescrita de métodos apresentada
 * na versão 1 do projeto, vamos introduzir alguns conceitos.
 * 
 * Como podem ver, o método {@link #calcularPrecoPassagem()}
 * agora tem uma implementação diferente. Ele está calculando
 * o preço base (distância * preço por KM) e somando
 * o resultado de um método {@link #ajuste()}.
 * 
 * Este ajuste será um valor a ser descontado ou acrescido do preço 
 * base, caso a voo seja, respectivamente, nacional ou internacional.
 * No entanto, como este desconto ou acréscimo será calculado e se 
 * ele será de fato um desconto ou um acréscimo deve ser decidido
 * pelas classes filhas de Voo (neste caso {@link VooNacional} ou {@link VooInternacional}).
 * 
 * Se somente as classes filhas é que vão decidir como implementar este método
 * ajuste, então criamos o método como abstrato, um novo conceito que apresentamos agora.
 * Um método abstrato é aquele que não possui uma implementação, logo, ele é definido
 * apenas com o cabeçalho (a primeira linha, a assinatura do método), 
 * mas sem um corpo (sem as chaves com o código).
 * 
 * Se temos um único método abstrato, então nossa classe precisa
 * obrigatoriamente ser definida como abstrata também, incluindo a palavra
 * abstract antes de "class".
 * 
 * Como podemos ter diversos níveis na nossa hierarquia de herança 
 * (neste caso só temos 2 níveis: I - Voo em um nível e II - VooNacional e VooInternacional
 * no segundo nível mais abaixo), alguma das classes filhas em qualquer nível
 * terá que implementar este método ajuste.
 * Uma classe filha que herda diretamente de Voo só não precisará implementar
 * os métodos abstratos definidos em Voo (neste caso apenas 1), 
 * se a filha for também definida como abstrata.
 * 
 * Se tivermos por exemplo, a classe Voo, uma filha e uma neta
 * e mais nenhuma classe em outros níveis depois da neta,
 * a filha ou a neta terão que implementar os métodos abstratos de Voo.
 * Se tanto a filha como a neta forem abstratas, elas não precisam
 * implementar os métodos abstratos de Voo.
 * Mas a primeira classe concreta depois da neta precisará.
 * Uma classe concreta é qualquer uma que não tenha sido definida como
 * abstrata.
 * 
 * Uma classe sendo abstrata significa que ela não é totalmente funcional
 * pois faltam partes a serem implementadas (que foram delegadas para as
 * classes abaixo da hierarquia o fazerem), logo, não podem ser instanciadas.
 * Mesmo que uma classe tenha todos os métodos implementados, ela ainda pode ser definida
 * como abstrata. Isto serve para indicar que apesar de ela funcionar, ela está incompleta
 * pois as subclasses agregam atributos e métodos que são essenciais para
 * um funcionamento adequado. Veja a classe {@link Pessoa} para mais detalhes.
 * 
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
    
    /**
     * Aqui mudamos a implementação do método de cálculo
     * do preço da passagem para ele chamar um método {@link #ajuste()}
     * que retornará um valor a ser acrescido ou descontado do preço base.
     * Veja o método citado para mais detalhes.
     * 
     * Ao usarmos o método ajuste, estamos delegando pras classes filhas
     * apenas o cálculo do desconto/acréscimo (o ajuste).
     * Assim, as classes filhas não precisarão sobrescrever o método
     * {@link #calcularPrecoPassagem()} para concluir o cálculo
     * do preço da passagem.
     * No entanto, da forma como o método estava, nada impedia que uma classe
     * filha fizesse isso e alterasse indevidamente o cálculo da passagem.
     * 
     * Para evitar tal problema, definimos o método como final.
     * Isto impede que o método seja modificado, isto é, sobrescrito
     * nas classes filhas.
     * 
     * Esta solução de introduzir o método {@link #ajuste()} que implementamos
     * é um dos muitos padrões de projetos (design patterns),
     * chamado de Template Method (método modelo).
     * O método {@link #calcularPrecoPassagem()} é um modelo
     * que chama métodos auxiliares como o {@link #ajuste()},
     * cuja implementação é definida nas classes filhas.
     * 
     * @return 
     */
    public final double calcularPrecoPassagem(){
        return getDistanciaKm()*getPrecoPorKm() + ajuste();
    }

    /**
     * Calcula e retorna um preço a ser acrescido ou descontado do preço
     * base da passagem. Veja a implementação deste método nas 
     * classes filhas {@link VooNacional} e {@link VooInternacional}.
     * 
     * Observe que o método foi definido como protegido, assim,
     * somente classes filhas e outras dentro do mesmo pacote poderão acessar tal método.
     * Como pode ver na classe Principal (que está no pacote padrão),
     * não temos como acessar tal método (e não há porque acessar, uma vez
     * que o método {@link #calcularPrecoPassagem()} é que deve chamá-lo).
     * 
     * @return um valor positivo para indicar que tal valor representa um
     * acréscimo ao preço da passagem; caso o valor retornado seja negativo,
     * indica que deve ser dado um desconto no preço da passagem.
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
