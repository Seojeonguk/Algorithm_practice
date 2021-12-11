#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

queue<pair<int, pair<int, int> > > q;
int n, m, x, y;
bool visit[102][102];
int X[] = { -2,-1,1,2,2,1,-1,-2 }, Y[] = { 1,2,2,1,-1,-2,-2,-1 };

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d %d %d", &n, &m, &x, &y);

    visit[1][1] = true;
    q.push({ 0,{1,1} });
    
    while (!q.empty()) {
        auto outdata = q.front();
        q.pop();

        if (outdata.second.first == x && outdata.second.second == y) {
            printf("%d\n", outdata.first);
            return 0;
        }

        for (int i = 0; i < 8; i++) {
            int nx = outdata.second.first + X[i];
            int ny = outdata.second.second + Y[i];
            
            if (nx<1 || ny<1 || nx>n || ny>m || visit[nx][ny])
                continue;
            visit[nx][ny] = true;
            q.push({ outdata.first + 1,{nx,ny} });
        }
    }
    puts("NEVAR");
}