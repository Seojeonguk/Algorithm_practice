#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int testcaseCnt;
pair<long long, long long> telecomparistech, eurecom;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &testcaseCnt);
    for (int testcase = 0; testcase < testcaseCnt; testcase++) {
        scanf("%lld %lld", &telecomparistech.first, &telecomparistech.second);
        scanf("%lld %lld", &eurecom.first, &eurecom.second);

        long long telecomparistechArea = telecomparistech.first * telecomparistech.second;
        long long eurecomArea = eurecom.first * eurecom.second;

        if (telecomparistechArea < eurecomArea) {
            puts("Eurecom");
        }
        else if (telecomparistechArea > eurecomArea) {
            puts("TelecomParisTech");
        }
        else {
            puts("Tie");
        }
    }
}