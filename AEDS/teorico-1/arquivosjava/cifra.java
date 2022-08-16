public class cifra {
    public static void main(String[] args) {
        int codigo = 3;
        String nome = "arquivoDeLeitura7.txt";
        Arq.openRead(nome);
        String texto = Arq.readAll();
        String espaco = "";

        for (int i = 0; i < texto.length(); ++i) {
            char letra = texto.charAt(i);
            char n = (char) (letra + codigo);
            if(n == '#'){ 
                espaco += " ";
            }
            else{
                espaco += String.valueOf(n);
            }
        }
        System.out.println(espaco);
    }
}
