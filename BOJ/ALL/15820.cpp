#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int s1, s2,ans,ex;
bool s1c, s2c;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &s1, &s2);

	while (s1--) {
		scanf("%d %d", &ans, &ex);
		if (ans != ex) s1c = true;
	}

	while (s2--) {
		scanf("%d %d", &ans, &ex);
		if (ans != ex) s2c = true;
	}
	if (s1c) puts("Wrong Answer");
	else if (s2c) puts("Why Wrong!!!");
	else puts("Accepted");
}