import java.util.Scanner;

import edu.xp.banco.Banco;
import edu.xp.cliente.Cliente;
import edu.xp.contas.Conta;
import edu.xp.contas.ContaCorrente;
import edu.xp.contas.ContaPoupanca;

public class Main {

	public static void main(String[] args) {
		boolean verificador;
		int opc, contador=0;
		double valor;
		
		Scanner scan = new Scanner(System.in);
        Banco registro = new Banco();
		Conta cc, poup;
		Cliente cli;

		System.out.print("\nSeja bem vindo!\nDigite o nome do titular:\n >> ");
		cli = new Cliente(scan.nextLine());
		cc = new ContaCorrente(cli);
		poup = new ContaPoupanca(cli);

		System.out.println("\nDeseja abrir uma conta corrente?");
		System.out.println("1) Sim.\n2) Não.\n >> ");
		opc = scan.nextInt();

		if (opc == 1) {
			contador++;

			verificador = true;
			
			while (verificador == true) {
				System.out.print("\nO que deseja fazer?\n1) Depositar.\n2) Sacar.\n3) Encerrar.\n >> ");
				opc = scan.nextInt();
				
				switch (opc) {
					case 1:
						System.out.println("\nQuanto você deseja depositar?");
						System.out.printf("\tSaldo atual: %.2f\n >> ",cc.getSaldo());
						cc.depositar(scan.nextDouble());
						break;
					
					case 2:
						System.out.println("\nQuanto você deseja sacar?");
						System.out.printf("\tSaldo atual: %.2f\n >> ",cc.getSaldo());
						valor = scan.nextDouble();
						
						if (cc.getSaldo() > valor) {
							cc.sacar(valor);
						}else {
							System.out.println("\nVocê não tem saldo suficiente!");
						}
						break;
						
					case 3:
						registro.setContas(cc);
						verificador = false;
						break;

					default:
						System.out.println("\nVocê não escolheu uma opção válida!");
						break;
				}
			}
		} else if (opc == 2) {
			System.out.println("\nVamos continuar então");
		} else {
			System.out.println("\nVocê não escolheu uma opção válida!");
		}

		System.out.println("\nDeseja abrir uma conta poupança?");
		System.out.print("1) Sim.\n2) Não.\n >> ");
		opc = scan.nextInt();

		if (opc == 1) {
			contador++;
			verificador = true;

			while (verificador == true) {
				System.out.print("\nO que deseja fazer?\n1) Depositar.\n2) Sacar.\n3) Encerrar.\n >> ");
				opc = scan.nextInt();
				
				switch (opc) {
					case 1:
						System.out.println("\nQuanto você deseja depositar?");
						System.out.printf("\tSaldo atual: %.2f\n >> ",poup.getSaldo());
						poup.depositar(scan.nextDouble());
						break;
					
					case 2:
						System.out.print("\nQuanto você deseja sacar?\n >> ");
						System.out.printf("\tSaldo atual: %.2f\n >> ",poup.getSaldo());
						valor = scan.nextDouble();

						if (poup.getSaldo() > valor) {
							poup.sacar(valor);
						}else {
							System.out.println("\nVocê não tem saldo suficiente!");
						}
						break;
						
					case 3:
						registro.setContas(poup);
						verificador = false;
						break;
				
					default:
						System.out.println("\nVocê não escolheu uma opção válida!");
						break;
				}
			}
		} else if (opc == 2) {
			System.out.println("\nVamos continuar então");
		} else {
			System.out.println("\nVocê não escolheu uma opção válida!");
		}

		System.out.print("\nDeseja fazer alguma transferência?\n1) Sim.\n2) Não.\n >> ");
		opc = scan.nextInt();

		if (opc == 1) {
			if (contador >= 2) {

				verificador = true;

				while (verificador == true) {
					System.out.println("\nO que você deseja?");
					System.out.println("1) Transferir da conta corrente para a poupança.\n2) Transferir da conta poupança para a corrente.\n3 ou outra opção) Encerrar.");
					System.out.printf("\tSaldo atual Conta Corrente: %.2f\n",cc.getSaldo());
					System.out.printf("\tSaldo atual Conta Poupança: %.2f\n >> ",poup.getSaldo());

					opc = scan.nextInt();
					
					switch (opc) {
						case 1:
							System.out.println("\nQuanto você deseja transferir?");
							System.out.printf("\tSaldo atual Conta Corrente: %.2f\n",cc.getSaldo());
							System.out.printf("\tSaldo atual Conta Poupança: %.2f\n >> ",poup.getSaldo());
							valor = scan.nextDouble();

							if (cc.getSaldo() >= valor) {
								cc.transferir(valor, poup);
							} else {
								System.out.println("\nVocê não tem saldo suficiente!");
							}
							break;
					
						case 2:
							System.out.println("\nQuanto você deseja transferir?");
							System.out.printf("\tSaldo atual Conta Corrente: %.2f\n",cc.getSaldo());
							System.out.printf("\tSaldo atual Conta Poupança: %.2f\n >> ",poup.getSaldo());
							valor = scan.nextDouble();

							if (poup.getSaldo() >= valor) {
								poup.transferir(valor, cc);
							} else {
								System.out.println("\nVocê não tem saldo suficiente!");
							}
							break;

						case 3:
							System.out.println("\n=== " + registro.getNome() + " ===\n" + registro.getContas());
							cc.imprimirExtrato();
							poup.imprimirExtrato();
							verificador = false;
							break;
						
						default:
							System.out.println("\nVocê não escolheu uma opção válida!");
							break;
					}
				}
			} if (contador < 2) {
				System.out.println("Você precisa de pelo menos duas contas para fazer tranferências");
				System.out.println("\n=== " + registro.getNome() + " ===\n" + registro.getContas());
				cc.imprimirExtrato();
				poup.imprimirExtrato();
			}
		} else if (opc == 2) {
			System.out.println("\n=== " + registro.getNome() + " ===\n" + registro.getContas());
			cc.imprimirExtrato();
			poup.imprimirExtrato();
			scan.close();
		} else {
			System.out.println("\n=== " + registro.getNome() + " ===\n" + registro.getContas());
			System.out.println("\nVocê não escolheu uma opção válida!");
			cc.imprimirExtrato();
			poup.imprimirExtrato();
		}
	}
}
