#include<cstdio>
#include<cstring>
using namespace std;
typedef long long ll;

int t, n, isAppearCnt, cnt;
bool isAppear[10];

int main() {
    scanf("%d", &t);

    for (int tc = 1; tc <= t; tc++) {
        cnt = isAppearCnt = 0;
        memset(isAppear, false, sizeof isAppear);
        scanf("%d", &n);

        
        while (isAppearCnt != 10) {
            int nTemp = n * (++cnt);

            while (nTemp) {
                int lastValue = nTemp % 10;
                if (!isAppear[lastValue]) {
                    isAppear[lastValue] = true;
                    isAppearCnt++;
                }
                nTemp /= 10;
            }
        }

        printf("#%d %d\n", tc, n * cnt);
    }
}