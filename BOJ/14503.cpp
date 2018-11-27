#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

//0ºÏ 1µ¿ 2³² 3¼­
int n, m, d, robot_x, robot_y,res=1;
int mapp[52][52];
int cleaning[52][52];
int X[] = { -1,0,1,0 }, Y[] = { 0,1,0,-1 };

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);
	scanf("%d %d %d", &robot_x, &robot_y, &d);
	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++) {
			scanf("%d", &mapp[i][j]);
			if (mapp[i][j]) cleaning[i][j] = 2;
		}
	cleaning[robot_x][robot_y] = true;

	while (1) {
		bool one_two_chk = false;
		for (int i = 1,tmp; i < 5; i++) {
			tmp = (d + 3 * i) % 4;
			if (!mapp[robot_x + X[tmp]][robot_y + Y[tmp]] && !cleaning[robot_x + X[tmp]][robot_y + Y[tmp]]) {
				d = tmp;
				robot_x += X[tmp], robot_y += Y[tmp];
				one_two_chk = true;
				cleaning[robot_x][robot_y] = true;
				res++;
				break;
			}

		}
		if (one_two_chk) continue;

		int three_four = (d + 2) % 4;
		if (mapp[robot_x + X[three_four]][robot_y + Y[three_four]] == 1) break;
		robot_x += X[three_four], robot_y += Y[three_four];
	}

	printf("%d\n", res);
}