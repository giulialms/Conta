package contas;
import java.io.*;

public class LendoArquivoTexto {
public static void main(String args[]) {
try {
String pathDir = "/Users/voce/TPI2020-1";
String pathArquivo = pathDir + "/" + "ArquivoTexto.txt";
FileReader arquivo = new FileReader(pathArquivo);
BufferedReader leitor = new BufferedReader(arquivo);
String contetudo = leitor.readLine();
while (contetudo != null) {
System.out.println(contetudo);
contetudo = leitor.readLine();
}
leitor.close();
} catch (IOException ioe) {
ioe.printStackTrace();
}
}
}