#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int a;
string ans = "123456789";
string now;
set<string> s;
queue<string> q;

int X[] = { 1,0,-1,0 }, Y[] = { 0,1,0,-1 };

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    for (int i = 0; i < 9; i++) {
        scanf("%d", &a);
        if (a == 0) a = 9;
        now.append(to_string(a));
    }

    q.push(now);
    s.insert(now);
    int answer = -1;
    int cnt = 0;
    while (!q.empty()) {
        int size = q.size();
        for (int i = 0; i < size; i++) {
            string outdata = q.front();
            q.pop();

            if (!outdata.compare(ans)) {
                answer = cnt;
            }

            int zeroIdx = 0;
            for (int idx = 0; idx < 9; idx++) {
                if (outdata[idx] == '9') {
                    zeroIdx = idx;
                }
            }

            for (int idx = 0; idx < 4; idx++) {
                int nextX = zeroIdx / 3 + X[idx];
                int nextY = zeroIdx % 3 + Y[idx];

                if (nextX < 0 || nextY < 0 || nextX>2 || nextY>2) {
                    continue;
                }
                int nextIdx = nextX * 3 + nextY;
                string tmp = outdata;
                swap(tmp[zeroIdx], tmp[nextIdx]);

                if (s.find(tmp) != s.end()) {
                    continue;
                }
                s.insert(tmp);
                q.push(tmp);
            }
        }
        cnt++;
        if (answer != -1) break;
    }
    printf("%d\n", answer);
}