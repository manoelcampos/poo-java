package com.manoelcampos.aviacao;

/**
 * Em cada classe que representa um tipo específico de voo, sobrescrevemos (override) o método
 * {@link #calcularPrecoPassagem()} herdado da superclasse {@link Voo} para
 * concluir o cálculo do preço da passagem.
 *
 * @author Manoel Campos da Silva Filho <http://github.com/manoelcampos>
 */
public class VooInternacional extends Voo{

    /**
     * O preço da passagem deve levar em consideração o custo pela distância
     * percorrida. Como tal cálculo foi feito na implementação deste
     * método {@link #calcularPrecoPassagem()} na superclasse {@link Voo},
 precisamos reutilizar tal cálculo.
 Para isto, basta chamarmos o próprio método na superclasse,
 usando super.calcularPrecoPassagem(), como mostrado abaixo.
 
 <p>Aqui na classe VooInternacional calculamos o acréscimo que é 
     * incluído ao preço da passagem e então somamos com o resultado
     * obtido do método na superclasse.</p>
     * 
     * <p>Desta forma, estamos modificando o método na subclasse VooInternacional,
     * fazendo ele executar o mesmo código herdado da superclases, mas
     * incluindo cálculos adicionais.</p>
     * 
     * <p>Assim estamos sobrescrevendo a implementação do método na classe
     * filha. Se quisermos modificar completamentar tal implementação,
     * ignorando o que é realizado pelo método na superclasse,
     * basta remover a chamada do método da superclasse, apagando
     * o super.calcularPrecoPassagem().
     * Isto é um recurso que a sobrescrita de métodos possibilita.
     * Se for isto que realmente quisermos fazer, pode ser feito normalmente.
     * No entanto, o problema que surge com a sobrescrita de métodos
     * é justamente quando não desejamos que a implementação 
     * do método na superclasse seja ignorado por alguma subclasse.
     * 
     * Como já sabemos, o preço base da passagem é feito na superclasse.
     * Assim, neste caso, ele não pode ser ignorado.
     * Se apagarmos a chamada do método na superclasse 
     * (o super.calcularPrecoPassagem()),
     * isso fará com que o preço da passagem seja calculado de forma incorreta,
     * podendo inclusive trazer prejuízos financeiros à companhia.
     * </p>
     * 
     * <p>Em face deste possível problema, caso queiramos obrigar que 
     * a implementação da superclasse seja sempre usada e não seja modificada,
     * precisaremos mudar nosso projeto, como veremos na versão 2.</p>
     * @return 
     */
    @Override
    public double calcularPrecoPassagem() {
        double acrescimo = (getAviao().getTotalPoltronas() - getPassageiros().size  ())*0.10;
        return super.calcularPrecoPassagem() + acrescimo;
    }
    
}
