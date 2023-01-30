#include<cstdio>
#include<queue>
using namespace std;

int MOD = 20171109;
int t, n, mid, a, b;

int main() {
    scanf("%d", &t);

    for (int tc = 1; tc <= t; tc++) {
        priority_queue<int, vector<int>, less<int> > l;
        priority_queue<int, vector<int>, greater<int> > r;

        int ans = 0;

        scanf("%d %d", &n, &mid);

        for (int i = 0; i < n; i++) {
            scanf("%d %d", &a, &b);

            a < mid ? l.push(a) : r.push(a);
            b < mid ? l.push(b) : r.push(b);

            while (l.size() > r.size()) {
                r.push(mid);
                mid = l.top();
                l.pop();
            }

            while (l.size() < r.size()) {
                l.push(mid);
                mid = r.top();
                r.pop();
            }

            ans = (ans + mid) % MOD;
        }

        printf("#%d %d\n", tc, ans);
    }
}