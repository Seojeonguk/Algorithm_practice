#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int mapSize, startIdx;
int pastuers[101][101];
bool isVisit[100001];
vector<int> v[101];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &mapSize, &startIdx);

    for (int row = 1; row <= mapSize; row++) {
        for (int col = 1; col <= mapSize; col++) {
            scanf("%d", &pastuers[row][col]);
            if (pastuers[row][col]) {
                v[row].push_back(col);
            }
        }
    }
    queue<int> q;
    q.push(startIdx);
    isVisit[startIdx] = true;
    
    while (!q.empty()) {
        int qSize = q.size();
        priority_queue<int, vector<int>, greater<int> > timeQ;
        for (int i = 0; i < qSize; i++) {
            int now = q.front();
            q.pop();

            timeQ.push(now);

            for (int idx = 0; idx < v[now].size(); idx++) {
                int next = v[now][idx];
                if (isVisit[next]) {
                    continue;
                }
                isVisit[next] = true;
                q.push(next);
            }
        }
        while (!timeQ.empty()) {
            printf("%d ", timeQ.top());
            timeQ.pop();
        }
        puts("");
    }
}