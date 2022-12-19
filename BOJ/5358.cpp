#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

string players;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    while (1) {
        if (cin.eof()) {
            break;
        }
        getline(cin,players);

        for (int idx = 0; idx < players.size(); idx++) {
            if (players[idx] == 'i') {
                players[idx] = 'e';
            }
            else if (players[idx] == 'I') {
                players[idx] = 'E';
            }
            else if (players[idx] == 'e') {
                players[idx] = 'i';
            }
            else if (players[idx] == 'E') {
                players[idx] = 'I';
            }
        }
        cout << players << '\n';
    }
}