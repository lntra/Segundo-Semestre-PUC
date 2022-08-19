import java.util.Random;

public class QuatroVerificacoes {
   
    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
     }

    public static boolean isVogal(String s) {
        int verificador = 0;
        char[] c = s.toCharArray();
        Boolean resposta = false;
        for(int i = 0; i < s.length(); i++){
            char c1 = Character.toUpperCase(c[i]);
            if (c1 =='A' || c1 =='E' || c1 =='I' || c1 =='O' || c1 =='U'){
                verificador++;
            }
        }
        if(verificador == s.length()){
            return resposta = true;
        }
        System.out.println(resposta);
        return resposta;
    }

    public static boolean isConsoante(String s) {
        return true;
    }

    public static boolean isLetra(String s, int vogalConsoante){
        int verificador = 0;
        char[] c = s.toCharArray();
        Boolean resposta = false;
        for(int i = 0; i < s.length(); i++){
            if(c[i] >= 'A' && c[i] <='Z' || c[i] >='a' && c[i] <='Z'){
                verificador++;
            }
        }
        if(verificador == s.length()){
            if(vogalConsoante == 0){
               resposta = isVogal(s);
               System.out.println(resposta);
            }
            if(vogalConsoante == 1){
                resposta =isConsoante(s);
            }
        }
        return (resposta);
     } 

    public static boolean isInteiro(String s){
        if(s == null){
            return false;
        }
        try{
           int valor = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    } 


    public static Void verificacoes (String s){
        if(isLetra(s,0)){
            System.out.println("Sim ");
        }
        else{
            System.out.println("Nao ");
        }
        if(isLetra(s,1)){
            System.out.print("Sim ");
        }
        else{
            System.out.print("Nao ");
        }
        if(isInteiro(s)){
            System.out.print("Sim");
        }
        else{
            System.out.print("Nao");
        }
        return null;
    }
    public static void main(String[] args) {
       
        String[] entrada = new String[1000];
        int numEntrada = 0;
    
        //Leitura da entrada padrao
        do {
            entrada[numEntrada] = MyIO.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--;   //Desconsiderar ultima linha contendo a palavra FIM
    
        //Para cada linha de entrada, gerando uma de saida contendo o numero de letras maiusculas da entrada
        for(int i = 0; i < numEntrada; i++){
            verificacoes(entrada[i]);
        }
    }
    
}
