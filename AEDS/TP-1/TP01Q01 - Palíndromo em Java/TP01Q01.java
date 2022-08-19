import javax.print.DocFlavor.STRING;

class TP01Q01 {
    //verifica se a condição de parar foi digitada no input
    public static boolean isFim(String s){
       return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M'); // Pega especificamente FIM, em maiúsculo
    }

    public static String verificarPalindromo (String s, int pos, String f){
       String resp = ""; 
       String frase = f;
       int controlador = s.length();      
       //Compara com a frase enviada, a frase pega começando pelo último caractere até o primeiro 
       for ( int i = controlador - 1; i >= 0; i-- ) {
            frase = frase + s.charAt(i);  
         }
       if (s.equals(frase)) {
            resp = "SIM";
         }
       else {
             resp = "NAO"; 
         } 
          return resp;
       } 
       
 
    public static void main (String[] args){
       String[] entrada = new String[1000];
       int numEntrada = 0;
 
       //Leitura da entrada padrao
       do {
          entrada[numEntrada] = MyIO.readLine();
       } while (isFim(entrada[numEntrada++]) == false);
       numEntrada--;   //Desconsiderar ultima linha contendo a palavra FIM
 
       //Para cada linha de entrada, gerando uma de saida 
       for(int i = 0; i < numEntrada; i++){
          MyIO.println(verificarPalindromo(entrada[i],0,""));
       }
    }
 }