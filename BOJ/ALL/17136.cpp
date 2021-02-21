#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, m, d, ans;
int arr[16][16], cparr[16][16];
bool visit[16][16];
struct da { int x, y, cnt; };
int X[] = { 0,-1,0 }, Y[] = { -1,0,1 };
pair<int, int> p[3];

void print() {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++)
            printf("%d ", arr[i][j]);
        puts("");
    }
}

void solve() {
    int cnt = 0;
    int t = n;
    
    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
            cparr[i][j] = arr[i][j];

    while (t--) {
        vector<pair<int, int> > v;
        for (int a = 0; a < 3; a++) {
            
            memset(visit, 0, sizeof visit);
            int delete_x = 9999, delete_y = 9999, delete_cnt = 9999;

            queue<da> q;
            q.push({ p[a].first,p[a].second,0 });

            while (!q.empty()) {
                auto outdata = q.front();
                q.pop();

                if (delete_cnt < outdata.cnt) continue;
                if (cparr[outdata.x][outdata.y] == 1) {
                    delete_cnt = outdata.cnt;
                    if (outdata.y < delete_y) {
                        delete_x = outdata.x;
                        delete_y = outdata.y;
                    }
                }
                for (int i = 0; i < 3; i++) {
                    int nx = outdata.x + X[i];
                    int ny = outdata.y + Y[i];
                    if (nx<0 || ny<0 || nx>n - 1 || ny>m - 1 || visit[nx][ny] || outdata.cnt == d) continue;
                    visit[nx][ny] = true;
                    q.push({ nx,ny,outdata.cnt + 1 });
                }
            }
            if(delete_cnt!=9999)v.push_back({ delete_x,delete_y });
        }
        for (auto item : v) {
            if (cparr[item.first][item.second] == 1) {
                cparr[item.first][item.second] = 0;
                cnt++;
            }

        }
        for (int i = 0; i < m; i++)
            cparr[n - 1][i] = 0;
        for (int i = 0; i < m; i++)
            for (int j = n - 1; j >= 1; j--)
                cparr[j][i] = cparr[j - 1][i];
        for (int i = 0; i < m; i++)
            cparr[0][i] = 0;
    }
    ans = max(ans, cnt);
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d %d", &n, &m, &d);

    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
            scanf("%d", &arr[i][j]);

    for (int i = 0; i < m; i++)
        for (int j = i + 1; j < m; j++)
            for (int k = j + 1; k < m; k++) {
                p[0].first = p[1].first = p[2].first = n;
                p[0].second = i;
                p[1].second = j;
                p[2].second = k;
                solve();
            }

    printf("%d\n", ans);
}