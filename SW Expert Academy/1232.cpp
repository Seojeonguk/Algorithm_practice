#include<iostream>
using namespace std;

struct Node {
    int num, leftNum, rightNum;
    string alphabet;
};

Node node[1001];

int n, num, leftNum, rightNum;
string alphabet;

bool is_digit(string str) {
    return (atoi(str.c_str()) || !str.compare("0"));
}

int solve(int idx) {
    if (is_digit(node[idx].alphabet)) 
        return stoi(node[idx].alphabet);


    int left, right;
    if (node[idx].leftNum != -1)
        left = solve(node[idx].leftNum);
    
    if (node[idx].rightNum != -1)
        right = solve(node[idx].rightNum);

    if (!node[idx].alphabet.compare("+")) return left + right;
    else if (!node[idx].alphabet.compare("-")) return left - right;
    else if (!node[idx].alphabet.compare("/")) return left / right;
    else if (!node[idx].alphabet.compare("*")) return left * right;
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