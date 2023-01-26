#include<cstdio>
#include<queue>
using namespace std;

int t, n, seq, x;

int main() {
    scanf("%d", &t);

    for (int tc = 1; tc <= t; tc++) {
        priority_queue<int> pq;
        scanf("%d", &n);

        printf("#%d ", tc);
        for (int i = 0; i < n; i++) {
            scanf("%d", &seq);

            
            if (seq == 1) {
                scanf("%d", &x);
                pq.push(x);
            }
            else {
                int ans = -1;
                if (!pq.empty()) {
                    ans = pq.top();
                    pq.pop();
                }
                printf("%d ", ans);
            }
        }
        puts("");
    }
}