#include<cstdio>
#include<queue>
using namespace std;

int t, n, k, arr[11];

int main() {
    scanf("%d", &t);

    for (int tc = 1; tc <= t; tc++) {
        scanf("%d", &n);

        for (int i = 0; i < n; i++)
            scanf("%d", &arr[i]);

        scanf("%d", &k);

        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        pq.push({ 0,k });

        while (pq.top().second) {
            pair<int, int> now = pq.top();
            pq.pop();

            pq.push({ now.first + now.second,0 });

            for (int i = 0; i < n; i++) {
                pq.push({ now.first + (now.second % arr[i]), now.second / arr[i] });
            }
        }

        printf("#%d %d\n", tc, pq.top().first);
    }
}