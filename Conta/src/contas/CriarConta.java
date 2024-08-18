package contas;

import br.ufc.dc.poo.banco.BancoIndependente;
import br.ufc.dc.poo.banco.CIException;

public class CriarConta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Conta c;
		c = new Conta("222");
		c.creditar(300);
		Conta d;
		d = new Conta("333");
		d.creditar(240);
		Conta conta;
		conta = new Conta("123");
		conta.creditar(500.87);
		conta.debitar(45.00);
		System.out.println(c.saldo());
		
		BancoIndependente bb = new BancoIndependente();
		bb.cadastrar(conta);
		bb.cadastrar(c);
		bb.cadastrar(d);
		try {
			bb.creditar("221", 5);
		} catch (CIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bb.saldo("222");
		
		try {
			bb.transferir("221", "333", 5);
		} catch (CIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(bb.saldo("222"));
		System.out.println(bb.saldo("333"));
	}

}
