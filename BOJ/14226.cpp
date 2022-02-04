#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

struct d {int emo, clip,cnt;};

int n;
bool visit[1100][1100];

int solve() {
    queue<d> q;
    q.push({ 1,0,0 });
    visit[1][0] = true;


    while (!q.empty()) {
        auto outdata = q.front();
        q.pop();

        if (outdata.emo == n)
            return outdata.cnt;

        if (!visit[outdata.emo][outdata.emo]) {
            visit[outdata.emo][outdata.emo] = true;
            q.push({ outdata.emo,outdata.emo,outdata.cnt + 1 });
        }
        

        int next_emo = outdata.emo + outdata.clip;
        if (next_emo < 1100 && !visit[next_emo][outdata.clip]) {
            visit[next_emo][outdata.clip] = true;
            q.push({ next_emo,outdata.clip,outdata.cnt + 1 });
        }

        next_emo = outdata.emo - 1;
        if (next_emo >= 0 && !visit[next_emo][outdata.clip]) {
            visit[next_emo][outdata.clip] = true;
            q.push({ next_emo,outdata.clip,outdata.cnt + 1 });
        }
    }
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &n);

    printf("%d\n", solve());
}