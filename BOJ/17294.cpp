#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
long long int k;
int tmp[20], idx;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%lld", &k);
	for (idx = 0; k; idx++) {
		tmp[idx] = k % 10;
		k /= 10;
	}
	int d = tmp[1] - tmp[0];

	for(int i=0;i<idx-1;i++)
		if (tmp[i + 1] - tmp[i] != d) {
			puts("흥칫뿡!! <(￣ ﹌ ￣)>");
			return 0;
		}

	puts("◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!");
}