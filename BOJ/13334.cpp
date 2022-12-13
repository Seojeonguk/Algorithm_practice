#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

ll n, l;
pair<ll, ll> p[100002];
bool compare(pair<ll, ll> a, pair<ll, ll> b) {
    if (a.second == b.second)
        return a.first > b.first;
    return a.second < b.second;
}
struct cmp {
    bool operator()(pair<ll, ll> a, pair<ll, ll> b) {
        return a.first > b.first;
    }
};
int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%lld", &n);

    for (int i = 0; i < n; i++) {
        scanf("%lld %lld", &p[i].first, &p[i].second);
        if (p[i].first > p[i].second) {
            swap(p[i].first, p[i].second);
        }
    }
    scanf("%lld", &l);
    sort(p, p + n, compare);
    priority_queue<pair<ll, ll>,vector<pair<ll,ll> >,cmp > pq;
    int ans = 0;
    for (int i = 0; i < n; i++) {
        if (p[i].second - p[i].first > l) {
            continue;
        }

        while (!pq.empty()) {
            if (pq.top().first >= p[i].second - l) {
                break;
            }
            pq.pop();
        }
        pq.push(p[i]);
        ans = max(ans, (int)pq.size());
    }
    printf("%d\n", ans);
}