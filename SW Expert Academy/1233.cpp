#include<iostream>
using namespace std;

struct Node {
    int num, leftNum, rightNum;
    char alphabet;
};

Node node[201];

int n, num, leftNum, rightNum;
char alphabet;

bool solve(int idx) {
    bool isValid = true;
    if (node[idx].leftNum != -1)
        isValid = (isValid && solve(node[idx].leftNum));
    
    if (node[idx].rightNum != -1)
        isValid = (isValid && solve(node[idx].rightNum));

    if (node[idx].leftNum == -1 && node[idx].rightNum == -1) {
        bool isLeafNode = (isdigit(node[idx].alphabet) ? true : false);
        isValid = (isValid && isLeafNode);
    }
    else {
        bool isLeafNode = (isdigit(node[idx].alphabet) ? false : true);
        isValid = (isValid && isLeafNode);
    }

    return isValid;
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

        cout << "#" << tc << " " << solve(1) << "\n";
    }
}