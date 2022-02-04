#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

double p_ad, p_bc, p_cd, p_da;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%lf %lf %lf", &p_ad, &p_bc, &p_cd);
	p_da = p_ad * p_cd / p_bc;
	printf("%lf\n", p_da);
}