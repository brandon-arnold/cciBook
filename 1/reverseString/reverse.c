#include <stdio.h>
#include <string.h>

void reverse(char* inStr);

int main() {
  char toReverse[] = "Here's the string to reverse.";
  printf("Original string: %s\n", toReverse);
  reverse(toReverse);
  printf("Reversed string: %s\n", toReverse);
  return -1;
}

void reverse(char* inStr) {
  int i = 0;
  char temp;
  int length = strlen(inStr);
  for(int i = 0; i < length / 2; i++) {
    temp = inStr[i];
    inStr[i] = inStr[length - i - 1];
    inStr[length - i - 1] = temp;
  }
}
