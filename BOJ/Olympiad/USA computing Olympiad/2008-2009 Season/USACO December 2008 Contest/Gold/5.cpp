#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n,si,di,ci;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);

	bool chk = false;
	for (int i = 0; i < n - 1; i++) {
		scanf("%d %d %d", &si, &di, &ci);
		if (ci) chk = !chk;
	}
	
	printf("%d\n", chk);
}