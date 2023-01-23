int xy[4][2] = { {1,0},{-1,0},{0,1},{0,-1} };
int copyMap[10][10], copyMapSize;
int p[101][2], begin, end;
bool isVisit[10][10];

bool isOut(int x, int y) {
    return (x<0 || y<0 || x>copyMapSize - 1 || y>copyMapSize - 1);
}

void bfs_init(int map_size, int map[10][10]) {
    copyMapSize = map_size;
    for (int i = 0; i < copyMapSize; i++)
        for (int j = 0; j < copyMapSize; j++)
            copyMap[i][j] = map[i][j];
}
int bfs(int x1, int y1, int x2, int y2) {
    begin = end = 0;
    for (int i = 0; i < copyMapSize; i++)
        for (int j = 0; j < copyMapSize; j++)
            isVisit[i][j] = false;
    
    x1--, y1--, x2--, y2--;
    p[end][0] = y1 * 10 + x1 % 10;
    p[end][1] = 0;
    end++;
    isVisit[y1][x1] = true;

    while (begin!=end) {
        int nowX = p[begin][0] / 10;
        int nowY = p[begin][0] % 10;
        int cnt = p[begin][1];
        begin++;

        if (nowX == y2 && nowY == x2)
            return cnt;

        for (int dir = 0; dir < 4; dir++) {
            int nextX = nowX + xy[dir][0];
            int nextY = nowY + xy[dir][1];
            int nextCnt = cnt + 1;

            if (isOut(nextX, nextY) || isVisit[nextX][nextY] || copyMap[nextX][nextY]) continue;

            isVisit[nextX][nextY] = true;
            p[end][0] = nextX * 10 + nextY % 10;
            p[end][1] = nextCnt;
            end++;
        }
    }

    return -1;
}