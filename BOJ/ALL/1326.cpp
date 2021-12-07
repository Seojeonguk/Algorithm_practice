#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, a, b;
int steppingstone[10001];
bool visit[10001];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &n);

    for (int i = 1; i <= n; i++)
        scanf("%d", &steppingstone[i]);

    scanf("%d %d", &a, &b);

    queue<pair<int, int> > q;
    q.push({ a,0 });

    while (!q.empty()) {
        auto outdata = q.front();
        q.pop();

        if (outdata.first == b) {
            printf("%d\n", outdata.second);
            return 0;
        }

        int cnt = 0;
        while (1) {
            cnt++;
            bool chk = true;

            int right = outdata.first + steppingstone[outdata.first] * cnt;
            if (right <= n) {
                chk = false;
                if (!visit[right]) {
                    visit[right] = true;
                    q.push({ right,outdata.second + 1 });
                }
            }
            int left = outdata.first - steppingstone[outdata.first] * cnt;
            if (left > 0) {
                chk = false;
                if (!visit[left]) {
                    visit[left] = true;
                    q.push({ left,outdata.second + 1 });
                }
            }

            if (chk) break;
        }
    }
    printf("-1");
}