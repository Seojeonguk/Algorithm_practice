#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

struct d {
	int x, y, cnt;
};



int n,m;
int arr[30][30];
bool visit[30][30];
int x, y,s=2,eat,ans;
int X[] = { -1,0,0,1 }, Y[] = { 0,-1,1,0 };

void print() {
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			printf("%d ", arr[i][j]);
		}
		puts("");
	}
	puts("");
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);

	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++) {
			scanf("%d", &arr[i][j]);
			if (arr[i][j] == 9) {
				arr[i][j] = 0;
				x = i, y = j;
			}
			else if (arr[i][j] != 0) m++;
		}

	while (1) {
		//printf("%d %d %d %d %d\n", x, y,s,eat,ans);
		//print();
		bool eating = false;
		memset(visit, 0, sizeof visit);
		queue<d> q;
		q.push({ x,y,0 });
		visit[x][y] = true;
		int temp_x = 31, temp_y = 31,temp=0;

		while (!q.empty()) {
			d outdata = q.front();
			q.pop();

			if (temp && temp != outdata.cnt) break;

			if (arr[outdata.x][outdata.y] < s && arr[outdata.x][outdata.y]) {
				
				eating = true;
				if (outdata.x <= temp_x) {
					temp_y = (outdata.x == temp_x ? min(temp_y,outdata.y) : outdata.y);
					temp_x = outdata.x;
					temp = outdata.cnt;
				}
			}
			if (eating) continue;

			for (int i = 0; i < 4; i++) {
				int nx = outdata.x + X[i];
				int ny = outdata.y + Y[i];

				if (nx<0 || ny<0 || nx>n - 1 || ny>n - 1 || visit[nx][ny] || arr[nx][ny]>s) continue;
				visit[nx][ny] = true;
				q.push({ nx,ny,outdata.cnt+1 });
			}
		}
		if (!eating) break;
		else {
			ans += temp;
			x = temp_x;
			y = temp_y;
			arr[x][y] = 0;
			eat++;
			if (eat == s) {
				s++;
				eat = 0;
			}
		}
	}

	printf("%d\n", ans);
}