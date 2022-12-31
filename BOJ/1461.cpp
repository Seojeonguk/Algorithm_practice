#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, m, ans, aIdx, bIdx;
int places[52];
vector<int> a, b;

bool cmp(int a, int b) {
    return abs(a) > abs(b);
}

void getSum(vector<int>& v) {
    int idx = 0;
    while (idx < v.size()) {
        ans += abs(v[idx] * 2);
        idx += m;
    }
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &n, &m);

    for (int i = 0; i < n; i++)
        scanf("%d", &places[i]);

    sort(places, places + n, cmp);

    bool first = true;
    for (int i = 0; i < n; i++) {
        if (places[i] < 0) a.push_back(places[i]);
        else b.push_back(places[i]);
    }

    getSum(a);
    getSum(b);

    int firstACost = (a.empty() ? 0 : abs(a[0]));
    int firstBCost = (b.empty() ? 0 : abs(b[0]));

    ans -= max(firstACost, firstBCost);

    printf("%d\n", ans);
} 
