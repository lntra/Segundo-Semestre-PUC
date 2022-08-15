import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.metal.MetalScrollBarUI;

  public class Array2 {

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
                    System.out.println("Array de números : " + userInputArray);
                    contador ++;
                } else {
                    break;
                }
            } while (x != finalizador);
            int z;
            System.out.println("Escolha o numero desejado: ");
            z = input.nextInt();
            procuraArray(userInputArray,z,contador);
            input.close();
    }

    public static void procuraArray(List<Integer> array,int busca,int contador){
        boolean encontrou = false; 
        if(valorMetade >= busca){
            for(int i = metade; i< contador; i--){
                if(array.get(i) == busca){
                    System.out.println("Numero encontrado no array");
                    encontrou = true;
                    break;
                }
            }
        }
        else{
            for(int i = 0;i<contador;i++){
                if(array.get(i) == busca){
                    System.out.println("Numero encontrado no array");
                    encontrou = true;
                    break;
                }
            }
        }
        if(!encontrou){
           System.out.println("Numero nao encontrado no array");
        }
    }
}