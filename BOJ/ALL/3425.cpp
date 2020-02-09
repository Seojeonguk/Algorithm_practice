#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
#define MA 1000000000
char arr[100003][5];
int num[100003];
int x, n;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	bool exi = false;
	while (1) {
		int idx = 0, num_idx = 0;
		while (1) {
			scanf("%s", arr[idx++]);
			if (arr[idx - 1][0] == 'E' || arr[idx - 1][0] == 'Q') {
				if (arr[idx - 1][0] == 'Q') exi = true;
				idx--;
				break;
			}
			if (arr[idx - 1][0] == 'N') {
				scanf("%d", &x);
				num[num_idx++] = x;
			}
		}
		if (exi) break;
		for (scanf("%d", &n); n--;) {
			num_idx = 0;
			stack<int> s;
			bool e = false;
			scanf("%d", &x);
			s.push(x);

			for (int i = 0; i < idx; i++) {
				if (arr[i][0] == 'N') s.push(num[num_idx++]);
				else if (arr[i][0] == 'P') {
					if (s.empty()) break;
					s.pop();
				}
				else if (arr[i][0] == 'I') {
					if (s.empty()) break;
					else {
						int tmp = -s.top();
						s.pop();
						s.push(tmp);
					}
				}
				else if (arr[i][0] == 'D') {
					if (arr[i][1] == 'U') {
						if (s.empty()) break;
						s.push(s.top());
					}
					else if (arr[i][1] == 'I') {
						if (s.size() < 2) {
							e = true;
							break;
						}
						int tmp = s.top();
						s.pop();
						int tmp2 = s.top();
						s.pop();
						if (tmp == 0) {
							e = true;
							break;
						}
						s.push(tmp2 / tmp);
					}
				}
				else if (arr[i][0] == 'S') {
					if (arr[i][1] == 'W') {
						if (s.size() < 2) {
							e = true;
							break;
						}
						int tmp = s.top();
						s.pop();
						int tmp2 = s.top();
						s.pop();
						s.push(tmp);
						s.push(tmp2);
					}
					else if (arr[i][1] == 'U') {
						if (s.size() < 2) {
							e = true;
							break;
						}
						int tmp = s.top();
						s.pop();
						int tmp2 = s.top();
						s.pop();
						tmp2 -= tmp;
						if (tmp2 < -MA) {
							e = true;
							break;
						}
						s.push(tmp2);
					}
				}
				else if (arr[i][0] == 'A') {
					if (s.size() < 2) {
						e = true;
						break;
					}
					int tmp = s.top();
					s.pop();
					int tmp2 = s.top();
					s.pop();
					tmp2 += tmp;
					if (tmp2 > MA) {
						e = true;
						break;
					}
					s.push(tmp2);
				}
				else if (arr[i][0] == 'M') {
					if (arr[i][1] == 'U') {
						if (s.size() < 2) {
							e = true;
							break;
						}
						int tmp = s.top();
						s.pop();
						int tmp2 = s.top();
						s.pop();
						long long int chk = 1LL * tmp2 * tmp;
						if (chk > MA) {
							e = true;
							break;
						}
						tmp2 = (int)chk;
						s.push(tmp2);
					}
					else if (arr[i][1] == 'O') {
						if (s.size() < 2) {
							e = true;
							break;
						}
						int tmp = s.top();
						s.pop();
						int tmp2 = s.top();
						s.pop();
						if (!tmp) {
							e = true;
							break;
						}
						s.push(tmp2%tmp);
					}
				}
			}

			if (e || s.size() != 1) puts("ERROR");
			else printf("%d\n", s.top());
		}
		puts("");
		cin.getline(arr[100000], 3);
	}
}