#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int todayYear, futureYear;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &todayYear, &futureYear);

    for (int year = todayYear; year <= futureYear; year += 60) {
        printf("All positions change in year %d\n", year);
    }
}