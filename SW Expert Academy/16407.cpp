#include<queue>
#include<cstring>
using namespace std;
#define MAX_N 100
int n;
struct Information {
    int energy, target, x, y;
}info[MAX_N + 1][MAX_N + 1];

struct cmp {
    bool operator()(Information& a, Information& b) {
        if (a.energy != b.energy) return a.energy < b.energy;
        if (a.x == b.x) return a.y > b.y;
        return a.x > b.x;
    }
};

int X[] = { 1,0,-1,0 }, Y[] = { 0,1,0,-1 };
int ans[3];
bool isVisit[MAX_N + 1][MAX_N + 1];


bool isOut(int x, int y) {
    return (x < 1 || y < 1 || x>n || y>n);
}

void init(int N, int mDish[MAX_N][MAX_N]){
    n = N;

    ans[1] = ans[2] = 0;

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            info[i][j].energy = mDish[i - 1][j - 1];
            info[i][j].target = 0;
            info[i][j].x = i;
            info[i][j].y = j;
        }
    }
}
int dropMedicine(int mTarget, int mRow, int mCol, int mEnergy) {
    int target = info[mRow][mCol].target;
    if (target && target != mTarget) return ans[mTarget];

    memset(isVisit, false, sizeof isVisit);
    if (!target) {
        info[mRow][mCol].target = mTarget;
        mEnergy -= info[mRow][mCol].energy;
        ans[mTarget]++;
    }
    queue<pair<int, int> > q;
    priority_queue<Information, vector<Information>, cmp> pq;
    q.push({ mRow,mCol });
    isVisit[mRow][mCol] = true;

    while (mEnergy > 0) {
        while (!q.empty()) {
            pair<int, int> now = q.front();
            q.pop();

            for (int dir = 0; dir < 4; dir++) {
                int nx = now.first + X[dir];
                int ny = now.second + Y[dir];

                if (isOut(nx, ny) || isVisit[nx][ny]) continue;
                
                isVisit[nx][ny] = true;
                if (info[nx][ny].target == mTarget) {
                    q.push({ nx,ny });
                }
                else if (!info[nx][ny].target) {
                    pq.push(info[nx][ny]);
                }
            }
        }

        if (pq.empty()) break;
        Information next = pq.top();
        pq.pop();

        ans[mTarget]++;
        info[next.x][next.y].target = mTarget;
        mEnergy -= info[next.x][next.y].energy;
        q.push({ next.x,next.y });
    }

    return ans[mTarget];
}

int cleanBacteria(int mRow, int mCol){    
    int target = info[mRow][mCol].target;
    if (!target) return -1;

    queue<pair<int, int> > q;
    q.push({ mRow,mCol });
    ans[target]--;
    info[mRow][mCol].target = 0;

    while (!q.empty()) {
        pair<int, int> now = q.front();
        q.pop();

        for (int dir = 0; dir < 4; dir++) {
            int nx = now.first + X[dir];
            int ny = now.second + Y[dir];

            if (isOut(nx, ny)) continue;
            if (info[nx][ny].target == target) {
                info[nx][ny].target = 0;
                ans[target]--;
                q.push({ nx,ny });
            }
        }
    }

    return ans[target];
}