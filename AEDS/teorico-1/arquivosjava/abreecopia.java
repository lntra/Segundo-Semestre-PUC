import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class abreecopia {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(arquivo);
        Arq.openWrite("Entrada1.txt");
        System.out.println("Digite a frase desejada: ");
        String x = leitura.nextLine();
        Arq.println(x);
        Arq.close();
        Arq.openWrite("Copia1.txt");
        Arq.println(x);
        Arq.close();
    }
}
