#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
long long int n,s;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%lld %lld", &n, &s);

	if (n > 5) puts("Love is open door");
	else {
		s = (s + 1) % 2;
		for (long long int i = 0; i < n-1; i++,s=(s+1)%2)
			printf("%lld\n", s);
	}
}