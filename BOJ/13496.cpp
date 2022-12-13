#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int tc;
int shipCnt, shipSpeed, date;
int shipDistance, shipWeight;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &tc);

    for (int testCase = 0; testCase < tc; testCase++) {
        scanf("%d %d %d", &shipCnt, &shipSpeed, &date);
        int maximumDistance = shipSpeed * date;

        int sum = 0;
        for (int ship = 0; ship < shipCnt; ship++) {
            scanf("%d %d", &shipDistance, &shipWeight);
            if (shipDistance <= maximumDistance) {
                sum += shipWeight;
            }
        }
        printf("Data Set %d:\n%d\n\n", testCase + 1, sum);
    }
}