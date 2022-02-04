#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
double x;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	while (1) {
		scanf("%lf", &x);
		if (x < 0) break;
		printf("Objects weighing %.2lf on Earth will weigh %.2lf on the moon.\n", x, x*0.167);
	}
}