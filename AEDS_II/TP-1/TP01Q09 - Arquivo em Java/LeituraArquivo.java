import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

public class LeituraArquivo {
    public static void main(String[] args) throws IOException {
        
        Scanner input = new Scanner(System.in).useLocale(Locale.US); // Mudando localização porque não aceita . no scanner
        int n = input.nextInt();
        double numero;

        RandomAccessFile raf = new RandomAccessFile("nDouble.txt", "rw");
        for(int i = 0; i < n; i++){
            numero = input.nextDouble();
            raf.writeDouble(numero);
        }
        
        raf.close(); 
        DecimalFormat DF = new DecimalFormat("0.#"); // método de alterar o display do double em que o .0 aparece em todos números

        raf = new RandomAccessFile("nDouble.txt", "rw");
        for(int i = n - 1 ; i >= 0 ; i --){
            raf.seek(i * 8); // número de bits de um double é 8
            numero = raf.readDouble();
            if(numero % 1 == 0){ // verificação para checar se o double pode ser um int, se for verdade não precisa do .0
                System.out.println(DF.format(numero)); 
            }
            else{
                System.out.println(numero);
            }
        }

    }
}
