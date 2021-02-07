#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n;
int arr[1000002];
stack<int> s,ans;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);

	for (int i = 0; i < n; i++) scanf("%d", &arr[i]);

	for (int i = n - 1; i >= 0; i--) {
		if (s.empty()) {
			ans.push(-1);
			s.push(arr[i]);
		}
		else {
			while (!s.empty()) {
				if (s.top() <= arr[i]) s.pop();
				else break;
			}
			ans.push(s.empty() ?  -1 : s.top());
			s.push(arr[i]);
		}
	}

	while (!ans.empty()) {
		printf("%d ", ans.top());
		ans.pop();
	}
}