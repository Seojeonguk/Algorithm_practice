#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int leng[3];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	for (int i = 0; i < 3; i++) scanf("%d", &leng[i]);

	sort(leng, leng + 3);

	if (leng[0] == leng[2]) puts("2");
	else if (leng[0] * leng[0] + leng[1] * leng[1] == leng[2] * leng[2]) puts("1");
	else puts("0");
}