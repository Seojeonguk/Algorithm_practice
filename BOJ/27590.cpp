#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

pair<int, int> planets[2];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	for (int i = 0; i < 2; i++)
		scanf("%d %d", &planets[i].first, &planets[i].second);
	planets[0].first = -planets[0].first;
	planets[1].first = -planets[1].first;

	while (planets[0].first != planets[1].first) {
		while (planets[0].first < planets[1].first)
			planets[0].first += planets[0].second;

		while (planets[1].first < planets[0].first)
			planets[1].first += planets[1].second;
	}

	printf("%d\n", planets[0].first);
}
