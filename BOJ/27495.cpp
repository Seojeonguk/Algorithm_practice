#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;
#define pspii pair<string,pair<int,int> >

string mandatra[9][9];
priority_queue<pspii, vector<pspii>, greater<pspii> > pq;
int X[] = { -1,-1,-1,0,0,1,1,1 }, Y[] = { -1,0,1,-1,1,-1,0,1 };

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	ios::sync_with_stdio(false);
	cin.tie(0);

	for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++) {
			cin >> mandatra[i][j];
			if (i%3==1 && j%3==1) {
				if (i == 4 && j == 4) continue;
				pq.push({ mandatra[i][j],{i,j} });
			}
				
		}
	}

	for (int i = 1; i <= 8; i++) {
		string middle = pq.top().first;
		int x = pq.top().second.first;
		int y = pq.top().second.second;
		pq.pop();
		cout << "#" << i << ". " << middle << "\n";
		priority_queue<string, vector<string>, greater<string> > details;
		for (int dir = 0; dir < 8; dir++) {
			details.push(mandatra[x + dir[X]][y + dir[Y]]);
		}
		for (int j = 1; j <= 8; j++) {
			cout << "#" << i << "-" << j << ". " << details.top() << "\n";
			details.pop();
		}
	}
}
