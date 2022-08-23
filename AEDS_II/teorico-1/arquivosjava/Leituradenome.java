import java.io.File;

public class Leituradenome {
    public static void main(String[] args) {
        File nomeArquivo = new File("meunome3.txt");
        String nomeDoArquivo = nomeArquivo.getName();
        
        System.out.println(nomeDoArquivo);
    }
}
