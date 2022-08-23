public class cifra {
    //verifica se a condição de parar foi digitada no input
    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M'); // Pega especificamente FIM, em maiúsculo
     }

    public static String resolveCifra (String s, int pos){
        int codigo = 3; // A chave usada para mover todas letras na quantidade desejada
        String espaco = "";

        for (int i = 0; i < s.length(); ++i) {
            char letra = s.charAt(i);
            char n = (char) (letra + codigo);
            espaco += String.valueOf(n);
        }
        return espaco;
    }
    public static void main(String[] args) {
       
        String[] entrada = new String[1000];
        int numEntrada = 0;
    
        //Leitura da entrada padrao
        do {
            entrada[numEntrada] = MyIO.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--;   //Desconsiderar ultima linha contendo a palavra FIM
    
        //Para cada linha de entrada, gerando uma de saida
        for(int i = 0; i < numEntrada; i++){
            MyIO.println(resolveCifra(entrada[i],0));
        }
    }
    
}
