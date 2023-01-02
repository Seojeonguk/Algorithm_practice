#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n,ans, arr[8];
vector<pair<int, int> > v;
bool visit[3601];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &n);

    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
        v.push_back({ i,arr[i] });
    }

    do {
        memset(visit, false, sizeof visit);
        int total = 0, cnt = 0;
        for (int i = 0; i < n; i++) {
            total += v[i].second*36;
            if (visit[(total + 1800)%3600]) {
                cnt++;
            }
            visit[total] = true;
        }
        ans = max(ans, cnt);
    } while (next_permutation(v.begin(),v.end()));

    printf("%d\n", ans);
}
