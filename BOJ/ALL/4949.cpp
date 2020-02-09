#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

char balance[102];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	while (1) {
		gets_s(balance);

		if (strcmp(balance, ".") == 0) break;
		
		stack<char> s;

		int balance_size = strlen(balance);
		bool unbalance_checker = false;
		for (int i = 0; i < balance_size; i++) {
			if (balance[i] == '[' || balance[i] == '(') s.push(balance[i]);

			else if (balance[i] == ']') {
				if (s.size())
					if (s.top() == '[')  s.pop();
					else unbalance_checker = true;
				else unbalance_checker = true;
			}

			else if (balance[i] == ')') {
				if (s.size())
					if (s.top() == '(') s.pop();
					else unbalance_checker = true;
				else 
					unbalance_checker = true;
			}

			if (unbalance_checker) break;
		}

		if (s.size() || unbalance_checker) printf("no\n");
		else printf("yes\n");
	}
}