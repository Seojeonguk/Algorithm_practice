#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int now[3], m[3];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	for (int i = 0; i < 3; i++) scanf("%d %d", &m[i], &now[i]);

	for (int i = 0; i < 100; i++) {
		now[(i+1) % 3] += now[i % 3];
		if (m[(i+1) % 3] < now[(i+1) % 3]) {
			now[i % 3] = now[(i + 1) % 3] - m[(i + 1) % 3];
			now[(i+1) % 3] = m[(i+1) % 3];
		}
		else now[i % 3] = 0;
	}

	for (int i = 0; i < 3; i++) printf("%d\n", now[i]);
}