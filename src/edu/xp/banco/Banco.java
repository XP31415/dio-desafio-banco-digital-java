package edu.xp.banco;

import java.util.ArrayList;
import java.util.List;
import edu.xp.contas.Conta;

public class Banco {
	private String nome = "Banco Central XP";
	private List<Conta> contas = new ArrayList<>();

	public String getNome() {
		return nome;
	}
	public List<Conta> getContas() {
		return contas;
	}
	public void setContas(Conta conta) {
		contas.add(conta);
	}	
}