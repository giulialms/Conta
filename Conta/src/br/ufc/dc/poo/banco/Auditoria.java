package br.ufc.dc.poo.banco;

public class Auditoria {
public static void main(String args[]){
BancoIndependente bancoIndependente = new BancoIndependente();

AuditorBancoGenerico auditor = new AuditorBancoGenerico();
auditor.auditar(bancoIndependente);
}
}