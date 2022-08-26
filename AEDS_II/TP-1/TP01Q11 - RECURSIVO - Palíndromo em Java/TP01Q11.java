import java.util.ArrayList;

class TP01Q11 {
    //verifica se a condição de parar foi digitada no input
    public static boolean isFim(String s){
       return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M'); // Pega especificamente FIM, em maiúsculo
    }

    public static String verificarPalindromo (String s, int pos){
       String resp = "SIM"; 
       int controlador = s.length() - 1 - pos;      
       if(pos < controlador){
            if(s.charAt(controlador) == s.charAt(pos)){
                return verificarPalindromo(s, pos + 1);
            }
            else{
                resp = "NAO";
            }
        }
            return resp;
       } 
       
 
    public static void main (String[] args){
       ArrayList<String> entrada = new ArrayList<String>();
       int numEntrada = 0;
 
       //Leitura da entrada padrao
       do {
          entrada.add(MyIO.readLine());
       } while (isFim(entrada.get(numEntrada++)) == false);
       numEntrada--;   //Desconsiderar ultima linha contendo a palavra FIM
 
       //Para cada linha de entrada, gerando uma de saida 
       for(int i = 0; i < numEntrada; i++){
          MyIO.println(verificarPalindromo(entrada.get(i),0));
       }
    }
 }