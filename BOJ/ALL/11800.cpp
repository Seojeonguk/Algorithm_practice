#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int t, a, b;
string str[] = { "","Yakk","Doh","Seh","Ghar","Bang","Sheesh" };
string sstr[] = { "","Habb Yakk","Dobara","Dousa","Dorgy","Dabash","Dosh" };
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	for (int i = 1; i <= t; i++) {
		scanf("%d %d", &a, &b);
		if (a < b) swap(a, b);
		printf("Case %d: ", i);
		if (a == b) cout << sstr[a] << "\n";
		else {
			if (a == 6 && b == 5) puts("Sheesh Beesh");
			else cout << str[a] << " " << str[b] << "\n";
		}
	}
}