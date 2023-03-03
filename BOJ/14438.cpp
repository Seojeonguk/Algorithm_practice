#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, m, q, a, b;
int arr[100002];

struct SEG {
    vector<int> v;
    void init(int h) {
        v.resize(h);
    }

    int init(int left,int right, int node) {
        if (left == right) return v[node] = arr[left];
        int mid = (left + right) / 2;
        return v[node] = min(init(left, mid, node * 2), init(mid + 1, right, node * 2 + 1));
    }

    int update(int pos,int value, int node_left, int node_right, int node) {
        if (pos < node_left || node_right < pos) return v[node];
        if (node_left == node_right) return v[node] = value;
        int mid = (node_left + node_right) / 2;
        return v[node] = min(update(pos, value, node_left, mid, node * 2), update(pos, value, mid + 1, node_right, node * 2 + 1));
    }

    int query(int left, int right, int node_left, int node_right, int node) {
        if (node_right < left || node_left > right) return 1e10;
        if (left <= node_left && node_right <= right) return v[node];
        int mid = (node_left + node_right) / 2;
        return min(query(left, right, node_left, mid, node * 2), query(left, right, mid + 1, node_right, node * 2 + 1));
    }
};

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    SEG seg;
    scanf("%d", &n);
    for (int i = 0; i < n; i++)
        scanf("%d", &arr[i]);

    int h = (1 << ((int)log2(n) + 2));
    seg.init(h);
    seg.init(0, n - 1, 1);

    scanf("%d", &m);
    while (m--) {
        scanf("%d %d %d", &q, &a, &b);
        if (q == 1) seg.update(a - 1, b, 0, n - 1, 1);
        else printf("%d\n", seg.query(a - 1, b - 1, 0, n - 1, 1));
    }
}
