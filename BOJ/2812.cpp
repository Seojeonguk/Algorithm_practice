#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, k;
stack<char> s;
char str[500003],ans[500003];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %s", &n, &k,str);

	for (int i = 0; i < n; i++) {
		while (k != 0 && !s.empty() && s.top() < str[i]) {
			s.pop();
			k--;
		}
		s.push(str[i]);
	}

	int i = s.size()-1,tmp = s.size();
	while (!s.empty()) {
		ans[i--] = s.top();
		s.pop();
	}
	reverse(ans, ans + tmp);
	for (int i = tmp - 1; i >= k; i--)
		printf("%c", ans[i]);
}