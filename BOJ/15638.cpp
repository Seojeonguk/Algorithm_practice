#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
bool era[100002];
int n;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif

	for (int i = 2; i <= 100000; i++) {
		if (era[i]) continue;
		for (int j = i * 2; j <= 100000; j += i) era[j] = true;
	}

	scanf("%d", &n);

	printf("%s", !era[n] ? "Yes" : "No");
}