package Classes;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Venda {
  public Date data;
  public String dataString;
  public Integer codigoProduto;
  public Integer quantidade;
  Produto produto;

  public Venda(String dataString, Produto produto, Integer quantidade) {
    this.dataString = dataString;
    this.produto = produto;
    this.quantidade = quantidade;
  }

  public Venda(Date data, Produto produto, Integer quantidade) {
    this.data = data;
    this.produto = produto;
    this.quantidade = quantidade;
  }

  // Construtor da classe, com campos obrigatorios
  public Venda(Date data, int codigoProduto, Integer quantidade) {
    this.data = data;
    this.codigoProduto = codigoProduto;
    this.quantidade = quantidade;
  }

  // Get e set
  public Date getData() {
    return data;
  }

  public String getDataFormatted() {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String dataFormatted = sdf.format(data);
    return dataFormatted;
  }

  public void setData(Date data) {
    this.data = data;
  }

  public Integer getCodigoProduto() {
    return codigoProduto;
  }

  public void setProduto(int codigoProduto) {
    this.codigoProduto = codigoProduto;
  }

  public Integer getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
  }

  public Integer getCdProdVenda() {
    return produto.getCodigo();
  }

  public Double getValor() {
    return produto.getValor();
  }

}
