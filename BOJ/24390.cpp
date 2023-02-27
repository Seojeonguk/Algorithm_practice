#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int m, s;
bool isVisit[3601][2];
struct state {
	int time, cnt;
	bool isCook;
};

int btns[3] = { 10,60,600 };

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%2d:%2d", &m, &s);

	s += m * 60;

	queue<state> q;
	isVisit[0][0] = true;
	q.push({ 0,0,false });

	while (!q.empty()) {
		state now = q.front();
		q.pop();

		if (now.time == s && now.isCook) {
			printf("%d\n", now.cnt);
			break;
		}

		int next_time = 0;
		for (int i = 0; i < 3; i++) {
			next_time = now.time + btns[i];
			if (isVisit[next_time][now.isCook] || next_time > s) continue;
			isVisit[next_time][now.isCook] = true;
			q.push({ next_time, now.cnt + 1,now.isCook });
		}

		if (now.isCook) {
			next_time = now.time + 30;
			if (isVisit[next_time][now.isCook] || next_time > s) continue;
			isVisit[next_time][now.isCook] = true;
			q.push({ next_time,now.cnt + 1,now.isCook });
		}
		else {
			next_time = now.time;
			if (!now.time) next_time = 30;
			if (isVisit[next_time][1] || next_time > s) continue;
			isVisit[next_time][1] = true;
			q.push({ next_time,now.cnt + 1,true });
		}
	}
}
