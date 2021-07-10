package Classes;

public class Produto {

  private int codigo;
  private String nome;
  private double valor;
  private int estoque;

  public Produto() {
  }

  public Produto(int codigo) {
    this.codigo = codigo;
  }

  public Produto(int codigo, String nome) {
    this.codigo = codigo;
    this.nome = nome;
  }

  // Construtor com todos os campos obrigatorios
  public Produto(int codigo, String nome, Double valor, int estoque) {
    this.codigo = codigo;
    this.nome = nome;
    this.valor = valor;
    this.estoque = estoque;
  }

  // Getter e Setter

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public double getValor() {
    return valor;
  }

  public void setValor(double valor) {
    this.valor = valor;
  }

  public double getEstoque() {
    return estoque;
  }

  public void setEstoque(int estoque) {
    this.estoque = estoque;
  }

}
