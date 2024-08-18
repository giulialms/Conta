package br.ufc.dc.poo.banco;
import contas.ContaAbstrata;
import contas.VectorContas; 
import contas.IRepositorioConta;
//import contas.ContaEspecial;
//import contas.ContaPoupanca;

public class BancoIndependente implements IBanco, IRepositorioConta{
	private VectorContas repositorio;

	public void cadastrar(ContaAbstrata contaabstrata){}
	public double saldoTotal(){return 0;}
	public int numeroContas(){return 0;}
	
	public BancoIndependente() {
		repositorio = new VectorContas();
	}
	
	public void inserir(ContaAbstrata conta) {
		repositorio.inserir(conta);
	}
	
	public ContaAbstrata procurar(String numero) {
        return repositorio.procurar(numero);
    }

    public void creditar(String numero, double valor) throws CIException{
        ContaAbstrata c = procurar(numero);
        if (c != null) {
            c.debitar(valor);
        } else {
        	throw new CIException(numero);
        }
    }

    public void debitar(String numero, double valor) throws CIException, SIException{
        ContaAbstrata conta = repositorio.procurar(numero);
        if(conta != null) {
        	if(conta.saldo() >= valor) {
        		conta.debitar(valor);
        	} else {
        		throw new SIException(conta.saldo(), conta.numero());
        	}
        	} else {
        		throw new CIException(numero);
        	}
    }

    public double saldo(String numero) {
        ContaAbstrata c = procurar(numero);
        if (c != null) {
            return c.saldo();
        } else {
            return 0;
        }
    }

    public void transferir(String origem, String destino, double valor) throws CIException{
        ContaAbstrata c = procurar(origem);
        ContaAbstrata d = procurar(destino);
        if (c != null) {
        	if (d != null) {
            c.debitar(valor);
            d.creditar(valor);
        	} else {
        		throw new CIException(destino);
        	}
        } else {
            throw new CIException(origem);
        }
    }
  

	@Override
	public void remover(String numero) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public ContaAbstrata[] listar() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int tamanho() {
		return repositorio.tamanho();
	}
	@Override
	public void renderJuros(String numero, double valor) {
		repositorio.renderJuros(numero,valor);
		
	}
	@Override
	public void renderBonus(String numero, double valor) {
		repositorio.renderBonus(numero,valor);
		
	}
    
}