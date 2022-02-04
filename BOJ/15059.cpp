#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int meals[3],ans,ch;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	for (int i = 0; i < 3; i++) scanf("%d", &meals[i]);
	for (int i = 0; i < 3; i++) {
		scanf("%d", &ch);
		ans += ch - meals[i] < 0 ? 0 : ch - meals[i];
	}
	printf("%d\n", ans);
}