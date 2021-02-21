#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int ans;
int n = 12, m = 6;
char arr[12][6];
bool visit[12][6];
int X[] = { 1,0,-1,0 }, Y[] = { 0,1,0,-1 };

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    for (int i = 0; i < n; i++)
        scanf(" %s", arr[i]);

    while (1) {
        bool destroy = false;
        memset(visit, 0, sizeof visit);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != '.' && !visit[i][j]) {
                    queue<pair<int, int> > q;
                    vector<pair<int, int> > v;

                    q.push({ i,j });
                    visit[i][j] = true;

                    while (!q.empty()) {
                        auto outdata = q.front();
                        q.pop();

                        v.push_back({ outdata.first,outdata.second });

                        for (int k = 0; k < 4; k++) {
                            int x = outdata.first + X[k];
                            int y = outdata.second + Y[k];
                            if (x<0 || y<0 || x>n - 1 || y>m - 1 || arr[i][j] != arr[x][y] || visit[x][y]) continue;
                            visit[x][y] = true;
                            q.push({ x,y });
                        }
                    }

                    int size = v.size();
                    if (size >= 4) {
                        destroy = true;
                        for (int k = 0; k < size; k++)
                            arr[v[k].first][v[k].second] = '.';
                    }
                }
            }
        }

        
        for (int i = 0; i < 6; i++) {
            int now = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (arr[j][i] != '.') {
                    swap(arr[now--][i], arr[j][i]);
                }
            }
        }

        if (!destroy) break;
        ans++;
    }
    printf("%d\n", ans);
}