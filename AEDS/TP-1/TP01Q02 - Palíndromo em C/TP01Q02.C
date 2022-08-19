#include <stdio.h>
#include <string.h>
#include <stdbool.h>

bool isFim(char *s){
  return(strlen(s) == 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M');
}

void isPalindromo(char *s){
  char frase[1000];
  int posicao = 0;
  int controlador = strlen(s);
  for(int i = 0 ; i < controlador; i++) {
    frase[i] = s[controlador - i - 1];
  }
  if (!strcmp(frase, s)) {
    printf("SIM\n");
  }
  else {
    printf("NAO\n");
  }
}

int main(void) {
  char entrada[1000];
  do {
    scanf(" %[^\n]",entrada);
    isPalindromo(entrada);
  } while(!isFim(entrada));
  return 0;
}