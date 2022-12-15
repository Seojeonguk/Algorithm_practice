#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, idx;
deque<pair<int, int> > dq;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &n);
    dq.resize(n);
    for (int i = 0; i < n; i++) {
        scanf("%d", &dq[i].first);
        dq[i].second = i + 1;
    }

    while (!dq.empty()) {
        printf("%d ", dq[0].second);

        int value = dq[0].first;
        if (value > 0)
            value--;

        dq.pop_front();
        if (dq.empty())
            break;
        if (value > 0) {
            while (value--) {
                dq.push_back(dq[0]);
                dq.pop_front();
            }
        }
        else {
            while (value++) {
                dq.push_front(dq.back());
                dq.pop_back();
            }
        }
    }
}