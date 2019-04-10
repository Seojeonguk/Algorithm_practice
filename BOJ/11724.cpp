#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n,m;
int x, y,ans;
vector<int> v[1002];
bool visit[1002];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);

	while (m--) {
		scanf("%d %d", &x, &y);
		v[x].push_back(y);
		v[y].push_back(x);
	}

	for (int i = 1; i <= n; i++) {
		if (!visit[i]) {
			ans++;
			queue<int> q;
			q.push(i);
			visit[i] = true;
			while (!q.empty()) {
				int now = q.front();
				q.pop();

				int size = v[now].size();

				for (int i = 0; i < size; i++) {
					if (!visit[v[now][i]]) {
						visit[v[now][i]] = true;
						q.push(v[now][i]);
					}
				}
			}
		}
	}

	printf("%d\n", ans);
}