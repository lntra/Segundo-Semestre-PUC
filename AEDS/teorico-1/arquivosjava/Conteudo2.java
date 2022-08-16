import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.ZoneId;
import java.util.Scanner;
import java.util.zip.ZipOutputStream;

public class Conteudo2 {
    public static void main(String[] args) {
        String nome = "arquivoDeLeitura6.txt";
        Arq.openRead(nome);
        String texto = Arq.readAll();

        try {
            FileWriter arquivoRecebe = new FileWriter("recebenome7.txt");
            arquivoRecebe.write(texto.toUpperCase());
            arquivoRecebe.close();
        } catch (IOException e) {
            System.out.println("Erro");
            e.printStackTrace();
        }

    }
}
