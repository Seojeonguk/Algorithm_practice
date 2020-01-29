#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, m;
vector<char> v;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);

	while (n / m) {
		v.push_back(n%m >= 10 ? n % m + 'A' - 10 : n % m + '0');
		n /= m;
	}
	v.push_back(n%m >= 10 ? n % m + 'A' - 10 : n % m + '0');

	for (int i = v.size()-1; i >=0; i--)
		printf("%c", v[i]);
}