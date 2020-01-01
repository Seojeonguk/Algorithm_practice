#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int t, tri[3];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);
	for (int i = 1; i <= t; i++) {
		scanf("%d %d %d", &tri[0], &tri[1], &tri[2]);
		sort(tri, tri + 3);
		printf("Case #%d: ",i);
		if (tri[0] + tri[1] <= tri[2]) puts("invalid!");
		else if (tri[0] == tri[1] && tri[1] == tri[2]) puts("equilateral");
		else if (tri[0] == tri[1] || tri[1] == tri[2]) puts("isosceles");
		else puts("scalene");
	}
}