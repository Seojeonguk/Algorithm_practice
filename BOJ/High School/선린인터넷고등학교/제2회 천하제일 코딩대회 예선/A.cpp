#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int a, b;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &a, &b);

	// 12�ð� ���� 12�ð� �̵�
	// 12�ð� ���� a/b*12 �ð� �̵�
	// a/b-1�� ����
	printf("%d\n", (abs(a - b) * 2) / b);
}