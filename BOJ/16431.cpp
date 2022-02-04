#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

pair<int, int> bessie, daisy, john;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &bessie.first, &bessie.second);
	scanf("%d %d", &daisy.first, &daisy.second);
	scanf("%d %d", &john.first, &john.second);

	int bessie_john_distance_x = abs(bessie.first - john.first);
	int bessie_john_distance_y = abs(bessie.second - john.second);
	int bessie_john_distance = bessie_john_distance_x + bessie_john_distance_y;
	
	if ((bessie.first != john.first) && (bessie.second != john.second))
		bessie_john_distance -= (bessie_john_distance_x > bessie_john_distance_y ? bessie_john_distance_y : bessie_john_distance_x);

	int daisy_john_distance = abs(daisy.first - john.first) + abs(daisy.second - john.second);

	if (bessie_john_distance > daisy_john_distance) puts("daisy");
	else if (bessie_john_distance < daisy_john_distance) puts("bessie");
	else puts("tie");
}