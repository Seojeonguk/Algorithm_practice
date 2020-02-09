#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;


int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	int a, b, c, d;
	for (int i = 2; i <= 100; i++) {
		a = i * i*i;
		for (int q = 2; q*q*q <=a; q++) {
			b = q * q*q;
			for (int w = q + 1; b + w * w*w <= a; w++) {
				c = w * w*w;
				for (int e = w + 1; b + c + e * e*e <= a; e++) {
					d = e * e*e;
					if (a == b + c + d)
						printf("Cube = %d, Triple = (%d,%d,%d)\n", i, q, w, e);
				}
			}
		}
	}
}