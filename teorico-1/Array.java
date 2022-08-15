import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

  public class Array {

    public static void main(String[] args) {

        List<String> userInputArray = new ArrayList<String>();
        Scanner input = new Scanner(System.in);
        String x;
        String finalizador = "FIM";
        int contador = 0;
            do {
                x = input.nextLine();
                if (!x.equals(finalizador)) {
                    userInputArray.add(x);
                    System.out.println("Array de números : " + userInputArray);
                    contador ++;
                } else {
                    break;
                }
            } while (!x.equals(finalizador));
            String z;
            System.out.println("Escolha o numero desejado: ");
            z = input.nextLine();
            procuraArray(userInputArray, z,contador);
            input.close();
    }

    public static void procuraArray(List<String> array,String busca,int contador){
        boolean encontrou = true; 
        for(int i = 0;i<contador;i++){
            if(array.get(i).equals(busca)){
                System.out.println("Numero encontrado no array");
                encontrou = false;
                break;
            }
        }
        if(encontrou){
           System.out.println("Numero nao encontrado no array");
        }
    }
}