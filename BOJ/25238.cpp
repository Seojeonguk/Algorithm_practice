#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

double defensiveRate, disregardRate;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%lf %lf", &defensiveRate, &disregardRate);
    double sensoryDefensiveRate = defensiveRate - (defensiveRate * disregardRate / 100);
    if (sensoryDefensiveRate >= 100.0f) {
        puts("0");
    }
    else {
        puts("1");
    }
}