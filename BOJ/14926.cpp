#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

bool visit[502][502];
vector<int> v;
int n;
void solve(int idx) {
	v.push_back(idx);
	for (int i = 1; i <= n; i++) {
		if (!visit[idx][i]) {
			visit[idx][i] = visit[i][idx] = true;
			solve(i);
			break;
		}
	}
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);
	int t = 1;
	for (int i = 1; i <= n; i++)
		visit[i][i] = true;
	visit[1][n] = visit[n][1] = true;
	solve(1);

	for(int x : v)
	printf("a%d ", x);
	printf("a1");
}