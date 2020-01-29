#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int t;
long long int k;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	while(t--) {
		scanf("%lld", &k);
		k--;

		vector<char> v;
		int cnt = 0;
		while (k % 26 != 0) {
			k--;
			cnt++;
		}
		v.push_back(cnt + 'A');
		while (k / 26) {
			k /= 26;
			k--;
			v.push_back(k%26 + 'A');
		}

		int s = v.size()-1;

		for (int i = s; i >= 0; i--) printf("%c", v[i]);
		puts("");
	}
}