#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

deque<pair<int, int> > dq;
int n, k, u, d;
int arr[100001];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);

	for (int i = 0; i < n; i++)
		scanf("%d", &arr[i]);

	scanf("%d", &k);

	for (int i = 0; i < 2*k; i++) {
		scanf("%d", &u);
		while (!dq.empty()) {
			if (dq.back().first <= u)
				dq.pop_back();
			else break;
		}
		dq.push_back({ u,i % 2 });
	}
    
	int maxValue = dq.front().first;
	vector<int> v;
	for (int i = 0; i < maxValue; i++)
		v.push_back(arr[i]);
	sort(v.begin(),v.end());

	int l = 0, r = maxValue - 1, arrIdx = maxValue - 1;
	while (!dq.empty()) {
		int now = dq.front().first;
		int nowse = dq.front().second;
		dq.pop_front();
		int next = dq.empty() ? 0 : dq.front().first;

		int length = now - next;

		for (int i = 0; i < length; i++)
			arr[arrIdx--] = (nowse ? v[l++] : v[r--]);
	}

	for (int i = 0; i < n; i++)
		printf("%d ", arr[i]);
}