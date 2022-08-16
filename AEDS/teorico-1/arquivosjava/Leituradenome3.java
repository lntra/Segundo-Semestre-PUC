import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Leituradenome3 {
    public static void main(String[] args) {
        File nomeArquivo = new File("meunome5.txt");
        String nomeDoArquivo = nomeArquivo.getName();
        try {
            FileWriter arquivoRecebe = new FileWriter("recebenome5.txt");
            arquivoRecebe.write(nomeDoArquivo);
            arquivoRecebe.close();
        } catch (IOException e) {
            System.out.println("Erro");
            e.printStackTrace();
        }

    }
}
