#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
long long int a, b;
vector<long long int> v;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%lld %lld", &a, &b);
	if (a > b) swap(a, b);

	for (long long int i = a + 1; i < b; i++)
		v.push_back(i);

	printf("%d\n", v.size());
	for (long long int i : v)
		printf("%lld ", i);
}