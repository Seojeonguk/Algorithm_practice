#include<iostream>
#include<cstring>
#include<cmath>
using namespace std;

int t;
int v, e, a, b, p, c;
int tree[10001][2];
int depths[10001];
int d[10001][21];

void makeTree(int here, int parent) {
    depths[here] = depths[parent] + 1;
    d[here][0] = parent;
    if (tree[here][0] != -1) makeTree(tree[here][0], here);
    if (tree[here][1] != -1) makeTree(tree[here][1], here);
}

int calSize(int idx) {
    int cnt = 1;
    if (tree[idx][0] != -1)
        cnt += calSize(tree[idx][0]);

    if (tree[idx][1] != -1)
        cnt += calSize(tree[idx][1]);

    return cnt;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cin >> t;
    for (int tc = 1; tc <= t; tc++) {
        memset(tree, -1, sizeof tree);
        cin >> v >> e >> a >> b;
        
        int h = log2(v);

        for (int i = 0; i < e; i++) {
            cin >> p >> c;
            int idx = (tree[p][0] == -1 ? 0 : 1);
            tree[p][idx] = c;
        }

        makeTree(1, 0);

        for (int j = 1; j < h; j++)
            for (int i = 1; i <= v; i++)
                d[i][j] = d[d[i][j - 1]][j - 1];

        if (depths[a] != depths[b]) {
            if (depths[a] > depths[b]) swap(a, b);
            for (int i = h; i >= 0; i--)
                if (depths[a] <= depths[d[b][i]])
                    b = d[b][i];
        }

        int ans = a;
        if (a != b) {
            for (int i = h; i >= 0; i--) {
                if (d[a][i] != d[b][i]) {
                    a = d[a][i];
                    b = d[b][i];
                }
                ans = d[a][i];
            }
        }

        int size = calSize(ans);

        cout << "#" << tc << " " << ans << " " << size << "\n";
    }
}