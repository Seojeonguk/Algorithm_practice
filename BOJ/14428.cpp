#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, m, q1, q2, q3;
vector<int> v;
bool operator < (const pair<int, int>& a, const pair<int, int>& b) {
    if (a.first == b.first) 
        return a.second < b.second;
    return a.first < b.first;
}
struct Tree {
    vector<pair<int,int> > tree;
    Tree(int n) {
        tree.resize(n);
    }


    pair<int,int> init(int left, int right, int node) {
        if (left == right) return tree[node] = {v[left],left};
        int middle = (left + right) / 2;
        pair<int,int> leftIdx = init(left, middle, node * 2);
        pair<int,int> rightIdx = init(middle + 1, right, node * 2 + 1);
        return tree[node] = min(leftIdx, rightIdx);
    }

    pair<int,int> query(int left, int right, int leftNode, int rightNode, int node) {
        if (left > rightNode || right < leftNode) return {INT32_MAX,INT32_MAX};
        if (left <= leftNode && rightNode <= right) return tree[node];
        pair<int,int> leftIdx = query(left, right, leftNode, (leftNode + rightNode) / 2, node * 2);
        pair<int,int> rightIdx = query(left, right, (leftNode + rightNode) / 2 + 1, rightNode, node * 2 + 1);

        return min(leftIdx, rightIdx);
    }

    pair<int,int> update(int pos, int value,int leftNode, int rightNode, int node) {
        if (pos < leftNode || rightNode < pos) return tree[node];
        if (leftNode == rightNode) return tree[node] = { value,pos };
        int middle = (leftNode + rightNode) / 2;
        pair<int,int> leftIdx = update(pos, value, leftNode, middle, node * 2);
        pair<int,int> rightIdx = update(pos, value, middle + 1, rightNode, node * 2 + 1);
        return tree[node] = min(leftIdx, rightIdx);
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
        scanf("%d", &v[i]);
    }
    t.init(0, n - 1, 1);

    scanf("%d", &m);
    for (int i = 0; i < m; i++) {
        scanf("%d %d %d", &q1, &q2, &q3);
        if (q1 & 1) t.update(q2 - 1, q3, 0, n - 1, 1);
        else printf("%d\n", t.query(q2 - 1, q3 - 1, 0, n - 1, 1).second+1);
    }
}