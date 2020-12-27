#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);
	if (n == 2006) puts("PetrSU, ITMO");
	else if (n == 1996 || n == 1997 || n == 2000 || n == 2007 || n == 2008 || n == 2013 || n == 2018) puts("SPbSU");
	else puts("ITMO");
}