#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define MAX_LIMIT 500
#define FILE_PATH "TP03Q02 - Ordenação por Seleção Recursiva em C/games.csv"

typedef struct 
{
    char name[MAX_LIMIT];
    char owners[MAX_LIMIT];
    char website[MAX_LIMIT];
    char developers[MAX_LIMIT];
    char languages[MAX_LIMIT];
    char genres[MAX_LIMIT];
    int app_id;
    int age;
    int dlcs;
    int avg_playtime;
    float price;
    float upvotes;
    char windows_os[10];
    char mac_os[10];
    char linux_os[10];
} Game ;

void ler(Game *lerGame){
    FILE *csv = fopen("games.csv","r");
    char *texto = NULL;
    size_t tamanho = 0;
    ssize_t linha;
    while((linha = getline(&texto,&tamanho,csv)) != -1) {
       printf("%s", texto);
       find(id)
    }
}

int main(void){
   char entrada[MAX_LIMIT];
   int i = 0;
   scanf(" %[^\n]",entrada);
   while ((strcmp(entrada,"FIM") != 0)){
        Game game;
        ler(&game);
        scanf(" %[^\n]",entrada);
   }
   
}
/*
   public static void main(String[] args) throws Exception {
        ArrayList<String> entrada = new ArrayList<String>();
        Lista lista = new Lista(200);
        int numEntrada = 0;
        String desempenho;
        Arq.openWrite("matrícula_selecao.txt");
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
                 lista.inserirFim(chamaGame);
             } 
        }
        lista.select();
        lista.mostrar();
        desempenho = lista.desempenho();
        Arq.print(System.currentTimeMillis() % 1000 + "ms" + "\t" + desempenho + "\t");
        Arq.close();
       }
     }

*/