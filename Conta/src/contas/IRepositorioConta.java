package contas;

public interface IRepositorioConta {
public void inserir(ContaAbstrata conta);
public void remover(String numero);
public ContaAbstrata procurar(String numero);
public ContaAbstrata[] listar();
public int tamanho();
public void renderJuros(String numero, double valor);
public void renderBonus(String numero, double valor);
}