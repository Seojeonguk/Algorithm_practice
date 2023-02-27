#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, m;
bool isTrue[26][26];
bool isVisit[26];
char a, b;

bool solve() {
	memset(isVisit, false, sizeof isVisit);
	queue<int> q;
	q.push(a);
	isVisit[a] = true;

	while (!q.empty()) {
		int now = q.front();
		q.pop();

		if (now == b)
			return true;

		for (int i = 0; i < 26; i++) {
			if (!isTrue[now][i] || isVisit[i])
				continue;

			isVisit[i] = true;
			q.push(i);
		}
	}

	return false;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);

	while (n--) {
		scanf(" %c is %c", &a, &b);
		a -= 'a';
		b -= 'a';
		isTrue[a][b] = true;
	}
	scanf("%d", &m);

	while (m--) {
		scanf(" %c is %c", &a, &b);
		a -= 'a';
		b -= 'a';
		puts(solve() ? "T" : "F");
	}
}
