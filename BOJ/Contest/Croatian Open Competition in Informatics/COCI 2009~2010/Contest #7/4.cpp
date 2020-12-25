#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

struct d {
	int x, y, z,now;
}arr[100003];
struct pqd {
	int sum, from, to;
};
vector<pqd> v;
int n;
bool t;
int parent[100002];

int find(int u) {
	if (u == parent[u]) return u;
	return parent[u] = find(parent[u]);
}

void merge(int u, int v) {
	t = false;
	u = find(u);
	v = find(v);

	if (u == v) return;

	parent[u] = v;
	t = true;
}

int getw(d d1, d d2) {
	return min(abs(d1.x - d2.x), min(abs(d1.y-d2.y),abs(d1.z-d2.z) ));
}

bool compq(pqd d1, pqd d2) { return d1.sum < d2.sum; }

bool compx(d d1, d d2) { return d1.x < d2.x; }
bool compy(d d1, d d2) { return d1.y < d2.y; }
bool compz(d d1, d d2) { return d1.z < d2.z; }
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		scanf("%d %d %d", &arr[i].x, &arr[i].y, &arr[i].z);
		arr[i].now = i;
	}

	for (int i = 0; i <= n; i++) parent[i] = i;

	sort(arr, arr + n,compx);
	for (int i = 0; i < n - 1; i++) {
		v.push_back({ getw(arr[i],arr[i + 1]),arr[i].now,arr[i + 1].now });
	}
	sort(arr, arr + n, compy);
	for (int i = 0; i < n - 1; i++) {
		v.push_back({ getw(arr[i],arr[i + 1]),arr[i].now,arr[i + 1].now });
	}

	sort(arr, arr + n, compz);
	for (int i = 0; i < n - 1; i++) {
		v.push_back({ getw(arr[i],arr[i + 1]),arr[i].now,arr[i + 1].now });
	}

	int s = v.size();
	sort(v.begin(),v.end(),compq);
	int res = 0;
	for (int i = 0; i < s; i++) {
		merge(v[i].from, v[i].to);
		if (t) res += v[i].sum;
	}

	printf("%d\n", res);
}