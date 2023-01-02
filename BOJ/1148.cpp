#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

vector<string> dicts;
string dict, puzzle;
int puzzleCnt[26], dictCnt[200002][26];

void print(deque<char>& dq) {
    while (!dq.empty()) {
        printf("%c", dq.front());
        dq.pop_front();
    }
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    int cnt = 0;
    while (1) {
        cin >> dict;
        if (!dict.compare("-")) {
            break;
        }
        dicts.push_back(dict);
        int dictSize = dict.length();
        for (int idx = 0; idx < dictSize; idx++) {
            dictCnt[cnt][dict[idx] - 'A']++;
        }
        cnt++;
    }

    while (1) {
        memset(puzzleCnt, 0, sizeof puzzleCnt);
        cin >> puzzle;
        if (!puzzle.compare("#")) {
            break;
        }

        for (int i = 0; i < 9; i++)
            puzzleCnt[puzzle[i] - 'A']++;

        vector<string> isPossible;
        for (int i = 0; i < cnt; i++) {
            bool possible = true;

            for (int j = 0; j < 26; j++) {
                if (puzzleCnt[j] < dictCnt[i][j]) {
                    possible = false;
                    break;
                }
            }

            if (possible)
                isPossible.push_back(dicts[i]);
        }

        vector<pair<int, char> > v;
        set<char> s;
        for (int i = 0; i < 9; i++) {
            int possibleCnt = 0;
            if (s.find(puzzle[i]) != s.end()) {
                continue;
            }
            for (string d : isPossible) {
                if (d.find(puzzle[i]) != -1) {
                    possibleCnt++;
                }
            }
            s.insert(puzzle[i]);
            v.push_back({ possibleCnt,puzzle[i] });
        }

        if (v.empty()) {
            for (int i = 0; i < 9; i++) {
                if (s.find(puzzle[i]) != s.end()) {
                    v.push_back({ 0,puzzle[i] });
                }
                s.insert(puzzle[i]);
            }
        }

        int vSize = v.size();
        sort(v.begin(), v.end());
        deque<char> dq;
        for (int i = 0; i < vSize; i++) {
            if (v[i].first != v[0].first) {
                break;
            }
            dq.push_back(v[i].second);
        }
            
        print(dq);
        printf(" %d ", v[0].first);
        for (int i = vSize - 1; i >= 0; i--) {
            if (v[i].first != v[vSize - 1].first) {
                break;
            }
            dq.push_front(v[i].second);
        }
        print(dq);
        printf(" %d\n", v[vSize - 1].first);
    }
}
