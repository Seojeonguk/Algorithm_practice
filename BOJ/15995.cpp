#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int a, m;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &a, &m);

	int cnt = 1;
	while (1) {
		if ((cnt * a) % m == 1) {
			printf("%d\n", cnt);
			break;
		}
		cnt++;
	}
}