#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;


int n,ans;
char friends[53][53];
int arr[53][53];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &n);

    memset(arr, 0x3f, sizeof arr);

    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++) {
            scanf(" %c", &friends[i][j]);
            if (friends[i][j] == 'Y')
                arr[i][j] = arr[j][i] = 1;
        }

    for (int k = 0; k < n; k++)
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (i == j || j == k || i == j) continue;
                else if (arr[i][k] + arr[k][j] < arr[i][j])
                    arr[i][j] = arr[i][k] + arr[k][j];

    for (int i = 0; i < n; i++) {
        int cnt = 0;
        for (int j = 0; j < n; j++)
            if (arr[i][j] <= 2)
                cnt++;
        ans = max(ans, cnt);
    }

    printf("%d\n", ans);
}