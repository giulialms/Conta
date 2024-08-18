package arquivos;

import java.io.*;

import contas.ContaAbstrata;
import contas.ContaEspecial;



public class ArquivoTeste {
    public static void main(String[] args) {
        ContaAbstrata conta;
        conta = new ContaEspecial("333");
        conta.creditar(240);

        String pathDir = "C:\\Users\\giuli\\Documents\\desktop\\Contas";
        File diretorio = new File(pathDir);
        File arquivo = new File(diretorio, "Contas.txt");

     
        if (!diretorio.exists()) {
            diretorio.mkdir();
        }

        try {
           
            FileWriter gravador = new FileWriter(arquivo, true);
            gravador.write(conta.numero() + ":" + conta.saldo()+ "\n") ;  
            gravador.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        try {
            
            BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
            String conteudo = leitor.readLine();
            while (conteudo != null) {
                System.out.println(conteudo);
                conteudo = leitor.readLine();
            }
            leitor.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
