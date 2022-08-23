import java.util.Scanner;

public class abreecopia2 {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o nome do arquivo: ");
        String nome = leitura.nextLine();
        Arq.openWrite(nome + ".txt");
        System.out.println("Digite a frase desejada: ");
        String frase = leitura.nextLine();
        leitura.close();
        Arq.println(frase);
        Arq.close();
        Arq.openWrite(nome + "copia.txt");
        Arq.println("nome: " + nome + " " + "frase: " + frase);
        Arq.close();
    }
}
