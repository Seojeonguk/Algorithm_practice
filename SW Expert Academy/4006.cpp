#include<cstdio>
#include<queue>

using namespace std;
typedef long long ll;

int t, n, m;
vector<pair<int, int> > v[50002];
int a, b, cost;
int par[50002], note[50002];

int find(int x) { return par[x] = (par[x] == x ? par[x] : find(par[x])); }
void setting(int u, int v) {
    int x = find(u);
    int y = find(v);
    if (note[x] > note[y]) swap(x, y);
    par[x] = y;
    if (note[x] == note[y]) note[y]++;
}

int main() {
    scanf("%d", &t);

    for (int tc = 1; tc <= t; tc++) {
        scanf("%d %d", &n, &m);

        for (int i = 1; i <= n; i++) {
            v[i].clear();
            par[i] = i;
            note[i]=0;
        }

        priority_queue<pair<int, pair<int, int> > > pq;
        for (int i = 0; i < m; i++) {
            scanf("%d %d %d", &a, &b, &cost);
            pq.push({ -cost,{a,b} });
        }

        ll ans = 0;
        while (!pq.empty()) {
            pair<int, pair<int, int> > now = pq.top();
            pq.pop();

            int x = now.second.first;
            int y = now.second.second;
            if (find(x) != find(y)) {
                setting(x, y);
                ans += -now.first;
            }
        }
        

        printf("#%d %lld\n", tc, ans);
    }
}