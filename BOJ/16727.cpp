#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int p1, s1, p2, s2;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d %d", &p1, &s1, &s2, &p2);
	if (p1 + p2 < s1 + s2) puts("Esteghlal");
	else if (p1 + p2 > s1 + s2) puts("Persepolis");
	else {
		if (s1 < p2) puts("Persepolis");
		else if (s1 > p2) puts("Esteghlal");
		else puts("Penalty");
	}
}