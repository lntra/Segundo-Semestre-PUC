import java.util.Random;

public class QuatroVerificacoes {
   
    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
     }

    public static boolean isVogal(String s, int caminho) {
        int verificador = 0;
        char[] c = s.toCharArray();
        Boolean resposta = false;
        for(int i = 0; i < s.length(); i++){
            char c1 = Character.toUpperCase(c[i]);
            if (c1 =='A' || c1 =='E' || c1 =='I' || c1 =='O' || c1 =='U'){
                verificador++;
            }
        }
        if(verificador == s.length() && caminho == 1){
            return resposta = true;
        }
        else if(verificador != s.length() && caminho == 0){
            resposta = isConsoante(s);
        }
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
            char c1 = Character.toUpperCase(c[i]);
            if(c1 >= 'A' && c1 <='Z'){
                verificador++;
            }
        }
        if(verificador == s.length()){
            if(vogalConsoante == 0){
               resposta = isVogal(s,1);
            }
            if(vogalConsoante == 1){
                resposta =isVogal(s,0);
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

    public static boolean isReal(String s){
        return false;
    } 

    public static Void verificacoes (String s){
        if(isLetra(s,0)){
            System.out.print("SIM ");
        }
        else{
            System.out.print("NAO ");
        }
        if(isLetra(s,1)){
            System.out.print("SIM ");
        }
        else{
            System.out.print("NAO ");
        }
        if(isInteiro(s)){
            System.out.print("SIM ");
        }
        else{
            System.out.print("NAO ");
        }
        if(isReal(s)){
            System.out.print("SIM" + "\r\n");
        }
        else{
            System.out.print("NAO" + "\r\n");
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
