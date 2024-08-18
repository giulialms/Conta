package contas;

public class ContaImposto extends ContaAbstrata{

	public ContaImposto(String numero) {
		super(numero);
	}
	public void debitar(double valor) {
		super.debitar(valor + (valor * 0.001));
	}

}