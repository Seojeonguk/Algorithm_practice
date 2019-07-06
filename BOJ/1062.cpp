#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, k,ans;
vector<int> v;
char arr[17];
map<int, int> m;
struct d {
	int first, second;
	int st;
};
queue<d> q;
int am,amcnt;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &k);

	for (int i = 0; i < n; i++) {
		scanf("%s", arr);
		int vector_push = 0;
		amcnt = 0;
		for (int j = 0; arr[j]; j++) {
			if (!(vector_push & (1 << (arr[j] - 'a')))) amcnt++;
			vector_push |= (1 << (arr[j] - 'a'));
		}
		v.push_back(vector_push);
		am = max(am, amcnt);
	}

	if (k < 5) {
		puts("0");
		return 0;
	}
	else if (k == 26) {
		printf("%d\n", n);
		return 0;
	}
	int indd = 0;
	indd |= (1 << ('a' - 'a'));
	indd |= (1 << ('c' - 'a'));
	indd |= (1 << ('i' - 'a'));
	indd |= (1 << ('n' - 'a'));
	indd |= (1 << ('t' - 'a'));

	q.push({ indd,5,1 });
	int indatax;

	while (!q.empty()) {
		auto outdata = q.front();
		q.pop();
		
		if (outdata.second == k) {
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				if ((outdata.first & v[i]) == v[i])
					cnt++;
			}

			ans = max(ans, cnt);
			continue;
		}

		for (int i = outdata.st; i < 26; i++) {
			if(outdata.first & (1<<i)) continue;
			indatax = outdata.first | (1 << i);
			if (m.find(indatax) != m.end()) continue;
			m[indatax] = 1;
			q.push({ indatax,outdata.second+1,i });
		}
	}

	printf("%d\n", ans);
} 