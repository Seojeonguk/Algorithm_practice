#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int ax, ay, az, cx, cy, cz;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d %d %d %d", &ax, &ay, &az,&cx,&cy,&cz);

	printf("%d %d %d\n", cx - az, cy / ay, cz - ax);
}