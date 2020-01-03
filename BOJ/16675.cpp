#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
char ml, mr, tl, tr;
int l, r;

int whos_win(char a, char b) {
	if (a == 'R') {
		if (b == 'S') return 1;
		else if (b == 'R') return 0;
		else return -1;
	}
	else if (a == 'S') {
		if (b == 'S') return 0;
		else if (b == 'R') return -1;
		else return 1;
	}
	else {
		if (b == 'S') return -1;
		else if (b == 'R') return 1;
		else return 0;
	}
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%c %c %c %c", &ml, &mr, &tl, &tr);

	if (ml == mr) {
		l = whos_win(ml, tl);
		r = whos_win(ml, tr);
		if (l == -1 || r == -1) puts("TK");
		else if (l == 0 || r == 0) puts("?");
		else puts("MS");
	}
	else if (tl == tr) {
		l = whos_win(ml, tr);
		r = whos_win(mr, tr);
		if (l == 1 || r == 1) puts("MS");
		else if (l == 0 || r == 0) puts("?");
		else puts("TK");
	}
	else puts("?");
}