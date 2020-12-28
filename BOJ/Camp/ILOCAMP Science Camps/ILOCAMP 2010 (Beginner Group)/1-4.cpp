#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int a, b;
pair<int, char> p[3];

void print(int x) {
	if (x < 0) printf("(%d)", x);
	else printf("%d", x);
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &a, &b);

	p[0].first = a + b;
	p[0].second = '+';

	p[1].first = a - b;
	p[1].second = '-';
	
	p[2].first = a * b;
	p[2].second = '*';

	sort(p, p + 3);

	if (p[1].first == p[2].first) puts("NIE");
	else {
		print(a);
		printf("%c", p[2].second);
		print(b);
		printf("=");
		print(p[2].first);
	}


}