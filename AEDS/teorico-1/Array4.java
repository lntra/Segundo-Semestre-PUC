import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.metal.MetalScrollBarUI;

  public class Array4 {

    public static void main(String[] args) {
        List<Integer> userInputArray = new ArrayList<Integer>();
        Scanner input = new Scanner(System.in);
        int x;
        int finalizador = 55;
        int contador = 0;
        System.out.println("Digite 55 para parar de adicionar");
            do {
                x = input.nextInt();
                if (x != finalizador) {
                    userInputArray.add(x);
                    System.out.println("Array de numeros : " + userInputArray);
                    contador ++;
                } else {
                    break;
                }
            } while (x != finalizador);
            procuraArray(userInputArray,contador);
            input.close();
    }

    public static void procuraArray(List<Integer> array,int contador){
        int menor = array.get(0) , maior = array.get(0);
        for(int i = 0;i<contador;i++){
            if(array.get(i) < menor ){
                menor = array.get(i);
            }
            else if (array.get(i) > maior){
                maior = array.get(i);
            }
        }
        System.out.println("Menor numero encontrado no array: " + menor);
        System.out.println("Maior numero encontrado no array: " + maior);
    }
}