#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n,idx,n_idx,dis;
vector<pair<int, int> > v[100002];
bool visit[100002];
int max_dis;

int find(int idx) {
    int ret = idx;
    max_dis = -1;

    queue<pair<int, int> > q;
    q.push({ idx,0 });
    visit[idx] = true;

    while (!q.empty()) {
        auto outdata = q.front();
        q.pop();

        if (outdata.second > max_dis) {
            max_dis = outdata.second;
            ret = outdata.first;
        }

        int size = v[outdata.first].size();
        for (int i = 0; i < size; i++) {
            if (!visit[v[outdata.first][i].first]) {
                visit[v[outdata.first][i].first] = true;
                q.push({ v[outdata.first][i].first,outdata.second + v[outdata.first][i].second });
            }
        }
    }
    return ret;
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &n);

    for (int i = 0; i < n; i++) {
        scanf("%d", &idx);
        
        while (1) {
            scanf("%d", &n_idx);
            if (n_idx == -1) break;
            scanf("%d", &dis);

            v[idx].push_back({ n_idx,dis });
        }
    }
    int ii = find(1);
    memset(visit, 0, sizeof visit);
    find(ii);
    printf("%d\n", max_dis);
}