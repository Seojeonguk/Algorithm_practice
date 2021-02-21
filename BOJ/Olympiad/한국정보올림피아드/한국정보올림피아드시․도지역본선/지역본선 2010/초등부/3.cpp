#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int k, w, h, square;
int dir[6], l[6];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &k);
    int cnt = 0;
    for (int i = 0; i < 6; i++) {
        scanf("%d %d", &dir[i], &l[i]);
        if (dir[i] == 1 || dir[i] == 2) w = max(w, l[i]);
        else h = max(h, l[i]);
    }

    square = w * h;

    for (int i = 0; i < 6; i++) {
        int d = dir[i];
        int nd = dir[(i + 1) % 6];
        if ((d==1&&nd==3) || (d==2&&nd==4) || (d==3&&nd==2) || (d==4&&nd==1)) {
            square -= l[i] * l[(i + 1) % 6];
            break;
        }
    }

    printf("%d\n", square * k);
}