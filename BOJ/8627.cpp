#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, p;
ll s, rocks[1001][2];
bool isVisit[1001];
double ans;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d %lld", &n, &p, &s);
    for (int i = 1; i <= n; i++)
        scanf("%lld %lld", &rocks[i][0], &rocks[i][1]);
    
    queue<int> q;
    isVisit[p] = true;
    q.push(p);
    while (!q.empty()) {
        int now = q.front();
        q.pop();

        double distance = sqrt((rocks[now][0] - rocks[p][0]) * (rocks[now][0] - rocks[p][0]) + (rocks[now][1] - rocks[p][1]) * (rocks[now][1] - rocks[p][1])) + s;
        ans = max(ans, distance);

        for (int i = 1; i <= n; i++) {
            if (isVisit[i]) continue;

            ll distance = ((rocks[now][0] - rocks[i][0]) * (rocks[now][0] - rocks[i][0]) + (rocks[now][1] - rocks[i][1]) * (rocks[now][1] - rocks[i][1]));
            if (distance > s * s) continue;
            isVisit[i] = true;
            q.push(i);

        }
    }

    printf("%.6lf", ans);
}
