#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int boardSize, snakeHead, appleCnt, appleX, appleY, transHeadCnt, transTime, ans;
char transDir;
deque<pair<int, int> > snakeInfo;
int headX[] = { 0,1,0,-1 }, headY[] = { 1,0,-1,0 };
bool apple[101][101], snake[101][101];
queue < pair<int, int> >transHead;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	snakeInfo.push_back({ 0,0 });
	snake[0][0] = true;
	scanf("%d", &boardSize);
	scanf("%d", &appleCnt);
	for (int i = 0; i < appleCnt; i++) {
		scanf("%d %d", &appleX, &appleY);
		apple[appleX-1][appleY-1] = true;
	}

	scanf("%d", &transHeadCnt);

	for (int i = 0; i < transHeadCnt; i++) {
		scanf("%d %c", &transTime, &transDir);
		int transDirCtoI = (transDir=='D'?1:3);
		transHead.push({ transTime,transDirCtoI });
	}

	while (1) {
		ans++;
		int snakeNextX = snakeInfo[0].first + headX[snakeHead];
		int snakeNextY = snakeInfo[0].second + headY[snakeHead];

		if (snakeNextX<0 || snakeNextY<0 || snakeNextX>boardSize - 1 || snakeNextY>boardSize - 1 || snake[snakeNextX][snakeNextY])
			break;

		snakeInfo.push_front({ snakeNextX,snakeNextY });
		snake[snakeNextX][snakeNextY] = true;

		if (!apple[snakeNextX][snakeNextY]) {
			snake[snakeInfo.back().first][snakeInfo.back().second] = false;
			snakeInfo.pop_back();
			
		}
		else
			apple[snakeNextX][snakeNextY] = false;

		if (!transHead.empty() && ans == transHead.front().first) {
			snakeHead = (snakeHead + transHead.front().second) % 4;
			transHead.pop();
		}

	}

	printf("%d\n",ans);
}