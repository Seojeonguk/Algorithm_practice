#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, k,x,y;
int arr[102][102];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
  
    scanf("%d %d", &n, &k);

    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            arr[i][j] = 1000000;
    for (int i = 0; i < k; i++) {
        scanf("%d %d", &x, &y);
        x--, y--;
        arr[x][y] = arr[y][x] = 1;
    }

    for (int k = 0; k < n; k++)
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (arr[i][k] + arr[k][j] < arr[i][j])
                    arr[i][j] = arr[i][k] + arr[k][j];

    for(int i=0;i<n;i++)
        for(int j=0;j<n;j++)
            if (arr[i][j] >= 7) {
                puts("Big World!");
                return 0;
            }

    puts("Small World!");
}