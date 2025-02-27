#include <stdio.h>
#include "math_operations.h"

void testcase() {
    printf("Running Test Cases...\n");

    printf("\nTesting add()...\n");
    printf("%s\n", add(23, 12) == 35 ? "PASS" : "FAIL");
    printf("%s\n", add(12, 25) == 37 ? "PASS" : "FAIL");
    printf("%s\n", add(1225, 2389) == 3614 ? "PASS" : "FAIL");
    printf("%s\n", add(-10, 5) == -5 ? "PASS" : "FAIL");
    printf("%s\n", add(0, 0) == 0 ? "PASS" : "FAIL");
    printf("%s\n", add(-100, -200) == -300 ? "PASS" : "FAIL");
    printf("%s\n", add(2147483647, -1) == 2147483646 ? "PASS" : "FAIL");
    printf("%s\n", add(2147483647, 0) == 2147483647 ? "PASS" : "FAIL");
    printf("%s\n", add(-2147483648, 1) == -2147483647 ? "PASS" : "FAIL");
    printf("%s\n", add(500, -500) == 0 ? "PASS" : "FAIL");

    printf("\nTesting subtract()...\n");
    printf("%s\n", subtract(10, 2) == 8 ? "PASS" : "FAIL");
    printf("%s\n", subtract(12, 25) == -13 ? "PASS" : "FAIL");
    printf("%s\n", subtract(2389, 1225) == 1164 ? "PASS" : "FAIL");
    printf("%s\n", subtract(-10, -5) == -5 ? "PASS" : "FAIL");
    printf("%s\n", subtract(0, 10) == -10 ? "PASS" : "FAIL");
    printf("%s\n", subtract(-100, -200) == 100 ? "PASS" : "FAIL");
    printf("%s\n", subtract(2147483647, 1) == 2147483646 ? "PASS" : "FAIL");
    printf("%s\n", subtract(2147483647, 2147483647) == 0 ? "PASS" : "FAIL");
    printf("%s\n", subtract(-2147483648, -1) == -2147483647 ? "PASS" : "FAIL");
    printf("%s\n", subtract(500, 500) == 0 ? "PASS" : "FAIL");

    printf("\nTesting multiply()...\n");
    printf("%s\n", multiply(10, 2) == 20 ? "PASS" : "FAIL");
    printf("%s\n", multiply(12, 25) == 300 ? "PASS" : "FAIL");
    printf("%s\n", multiply(1225, 2389) == 2926525 ? "PASS" : "FAIL");
    printf("%s\n", multiply(-10, 5) == -50 ? "PASS" : "FAIL");
    printf("%s\n", multiply(0, 100) == 0 ? "PASS" : "FAIL");
    printf("%s\n", multiply(-100, -200) == 20000 ? "PASS" : "FAIL");
    printf("%s\n", multiply(2147483647, 0) == 0 ? "PASS" : "FAIL");
    printf("%s\n", multiply(1, -2147483648) == -2147483648 ? "PASS" : "FAIL");
    printf("%s\n", multiply(2147483647, 1) == 2147483647 ? "PASS" : "FAIL");
    printf("%s\n", multiply(-500, 500) == -250000 ? "PASS" : "FAIL");

    printf("\nTesting divide()...\n");
    printf("%s\n", divide(10, 2) == 5 ? "PASS" : "FAIL");
    printf("%s\n", divide(12, 25) == 0.48 ? "PASS" : "FAIL");  
    printf("%s\n", divide(1225, 5) == 245 ? "PASS" : "FAIL");
    printf("%s\n", divide(-10, 2) == -5 ? "PASS" : "FAIL");
    printf("%s\n", divide(0, 10) == 0 ? "PASS" : "FAIL");
    printf("%s\n", divide(-100, -10) == 10 ? "PASS" : "FAIL");
    printf("%s\n", divide(1234, -1234) == -1 ? "PASS" : "FAIL");
    printf("%s\n", divide(500, 500) == 1 ? "PASS" : "FAIL");
    printf("%s\n", divide(1225, 0) == 0 ? "PASS" : "FAIL");
    printf("%s\n", divide(0, 0) == 0 ? "PASS" : "FAIL");

    printf("\nTest Cases Finished!\n");
}

int main() {
    testcase();
    return 0;
}
