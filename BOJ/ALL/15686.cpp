#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, m,x,chi_size,house_size;
int ans = 987654321;
vector<pair<int, int> > house;
vector<pair<int, int> > qq;


void solve(int cnt,vector<pair<int,int> > &v,int idx) {
	vector<pair<int,int> > in = v;
	if (cnt >= m) {	
		int sum = 0;

		for (int i = 0; i < house_size; i++) {
			int qwer = 987654321;
			for (int j = 0; j < chi_size - cnt; j++)
				qwer = min(qwer, abs(in[j].first - house[i].first) + abs(in[j].second - house[i].second));
			sum += qwer;
		}

		if (ans > sum) {
			ans = sum;
			qq = in;
		}
		if (cnt == chi_size-1) return;
	}

	for (int i = idx; i < chi_size - cnt; i++) {
		pair<int, int> p = in[i];
		in.erase(in.begin()+i);
		solve(cnt + 1, in,i);
		in.insert(in.begin() + i, p);
	}
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);

	vector<pair<int, int> > chi;
	for(int i=0;i<n;i++)
		for (int j = 0; j < n; j++) {
			scanf("%d", &x);
			if (x == 1) house.push_back({ i,j });
			else if (x == 2) chi.push_back({ i,j });
		}

	house_size = house.size();
	chi_size = chi.size();
	m = chi_size - m;
	solve(0,chi,0);

	printf("%d\n", ans);
}