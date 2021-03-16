#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n;
int arr[2224][2224], d[2224][2224];
queue < pair<int,int> > q;
int X[] = { 1,0 }, Y[] = { 0,1 };

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &n);

    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            scanf("%d", &arr[i][j]);

    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            d[i][j] = 1e9;

    d[0][0] = 0;
    q.push({ 0,0 });


    while (!q.empty()) {
        auto outdata = q.front();
        q.pop();


        for (int i = 0; i < 2; i++) {
            int nx = outdata.first + X[i];
            int ny = outdata.second + Y[i];

            if (nx<0 || ny<0 || nx>n - 1 || ny>n - 1) continue;
            int next_cost = d[outdata.first][outdata.second] + (arr[outdata.first][outdata.second] <= arr[nx][ny] ? arr[nx][ny] - arr[outdata.first][outdata.second] + 1 : 0);
            if (next_cost < d[nx][ny]) {
                d[nx][ny] = next_cost;
                q.push({ nx,ny });
            }
        }
    }

    printf("%d\n", d[n - 1][n - 1]);
}