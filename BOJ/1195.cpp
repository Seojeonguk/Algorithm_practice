#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int ans;

void solve(string x, string y) {
    int xSize = x.size();
    int ySize = y.size();
    for (int i = 0; i < xSize; i++) {
        bool isPossible = true;
        for (int j = 0; j < ySize && i+j < xSize; j++) {
            if (x[i+j] == '2' && y[j] == '2') {
                isPossible = false;
                break;
            }
        }
        if (isPossible) {
            ans = min(ans, xSize + max(ySize + i - xSize, 0));
        }
    }
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    string gear1, gear2;
    cin >> gear1 >> gear2;
    
    if (gear1.size() < gear2.size()) 
        swap(gear1, gear2);
    
    ans = gear1.size() + gear2.size();

    solve(gear1, gear2);

    reverse(gear1.begin(), gear1.end());
    reverse(gear2.begin(), gear2.end());

    solve(gear1, gear2);

    printf("%d\n", ans);
}
