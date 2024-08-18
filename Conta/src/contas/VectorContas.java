package contas;

import java.util.Vector;

public class VectorContas implements IRepositorioConta {
	private Vector<ContaAbstrata> vetorBanco = new Vector<ContaAbstrata>();
	@Override
	public void inserir(ContaAbstrata conta) {
		vetorBanco.add(conta);
		
	}

	@Override
	public void remover(String numero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ContaAbstrata procurar(String numero) {
        for (ContaAbstrata conta : vetorBanco) {
            if (conta.numero().equals(numero)) {
                return conta;
            }
        }
        return null;
    }

	@Override
	public ContaAbstrata[] listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int tamanho() {
		return vetorBanco.size();
	}

	@Override
	public void renderJuros(String numero, double taxa) {
		ContaAbstrata c = procurar(numero);
		if(c instanceof ContaPoupanca) {
			((ContaPoupanca) c).renderJuros(taxa);
		}
		
	}

	@Override
	public void renderBonus(String numero, double valor) {
		ContaAbstrata c = procurar(numero);
		if(c instanceof ContaEspecial) {
			((ContaEspecial) c).renderBonus();
		}
		
	}
	

}
