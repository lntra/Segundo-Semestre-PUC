import java.io.File;
import java.io.FileWriter;
import java.time.ZoneId;
import java.util.Scanner;
import java.util.zip.ZipOutputStream;

public class Leituradenome2 {
    public static void main(String[] args) {
        File nomeArquivo = new File("meunome4.txt");
        String nomeDoArquivo = nomeArquivo.getName();
        
        System.out.println(nomeDoArquivo.toUpperCase());
    }
}
