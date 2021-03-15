#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, m, up[53][53], down[53][53];;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &n, &m);


    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
            scanf("%1d", &up[i][j]);

    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
            scanf("%1d", &down[i][j]);

    int cnt = 0;

    for (int i = 0; i <= n - 3; i++) {
        for (int j = 0; j <= m - 3; j++) {
            if (up[i][j] != down[i][j]) {
                cnt++;
                for (int k = i; k < i + 3; k++)
                    for (int l = j; l < j + 3; l++)
                        up[k][l] = (up[k][l] + 1) % 2;
            }
        }
    }

    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
            if (up[i][j] != down[i][j]) {
                cnt = -1;
                break;
            }
    printf("%d\n", cnt);
}