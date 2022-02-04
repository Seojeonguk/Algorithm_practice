#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int t, n;
pair<int, int> p[102];
bool visit[102][102];

int dis(pair<int, int> a, pair<int, int> b) {
    return abs(a.first - b.first) + abs(a.second - b.second);
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &t);
    while (t--) {
        memset(visit, false, sizeof visit);
        scanf("%d", &n);

        n += 2;

        for (int i = 0; i < n; i++)
            scanf("%d %d", &p[i].first, &p[i].second);

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (dis(p[i], p[j]) <= 1000)
                    visit[i][j] = true;

        for(int k=0;k<n;k++)
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    if (visit[i][k] && visit[k][j]) {
                        visit[i][j] = true;
                    }

        if (visit[0][n - 1]) puts("happy");
        else puts("sad");
    }
}