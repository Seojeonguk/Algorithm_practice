#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int st[3], de[3];
char c;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %c %d %c %d", &st[0], &c, &st[1], &c, &st[2]);
	scanf("%d %c %d %c %d", &de[0], &c, &de[1], &c, &de[2]);

	if (de[2] < st[2]) de[1]--, de[2] += 60;
	if (de[1] < st[1]) de[0]--, de[1] += 60;
	if (de[0] < st[0]) de[0] += 24;

	printf("%d\n", (de[0]-st[0]) * 3600 + (de[1]-st[1]) * 60 + de[2]-st[2]);
}