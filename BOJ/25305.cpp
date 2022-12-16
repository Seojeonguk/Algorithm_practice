#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int studentCnt, k;
int students[1002];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &studentCnt, &k);
    for (int idx = 0; idx < studentCnt; idx++)
        scanf("%d", &students[idx]);

    sort(students, students + studentCnt, greater<>());

    printf("%d\n", students[k - 1]);
}