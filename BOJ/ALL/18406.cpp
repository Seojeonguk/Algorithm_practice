#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
string n;
int chk;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	cin >> n;
	for (int i = 0; i < n.length(); i++)
		chk += (i < n.length() / 2 ? n[i] - '0' : -(n[i] - '0'));
	puts(chk ? "READY" : "LUCKY");
}