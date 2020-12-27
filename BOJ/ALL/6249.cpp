#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, p, h, inp;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d", &n, &p, &h);

	for (int i = 0; i < n; i++) {
		scanf("%d", &inp);
		if (p > inp) printf("NTV: Dollar dropped by %d Oshloobs\n", p - inp);
		else if (p < inp) {
			if (inp > h) {
				printf("BBTV: Dollar reached %d Oshloobs, A record!\n", inp);
				h = inp;
			}
		}

		p = inp;
	}
}