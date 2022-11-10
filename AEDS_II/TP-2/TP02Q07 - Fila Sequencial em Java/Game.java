import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

class FilaCircular {
    private Game[] array;
    private int frente; // Aponta para a posi��o do vetor que armazena o primeiro elemento da fila
    private int tras;   // Aponta para a posi��o do vetor que armazena o �ltimo elemento da fila
    private float playtime;
    private float avg_playtime;
    private int playtime_conversao;
    private int n;
    /**
     * Construtor da classe.
     */
    public FilaCircular() {
       this(5);
    }
 
    /**
     * Construtor da classe.
     * @param tamanho Tamanho da fila.
     */
    public FilaCircular(int tamanho){
       array = new Game[tamanho];
       frente = tras = 0;
    }
 
    /**
     * Insere um elemento na �ltima posi��o da fila.
     * @param Game item: elemento a ser inserido.
     */
    public boolean enfileira(Game item) {
        if (tras - frente < array.length) {
            array[tras % array.length] = item;
            tras = tras % array.length;
            tras++;
            return true; 
        }
        System.out.println("TRAS é: " + tras);
        return false;
    }
 
    /**
     * Remove o elemento armazenado no posi��o referenciada pelo �ndice "frente".
     * @return Elemento desenfileirado.
     */
    public Game desenfileira() {
       //validar remocao
         frente = frente % array.length;
         return array[frente++];
    }
 
     public void imprimeVet(int i) {
       for(; i < array.length; i++){
            System.out.print("[" + i + "] ");
            array[i].imprimir();
        }
     }
     
     /**
      * Mostra os elementos da Fila separados por espa�os.
      */    
    public void mostrar (){ 
        if(n > 4){
            playtime = 0;
            for(int i = 0; i < array.length; i++) {
                playtime += array[i].getAvgPlaytime();
            }
            playtime = playtime / 5;
            System.out.println(Math.round(playtime) + " ");
        }

        else{
            playtime += array[n % 5].getAvgPlaytime();
            n++;
            avg_playtime = playtime;
            avg_playtime = avg_playtime / n;
            System.out.println(Math.round(avg_playtime) + " ");
        }
    }
 
    /**
     * Mostra os elementos da Fila separados por espa�os (m�todo recursivo).
     */  
    public void mostrarRec(){
       System.out.print("[ ");
       mostrarRec(frente);
       System.out.println("]");
    }
 
    public void mostrarRec(int i){
       if(i != tras){
          System.out.print(array[i % array.length] + " ");
          mostrarRec(++i);
       }
    }
 
    /**
     * Retorna um boolean indicando se a fila esta vazia
     * @return boolean indicando se a fila esta vazia
     */
    public boolean vazia() {
       return frente == tras; 
    }
 }

class Lista{
	private Game[] array;
	private int n;

	/**
	 * Construtor da classe.
	 */
	public Lista() {
		this(6);
	}

	/**
	 * Construtor da classe.
	 * 
	 * @param tamanho Tamanho da lista.
	 */
	public Lista(int tamanho) {
		array = new Game[tamanho];
		n = 0;
	}

	/**
	 * Insere um elemento na primeira posicao da lista e desloca os demais elementos
	 * para o fim da lista.
	 * 
	 * @param Elemento a ser inserido.
	 */
	public boolean inserirInicio(Game item) {
		if (n < array.length) {
			// Desloca elementos para o fim do array
			for (int i = n; i > 0; i--)
				array[i] = array[i - 1];

			array[0] = item;
			n++;
			return true;
		}
		return false;
	}

	/**
	 * Insere um elemento na ultima posicao da lista.
	 * 
	 * @param Elemento a ser inserido.
	 */
	public boolean inserirFim(Game item) {
		// validar insercao
		if (n < array.length) {
			array[n] = item;
			n++;
			return true;
		}
		return false;
	}

	/**
	 * Insere um elemento em uma posicao especifica e move os demais elementos para
	 * o fim da lista.
	 * 
	 * @param item: elemento a ser inserido.
	 * @param pos:  Posicao de insercao.
	 */
	public boolean inserir(Game item, int pos) {

		// validar insercao
		if (n < array.length && pos >= 0 && pos <= n) {
			// Desloca elementos para o fim do array
			for (int i = n; i > pos; i--)
				array[i] = array[i - 1];

			array[pos] = item;
			n++;
			return true;
		}
		return false;
	}

	/**
	 * Remove um elemento da primeira posicao da lista e movimenta os demais
	 * elementos para o inicio da mesma.
	 * 
	 * @return Elemento a ser removido.
	 */
	public Game removerInicio() {
		if (n > 0) {
			Game item = array[0];
			n--;

			for (int i = 0; i < n; i++) {
				array[i] = array[i + 1];
            }
			return item;
		}
		return null;
	}

	/**
	 * Remove um elemento da ultima posicao da lista.
	 * 
	 * @return Elemento a ser removido.
	 */
	public Game removerFim() {
		if (n > 0){
			return array[--n];
        }
		return null;
	}

	/**
	 * Remove um elemento de uma posicao especifica da lista e movimenta os demais
	 * elementos para o inicio da mesma.
	 * 
	 * @param pos: Posicao de remocao.
	 * @return Elemento a ser removido.
	 */
	public Game remover(int pos) {
		if (n > 0 && pos >= 0 && pos < n) {
			Game item = array[pos];
			n--;

			for (int i = pos; i < n; i++){
				array[i] = array[i + 1];
            }
			
            return item;
		}
		return null;
	}

	/**
	 * Mostra os elementos da lista separados por espacos.
	 */
	public void mostrar() {
		for (int i = 0; i < n; i++) {
			System.out.print("[" + i + "] ");
            array[i].imprimir();
		}
	}

	/**
	 * Procura um elemento e retorna se ele existe.
	 * 
	 * @param x int elemento a ser pesquisado.
	 * @return true se o item existir, false caso contr�rio.
	 */
	public boolean pesquisar(String item) {
		for (int i = 0; i < n; i++)
			if (array[i].getName().equals(item))
				return true;
		return false;
	}
}

public class Game {

    static SimpleDateFormat default_dateFormat = new SimpleDateFormat("MMM/yyyy", Locale.ENGLISH);

    private String name, owners, website, developers;
    private ArrayList<String> languages, genres;
    private Date release_date;
    private int app_id, age, dlcs, avg_playtime;
    private float price, upvotes;
    private boolean windows, mac, linux;

    public Game() {
        this.name = this.owners = this.website = this.developers = null;
        this.languages = new ArrayList<String>();
        this.genres = new ArrayList<String>();
        this.release_date = null;
        this.app_id = this.age = this.dlcs = this.avg_playtime = -1;
        this.price = this.upvotes = -1;
        this.windows = this.mac = this.linux = false;
    }

    public Game(String name, String owners, String website, String developers, ArrayList<String> languages,
            ArrayList<String> genres, Date release_date, int app_id, int age, int dlcs, int upvotes, int avg_playtime,
            float price, boolean windows, boolean mac, boolean linux) {
        this.name = name;
        this.owners = owners;
        this.website = website;
        this.developers = developers;
        this.languages = languages;
        this.genres = genres;
        this.release_date = release_date;
        this.app_id = app_id;
        this.age = age;
        this.dlcs = dlcs;
        this.upvotes = upvotes;
        this.avg_playtime = avg_playtime;
        this.price = price;
        this.windows = windows;
        this.mac = mac;
        this.linux = linux;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwners(String owners) {
        this.owners = owners;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setDevelopers(String developers) {
        this.developers = developers;
    }

    public void setLanguages(ArrayList<String> languages) {
        this.languages = languages;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    public void setReleaseDate(Date release_date) {
        this.release_date = release_date;
    }

    public void setAppId(int app_id) {
        this.app_id = app_id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDlcs(int dlcs) {
        this.dlcs = dlcs;
    }

    public void setAvgPlaytime(int avg_playtime) {
        this.avg_playtime = avg_playtime;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setUpvotes(float upvotes) {
        this.upvotes = upvotes;
    }

    public void setWindows(boolean windows) {
        this.windows = windows;
    }

    public void setMac(boolean mac) {
        this.mac = mac;
    }

    public void setLinux(boolean linux) {
        this.linux = linux;
    }

    public String getName() {
        return this.name;
    }

    public String getOwners() {
        return this.owners;
    }

    public String getWebsite() {
        return this.website;
    }

    public String getDevelopers() {
        return this.developers;
    }

    public ArrayList<String> getLanguages() {
        return this.languages;
    }

    public ArrayList<String> getGenres() {
        return this.genres;
    }

    public Date getReleaseDate() {
        return this.release_date;
    }

    public int getAppId() {
        return this.app_id;
    }

    public int getAge() {
        return this.age;
    }

    public int getDlcs() {
        return this.dlcs;
    }

    public int getAvgPlaytime() {
        return this.avg_playtime;
    }

    public float getPrice() {
        return this.price;
    }

    public float getUpvotes() {
        return this.upvotes;
    }

    public boolean getWindows() {
        return this.windows;
    }

    public boolean getMac() {
        return this.mac;
    }

    public boolean getLinux() {
        return this.linux;
    }

    public Game clone() {
        Game cloned = new Game();
        cloned.name = this.name;
        cloned.owners = this.owners;
        cloned.website = this.website;
        cloned.developers = this.developers;
        cloned.languages = this.languages;
        cloned.genres = this.genres;
        cloned.release_date = this.release_date;
        cloned.app_id = this.app_id;
        cloned.age = this.age;
        cloned.dlcs = this.dlcs;
        cloned.avg_playtime = this.avg_playtime;
        cloned.price = this.price;
        cloned.upvotes = this.upvotes;
        cloned.windows = this.windows;
        cloned.mac = this.mac;
        cloned.linux = this.linux;
        return cloned;
    }

    public void ler(String line) {
        char c_search;
        int index = 0, atr_index = 0;

        // ---------------------------------- //
        // Find "AppID"
        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                this.app_id = Integer.parseInt(line.substring(atr_index, index));
                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //
        // Find "Name"
        if (line.charAt(atr_index) != ',') {
            if (line.charAt(atr_index) == '\"') {
                atr_index++;
                c_search = '\"';
            } else
                c_search = ',';
            while (true) {
                index++;
                if (line.charAt(index) == c_search) {
                    this.name = line.substring(atr_index, index);
                    if (c_search == ',')
                        index++;
                    else if (c_search == '\"')
                        index += 2;
                    atr_index = index;
                    break;
                }
            }
        } else
            atr_index = ++index;

        // ---------------------------------- //
        // Find release date
        if (line.charAt(atr_index) != ',') {
            SimpleDateFormat df;
            if (line.charAt(atr_index) == '\"') {
                df = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
                atr_index++;
                c_search = '\"';
            } else {
                df = new SimpleDateFormat("MMM yyyy", Locale.ENGLISH);
                c_search = ',';
            }
            while (true) {
                index++;
                if (line.charAt(index) == c_search) {
                    try {
                        this.release_date = df.parse(line.substring(atr_index, index));
                    } catch (java.text.ParseException e) {
                        e.printStackTrace();
                    }
                    if (c_search == ',')
                        index++;
                    else if (c_search == '\"')
                        index += 2;
                    atr_index = index;
                    break;
                }
            }
        } else
            atr_index = ++index;

        // ---------------------------------- //
        // Find "Owners"
        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                this.owners = line.substring(atr_index, index);
                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //
        // Find "Age"
        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                this.age = Integer.parseInt(line.substring(atr_index, index));
                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //
        // Find "Price"
        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                this.price = Float.parseFloat(line.substring(atr_index, index));
                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //
        // Find "DLCs"
        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                this.dlcs = Integer.parseInt(line.substring(atr_index, index));
                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //
        // Find "Languages"
        while (true) {
            index++;
            if (line.charAt(index) == ']') {
                index++;
                if (line.charAt(index) == ',')
                    index++;
                else if (line.charAt(index) == '\"')
                    index += 2;
                atr_index = index;
                break;
            } else if (line.charAt(index) == '\'') {
                int wordStart = index + 1;
                while (true) {
                    index++;
                    if (line.charAt(index) == '\'') {
                        this.languages.add(line.substring(wordStart, index));
                        break;
                    }
                }
            }
        }

        // ---------------------------------- //
        // Find "Website"
        if (line.charAt(atr_index) != ',') {
            if (line.charAt(atr_index) == '\"') {
                atr_index++;
                c_search = '\"';
            } else
                c_search = ',';

            while (true) {
                index++;
                if (line.charAt(index) == c_search) {
                    this.website = line.substring(atr_index, index);
                    atr_index = ++index;
                    break;
                }
            }
        } else
            atr_index = ++index;

        // ---------------------------------- //

        // Find "Windows"
        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                this.windows = Boolean.parseBoolean(line.substring(atr_index, index));
                atr_index = ++index;
                break;
            }
        }

        // Find "Mac"
        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                this.mac = Boolean.parseBoolean(line.substring(atr_index, index));
                atr_index = ++index;
                break;
            }
        }

        // Find "Linux"
        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                this.linux = Boolean.parseBoolean(line.substring(atr_index, index));
                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //
        // Find "Upvotes"
        int positives, negatives;
        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                positives = Integer.parseInt(line.substring(atr_index, index));
                atr_index = ++index;
                break;
            }
        }

        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                negatives = Integer.parseInt(line.substring(atr_index, index));
                atr_index = ++index;
                break;
            }
        }
        this.upvotes = (float) (positives * 100) / (float) (positives + negatives);

        // ---------------------------------- //
        // Find "AVG Playtime"
        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                this.avg_playtime = Integer.parseInt(line.substring(atr_index, index));
                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //
        // Find "Developers"
        if (line.charAt(atr_index) != ',') {
            if (line.charAt(atr_index) == '\"') {
                atr_index++;
                c_search = '\"';
            } else
                c_search = ',';
            while (true) {
                index++;
                if (line.charAt(index) == c_search) {
                    this.developers = line.substring(atr_index, index);
                    atr_index = ++index;
                    break;
                }
            }
        } else
            atr_index = ++index;
        // ---------------------------------- //

        // Find "Genres"
        if (index < line.length() - 1) {
            if (line.charAt(index) == ',')
                atr_index = ++index;
            if (line.charAt(atr_index) == '\"') {
                atr_index++;
                while (true) {
                    index++;
                    if (line.charAt(index) == ',') {
                        this.genres.add(line.substring(atr_index, index));
                        atr_index = ++index;
                    } else if (line.charAt(index) == '\"') {
                        this.genres.add(line.substring(atr_index, line.length() - 1));
                        break;
                    }
                }
            } else
                this.genres.add(line.substring(atr_index, line.length()));
        }
    }

    public void imprimir() {
        String avg_pt = null;
        if (this.avg_playtime == 0)
            avg_pt = "null ";
        else if (this.avg_playtime < 60)
            avg_pt = this.avg_playtime + "m ";
        else {
            if (this.avg_playtime % 60 == 0)
                avg_pt = this.avg_playtime / 60 + "h ";
            else
                avg_pt = (this.avg_playtime / 60) + "h " + (this.avg_playtime % 60) + "m ";
        }

        DecimalFormat df = new DecimalFormat("##");
        System.out.println(this.app_id + " " + this.name + " " + default_dateFormat.format(this.release_date) + " "
                + this.owners + " " + this.age + " " + String.format("%.2f", this.price) + " " + this.dlcs + " "
                + this.languages + " " + this.website + " " + this.windows + " " + this.mac + " " + this.linux + " "
                + (Float.isNaN(this.upvotes) ? "0.0% " : df.format(this.upvotes) + "% ") + avg_pt + this.developers
                + " " + this.genres);
    }
    public Boolean acharID(String ids) throws FileNotFoundException{
        String nomeArquivo = "games.csv";
        String delims = "[,]";
        Boolean continuar = true;
        String jogo = "c";
        try (BufferedReader reader = new BufferedReader(new FileReader(
            "/tmp/" +  nomeArquivo
        ))){
            while(continuar == true){
               jogo = reader.readLine();
               if(!(jogo == null)){
                    String[] tokens = jogo.split(delims);
                    if(tokens[0].equals(ids)){
                        ler(jogo); 
                        continuar = false;
                        return true;
                    }
                    else{
                        continuar = true;
                    }
               }
               else{
                continuar = false;
                return false;
               }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return false;
    }
    
    public static void main(String[] args) throws Exception {
        ArrayList<String> entrada = new ArrayList<String>();
        ArrayList<Game> clone = new ArrayList<Game>();
        FilaCircular fCircular = new FilaCircular(5);
        int numEntrada = 0;
        int numOpera = 0;
        int operador = 0;
        String nome = "";
        int side = 0;
        Boolean existe = false;
        Boolean completo = false;
        //Leitura da entrada padrao
        do {
           entrada.add(MyIO.readLine());
        } while (entrada.get(numEntrada++).equals("FIM") == false);
        numEntrada--;   //Desconsiderar ultima linha contendo a palavra FIM
  
        //Para cada linha de entrada, gerando uma de saida 
        for(int i = 0; i < numEntrada; i++){
            if(!(entrada.get(i).equals(""))){
                 Game chamaGame = new Game();
                 chamaGame.acharID(entrada.get(i));
                 if(i > 4){
                    fCircular.desenfileira();
                    completo = true;
                 }
                 fCircular.enfileira(chamaGame);
                 fCircular.mostrar();
            } 
        }
        operador = MyIO.readInt();
        while(numOpera < operador){
            side = operador % 5;
            nome = MyIO.readLine();
            System.out.println(nome);
            numOpera++;
            Game chamaGame = new Game();
            //int idAlterado = 0;
            Boolean funciona = false;
            String tokens[] = nome.split(" ");
            
            if(tokens[0].contains("I")){
                funciona = chamaGame.acharID(tokens[1]);
                if (funciona){
                    if(completo){
                        fCircular.desenfileira();
                    }
                    fCircular.enfileira(chamaGame);
                    fCircular.mostrar();
                    if(side > 0){
                        side --;
                    }
                    if(side == 0){
                        side = 5;
                    }
                }
            }
           
            if(tokens[0].contains("R")){
                side = (side % 5) + 1;
                if(side < 5){
                    MyIO.println("(R) " + fCircular.desenfileira().getName());
                }
                
            }
        }
    }
}