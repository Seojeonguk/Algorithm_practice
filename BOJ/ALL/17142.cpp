#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, m, arr[52][52], X[] = { 1,0,-1,0 }, Y[] = { 0,1,0,-1 };
vector<pair<int, int> > v;
pair<int, int> p[12];
bool visit[52][52];
int chk,ans=9999999;
struct d {
    int x, y, cnt;
};

void solve(int idx, int cnt) {
    if (cnt == m) {
        int temp = chk;
        memset(visit, 0, sizeof visit);
        int ma = 0;
        queue<d> q;
        for (int i = 0; i < m; i++) {
            q.push({ p[i].first, p[i].second,0 });
            visit[p[i].first][p[i].second] = true;
        }

        while (!q.empty()) {
            auto outdata = q.front();
            q.pop();
            
            if(arr[outdata.x][outdata.y]==0)
                ma = max(ma,outdata.cnt);
            temp--;

            for (int i = 0; i < 4; i++) {
                int nx = outdata.x + X[i];
                int ny = outdata.y + Y[i];
                if (nx<0 || ny<0 || nx>n - 1 || ny>n - 1 || arr[nx][ny]==1 || visit[nx][ny]) continue;
                visit[nx][ny] = true;
                q.push({ nx,ny,outdata.cnt + 1 });
            }
        }
        if (temp == 0) {
            ans = min(ans, ma);
        }
        return;
    }
    if (idx == v.size()) return;

    p[cnt] = v[idx];
    solve(idx + 1, cnt + 1);

    solve(idx + 1, cnt);
}
 
int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &n, &m);
    chk = n * n;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            scanf("%d", &arr[i][j]);
            if (arr[i][j] == 1) chk--;
            else if (arr[i][j] == 2) v.push_back({ i,j });
        }
    }

    solve(0, 0);

    printf("%d\n", ans== 9999999?-1:ans);
}