#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

ll matrixSize, b;

vector<vector<ll> > multiply(vector<vector<ll> >& a, vector<vector<ll> >& b) {
    vector<vector<ll> > ret(matrixSize, vector<ll>(matrixSize));

    for (int i = 0; i < matrixSize; i++) {
        for (int j = 0; j < matrixSize; j++) {
            for (int k = 0; k < matrixSize; k++) {
                ret[i][j] += a[i][k] * b[k][j];
            }
            ret[i][j] %= 1000;
        }
    }

    return ret;
}

void print(const vector<vector<ll> >& m) {
    for (int row = 0; row < matrixSize; row++) {
        for (int col = 0; col < matrixSize; col++) {
            printf("%lld ", m[row][col]);
        }
        puts("");
    }
}

vector<vector<ll> > solve(vector<vector<ll> > a, ll cnt) {
    vector<vector<ll> > unitMaxtrix(matrixSize, vector<ll>(matrixSize));
    for (int row = 0; row < matrixSize; row++) {
        unitMaxtrix[row][row] = 1;
    }
    if (cnt == 0) {
        return unitMaxtrix;
    }
    vector<vector<ll> > temp = solve(a, cnt / 2);
    vector<vector<ll> > ret = multiply(temp, temp);
    if (cnt % 2) {
        ret = multiply(ret, a);
    }

    return ret;
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%lld %lld", &matrixSize, &b);

    vector<vector<ll> > matrix(matrixSize,vector<ll>(matrixSize));

    for (int row = 0; row < matrixSize; row++) {
        for (int col = 0; col < matrixSize; col++) {
            scanf("%lld", &matrix[row][col]);
        }
    }

    print(solve(matrix,b));
}