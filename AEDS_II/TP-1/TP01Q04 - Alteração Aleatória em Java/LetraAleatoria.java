import java.util.Random;

public class LetraAleatoria {
    //verifica se a condição de parar foi digitada no input
    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');  // Pega especificamente FIM, em maiúsculo
    } 

    public static String resolveLetra (String s, Random gerador){
        int i = 0;
        char[] textoParaChar = s.toCharArray();
        char letraOriginal = (char) ( 'a' + (Math.abs(gerador.nextInt()) % 26)); //comando utilizado para gerar a letra "aleatória", que será substituída
        char letraTrocada = (char) ( 'a' + (Math.abs(gerador.nextInt()) % 26)); //por esta letra
        for(;i<s.length();i++){
            if(textoParaChar[i] == letraOriginal){ //se o texto em i for igual ao que eu estou procurando
                textoParaChar[i] = letraTrocada; // troque pelo definido
            }
        }
        String resultado = String.valueOf(textoParaChar);
        return resultado;
    }
    public static void main(String[] args) {
       
        String[] entrada = new String[1000];
        int numEntrada = 0;
    
        //Leitura da entrada padrao
        do {
            entrada[numEntrada] = MyIO.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--;   //Desconsiderar ultima linha contendo a palavra FIM
        
        Random gerador = new Random( ) ;
        gerador.setSeed(4) ;

        //Para cada linha de entrada, gerando uma de saida contendo o numero de letras maiusculas da entrada
        for(int i = 0; i < numEntrada; i++){
            MyIO.println(resolveLetra(entrada[i],gerador));
        }
    }
    
}
