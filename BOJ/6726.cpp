#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

#define MAX 63356
int x;
pair<int,int> par[140000];


int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	while (scanf("%d", &x)) {
		if (!x) break;

		memset(par, -1, sizeof par);
		queue<int> q;
		x += MAX;
		par[MAX-1].first = par[MAX+1].first = 0;
		par[MAX-1].second = 1;
		par[MAX+1].second = 2;

		q.push(MAX-1);
		q.push(MAX+1);

		while (!q.empty()) {
			int idx = q.front() - MAX;
			q.pop();

			if (idx + MAX == x) break;

			int next_idx = idx * 2;
			if (-MAX <= next_idx && next_idx <= MAX && par[next_idx + MAX].first == -1) {
				par[next_idx + MAX].first = idx + MAX;
				par[next_idx + MAX].second = 3;
				q.push(next_idx + MAX);
			}
			next_idx = idx + 1;
			if (-MAX <= next_idx && next_idx <= MAX && par[next_idx + MAX].first == -1) {
				par[next_idx + MAX].first = idx + MAX;
				par[next_idx + MAX].second = 4;
				q.push(next_idx + MAX);
			}
		}
		printf("Constant %d\n", x - MAX);
		stack<int> s;
		while (x) {
			s.push(par[x].second);

			x = par[x].first;
		}
		while (!s.empty()) {
			int top = s.top();
			if (top == 1) puts("C-1");
			else if (top == 2) puts("C+1");
			else if (top == 3) puts("DBL");
			else if (top == 4) puts("INCR");
			s.pop();
		}
		puts("");
	}
}
