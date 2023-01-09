#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, st, rocks[100001];
bool isVisit[100001];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &n);

    for (int i = 1; i <= n; i++)
        scanf("%d", &rocks[i]);

    scanf("%d", &st);

    int ans = 1;
    isVisit[st] = true;
    queue<int> q;
    q.push(st);

    while (!q.empty()) {
        int now = q.front();
        q.pop();

        int left = now - rocks[now];
        int right = now + rocks[now];

        if (left > 0 && !isVisit[left]) {
            isVisit[left] = true;
            q.push(left);
            ans++;
        }
        if (right <= n && !isVisit[right]) {
            isVisit[right] = true;
            q.push(right);
            ans++;
        }
    }
    printf("%d\n", ans);
}
