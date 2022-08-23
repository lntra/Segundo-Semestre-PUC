#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <ctype.h>

bool isFim(char *s){
  return(strlen(s) == 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M');
}

bool isVogal(char *s, int caminho){

  int verificador = 0;
  int resposta = 0;
  char maior[1000];
  int consoante = true;

  for(int i = 0; i < strlen(s); i++){
    maior[i] = toupper(s[i]);
    if(maior[i] == 'A' || maior[i] == 'E' || maior[i] == 'I' || maior[i] == 'O' || maior[i] == 'U'){
      verificador ++;
      consoante = false;
    }
  }
  if(verificador == strlen(s) && caminho == 0){
    return resposta = 1;
  }
  else if(verificador != strlen(s) && caminho == 1 && consoante == true){
    return resposta = 1;
  }
  
  return resposta;
}

bool isLetra(char *s, int caminho){
 
  int verificador = 0;
  int resposta = 0;
  char maior[1000];
    
  for(int i = 0; i < strlen(s); i++){
     maior[i] = toupper(s[i]);
       if(isalpha(maior[i])){
         verificador++;
       }
  }
 
  if(verificador == strlen(s)){
    if(caminho == 0){
      resposta = isVogal(s,0);
    }
    else if(caminho == 1){
      resposta = isVogal(s,1);
    }
  }
  return resposta;
}

bool isInteiro(char *s, int caminho){
  
  int verificador = 0;
  int resposta = 0;
  int virgula = 0;
  
  for(int i = 0; i < strlen(s); i++){
    if(isdigit(s[i])){
      verificador++;
    }
    else if(s[i] == ',' || s[i] == '.' && caminho == 1 && virgula == 0){
      verificador++;
      virgula = 1;
    }
  }

  if(verificador == strlen(s)){
    return resposta = 1;
  }
  return resposta;
}

void verificacoes(char *s){
  if(isLetra(s,0)){
    printf("SIM ");
  }
  else{
    printf("NAO ");
  }
 if(isLetra(s,1)){
    printf("SIM ");
  }
  else{
    printf("NAO ");
  }
  if(isInteiro(s,0)){
    printf("SIM ");
  }
  else{
    printf("NAO ");
  }
  if(isInteiro(s,1)){
    printf("SIM\n");
  }
  else{
    printf("NAO\n");
  }
}



int main(void) {
  char entrada[1000];
  do {
    scanf(" %[^\n]",entrada);
    verificacoes(entrada);
  } while(!isFim(entrada));
  return 0;
}