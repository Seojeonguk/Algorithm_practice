#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

const int MAX = 1e5;

int n, num, p[MAX + 1], temp;
char c;
bool zero, chk;

void gophagi(int x) {
	temp = (int)sqrt(x);
	for (int i = 2; i <= temp; i++)
		while (!(x % i)) x /= i, p[i]++;
	if (x > 1) p[x]++;
}

void nanugi(int x) {
	temp = (int)sqrt(x);
	for (int i = 2; i <= temp; i++)
		while (!(x % i)) x /= i, p[i]--;
	if (x > 1) p[x]--;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	cin >> n;
	for (int i = 0; i < n; i++) {
		if (!i) {
			cin >> num;
			num = abs(num);
			
			if (num) gophagi(num);
			else {
				zero = 1;
				break;
			}
		}
		else {
			cin >> c >> num;
			num = abs(num);
			if (!num) {
				zero = 1;
				break;
			}

			if (c == '/') nanugi(num);
			else gophagi(num);
		}
	}
	if (zero) {
		puts("mint chocolate");
		return 0;
	}

	for (int i = 2; i <= MAX; i++)
		if (p[i] < 0) {
			chk = 1;
			break;
		}
	if (chk) puts("toothpaste");
	else puts("mint chocolate");
}