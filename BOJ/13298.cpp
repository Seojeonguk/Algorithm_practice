#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n,l1,a1,l2,a2,lt,at;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%d %d %d %d %d %d", &l1, &a1, &l2, &a2, &lt, &at);
		map<pair<int, int>,int > m;
		pair<int, int> p;
		for (int j = 1; j <= min(lt / l1, at / a1); j++) {
			if ((lt - l1 * j) % l2 == 0 && (at - a1 * j) % a2 == 0) {
				if ((lt - l1 * j) / l2 == (at - a1 * j) / a2) {
					if ((lt - l1 * j) / l2 != 0) {
						p.first = j;
						p.second = (lt - l1 * j) / l2;
						m[p] = 1;
					}
				}
			}
		}
		for (int j = 1; j <= min(lt / l2, at / a2); j++) {
			if ((lt - l2 * j) % l1 == 0 && (at - a2 * j) % a1 == 0) {
				if ((lt - l2 * j) / l1 == (at - a2 * j) / a1) {
					if ((lt - l2 * j) / l1 != 0) {
						p.first = (lt - l2 * j) / l1;
						p.second = j;
						m[p] = 1;
					}
				}
			}
		}
		if (m.size() != 1) puts("?");
		else printf("%d %d\n", p.first, p.second);
	}
}