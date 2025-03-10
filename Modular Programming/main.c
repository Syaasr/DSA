#include <stdio.h>
#include "math_operations.h"

void calculator(){
    int a, b;
    char c;
    int temp = 0;
    printf("Masukkan angka pertama : ");
    scanf("%d", &a);
    printf("Masukkan angka kedua : ");
    scanf("%d", &b);
    printf("Masukkan operasi (+ - * /) : ");
    scanf(" %c", &c);

    switch (c)
    {
    case '+':
        printf("%d + %d = %d\n", a, b, add(a,b));
        break;
    case '-':
        printf("%d - %d = %d\n", a, b, subtract(a,b));
        break;
    case '*':
        printf("%d * %d = %d\n", a, b, multiply(a,b));
        break;
    case '/':
        printf("%d / %d = %f\n", a, b, divide(a,b));
        break;
    default:
        printf("Operator %c invalid\n", c);
        break;
    }
}

int main(){
    calculator();
    return 0;
}
