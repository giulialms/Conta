package br.ufc.dc.poo.banco;
import contas.ContaAbstrata;

public interface IBanco {
	public double saldoTotal();
	public int numeroContas();
	public void cadastrar(ContaAbstrata conta);
	public ContaAbstrata procurar(String numero) throws CIException;
	public void creditar(String numero, double valor) throws CIException;
    public void debitar(String numero, double valor) throws CIException, SIException;
	public double saldo(String numero);
	public void transferir(String origem, String destino, double valor) throws CIException;
}
