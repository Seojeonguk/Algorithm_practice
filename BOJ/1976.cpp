#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, m, x,p[202], plan[1002];

int find(int x) {
    if (x == p[x]) return p[x];
    return p[x] = find(p[x]);
}

void merge(int x, int y) {
    x = find(x);
    y = find(y);
    if (x == y) return;
    p[x] = y;
}

bool solve() {
    for(int i=0;i<m;i++)
        if(find(plan[0]) != find(plan[i]))
            return false;
    return true;
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &n, &m);

    for (int i = 1; i <= n; i++)
        p[i] = i;

    for(int i=1;i<=n;i++)
        for (int j = 1; j <= n; j++) {
            scanf("%d", &x);
            if (x == 1) 
                merge(i, j);
        }

    for (int i = 0; i < m; i++)
        scanf("%d", &plan[i]);

    if (solve()) puts("YES");
    else puts("NO");
}