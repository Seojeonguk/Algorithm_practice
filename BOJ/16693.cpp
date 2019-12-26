#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int a1, p1, r1, p2;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d %d", &a1, &p1, &r1, &p2);
	double A = (double)a1 / p1;
	double B = (double)r1*r1*3.14 / p2;
	if (A > B) puts("Slice of pizza");
	else puts("Whole pizza");
}