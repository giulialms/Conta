package contas;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AccountFile extends ContaAbstrata implements IRepositorioConta {
    private List<ContaAbstrata> contas;
    private String filename;

    public AccountFile(String numero, String filename) {
        super(numero);
        this.filename = filename;
        this.contas = new ArrayList<>();
        carregarContas();
    }

    @Override public void  inserir(ContaAbstrata conta) {
        contas.add(conta);
        salvarContas();
    }

    @Override public void remover(String numero) {
        contas.removeIf(conta -> conta.numero().equals(numero));
        salvarContas();
    }

    @Override public ContaAbstrata procurar(String numero) {
        for (ContaAbstrata conta : contas) {
            if (conta.numero().equals(numero)) {
                return conta;
            }
        }
        return null;
    }

    @Override public ContaAbstrata[] listar() {
        return contas.toArray(new ContaAbstrata[0]);
    }

    @Override public int tamanho() {
        return contas.size();
    }

    @Override public void renderJuros(String numero, double valor) {
        ContaAbstrata conta= procurar(numero);
        if (conta != null) {
            conta.creditar(valor);
            salvarContas();
        }
    }

    @Override public void renderBonus(String numero, double valor) {
        ContaAbstrata conta= procurar(numero);
        if (conta != null) {
            conta.creditar(valor);
            salvarContas();
        }
    }

    private void carregarContas() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            contas = (List<ContaAbstrata>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado. Um novo arquivo será criado.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void salvarContas() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(contas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}