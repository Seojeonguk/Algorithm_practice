#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, arr[100002], ans;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &n);

    for (int i = 0; i < n; i++)
        scanf("%d", &arr[i]);

    int leftSum = 0, rightSum = 0;
    int leftMax = -99999999, rightMax = -99999999;
    int tmp = 0, ans = -999999999;

    for (int i = 0; i < n; i++) {
        int left = (arr[i] == 1 ? 1 : -1);
        int right = (arr[i] == 2 ? 1 : -1);

        leftSum += left;
        rightSum += right;

        ans = max(ans, leftSum);
        ans = max(ans, rightSum);

        if (leftSum < 0) leftSum = 0;
        if (rightSum < 0) rightSum = 0;
    }
    printf("%d\n", ans);
}
