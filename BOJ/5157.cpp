#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int t, n, companyCnt, bailedCompanyCnt, executiveCnt, taxation;
int companyNum, payment;
int payments[502];
vector<int> bailedCompanies;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &t);

    for (int tc = 1; tc <= t; tc++) {
        memset(payments, 0, sizeof payments);
        scanf("%d %d %d %d", &companyCnt, &bailedCompanyCnt, &executiveCnt, &taxation);
        bailedCompanies.resize(bailedCompanyCnt);

        for (int i = 0; i < bailedCompanyCnt; i++)
            scanf("%d", &bailedCompanies[i]);

        while (executiveCnt--) {
            scanf("%d %d", &companyNum, &payment);
            payments[companyNum] += payment * taxation / 100;
        }

        int ans = 0;
        for (int i = 0; i < bailedCompanyCnt; i++) {
            ans += payments[bailedCompanies[i]];
        }
        printf("Data Set %d:\n", tc);
        printf("%d\n\n", ans);
    }
}
