public class QuatroVerificacoesRecursivo {
   
    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
     }

    public static boolean isVogal(String s, int caminho, int pos) {
        char[] c = s.toCharArray();
        Boolean resposta = false;
        if(pos < s.length()){
            char pos1 = Character.toUpperCase(c[pos]);
            if(caminho == 0){
                if (pos1 =='A' || pos1 =='E' || pos1 =='I' || pos1 =='O' || pos1 =='U'){ // se conter alguma vogal então não é consoante
                    return(isVogal(s, caminho, pos + 1));
                }
            }
            else if(caminho == 1){
                if (pos1 !='A' && pos1 !='E' && pos1 !='I' && pos1 !='O' && pos1 !='U'){ // se conter alguma vogal então não é consoante
                    return(isVogal(s, caminho, pos + 1));
                }
            }
        }
        if(pos == s.length()){
            resposta = true;
        }
        return resposta;
    }

    public static boolean isLetra(String s, int vogalConsoante, int pos){
        char[] c = s.toCharArray();
        Boolean resposta = false;
        if(pos < s.length()){
            char pos1 = Character.toUpperCase(c[pos]);
                if(pos1 >= 'A' && pos1 <='Z'){
                    return(isLetra(s, vogalConsoante, pos + 1));
                }
                else{
                    return resposta;
                }
        }
        if(pos == s.length()){
            if(vogalConsoante == 0){
               resposta = isVogal(s,0,0); //caminho é necessário para não repetir as mesmas verificacões
            }
            if(vogalConsoante == 1){
                resposta =isVogal(s,1,0);
            }
        }
        return (resposta);
     } 

    public static boolean isInteiro(String s,int caminho){ //tenta dar parse em uma string, se funcionar então é true
        Boolean resposta = false;
        if(s == null){
            return resposta;
        }
        if(caminho == 0){
            try{
                int valor = Integer.parseInt(s);
                } catch (NumberFormatException e) {
                    return resposta;
                }
             resposta = true;
        }
        else if (caminho == 1){
            resposta = isReal(s);
        }
        return resposta;
    } 

    public static boolean isReal(String s){
        try{
            double valor = Double.parseDouble(s.replace( ',',  '.')); // troca , por ., é necessário, pois o locale us lê double usando pontos e não virgula
            } catch (NumberFormatException e) {
                return false;
            }
        return true;
    } 

    public static Void verificacoes (String s){
        if(isLetra(s,0,0)){
            System.out.print("SIM ");
        }
        else{
            System.out.print("NAO ");
        }

        if(isLetra(s,1,0)){
            System.out.print("SIM ");
        }
        else{
            System.out.print("NAO ");
        }

        if(isInteiro(s, 0)){
            System.out.print("SIM ");
        }
        else{
            System.out.print("NAO ");
        }

        if(isInteiro(s, 1)){
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
