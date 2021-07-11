package Aplicação;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Scanner;
import Classes.Produto;
import Classes.Venda;

import java.util.Date;

public class Programa {

  public static void main(String[] args) {

    Vector<Produto> produtos = new Vector<Produto>();
    Vector<Venda> vendas = new Vector<Venda>();
    Integer opcao;

    System.out.println("|------------------------------------|");
    System.out.println("|---------------Produtos-------------|");
    System.out.println("|------------------------------------|");
    System.out.println("");

    // Popular vetores
    // Produto p1 = new Produto(1, "Agua", 2.00, 20);
    // Produto p2 = new Produto(2, "Refrigerante", 3.50, 25);
    // Produto p3 = new Produto(3, "Vinho", 15.00, 10);
    // produtos.add(p1);
    // produtos.add(p2);
    // produtos.add(p3);

    do {
      System.out.println();
      System.out.println("|------------------------------------|");
      System.out.println("Digite uma opção para começar!");
      System.out.println();
      System.out.println("1 - Incluir produto");
      System.out.println("2 - Consultar produto");
      System.out.println("3 - Listagem de produtos");
      System.out.println("4 - Realizar venda");
      System.out.println("5 - Vendas por periodo - detalhado");
      System.out.println("0 - Sair");
      System.out.println();

      Scanner in = new Scanner(System.in);
      opcao = in.nextInt();
      switch (opcao) {
        case 1:
          System.out.println("Opção 1: ");
          System.out.println("Digite o codigo: ");
          int codigo = in.nextInt();
          in.nextLine();
          System.out.println("Digite o nome do produto: ");
          String nome = in.nextLine();
          System.out.println("Digite o valor inicial: ");
          Double valor = in.nextDouble();
          System.out.println("Digite o saldo inicial em estoque: ");
          int saldo = in.nextInt();

          Produto prod = new Produto(codigo, nome, valor, saldo);
          produtos.add(prod);
          continue;
        case 2:
          System.out.println("Opção 2 - Consulta de produtos : ");
          System.out.println("Digite 1 pra consultar por codigo: ");
          System.out.println("Digite 2 pra consultar por nome: ");
          Scanner in2 = new Scanner(System.in);
          int opcaoConsulta = in2.nextInt();
          Scanner cd = new Scanner(System.in);
          int cod;
          String nom;
          if (opcaoConsulta == 1) {
            System.out.println("Digite o codigo do produto: ");
            cod = cd.nextInt();
            System.out.println("------------------------------");
            produtos.stream().filter(s -> s.getCodigo() == cod)
                .forEach(s -> System.out.println("Codigo: " + s.getCodigo() + " " + "Nome: " + s.getNome()));
            System.out.println("------------------------------");
            continue;
          } else if (opcaoConsulta == 2) {
            System.out.println("Digite o nome do produto: ");
            nom = cd.nextLine();
            System.out.println("Nome do produto: " + nom);
            System.out.println("------------------------------");
            produtos.stream().filter(t -> t.getNome().equals(nom))
                .forEach(t -> System.out.println("Codigo: " + t.getCodigo() + " " + "Nome: " + t.getNome()));
            System.out.println("------------------------------");
            continue;
          }
        case 3:
          // System.out.println("Opção 3:");
          System.out.println(" ----Listagem de produtos----");
          produtos.stream().forEach(p -> System.out.println("Codigo: " + p.getCodigo() + "| Nome:  " + p.getNome()
              + "\t\t| Valor unitário: " + p.getValor() + "\t\t| Saldo em estoque: " + p.getEstoque()));
          System.out.println("------------------------------");
          break;

        case 4: // Realizar venda
          Scanner in4 = new Scanner(System.in);
          int codProdVenda;
          Produto prodVenda;
          int qtdProdVenda;
          Double vlProdVenda;
          Date data = new Date();
          SimpleDateFormat dataFormatada = new SimpleDateFormat("dd-MM-yyyy");
          String dtVenda = dataFormatada.format(data);

          // System.out.println("Opão 4:");
          System.out.println("------------------------------");
          System.out.println("Informe o codigo: ");
          codProdVenda = in4.nextInt();

          System.out.println("Informe a quantidade: ");
          qtdProdVenda = in4.nextInt();
          // Produto pv1 = new Produto(1, "Produto A", 2.50, 10);
          // Produto pv2 = new Produto(2, "Produto B", 2.00, 12);
          // Produto pv3 = new Produto(3, "Produto A", 1.50, 20);
          // String dt1 = "01/10/2000";
          // String dt2 = "01/05/2010";
          // String dt3 = "31/12/2030";
          // SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

          // try {
          // Date d1 = sdf.parse(dt1);
          // Date d2 = sdf.parse(dt2);
          // Date d3 = sdf.parse(dt3);
          // Venda v1 = new Venda(d1, pv1, 1);
          // Venda v2 = new Venda(d2, pv2, 3);
          // Venda v3 = new Venda(d3, pv3, 2);
          // vendas.add(v1);
          // vendas.add(v2);
          // vendas.add(v3);
          // } catch (ParseException e) {
          // System.out.println("Erro: " + e.getMessage());
          // e.printStackTrace();
          // }

          for (Produto p : produtos) {
            if (p.getCodigo() == codProdVenda) {
              if (p.getEstoque() >= qtdProdVenda) {
                Venda venda = new Venda(data, p, qtdProdVenda);
                vendas.add(venda);
                System.out.println("Venda efetivada!");
              } else if (p.getEstoque() < qtdProdVenda) {
                System.out.println("Produto " + codProdVenda + "com estoque insuficiente");
              }
            } else {
              System.out.println("Produto não existe, verifique!");
            }
          }

          System.out.println("Venda realizada");
          break;

        case 5: // Vendas por periodo
          Scanner in5 = new Scanner(System.in);
          System.out.println("------Vendas por periodo------");
          System.out.println("Informe a data inicial(dd/mm/yyyy): ");
          String dtInicial = in5.nextLine();
          System.out.println("Informe a data final(dd/mm/yyyy): ");
          String dtFinal = in5.nextLine();
          SimpleDateFormat sdf5 = new SimpleDateFormat("dd/MM/yyyy");
          try {
            Date dtInicialFormatted = sdf5.parse(dtInicial);
            Date dtFinalFormatted = sdf5.parse(dtFinal);
            System.out.println("-------------------------");
            vendas.stream().filter(v -> v.getData().after(dtInicialFormatted) && v.getData().before(dtFinalFormatted))
                .forEach(v -> System.out.println("Nr.Venda: " + (vendas.indexOf(v) + 1) + "\nData: "
                    + v.getDataFormatted() + "\nCodigo do Produto: " + v.getCdProdVenda() + "\nQuantidade: "
                    + v.getQuantidade() + "\nValor: " + v.getValor() * v.getQuantidade() + "\n"));
            System.out.println("-------------------------");
            System.out.println();

          } catch (Exception e) {
            // System.out.println("Erro: " + e.getMessage());
          }

          break;
        case 6:
          // System.out.println("Opção 6: ");
        case 0: // Sair
          // System.out.println("Opção 0: ");
          break;
        default:
          System.out.println("");
      }
    } while (opcao != 0);
  }
}