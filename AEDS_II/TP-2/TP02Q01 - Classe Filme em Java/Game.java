import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;


class Game{ 

    private int app_id;
    private String name;
    private String release_date;
    private String owners;
    private int age;
    private Float price;
    private int dlcs;
    private String[] languages;
    private String website;
    private Boolean windows;
    private Boolean mac;
    private Boolean linux;
    private Float upvotes;
    private int avg_ptH;
    private int avg_ptM;
    private String[] developers;
    private String[] genres;

    public Game(){ //iniciando o construtuor vazio
        app_id = 0;
        name = "";
        release_date = "";
        owners = "";
        age = 0;
        price = (float) 0;
        dlcs = 0;
        languages = new String[]{""};
        website = null;
        windows = null;
        mac = null; 
        linux = null;
        upvotes =(float) 0;
        avg_ptH = 0;
        avg_ptM = 0;
        developers = new String[]{""};
        genres = new String[]{""};
    }

    public Game(int app_id, String name,String release_date,String owners,int age,Float price,int dlcs,String[] languages,String website,Boolean windows ,Boolean mac,Boolean linux,Float upvotes,int avg_ptH, int avg_ptM, String[] developers,String[] genres){ //usando o segundo construtuor para receber o valor do que foi pego pelo id do jogo
        this.app_id = app_id;
        this.name = name;
        this.release_date = release_date;
        this.owners = owners;
        this.age = age;
        this.price = price;
        this.dlcs = dlcs;
        this.languages = languages;
        this.website = website;
        this.windows = windows;
        this.mac = mac; 
        this.linux = linux;
        this.upvotes = upvotes;
        this.avg_ptH = avg_ptH;
        this.avg_ptM = avg_ptM;
        this.developers = developers;
        this.genres = genres;
    }

    public void imprimirArray(String[] array,int tipo){ //imprimirArray foi necessário devido a implementação de string fixa, caso contrário o "Array.toString" resolveria o problema
        Boolean elementoUnico = false; 
        if(tipo == 0){
            System.out.print("[");
            elementoUnico = true;
        }
        else if(!(array[1] == null && tipo == 1)){
            System.out.print("[");
            elementoUnico = true;
        }
            for(int i = 0; i < array.length;i++){
                if(array[i]!=null){
                    System.out.print(array[i]);
                    if(array[i+1]!=null){
                        System.out.print(", ");
                    }
                }   
            }     
        if(elementoUnico){  
            System.out.print("]");  
        }
    }

    public void imprimir(){ // pega todos os dados alocados e mostra na tela
        DecimalFormat df = new DecimalFormat("#");

        System.out.print(this.app_id + " " + this.name + " " + this.release_date + " " + this.owners + " " + this.age + " " + this.price + " " + this.dlcs + " " ); 

        imprimirArray(this.languages,0); // tipos diferentes são necessários porque alguns usam barra no resultado final e em certos casos não
  
        System.out.print(" " + this.website + " " + this.windows + " " + this.mac + " " + this.linux + " " + (df.format(this.upvotes)) + "% " + this.avg_ptH + "h" + " " + this.avg_ptM + "m" + " ");

        imprimirArray(this.developers,1);

        System.out.print(" ");

        imprimirArray(this.genres,1);
        System.out.print("\n");

    }

    public int getApp_id(){
        return this.app_id;
    }
    public void setApp_id(int app_id){
        this.app_id = app_id;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getRelease_date(){
        return this.release_date;
    }
    public void setRelease_date(String release_date){
        this.release_date = release_date;
    }

    public String getOwners(){
        return this.owners;
    }
    public void setOwners(String owners){
        this.owners=owners;
    }

    public int getAge(){
        return this.age;
    }
    public void setAge(int age){
        this.age=age;
    }

    public Float getPrice(){
        return this.price;
    }
    public void setPrice(Float price){
        this.price=price;
    }

    public int getDlcs(){
        return this.dlcs;
    }
    public void setDlcs(int dlcs){
        this.dlcs=dlcs;
    }

    public String[] getLanguages(){
        return this.languages;
    }
    public void setLanguages(String[] languages){
        this.languages=languages;
    }

    public String getWebsite(){
        return this.website;
    }
    public void setWebsite(String website){
        this.website=website;
    }

    public Boolean getWindows(){
        return this.windows;
    }
    public void setWindows(Boolean windows){
        this.windows=windows;
    }

    public Boolean getMac(){
        return this.mac;
    }
    public void setMac(Boolean mac){
        this.mac=mac;
    }

    public Boolean getLinux(){
        return this.linux;
    }
    public void setLinux(Boolean linux){
        this.linux=linux;
    }

    public Float getUpvotes(){
        return this.upvotes;
    }
    public void setUpvotes(Float upvotes){
        this.upvotes=upvotes;
    }

    public int getAvg_ptH(){
        return this.avg_ptH;
    }
    public void setAvg_ptH(int avg_ptH){
        this.avg_ptH=avg_ptH;
    }

    public int getAvg_ptM(){
        return this.avg_ptM;
    }
    public void setAvg_ptM(int avg_ptM){
        this.avg_ptM=avg_ptM;
    }

    public String[] getDevelopers(){
        return this.developers;
    }
    public void setDevelopers(String[] devs){
        this.developers=devs;
    }

    public String[] getGenres(){
        return this.genres;
    }
    public void setGenres(String[] genres){
        this.genres=genres;
    }

    public void tratarData(String mes, String ano) throws Exception { 
        String delims = "[ ^\" ]"; // mes e ano já é recebido em metade, mas é necessário dividir por o delimitador aspas, que é escrito dessa maneira para não interferir com o código
        String[] tokens = mes.split(delims);
        String[] tokens2 = ano.split(delims);
        String lancamento =  tokens[1] + "/" + tokens2[1];
        setRelease_date(lancamento);
    }

    public static boolean isLetra(String s, int pos){
        char[] c = s.toCharArray();
        Boolean resposta = false;
        if(pos < s.length()){
            char pos1 = Character.toUpperCase(c[pos]);
                if(pos1 >= 'A' && pos1 <='Z'){
                    return(isLetra(s,pos + 1));
                }
                else{
                    return resposta;
                }
        }
        return (resposta);
    } 

    public void ler(String linha){
        int i = 9;
        String[] linguas = new String[100];
        String[] Devs = new String[20];
        String[] Genres = new String[40];
        String delims = "[,]";
        String[] tokens = linha.split(delims);
        String subString = "]";
        String subString2 = " ";
        Boolean idiomaunico = false;
        int tamanho = (tokens.length);

    setApp_id(Integer.parseInt(tokens[0])); 
    setName(tokens[1]);    
    try {
        tratarData(tokens[2],tokens[3]);
    } catch (Exception e) {
        e.printStackTrace();
    }
    setOwners(tokens[4]);
    setAge(Integer.parseInt(tokens[5]));
    setPrice(Float.parseFloat(tokens[6]));
    setDlcs(Integer.parseInt(tokens[7]));

    if(tokens[i - 1].contains(subString)){
        linguas[0] = tokens[i - 1].substring(2, tokens[i - 1].length() - 2);
        setLanguages(linguas);
        idiomaunico = true;      
        i = i - 1;  
    }
    else if (idiomaunico == false){
        linguas[0] = tokens[i - 1].substring(3, tokens[i - 1].length() - 1);
        while(!tokens[i].contains(subString)){
            tokens[i] = tokens[i].replace("'", subString2);
            linguas[i - 8] = tokens[i].trim();
            i++;
       }   
           tokens[i] = tokens[i].replace("'", subString2);
           linguas[i - 8] = tokens[i].replace("]", subString2);
           linguas[i - 8] = linguas[i - 8].trim();
           linguas[i - 8] = linguas[i - 8].substring(0, linguas[i - 8].length() - 3);
           setLanguages(linguas);
    }
    setWebsite(tokens[i+1]);
    setWindows(Boolean.parseBoolean(tokens[i+2]));
    setMac(Boolean.parseBoolean(tokens[i+3]));
    setLinux(Boolean.parseBoolean(tokens[i+4]));
    if(!tokens[i + 5].equals(null) || !tokens[i + 6].equals(null)){
        Double Upvotes = Double.parseDouble(tokens[i + 5]);
        Double Downvotes = Double.parseDouble(tokens[i + 6]);
        Double totalUpvotes =  Upvotes + Downvotes;
        Double porcentagem = (Upvotes / totalUpvotes)*100; 
        Long porcentagemLong = Math.round(porcentagem); //Math.round só aceita long aparentemente
        Float finalUpvote = porcentagemLong.floatValue();
        setUpvotes(finalUpvote);
    }
    if(!tokens[i + 7].equals(null)){
        int tempo = Integer.parseInt(tokens[i + 7]);
        int horas = tempo / 60;
        int minutos = tempo % 60;
        setAvg_ptH(horas);
        setAvg_ptM(minutos);
    }
    int j = i + 8;
    int aux = j;    
    if(!tokens[j].contains("\"")){ //se a linha não tem "" quer dizer que é elemento único
        Devs[0] = tokens[j].substring(0, tokens[j].length());
        j++;
        setDevelopers(Devs);
    }
    else if(tokens[j].contains("\"")){ // caso contrário
        Devs[0] = tokens[j].substring(1, tokens[j].length());
        j++;
        do{
            Devs[j - aux] = tokens[j];
            j++;
        }while(!tokens[j].contains("\""));
        Devs[j - aux - 1] = tokens[j - 1].substring(0, tokens[j - 1].length() - 1 );
        setDevelopers(Devs);
    }
    aux = j;
    if(!tokens[j].contains("\"")){
        Genres[0] = tokens[j].substring(0, tokens[j].length());
        setGenres(Genres);
    }
    else if(tokens[j].contains("\"")){
        Genres[0] = tokens[j].substring(1, tokens[j].length());
        j++;
            while(!tokens[j].contains("\"") && (j < tamanho)){
                Genres[j - aux] = tokens[j];
                j++;
            }
            Genres[j - aux] = tokens[j ].substring(0, tokens[j].length() - 1);
            setGenres(Genres);
        }
}



public void acharID(String ids) throws FileNotFoundException{
    String nomeArquivo = "games.csv";
    String delims = "[,]";
    Boolean continuar = true;
    try (BufferedReader reader = new BufferedReader(new FileReader("/tmp/" + nomeArquivo))){
        while(continuar == true){
           String jogo = reader.readLine();
           String[] tokens = jogo.split(delims);
           if(tokens[0].equals(ids)){
                ler(jogo); 
                continuar = false;
           }
           else{
                continuar = true;
           }
        }
    } catch (IOException e){
        e.printStackTrace();
    }
}

public static boolean isFim(String s){
       return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M'); // Pega especificamente FIM, em maiúsculo
    }

    public static void main(String[] args) throws Exception {
        ArrayList<String> entrada = new ArrayList<String>();
        int numEntrada = 0;
        //Leitura da entrada padrao
        do {
           entrada.add(MyIO.readLine());
        } while (isFim(entrada.get(numEntrada++)) == false);
        numEntrada--;   //Desconsiderar ultima linha contendo a palavra FIM
  
        //Para cada linha de entrada, gerando uma de saida 
        for(int i = 0; i < numEntrada; i++){
             if(!(entrada.get(i).equals(""))){
                 Game chamaGame = new Game();
                 chamaGame.acharID(entrada.get(i));
                 chamaGame.imprimir();
             } 
        }
     }
  }   