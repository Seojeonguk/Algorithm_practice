#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, m, negotiations_idx, contest_idx;
char negotiations[300002];
char contest_name[300002];

bool isConsonant(char c) {
	if (c == 'A') return false;
	if (c == 'E') return false;
	if (c == 'I') return false;
	if (c == 'O') return false;
	if (c == 'U') return false;
	return true;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %s", &n, &m, negotiations);

	int negotiations_idx = n - 1;
	int contest_idx = 0;

	while (negotiations_idx >= 0) {
		char c = negotiations[negotiations_idx--];
		if (isConsonant(c)) {
			contest_name[contest_idx++] = c;
			break;
		}
	}

	int a_cnt = 0;

	while (negotiations_idx >= 0 && a_cnt < 2) {
		char c = negotiations[negotiations_idx--];
		if (c == 'A') {
			contest_name[contest_idx++] = c;
			a_cnt++;
		}
	}

	while (negotiations_idx >= 0) {
		contest_name[contest_idx++] = negotiations[negotiations_idx--];
	}

	if (contest_idx < m) {
		puts("NO");
		return 0;
	}

	puts("YES");
	for (int i = m - 1; i >= 0; i--)
		printf("%c", contest_name[i]);
}
