#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
double h, w;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%lf %lf", &h, &w);

	printf("%lf\n", max(max(min(h, w / 3), min(h / 3, w)),min(h / 2, w / 2)));
}