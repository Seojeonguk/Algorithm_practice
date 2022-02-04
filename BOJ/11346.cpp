#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int t, n, m;
string name;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);
	while (t--) {
		map<string,int> s;
		scanf(" %d %d ", &n, &m);

		for (int i = 0; i < n; i++) {
			cin >> name;
			s[name] = 1;
		}

		for (int i = 0; i < m; i++) {
			cin >> name;
			s[name] = 1;
		}

		printf("%d\n", s.size());
	}
}