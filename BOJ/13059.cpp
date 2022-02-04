#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, x, y, depth[200002], f[200002][21];
vector<int> v[200001];
void get_tree() {
	queue<int> q;
	q.push(1);
	depth[1] = 1;

	while (!q.empty()) {
		int outdata = q.front();
		q.pop();
		for (int next : v[outdata]) {
			if (next != f[outdata][0]) {
				depth[next] = depth[outdata] + 1;
				f[next][0] = outdata;
				q.push(next);
			}
		}
	}
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);
	for (int i = 1; i < n; i++) {
		scanf("%d %d", &x, &y);
		v[x].push_back(y);
		v[y].push_back(x);
	}

	get_tree();

	for (int i = 1; i < 21; i++)
		for (int j = 1; j <= n; j++)
			f[j][i] = f[f[j][i - 1]][i - 1];

	long long sum = 0;
	for (int i = 1; i <= n / 2; i++) {
		for (int j = i * 2; j <= n; j += i) {
			int tmp1 = i, tmp2 = j;
			if (depth[tmp1] != depth[tmp2]) {
				if (depth[tmp1] < depth[tmp2]) swap(tmp1, tmp2);
				for (int i = 20; i >= 0; i--) {
					if (depth[f[tmp1][i]] >= depth[tmp2])
						tmp1 = f[tmp1][i];
				}
			}
			int ans = tmp1;
			if (tmp1 != tmp2) {
				for (int i = 20; i >= 0; i--) {
					if (f[tmp1][i] != f[tmp2][i]) {
						tmp1 = f[tmp1][i];
						tmp2 = f[tmp2][i];
					}
					ans = f[tmp1][i];
				}
			}

			if (ans == 1) sum += depth[i] + depth[j] - 1;
			else if (ans == i || ans == j) sum += abs(depth[i] - depth[j]) + 1;
			else sum += depth[i] + depth[j] - 2 * depth[ans] + 1;
		}
	}
	printf("%lld\n", sum);
}