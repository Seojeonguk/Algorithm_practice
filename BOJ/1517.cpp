#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, m, q1, q2, q3;
ll ans;
vector<pair<int,int> > v;
bool operator < (const pair<int, int>& a, const pair<int, int>& b) {
    if (a.first == b.first) 
        return a.second < b.second;
    return a.first < b.first;
}
struct Tree {
    vector<ll> tree;
    Tree(int n) {
        tree.resize(n);
    }

    ll query(int left, int right, int leftNode, int rightNode, int node) {
        if (left > rightNode || right < leftNode) return 0;
        if (left <= leftNode && rightNode <= right) return tree[node];
        
        ll leftIdx = query(left, right, leftNode, (leftNode + rightNode) / 2, node * 2);
        ll rightIdx = query(left, right, (leftNode + rightNode) / 2 + 1, rightNode, node * 2 + 1);

        return leftIdx+rightIdx;
    }

    ll update(int pos, int value,int leftNode, int rightNode, int node) {
        if (pos < leftNode || rightNode < pos) return tree[node];
        if (leftNode == rightNode) return tree[node] = value;
        int middle = (leftNode + rightNode) / 2;
        ll leftIdx = update(pos, value, leftNode, middle, node * 2);
        ll rightIdx = update(pos, value, middle + 1, rightNode, node * 2 + 1);
        return tree[node] = leftIdx + rightIdx;
    }
};

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &n);
    int length = (int)ceil(log2(n));
    Tree t((1 << (length + 1)));
    v.resize(n);

    for (int i = 0; i < n; i++) {
        scanf("%d", &v[i].first);
        v[i].second = i;
    }

    sort(v.begin(), v.end());

    for (int i = 0; i < n; i++) {
        ans += t.query(v[i].second, n - 1, 0, n - 1, 1);
        t.update(v[i].second,1,0,n-1,1);
    }
    
    printf("%lld\n", ans);
}