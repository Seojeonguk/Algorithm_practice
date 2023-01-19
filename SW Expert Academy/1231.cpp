#include<iostream>
using namespace std;

struct Node {
    int num, leftNum, rightNum;
    char alphabet;
};

Node node[101];

int n, num, leftNum, rightNum;
char alphabet;

void solve(int idx) {
    if (node[idx].leftNum != -1)
        solve(node[idx].leftNum);
    cout << node[idx].alphabet;
    if (node[idx].rightNum != -1)
        solve(node[idx].rightNum);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    for (int tc = 1; tc <= 10; tc++) {
        cin >> n;

        for (int i = 0; i < n; i++) {
            cin >> num >> alphabet;
            leftNum = rightNum = -1;
            if (cin.get() != '\n') {
                cin >> leftNum;
                if (cin.get() != '\n')
                    cin >> rightNum;
            }

            node[num].alphabet = alphabet;
            node[num].leftNum = leftNum;
            node[num].rightNum = rightNum;
        }

        cout << "#" << tc << " ";
        solve(1);
        cout << '\n';
    }
}