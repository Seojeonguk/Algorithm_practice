#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n,q,w,e,r;
char rt[102];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %s", &n,rt);

	for (int i = 0; i < n; i++) {
		if (isupper(rt[i])) q=1;
		else if (islower(rt[i]))w=1;
		else if (isdigit(rt[i])) e=1;
		else r=1;
	}

	printf("%d\n", max(6 - n, 4 - q - w - e - r));
}