#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, x;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	while (1) {
		scanf("%d", &n);
		if(!n)break;
		int mary = 0, john = 0;
		
		for (int i = 0; i < n; i++) {
			scanf("%d", &x);
			if (x) john++;
			else mary++;
		}

		printf("Mary won %d times and John won %d times\n",mary,john);
	}
}