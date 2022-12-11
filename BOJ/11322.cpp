#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

set<unsigned long long> s;
queue<unsigned long long> q;
deque<unsigned long long> dq;
int t, n;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    q.push(1);
    s.insert(1);
    while (!q.empty()) {
        unsigned long long now = q.front();
        q.pop();

        dq.push_back(now);

        unsigned long long next = now * 10L;
        if (next > INT64_MAX) {
            continue;
        }
        q.push(next);
        next += 1L;
        q.push(next);
    }
    sort(dq.begin(), dq.end());

    scanf("%d", &t);

    for (int testCase = 0; testCase < t; testCase++) {
        scanf("%d", &n);
        for (unsigned long long value : dq) {
            if (value % n == 0) {
                printf("%llu\n", value);
                break;
            }
        }
    }
}