#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int tc;
int examinee, strategy, management, technology;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &tc);

    for (int testCase = 0; testCase < tc; testCase++) {
        scanf("%d %d %d %d", &examinee, &strategy, &management, &technology);

        int sum = strategy + management + technology;
        bool isPass = (strategy > 10 && management > 7 && technology >= 12 && sum >= 55);
        

        printf("%d %d %s\n", examinee, sum, isPass ? "PASS" : "FAIL");
    }
}