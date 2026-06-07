/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lcjo_revisao;

import com.mycompany.lcjo_revisao.dao.PecaDao;
import com.mycompany.lcjo_revisao.dao.VeiculoDao;
import com.mycompany.lcjo_revisao.dao.VeiculoPeca;
import com.mycompany.lcjo_revisao.model.Peca;
import com.mycompany.lcjo_revisao.model.Veiculo;
import java.util.Scanner;

/**
 *
 * @author lucas
 */
public class LCJO_Revisao {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VeiculoDao vd = new VeiculoDao();
        PecaDao pd = new PecaDao();
        VeiculoPeca vp = new VeiculoPeca();
        
        int opcao;
    do {

        System.out.println("\n===== SISTEMA DE MANUTENÇÃO DE VEÍCULOS =====");
        System.out.println("1 - Cadastrar veículo");
        System.out.println("2 - Cadastrar peça");
        System.out.println("3 - Vincular peça a veículo");

        System.out.println("4 - Listar veículos");
        System.out.println("5 - Listar peças");
        System.out.println("6 - Consultar peças de um veículo");

        System.out.println("7 - Atualizar veículo");
        System.out.println("8 - Atualizar valor de peça");

        System.out.println("9 - Excluir peça");
        System.out.println("10 - Desvincular peça de veículo");

        System.out.println("0 - Sair");

        System.out.println("Escolha uma opção:");

        try {

            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {

                case 1:
                    System.out.print("Placa: ");
                    String placa = sc.nextLine();

                    System.out.print("Marca: ");
                    String marca = sc.nextLine();

                    System.out.print("Modelo: ");
                    String modelo = sc.nextLine();

                    Veiculo veiculo = new Veiculo(placa, marca, modelo);
                    
                    vd.salvarVeiculo(veiculo);
                    break;

                case 2:
                    
                    System.out.print("Nome da peça: ");
                    String nome = sc.nextLine();

                    System.out.print("Fabricante: ");
                    String fabricante = sc.nextLine();

                    System.out.print("Valor: ");
                    double valor = sc.nextDouble();sc.nextLine();

                    Peca peca = new Peca(nome, fabricante, valor);                                        
                    
                    pd.salvarPeca(peca);
                    break;

                case 3:
                    System.out.println("=== VEÍCULOS ===\n");
                    
                    vd.listaVeiculo();

                    System.out.print("\nID do veículo: ");
                    int idVeiculo = sc.nextInt();sc.nextLine();

                    System.out.println("\n=== PEÇAS ===");
                    
                    pd.listaPeca();

                    System.out.print("\nID da peça: ");
                    int idPeca = sc.nextInt();sc.nextLine();

                    vp.salvarVeiculoPeca(idVeiculo, idPeca);
                    
                    break;

                case 4:
                    vd.listaVeiculo();
                    break;

                case 5:
                    pd.listaPeca();
                    break;

                case 6:
                    System.out.print("Digite a placa do veículo: ");
                    String placaConsulta = sc.nextLine();

                    vp.listaVeiculoPeca(placaConsulta);
                    break;

                case 7:
                    System.out.print("Placa do veículo: ");
                    String placaAtualizar = sc.nextLine();

                    System.out.print("Novo modelo: ");
                    String novoModelo = sc.nextLine();

                    vd.updateVeiculo(placaAtualizar, novoModelo);
                    break;

                case 8:
                    System.out.print("Nome da peça: ");
                    String nomePeca = sc.nextLine();

                    System.out.print("Fabricante: ");
                    String fabricantePeca = sc.nextLine();

                    System.out.print("Novo valor: ");
                    double novoValor = Double.parseDouble(sc.nextLine());

                    pd.updatepeca(nomePeca, fabricantePeca, novoValor);
                    
                    break;

                case 9:
                    System.out.print("Nome da peça: ");
                    String nomeExcluir = sc.nextLine();

                    System.out.print("Fabricante: ");
                    String fabricanteExcluir = sc.nextLine();

                    pd.deletaPeca(nomeExcluir, fabricanteExcluir);
                    break;

                case 10:
                    System.out.print("ID do veículo: ");
                    int idV = sc.nextInt();sc.nextLine();

                    System.out.print("ID da peça: ");
                    int idP = sc.nextInt();sc.nextLine();

                    vp.apagarPecaVeiculo(idV, idP);
                    break;

                case 0:
                    System.out.println("Sistema encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            opcao = -1;
        }
    } while (opcao != 0);

    sc.close();
    }
}
