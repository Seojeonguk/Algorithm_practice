#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, h, l, a, b;
int horrorList[1002];
int hi[1002];
vector<int> v[1002];
queue<int> q;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    memset(hi, 0x3f, sizeof hi);
    scanf("%d %d %d", &n, &h, &l);

    for (int i = 0; i < h; i++) {
        scanf("%d", &horrorList[i]);
        hi[horrorList[i]] = 0;
        q.push(horrorList[i]);
    }

    for (int i = 0; i < l; i++) {
        scanf("%d %d", &a, &b);
        v[a].push_back(b);
        v[b].push_back(a);
    }

    while (!q.empty()) {
        int now = q.front();
        q.pop();

        for (int i = 0; i < v[now].size(); i++) {
            int next = v[now][i];
            if (hi[next] != 0x3f3f3f3f) continue;
            hi[next] = hi[now] + 1;
            q.push(next);
        }
    }

    int bestMovieIndex = 0;
    for (int i = 0; i < n; i++) 
        if (hi[bestMovieIndex] < hi[i]) 
            bestMovieIndex = i;

    printf("%d\n", bestMovieIndex);
}