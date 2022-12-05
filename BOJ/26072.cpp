#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int chickenCnt, seesawlength;


int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &chickenCnt, &seesawlength);

    vector<pair<double, double> > chickens(chickenCnt);

    for (int idx = 0; idx < chickenCnt; idx++) {
        scanf("%lf", &chickens[idx].first);
    }

    for (int idx = 0; idx < chickenCnt; idx++) {
        scanf("%lf", &chickens[idx].second);
    }

    double weightSum = 0.0f;
    double multiSum = 0.0f;
    for (int idx = 0; idx < chickenCnt; idx++) {
        weightSum += chickens[idx].second;
        multiSum += (chickens[idx].first * chickens[idx].second);
    }

    printf("%lf\n", multiSum / weightSum);
}