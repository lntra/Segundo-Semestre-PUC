import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Conteudo3 {
    public static void main(String[] args) throws Exception{
        String x = "";
        RandomAccessFile raf = new RandomAccessFile("arquivoDeLeitura6.txt", "r") ;
        for(int i = 32; i > 0; i--){
            raf.seek(i);
             x += raf.readChar();
             System.out.println(x);

        }
        raf.close();
        try {
            FileWriter arquivoRecebe = new FileWriter("recebenome8.txt");
            arquivoRecebe.write(x);
            arquivoRecebe.close();
        } catch (IOException e) {
            System.out.println("Erro");
            e.printStackTrace();
        }

    }
}
