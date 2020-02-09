#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

deque<int> v[4];
int k,idx,slice,ans;
//2  6

// w 1 시계
// w -1 반시계
void moving(int id, int w,int prev_id) {
	deque<int> tmp(v[id]);
	if (w == 1) {
		v[id].push_front(v[id].back());
		v[id].pop_back();
	}
	else if (w == -1) {
		v[id].push_back(v[id].front());
		v[id].pop_front();
	}
	
	if (id != 3 && tmp[2] != v[id + 1][6]) {
		if(prev_id != id+1) moving(id + 1, -w,id);
	}

	if (id != 0 && tmp[6] != v[id - 1][2]) {
		if(prev_id != id-1) moving(id - 1, -w,id);
	}
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	for (int i = 0; i < 4; i++) {
		v[i].resize(8);
		for (int j = 0; j < 8; j++)
			scanf("%1d", &v[i][j]);
	}

	scanf("%d", &k);
	while (k--) {
		scanf("%d %d", &idx, &slice);

		moving(idx-1, slice,999);
	}

	for (int i = 0; i < 4; i++) {
		ans += (v[i][0] << i);
	}
	printf("%d\n", ans);
}