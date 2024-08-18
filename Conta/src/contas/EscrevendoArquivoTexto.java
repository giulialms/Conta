package contas;

import java.io.*;

public class EscrevendoArquivoTexto {
public static void main(String args[]) {
String pathDir = "/Users/voce/TPI2020-1";
File diretorio = new File(pathDir);
if (!diretorio.isDirectory()) {
diretorio.mkdir();
}
try {
String pathArquivo = pathDir + "/" + "ArquivoTexto.txt";
FileWriter arquivo = new FileWriter(pathArquivo);
PrintWriter gravador = new PrintWriter(arquivo);
for (int i = 0; i < 5; i++){
gravador.println("Linha[" + i + "] LIXO-Texto");

}
gravador.close();
} catch (IOException ioe) {
ioe.printStackTrace();
}
}
}