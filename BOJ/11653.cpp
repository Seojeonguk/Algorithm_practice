#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n;
bool chk[10000001];
vector<int> v;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);

	for (int i = 2; i <= n; i++) {
		if (!chk[i]) {
			for (int j = i; j <= n; j++) {
				chk[j] = true;
				v.push_back(j);
			}
		}
	}

	int size = v.size();
	for (int i = 0; n != 1;) {
		if (n%v[i])
			i++;
		else {
			n /= v[i];
			printf("%d\n", v[i]);
		}
	}
}

