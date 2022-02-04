#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, sc[102];
double avg,expe;
map<double,double> m;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);
	if (!n) {
		puts("divide by zero");
		return 0;
	}
	for (int i = 0; i < n; i++) {
		scanf("%d", &sc[i]);
		m[sc[i]]++;
		avg += sc[i];
	}
	avg /= n;
	for (auto i : m) expe += i.first*i.second / (double)n;
	printf("%.2lf", avg / expe);
}