#include <stdio.h>
#include <string.h>

#define MAX 100
// mantap
// Fungsi untuk menghapus elemen duplikat dalam himpunan
int remove_duplicates(char set[MAX][MAX], int n) {
    char temp[MAX][MAX];
    int size = 0;
    
    for (int i = 0; i < n; i++) {
        int is_duplicate = 0;
        for (int j = 0; j < size; j++) {
            if (strcmp(set[i], temp[j]) == 0) {
                is_duplicate = 1;
                break;
            }
        }
        if (!is_duplicate) {
            strcpy(temp[size++], set[i]);
        }
    }
    
    for (int i = 0; i < size; i++) {
        strcpy(set[i], temp[i]);
    }
    return size;
}

int main() {
    char setA[MAX][MAX];
    int sizeA;

    // Input ukuran dan elemen himpunan
    printf("Masukkan jumlah elemen himpunan: ");
    scanf("%d", &sizeA);
    printf("Masukkan elemen himpunan (gunakan 'ø' untuk himpunan kosong, atau '{ø}' jika berisi himpunan kosong):\n");
    for (int i = 0; i < sizeA; i++) {
        scanf("%s", setA[i]);
    }

    // Menangani kasus himpunan kosong
    if (sizeA == 1 && strcmp(setA[0], "ø") == 0) {
        sizeA = 0; // Himpunan kosong, kardinalitas 0
    } else {
        // Menghapus duplikat
        sizeA = remove_duplicates(setA, sizeA);
    }

    // Output kardinalitas himpunan
    printf("\nKardinalitas Himpunan: %d\n", sizeA);

    return 0;
}
