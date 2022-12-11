#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int nodeCnt, lineCnt, startNode;
int aNode, bNode, cnt;
vector<int> v[100002];
int visitOrder[100002];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d %d", &nodeCnt, &lineCnt, &startNode);

    for (int idx = 0; idx < lineCnt; idx++) {
        scanf("%d %d", &aNode, &bNode);
        v[aNode].push_back(bNode);
        v[bNode].push_back(aNode);
    }

    for (int idx = 1; idx <= nodeCnt; idx++) {
        sort(v[idx].begin(), v[idx].end());
    }

    queue<int> q;
    q.push(startNode);
    visitOrder[startNode] = ++cnt;
    while (!q.empty()) {
        int now = q.front();
        q.pop();

        for (int next : v[now]) {
            if (visitOrder[next]) {
                continue;
            }
            visitOrder[next] = ++cnt;
            q.push(next);
        }
    }

    for (int idx = 1; idx <= nodeCnt; idx++) {
        printf("%d\n", visitOrder[idx]);
    }
}