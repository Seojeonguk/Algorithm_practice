#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n;
int arr[102][102];
pair<int, int> d[102][102];
struct da{
	int x, y, chk;
};
int cnt;
int X[] = { 1,0,-1,0 }, Y[] = { 0,1,0,-1 };
queue<da> q;
queue<da> treqw;
bool out_map(int x, int y) {
	if (x<0 || y<0 || x>n - 1 || y>n - 1) return true;
	return false;
}
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);
	memset(d, -1, sizeof d);

	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			scanf("%d", &arr[i][j]);

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (arr[i][j] == 1 && d[i][j].first == -1) {
				da in = { i,j,cnt };
				treqw.push(in);
				d[i][j].first = 0;
				d[i][j].second = cnt++;
			

				while (!treqw.empty()) {
					auto outdata = treqw.front();
					treqw.pop();
					q.push(outdata);

					for (int i = 0; i < 4; i++) {
						auto indata = outdata;
						indata.x += X[i], indata.y += Y[i];
						if (out_map(indata.x, indata.y)) continue;
						if (arr[indata.x][indata.y] == 0) continue;
						if (d[indata.x][indata.y].first == 0) continue;
						d[indata.x][indata.y].first = 0;
						d[indata.x][indata.y].second = outdata.chk;
						treqw.push(indata);
					}
				}
			}
		}
	}
	int sum = 987654321;
	while (!q.empty()) {
		auto outdata = q.front();
		q.pop();

		for (int i = 0; i < 4; i++) {
			auto indata = outdata;
			indata.x += X[i], indata.y += Y[i];
			if (out_map(indata.x, indata.y))continue;
			if (d[indata.x][indata.y].first == -1) {
				d[indata.x][indata.y].first = d[outdata.x][outdata.y].first + 1;
				d[indata.x][indata.y].second = outdata.chk;
				q.push(indata);
			}
			else if (d[indata.x][indata.y].first > 0 && d[indata.x][indata.y].second != outdata.chk) {
				sum = min(sum, d[indata.x][indata.y].first + d[outdata.x][outdata.y].first);

			}
		}
	}
	printf("%d\n", sum);
}