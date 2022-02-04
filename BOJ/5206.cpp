#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
void calcPersonDist(int, int, bool);
int meetingTorest(int, int, int, int);
int tc;
int n, m, ans,number_cnt;
int X[] = { 1,0,-1,0 }, Y[] = { 0,1,0,-1 };
char campus[32][32];
pair<int,int> meeting_to_person[32][32];
pair<int,int> rest_to_person[32][32];


int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &tc);

    for (int testCase = 1; testCase <= tc; testCase++) {
        ans = 987654321;
        scanf("%d %d", &n, &m);
        number_cnt = 0;
        vector<pair<int, int> > mtp;
        vector<pair<int, int> > rtp;
        memset(meeting_to_person, 0, sizeof meeting_to_person);
        memset(rest_to_person, 0, sizeof rest_to_person);

        for (int i = 0; i < n; i++) {
            scanf("%s", &campus[i]);
            for (int j = 0; j < m; j++) {
                if (campus[i][j] == 'S')
                    number_cnt++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (campus[i][j] == 'M') {
                    calcPersonDist(i, j,false);
                    mtp.push_back({ i,j });
                }
                else if (campus[i][j] == 'R') {
                    calcPersonDist(i, j, true);
                    rtp.push_back({ i,j });
                }
            }
        }

        for (int i = 0; i < mtp.size(); i++) {
            for (int j = 0; j < rtp.size(); j++) {
                if (meeting_to_person[mtp[i].first][mtp[i].second].second != number_cnt) 
                    continue;
                if (rest_to_person[rtp[j].first][rtp[j].second].second != number_cnt) 
                    continue;
                int mtr = meetingTorest(mtp[i].first, mtp[i].second, rtp[j].first, rtp[j].second);
                if (mtr == -1) continue;
                int tmp = meeting_to_person[mtp[i].first][mtp[i].second].first + rest_to_person[rtp[j].first][rtp[j].second].first + mtr*number_cnt;
                ans = min(ans, tmp);
            }
        }

        printf("Data Set %d:\n",testCase);
        if (ans == 987654321) puts("Impossible");
        else printf("%d\n", ans);
    }
}

void calcPersonDist(int x, int y, bool p) {
    bool visit[32][32] = { false, };

    visit[x][y] = true;
    queue < pair<int, pair<int, int> > > q;
    q.push({ 0,{x,y} });

    while (!q.empty()) {
        auto outdata = q.front();
        q.pop();

        if (campus[outdata.second.first][outdata.second.second] == 'S') {
            if (!p) {
                meeting_to_person[x][y].first += outdata.first;
                meeting_to_person[x][y].second++;
            }
            else {
                rest_to_person[x][y].first += outdata.first;
                rest_to_person[x][y].second++;
            }
            
        }

        for (int i = 0; i < 4; i++) {
            int nx = outdata.second.first + X[i];
            int ny = outdata.second.second + Y[i];

            if (nx<0 || ny<0 || nx>n - 1 || ny>m - 1 || visit[nx][ny] || campus[nx][ny] == 'X' || campus[nx][ny] == 'R')
                continue;

            q.push({ outdata.first + 1,{nx,ny} });
            visit[nx][ny] = true;
        }
    }
}

int meetingTorest(int stx, int sty, int dex, int dey) {
    bool visit[32][32] = { false, };

    visit[stx][sty] = true;
    queue < pair<int, pair<int, int> > > q;
    q.push({ 0,{stx,sty} });

    while (!q.empty()) {
        auto outdata = q.front();
        q.pop();

        if (outdata.second.first == dex && outdata.second.second == dey)
            return outdata.first;

        for (int i = 0; i < 4; i++) {
            int nx = outdata.second.first + X[i];
            int ny = outdata.second.second + Y[i];

            if (nx<0 || ny<0 || nx>n - 1 || ny>m - 1 || visit[nx][ny] || campus[nx][ny] == 'X')
                continue;

            if (campus[nx][ny] == 'R' && (outdata.second.first != dex && outdata.second.second != dey))
                continue;

            q.push({ outdata.first + 1,{nx,ny} });
            visit[nx][ny] = true;
        }
    }
    return -1;
}