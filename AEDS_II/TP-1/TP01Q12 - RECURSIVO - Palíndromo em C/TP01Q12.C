#include <stdbool.h>
#include <stdio.h>
#include <string.h>

bool isFim(char *s) {
  return (strlen(s) == 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M');
}

void isPalindromo(char *s, int pos) {
  char frase[1000];
  int controlador = strlen(s);
  if (pos < controlador) {
    if (s[controlador - 1 - pos] == s[pos]) {
      return isPalindromo(s, pos + 1);
    }  
    else {
      printf("NAO\n");
    }
  }
  else if (controlador == pos || pos != 0) {
      printf("SIM\n");
  }
}

int main(void) {
  char entrada[1000];
  int pos = 0;
  do {
    scanf(" %[^\n]", entrada);
    isPalindromo(entrada, pos);
  } while (!isFim(entrada));
  return 0;
}