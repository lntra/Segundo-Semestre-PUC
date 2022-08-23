import java.io.File;

public class Leituradenome2 {
    public static void main(String[] args) {
        File nomeArquivo = new File("meunome4.txt");
        String nomeDoArquivo = nomeArquivo.getName();
        
        System.out.println(nomeDoArquivo.toUpperCase());
    }
}
