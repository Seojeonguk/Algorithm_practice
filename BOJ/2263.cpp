#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

void solve(int, int, int, int);
int nodeCnt, inOrder[100002], postOrder[100002], inOrderIdx[100002];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &nodeCnt);
    for (int idx = 1; idx <= nodeCnt; idx++) {
        scanf("%d", &inOrder[idx]);
        inOrderIdx[inOrder[idx]] = idx;
    }
    for (int idx = 1; idx <= nodeCnt; idx++) {
        scanf("%d", &postOrder[idx]);
    }

    solve(1, nodeCnt, 1, nodeCnt);
}

void solve(int inLeft,int inRight, int postLeft, int postRight) {
    if (inLeft > inRight || postLeft > postRight) {
        return;
    }
    
    printf("%d ", postOrder[postRight]);

    int rootIdx = inOrderIdx[postOrder[postRight]];

    solve(inLeft, rootIdx - 1, postLeft, postLeft + rootIdx - inLeft -1 );
    solve(rootIdx + 1, inRight, postLeft + rootIdx - inLeft ,postRight-1);

}