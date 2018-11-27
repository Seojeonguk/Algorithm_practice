#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int map_x, map_y, k, dice_x, dice_y;
int X[] = { 0, 0,0,-1,1 }, Y[] = { 0, 1,-1,0,0 };
int mapp[22][22];
int dice_num[6]; 
//0À­¸é 1µÞ¸é 2¿À¸¥¸é 3¿Þ¸é 4¾Õ¸é 5¾Æ·§¸é

bool out_map() {
	if (dice_x <0 || dice_y<0 || dice_x > map_x - 1 || dice_y > map_y - 1) return true;
	return false;
}

//µ¿ 0>2 2>5 5>3 3>0
//¼­ 0>3 3>5 5>2 2>0
//ºÏ 0>1 1>5 5>4 4>0
//³² 0>4 4>5 5>1 1>0
void move_dice(int a, int b, int c, int d) {
	int tmp = dice_num[d];
	dice_num[d] = dice_num[c];
	dice_num[c] = dice_num[b];
	dice_num[b] = dice_num[a];
	dice_num[a] = tmp;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d %d %d", &map_x, &map_y, &dice_x, &dice_y, &k);

	for (int i = 0; i < map_x; i++)
		for (int j = 0; j < map_y; j++)
			scanf("%d", &mapp[i][j]);

	for (int i = 0,order; i < k; i++) {
		scanf("%d", &order);
		dice_x += X[order], dice_y += Y[order];
		if (out_map()) {
			dice_x -= X[order], dice_y -= Y[order];
			continue;
		}

		if (order == 1) move_dice(0, 2, 5, 3);
		else if (order == 2) move_dice(0, 3, 5, 2);
		else if (order == 3) move_dice(0, 1, 5, 4);
		else if (order == 4) move_dice(0, 4, 5, 1);

		if (mapp[dice_x][dice_y] != 0) {
			dice_num[5] = mapp[dice_x][dice_y];
			mapp[dice_x][dice_y] = 0;
		}
		else mapp[dice_x][dice_y] = dice_num[5];

		printf("%d\n", dice_num[0]);
	}
}