package edu.xp.interfaces;

import edu.xp.contas.Conta;

public interface ContaInterface {
    void imprimirExtrato();
    void sacar(double valor);
    void depositar(double valor);
    void transferir(double valor, Conta contaDestino);
}
