#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int t, a, b;
int D, S, L, R;
int idx[10002];
char DSLR[10002];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);
	while (t--) {
		memset(idx, -1, sizeof idx);
		memset(DSLR, 0, sizeof DSLR);
		scanf("%d %d", &a, &b);

		stack<char> s;
		queue<int> q;
		q.push(a);
		idx[a] = -9999;

		while (!q.empty()) {
			int outdata = q.front();
			q.pop();
			if (outdata == b) {
				while (idx[outdata] != -9999) {
					s.push(DSLR[outdata]);
					outdata = idx[outdata];
				}
				while (!s.empty()) {
					printf("%c", s.top());
					s.pop();
				}
				break;
			}

			D = (outdata * 2) % 10000;
			if (idx[D] == -1) {
				idx[D] = outdata;
				DSLR[D] = 'D';
				q.push(D);
			}

			S = (10000 + outdata - 1) % 10000;
			if (idx[S] == -1) {
				idx[S] = outdata;
				DSLR[S] = 'S';
				q.push(S);
			}

			L = (outdata % 1000) * 10 + (outdata / 1000);
			if (idx[L] == -1) {
				idx[L] = outdata;
				DSLR[L] = 'L';
				q.push(L);
			}

			R = (outdata / 10) + (outdata % 10) * 1000;
			if (idx[R] == -1) {
				idx[R] = outdata;
				DSLR[R] = 'R';
				q.push(R);
			}

		}
		puts("");
	}
}