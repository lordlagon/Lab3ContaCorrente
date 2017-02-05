package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Lab03ContaCorrente {

	private int numAge;
	private int numConta;
	private String nome;
	private double saldo;

	private void recuperar (){
		FileReader     tArq1;
		BufferedReader tArq2;
		int            tQtde = 4;
		try
		{
			// Operação I - Abrir o arquivo
			tArq1 = new FileReader (getNumAge() + "." + getNumConta() + ".dat");
			tArq2 = new BufferedReader (tArq1);
			// Operação III - Ler atributo/valor e colocar na matriz
			String [] tLinha = new String [tQtde];
			for (int i = 0; i < tQtde; i++){
				tLinha [i] = tArq2.readLine();
			}
			// Operação IV - Fechar o arquivo
			tArq2.close();
			setNumAge(Integer.parseInt(tLinha [0]));
			setNumConta(Integer.parseInt(tLinha [1]));
			setNome(tLinha [2]);
			setSaldo(Double.parseDouble(tLinha [3]));	
		}
		catch (IOException tExcept)
		{
			System.out.println("Conta Inexistente");
		//	tExcept.printStackTrace();
		}
		
}

	
	public Lab03ContaCorrente(int numAge, int numConta) {
		super();
		this.numAge = numAge;
		this.numConta = numConta;
						
	}
	
	public Lab03ContaCorrente(int numAge, int numConta, String nome, double saldo) {
		super();
		
		this.numAge = numAge;
		this.numConta = numConta;
		this.nome = nome;
		this.saldo = saldo;
		
	}



	public void imprimir(){
		
		NumberFormat formatter;
		formatter = DecimalFormat.getCurrencyInstance(new Locale("pt","BR"));
		formatter.setMinimumFractionDigits(2);
		
		recuperar();

		System.out.println("------------------------------------------");
		System.out.println("	Situação da Conta");
		System.out.println("------------------------------------------");
		System.out.println("Agência	: " + numAge + " ");
		System.out.println("Conta	: " + numConta + " ");
		System.out.println("Cliente	: " + nome + " ");
		System.out.println("Saldo	: " + formatter.format(saldo) + " ");
		System.out.println("------------------------------------------\n");
		
		
		

	}
	
	public int sacar (double pValor) {
	
		recuperar();
		if (saldo>pValor){
			saldo = saldo - pValor;
			gravar();
			return 1;
			
		}else{
			
			return 0;
		}
	}
	
	public void depositar (double pValor) {
			recuperar();
			saldo = saldo + pValor;
			gravar();
			
	}
	
	public boolean gravar ()	{
		FileWriter      tArq1;
		PrintWriter     tArq2;

		try
		{
			// Operação I - Abrir o aquivo
			tArq1 = new FileWriter (getNumAge() + "." + getNumConta() + ".dat");
			tArq2 = new PrintWriter (tArq1);

			tArq2.println (getNumAge());
			tArq2.println (getNumConta());
			tArq2.println (getNome());
			tArq2.println (getSaldo());
			// Operação III - Fechar o arquivo
			tArq2.close();

			return true;
		}
		catch (IOException tExcept)
		{
			tExcept.printStackTrace();
			return false;
		}
		
	}

	
	public int getNumAge() {
		return numAge;
	}
	public void setNumAge(int numAge) {
		if (numAge<9999 && numAge>1){
		this.numAge = numAge;
		}else{
			System.out.println("Agência Incorreta");
		}
	}
	public int getNumConta() {
		return numConta;
	}
	public void setNumConta(int numConta) {
		if (numConta<9999999 && numConta>1){
			this.numConta = numConta;
			}else{
				System.out.println("Agência Incorreta");
			}
		
		
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
}
