package contas;

import br.ufc.dc.poo.banco.BancoIndependente;
//import br.ufc.dc.poo.banco.BancoVector;
import br.ufc.dc.poo.banco.CIException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Conta c;
		c = new ContaEspecial("222");
		c.creditar(300);
		ContaEspecial d;
		d = new ContaEspecial("333");
		d.creditar(240);
		d.renderBonus();
		ContaPoupanca a;
		a = new ContaPoupanca("555");
		a.creditar(200);
		a.renderJuros(0.5);
		Conta e;
		e = new ContaPoupanca("444");
		e.creditar(100);
//		BancoArray bb = new BancoArray();
	//	bb.cadastrar(c);
		//bb.cadastrar(d);
	//	bb.creditar("222", 5);
	//	bb.saldo("222");
	//	bb.transferir("222", "333", 5);
	//	bb.render("333", 0);
		BancoIndependente nu = new BancoIndependente();
		nu.inserir(a);
		nu.inserir(e);
		try {
			nu.transferir("555", "444", 50);
		} catch (CIException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		nu.renderBonus("555", 0.2);
		System.out.println("poupanca" + " " + nu.saldo("555"));
		System.out.println("poupanca" + " " + nu.saldo("444"));
		System.out.println("especial" + " " + nu.saldo("333"));
	}

}