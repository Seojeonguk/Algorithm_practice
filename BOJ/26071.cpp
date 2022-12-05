#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int gameSize;
char gameDisplay[1502][1502];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif    
    scanf("%d", &gameSize);

    int minRow = gameSize, maxRow = 0, minCol = gameSize, maxCol = 0;

    for (int row = 0; row < gameSize; row++) {
        scanf(" %s", gameDisplay[row]);
        for (int col = 0; col < gameSize; col++) {
            if (gameDisplay[row][col] == 'G') {
                minRow = min(minRow, row);
                maxRow = max(maxRow, row);
                minCol = min(minCol, col);
                maxCol = max(maxCol, col);
            }
        }
    }
    int mindistanceX = minRow == maxRow ? 0 : min(maxRow, abs(gameSize - minRow - 1));
    int mindistanceY = minCol == maxCol ? 0 : min(maxCol, abs(gameSize - minCol - 1));

    printf("%d\n", mindistanceX + mindistanceY);
}