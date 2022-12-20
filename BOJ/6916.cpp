#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

void paint(int);
char display[9][9];
int n;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    memset(display, ' ', sizeof display);
    display[0][0] = display[4][0] = display[8][0] = '\0';
    scanf("%d", &n);

    if (n == 0) {
        paint(1);
        paint(2);
        paint(3);
        paint(5);
        paint(6);
        paint(7);
    }
    else if (n == 1) {
        paint(3);
        paint(6);
    }
    else if (n == 2) {
        paint(1);
        paint(3);
        paint(4);
        paint(5);
        paint(7);
    }
    else if (n == 3) {
        paint(1);
        paint(3);
        paint(4);
        paint(6);
        paint(7);
    }
    else if (n == 4) {
        paint(2);
        paint(3);
        paint(4);
        paint(6);
    }
    else if (n == 5) {
        paint(1);
        paint(2);
        paint(4);
        paint(6);
        paint(7);
    }
    else if (n == 6) {
        paint(1);
        paint(2);
        paint(4);
        paint(5);
        paint(6);
        paint(7);
    }
    else if (n == 7) {
        paint(1);
        paint(3);
        paint(6);
    }
    else if (n == 8) {
        paint(1);
        paint(2);
        paint(3);
        paint(4);
        paint(5);
        paint(6);
        paint(7);
    }
    else if (n == 9) {
        paint(1);
        paint(2);
        paint(3);
        paint(4);
        paint(6);
        paint(7);
    }
    for (int i = 0; i <= 8; i++) {
        puts(display[i]);
    }
}

void paint(int x) {
    if (x == 1) {
        display[0][0] = ' ';
        display[0][1] = display[0][3] = display[0][5] = '*';
        display[0][6] = '\0';
    }
    else if (x == 2) {
        display[1][0] = display[2][0] = display[3][0] = '*';
        display[1][1] = display[2][1] = display[3][1] = '\0';
    }
    else if (x == 3) {
        display[1][1] = display[2][1] = display[3][1] = ' ';
        display[1][6] = display[2][6] = display[3][6] = '*';
        display[1][7] = display[2][7] = display[3][7] = '\0';
    }
    else if (x == 4) {
        display[4][0] = ' ';
        display[4][1] = display[4][3] = display[4][5] = '*';
        display[4][6] = '\0';
    }
    else if (x == 5) {
        display[5][0] = display[6][0] = display[7][0] = '*';
        display[5][1] = display[6][1] = display[7][1] = '\0';
    }
    else if (x == 6) {
        display[5][1] = display[6][1] = display[7][1] = ' ';
        display[5][6] = display[6][6] = display[7][6] = '*';
        display[5][7] = display[6][7] = display[7][7] = '\0';
    }
    else if (x == 7) {
        display[8][0] = ' ';
        display[8][1] = display[8][3] = display[8][5] = '*';
        display[8][6] = '\0';
    }
}