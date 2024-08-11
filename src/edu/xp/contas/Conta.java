package edu.xp.contas;

import edu.xp.cliente.Cliente;
import edu.xp.interfaces.ContaInterface;

public abstract class Conta implements ContaInterface{
    
    private static final int AGENCIA_PADRAO = 314;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo = 0.0;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    public int getAgencia() {
        return agencia;
    }
    public int getNumero() {
        return numero;
    }
    public double getSaldo() {
        return saldo;
    }
    
    protected void infoComum() {
        System.out.printf("Titular: %s\n",cliente.getNome());
        System.out.printf("Agência: %d\n",agencia);
        System.out.printf("Conta:\t %d\n",numero);
        System.out.printf("Saldo:\t %.2f\n",saldo);
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }
    @Override
    public void depositar(double valor) {
        saldo += valor;
    }
    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }
    @Override
    public String toString() {
        return "\nConta:"+"Titular: "+cliente.getNome()+", numero="+numero+", agencia="+agencia+", saldo="+saldo;
    }
}
