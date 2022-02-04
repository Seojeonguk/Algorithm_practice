#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int k, e, a;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &k);

	for (int i = 1; i <= k; i++) {
		scanf("%d %d", &e, &a);
		
		printf("Data Set %d:\n", i);
		if (e < 5 * a) printf("no ");
		else {
			int cnt = 0;
			int now = 5;
			while (a * now <= e-1) {
				cnt++;
				now *= 5;
			}

			for (int i = 0; i < cnt; i++)
				printf("mega ");
		}
		puts("drought");
		puts("");
	}
}