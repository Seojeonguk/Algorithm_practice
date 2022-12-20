#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int t;
int sliceArea, slicePrice, wholeRadius, wholePrice;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &t);

    while (t--) {
        scanf("%d %d %d %d", &sliceArea, &slicePrice, &wholeRadius, &wholePrice);
        double slicePerDollar = 1.0f * sliceArea / slicePrice;
        double wholePerDollar = 1.0f * 3.14159 * wholeRadius * wholeRadius / wholePrice;

        puts(slicePerDollar > wholePerDollar ? "Slice of pizza" : "Whole pizza");
    }
}