import java.io.File;
import java.io.FileWriter;
import java.time.ZoneId;
import java.util.Scanner;
import java.util.zip.ZipOutputStream;

public class Leituradenome {
    public static void main(String[] args) {
        File nomeArquivo = new File("meunome3.txt");
        String nomeDoArquivo = nomeArquivo.getName();
        
        System.out.println(nomeDoArquivo);
    }
}
