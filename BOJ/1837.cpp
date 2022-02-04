#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

bool visit[1000006];
char p[104];
int k, tmp;
vector<int> v;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%s %d", p, &k);

	for (int i = 2; i < k; i++) {
		if (!visit[i]) {
			v.push_back(i);
			for (int j = i * 2; j < k; j += i) visit[j] = true;
		}
	}

	int size = v.size();

	for (int i = 0; i < size; i++) {
		tmp = 0;
		for (int j = 0; p[j]; j++) {
			tmp = tmp * 10 + p[j] - '0';
			tmp %= v[i];
		}

		if (tmp == 0) {
			printf("BAD %d\n", v[i]);
			return 0;
		}
	}
	puts("GOOD");
}