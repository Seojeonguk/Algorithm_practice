#include<map>
#include<vector>
#include<queue>
typedef long long ll;
using namespace std;
map<int, int> m;
vector<pair<int, int> > v[701];
vector<pair<int, int> > rv[701];
int vSize;

int init(int N, int sCity[], int eCity[], int mCost[]) {
	m.clear();
	for (int i = 1; i <= vSize; i++) {
		v[i].clear();
		rv[i].clear();
	}
	int ret = 0;
	for (int i = 0; i < N; i++) {
		if (m.find(sCity[i]) == m.end()) {
			m[sCity[i]] = ++ret;
		}
		if (m.find(eCity[i]) == m.end()) {
			m[eCity[i]] = ++ret;
		}
		v[m[sCity[i]]].push_back({ m[eCity[i]],mCost[i] });
		rv[m[eCity[i]]].push_back({ m[sCity[i]],mCost[i] });
	}
	vSize = ret;
	return ret;
}

void add(int sCity, int eCity, int mCost) {
	v[m[sCity]].push_back({ m[eCity],mCost });
	rv[m[eCity]].push_back({ m[sCity],mCost });
	return;
}

int solve(int startCity, bool isReverse) {
	int sum = 0;
	vector<int> d(vSize + 1, 1000000);
	priority_queue<pair<int, int> > pq;

	d[startCity] = 0;
	pq.push({ 0,startCity });

	while (!pq.empty()) {
		pair<int, int> now = pq.top();
		pq.pop();

		if (d[now.second] < -now.first) continue;

		for (pair<int, int> next : (isReverse ? v[now.second] : rv[now.second])) {
			int nextCity = next.first;
			int nextCost = -now.first + next.second;

			if (nextCost < d[nextCity]) {
				d[nextCity] = nextCost;
				pq.push({ -nextCost,nextCity });
			}
		}
	}

	for (int i = 1; i <= vSize; i++)
		sum += d[i];

	return sum;
}

int cost(int mHub) {
	int ret = 0;
	int startCity = m[mHub];

	ret += solve(startCity, 1);
	ret += solve(startCity, 0);

	return ret;
}