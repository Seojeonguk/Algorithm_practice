#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, x, cnt[1001];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		scanf("%d", &x);
		cnt[x]++;
	}

	deque<pair<int, int> > dq;
	for (int i = 0; i < 1001; i++)
		if (cnt[i])
			dq.push_back({ i,cnt[i] });

	for (int i = 0; i < dq.size() - 1; i++) {
		if (dq[i].first + 1 == dq[i + 1].first) {
			if (i + 2 < dq.size()) {
				dq.insert(dq.begin() + i + 1, { dq[i + 2].first,1 });
				if (i + 3 < dq.size()) {
					dq[i + 3].second--;
					if (!dq[i + 3].second)
						dq.erase(dq.begin() + i + 3);
				}
			}
			else {
				swap(dq[i], dq[i + 1]);
			}
		}
	}

	for (int i = 0; i < dq.size(); i++)
		for (int j = 0; j < dq[i].second; j++)
			printf("%d ", dq[i].first);
}
