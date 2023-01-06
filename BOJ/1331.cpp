#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

bool isVisit[6][6], diff[3];
string knigntPlace;
vector<string> knightPlaces;
bool isValid=true;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    for (int i = 0; i < 36; i++) {
        cin >> knigntPlace;
        knightPlaces.push_back(knigntPlace);
    }
    knightPlaces.push_back(knightPlaces[0]);

    for (int i = 1; i < knightPlaces.size(); i++) {
        diff[1] = diff[2] = false;
        int prevPlaceX = knightPlaces[i - 1][0] - 'A';
        int prevPlaceY = knightPlaces[i - 1][1] - '1';

        int nextPlaceX = knightPlaces[i][0] - 'A';
        int nextPlaceY = knightPlaces[i][1] - '1';

        int diffX = abs(prevPlaceX - nextPlaceX);
        int diffY = abs(prevPlaceY - nextPlaceY);

        if (diffX > 2 || diffY > 2 || diffX <= 0 || diffY <= 0) {
            isValid = false;
            break;
        }

        diff[diffX] = true;
        diff[diffY] = true;

        if (!diff[1] || !diff[2]) {
            isValid = false;
            break;
        }

        if (isVisit[nextPlaceX][nextPlaceY]) {
            isValid = false;
            break;
        }

        isVisit[nextPlaceX][nextPlaceY] = true;
    }
    puts(isValid ? "Valid" : "Invalid");
}
