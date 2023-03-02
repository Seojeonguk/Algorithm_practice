#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

#define FOR(i,n) for(int i = 0;i < n;i++)
#define MP make_pair
#define PB push_back
#define ALL(a) (boards).begin(),(boards).end()

int n;
char boards[1003][1003];
bool visit[1003][1003];

int dir[8][2] = { {-1,0},{0,-1},{1,0},{0,1},{-1,-1},{-1,1},{1,-1},{1,1} };

bool isOut(int x, int y) {
    return x < 0 || y<0 || x>n - 1 || y>n - 1;
}

int solve() {
    int ans = 0;
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n; j++) {
            if (boards[i][j] == '*' && !visit[i][j]) {
                if (j + 1 < n && boards[i + 1][j + 1] == '-') {
                    boards[i + 1][j + 1] = '.';
                    visit[i][j] = 1;
                    if (j + 2 < n) visit[i][j + 2] = 1;
                    ans++;
                }
                else if (j - 1 >= 0 && boards[i + 1][j - 1] == '-') {
                    boards[i + 1][j - 1] = '.';
                    visit[i][j] = 1;
                    ans++;
                }
            }
        }
    }

    for (int i = 0; i < n; i++) 
        for (int j = 0; j < n; j++) 
            if (boards[i][j] == '*' && !visit[i][j]) 
                return -1;

    return ans;
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    scanf("%d", &n);

    for (int i = 0; i < n; i++)
        scanf(" %s", boards[i]);


    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (boards[i][j] == 'K') {
                for (int k = 0; k < 8; k++) {
                    int nx = i + dir[k][0];
                    int ny = j + dir[k][1];
                    if (isOut(nx, ny)) continue;
                    if (boards[nx][ny] == '*') visit[nx][ny] = true;
                }
                break;
            }
        }
    }

    printf("%d\n", solve());
}
