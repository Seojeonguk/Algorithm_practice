#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, q;
deque<pair<char, int>> dq;
char c, ans[1000002];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> q;
		if (q != 3) {
			cin >> c;
			dq.push_back({ c,q });
		}
		else
			if(!dq.empty())
			dq.pop_back();
	}

	if (dq.empty()) {
		cout << "0" << endl;
		return 0;
	}

	ans[dq.size()] = '\0';
	int left = 0, right = dq.size() - 1;
	while (!dq.empty()) {
		if (dq.back().second == 1)
			ans[right--] = dq.back().first;
		else
			ans[left++] = dq.back().first;
		dq.pop_back();
	}
	
	cout << ans << endl;
}
