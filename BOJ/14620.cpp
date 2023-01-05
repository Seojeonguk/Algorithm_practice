#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, arr[11][11], ans=INT32_MAX,flowerSum;
int X[] = { 1,0,-1,0 }, Y[] = { 0,1,0,-1 };
bool isOn[11][11];

bool isOut(int x, int y) {
    return x < 0 || y < 0 || x > n - 1 || y > n - 1;
}

bool isValid(int x) {
    pair<int, int> position = { x / n,x % n };
    if (isOn[position.first][position.second]) return false;
    flowerSum += arr[position.first][position.second];
    isOn[position.first][position.second] = true;
    for (int i = 0; i < 4; i++) {
        int nextX = position.first + X[i];
        int nextY = position.second + Y[i];
        if (isOut(nextX, nextY)) return false;
        if (isOn[nextX][nextY]) return false;
        isOn[nextX][nextY] = true;
        flowerSum += arr[nextX][nextY];
    }
    return true;
}

void solve(int x, int y, int z) {
    memset(isOn, false, sizeof isOn);
    flowerSum = 0;
    if (!isValid(x)) return;
    if (!isValid(y)) return;
    if (!isValid(z)) return;

    ans = min(ans, flowerSum);
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &n);

    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            scanf("%d", &arr[i][j]);

    for (int i = 0; i < n * n; i++)
        for (int j = i + 1; j < n * n; j++)
            for (int k = j + 1; k < n * n; k++)
                solve(i, j, k);

    printf("%d\n", ans);
}
