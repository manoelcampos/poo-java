
/**
 * Write a description of class Produto here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Produto
{
  int codigo;
  String descricao;
  double precoVenda;
  String marca;
  String unidade;
  int estoque;
  
  void setCodigo(int codigo){
      this.codigo = codigo;
  }
  
  void setDescricao(String descricao){
      this.descricao = descricao;
  }
  
  void setPrecoVenda(double precoVenda){
      this.precoVenda = precoVenda;
  }
  
  void setMarca(String marca){
      this.marca = marca;
  }
  
  void setUnidade(String unidade){
      this.unidade = unidade;
  }
  
}
