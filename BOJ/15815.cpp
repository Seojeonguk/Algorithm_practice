#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

char arr[200];
stack<int> s;

 
int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%s ", arr);
    int size = strlen(arr);

    for (int i = 0; i < size; i++) {
        if ('0' <= arr[i] && arr[i] <= '9') {
            s.push(arr[i] - '0');
        }
        else {
            int x1 = s.top();
            s.pop();
            int x2 = s.top();
            s.pop();

            if (arr[i] == '+') s.push(x1 + x2);
            else if (arr[i] == '*') s.push(x1 * x2);
            else if (arr[i] == '-') s.push(x2 - x1);
            else s.push(x2 / x1);
        }
    }

    printf("%d\n", s.top());
}