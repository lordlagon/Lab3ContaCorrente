/* Autor: André Xavier
 * Projeto: Laboratório 3
 */

package view;

import java.util.Scanner;
import model.Lab03ContaCorrente;

public class Lab03Sistema {

	static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {

		menu();
	}


	public static void execCadastramento(){

		int nAge;
		int nConta;
		String nNome;
		double nSaldo;

		System.out.println("Digite o número da Agencia: ");
		nAge=entrada.nextInt();
		System.out.println("Digite o número da Conta: ");
		nConta=entrada.nextInt();
		System.out.println("Digite o Nome do Cliente: ");
		nNome=entrada.next();
		System.out.println("Digite o Saldo Inicial: ");
		nSaldo=entrada.nextDouble();

		Lab03ContaCorrente C1 = new Lab03ContaCorrente(nAge, nConta, nNome, nSaldo);

		System.out.println("Confirma cadastramento (S/N): ");

		String confirma = entrada.next();

		if (confirma.equals("S")||confirma.equals("s")){
			C1.gravar();
			System.out.println("Cadastramento Realizado \n");

		}else{
			System.out.println("Cadastramento Cancelado \n");

		}	

		menu();

	}

	public static void execSaque() {

		int nAge;
		int nConta;
		double nSaque;

		System.out.println("Digite o número da Agencia: ");
		nAge = entrada.nextInt();
		System.out.println("Digite o número da Conta: ");
		nConta = entrada.nextInt();
		do {
			System.out.println("Digite o Valor do Saque: ");
			nSaque = entrada.nextDouble();
		} while (nSaque <= 0.0);

		Lab03ContaCorrente C1 = new Lab03ContaCorrente(nAge, nConta);

		System.out.println("Confirma o Saque (S/N): ");

		String confirma = entrada.next();

		if (confirma.equals("S") || confirma.equals("s")) {

			C1.sacar(nSaque);
			System.out.println("Saque Realizado \n");

		} else {
			System.out.println("Saque Cancelado \n");

		}

		menu();

	}

	public static void execDeposito() {

		int nAge;
		int nConta;
		double nDeposito;

		System.out.println("Digite o número da Agencia: ");
		nAge = entrada.nextInt();
		System.out.println("Digite o número da Conta: ");
		nConta = entrada.nextInt();
		do {
			System.out.println("Digite o Valor do Deposito: ");
			nDeposito = entrada.nextDouble();
		} while (nDeposito <= 0.0);

		System.out.println("Confirma o Deposito (S/N): ");

		String confirma = entrada.next();

		if (confirma.equals("S") || confirma.equals("s")) {

			Lab03ContaCorrente C1 = new Lab03ContaCorrente(nAge, nConta);
			
				C1.depositar(nDeposito);
				System.out.println("Deposito Realizado \n");

					System.out.println("Conta Inexistente \n");
			
		} else {
			System.out.println("Deposito Cancelado \n");

		}

		menu();

	}

	public static void execConsulta() {

		int nAge;
		int nConta;

		System.out.println("Digite o número da Agencia: ");
		nAge=entrada.nextInt();
		System.out.println("Digite o número da Conta: ");
		nConta=entrada.nextInt();
		
		System.out.println("Agência	: " + nAge + " ");
		System.out.println("Conta	: " + nConta + "\n ");
		System.out.println("Confirma Consulta (S/N)	: "); 
		String confirma = entrada.next();

		Lab03ContaCorrente C1 = new Lab03ContaCorrente(nAge, nConta);

		if (confirma.equals("S") || confirma.equals("s")) {
			C1.imprimir();
		}else{
			System.out.println("Consulta Cancelada\n");
		}

		menu();
	}


	public static void menu() {

		System.out.println("|1 - Cadastramento |");
		System.out.println("|2 - Saque         |");
		System.out.println("|3 - Deposito      |");
		System.out.println("|4 - Consulta      |");
		System.out.println("|9 - Fim           |");

		int numMenu;
		System.out.println("Digite o numero da função: ");
		numMenu = entrada.nextInt();

		switch (numMenu) {
		case 1:
			execCadastramento();
			break;
		case 2:
			execSaque();
			break;
		case 3:
			execDeposito();
			break;
		case 4:
			execConsulta();
			break;
		case 9:
			System.out.println("!Fim!\n");
			break;
		default:
			System.out.println("\n!Numero Incorreto!");
			menu();

		}
	}

}