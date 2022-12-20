#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

double height, weight;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%lf %lf", &weight, &height);

    double bmi = weight / (height * height);
    if (bmi >= 25.0) {
        puts("Overweight");
    }
    else if (bmi >= 18.5) {
        puts("Normal weight");
    }
    else {
        puts("Underweight");
    }
}