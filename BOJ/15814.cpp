#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
char name[104];
int t, a, b;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf(" %s %d", name, &t);

	for (int i = 0; i < t; i++) {
		scanf("%d %d", &a, &b);
		swap(name[a], name[b]);
	}
	puts(name);
}