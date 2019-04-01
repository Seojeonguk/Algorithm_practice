#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int a, b, c;
struct d {
	int a_, b_, c_;
};
bool vi[201][201][201];
bool C[201];
queue<d> q;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d", &a, &b, &c);

	q.push({ 0,0,c });
	C[c] = true;
	vi[0][0][c] = true;
	d indata;
	while (!q.empty()) {
		auto outdata = q.front();
		q.pop();
		if (outdata.a_) {
			if (outdata.b_ != b) {
				indata = outdata;
				if (outdata.a_ + outdata.b_ > b) {
					indata.a_ = indata.a_ - (b - outdata.b_);
					indata.b_ = b;
					if (!vi[indata.a_][indata.b_][indata.c_]) {
						vi[indata.a_][indata.b_][indata.c_] = true;
						q.push(indata);
					}
				}
				else {
					indata.b_ = indata.a_ + indata.b_;
					indata.a_ = 0;
					if (!vi[indata.a_][indata.b_][indata.c_]) {
						vi[indata.a_][indata.b_][indata.c_] = true;
						q.push(indata);
					}
				}
				if (!indata.a_) C[indata.c_] = true;
			}

			if (outdata.c_ != c) {
				indata = outdata;
				if (outdata.a_ + outdata.c_ > c) {
					indata.a_ = indata.a_ - (c - outdata.c_);
					indata.c_ = c;
					if (!vi[indata.a_][indata.b_][indata.c_]) {
						vi[indata.a_][indata.b_][indata.c_] = true;
						q.push(indata);
					}
				}
				else {
					indata.c_ = indata.a_ + indata.c_;
					indata.a_ = 0;
					if (!vi[indata.a_][indata.b_][indata.c_]) {
						vi[indata.a_][indata.b_][indata.c_] = true;
						q.push(indata);
					}
				}
				if (!indata.a_) C[indata.c_] = true;
			}
		}

		if (outdata.b_) {
			if (outdata.a_ != a) {
				indata = outdata;
				if (outdata.b_ + outdata.a_ > a) {
					indata.b_ = indata.b_ - (a - outdata.a_);
					indata.a_ = a;
					if (!vi[indata.a_][indata.b_][indata.c_]) {
						vi[indata.a_][indata.b_][indata.c_] = true;
						q.push(indata);
					}
				}
				else {
					indata.a_ = indata.a_ + indata.b_;
					indata.b_ = 0;
					if (!vi[indata.a_][indata.b_][indata.c_]) {
						vi[indata.a_][indata.b_][indata.c_] = true;
						q.push(indata);
					}
				}
				if (!indata.a_) C[indata.c_] = true;
			}
			if (outdata.c_ != c) {
				indata = outdata;
				if (outdata.b_ + outdata.c_ > c) {
					indata.b_ = indata.b_ - (c - outdata.c_);
					indata.c_ = c;
					if (!vi[indata.a_][indata.b_][indata.c_]) {
						vi[indata.a_][indata.b_][indata.c_] = true;
						q.push(indata);
					}
				}
				else {
					indata.c_ = indata.b_ + indata.c_;
					indata.b_ = 0;
					if (!vi[indata.a_][indata.b_][indata.c_]) {
						vi[indata.a_][indata.b_][indata.c_] = true;
						q.push(indata);
					}
				}
				if (!indata.a_) C[indata.c_] = true;
			}

		}

		if (outdata.c_) {
			if (outdata.a_ != a) {
				indata = outdata;
				if (outdata.c_ + outdata.a_ > a) {
					indata.c_ = indata.c_ - (a - outdata.a_);
					indata.a_ = a;
					if (!vi[indata.a_][indata.b_][indata.c_]) {
						vi[indata.a_][indata.b_][indata.c_] = true;
						q.push(indata);
					}
				}
				else {
					indata.a_ = indata.a_ + indata.c_;
					indata.c_ = 0;
					if (!vi[indata.a_][indata.b_][indata.c_]) {
						vi[indata.a_][indata.b_][indata.c_] = true;
						q.push(indata);
					}
				}
				if (!indata.a_) C[indata.c_] = true;
			}
			if (outdata.b_ != b) {
				indata = outdata;
				if (outdata.c_ + outdata.b_ > b) {
					indata.c_ = indata.c_ - (b - outdata.b_);
					indata.b_ = b;
					if (!vi[indata.a_][indata.b_][indata.c_]) {
						vi[indata.a_][indata.b_][indata.c_] = true;
						q.push(indata);
					}
				}
				else {
					indata.b_ = indata.b_ + indata.c_;
					indata.c_ = 0;
					if (!vi[indata.a_][indata.b_][indata.c_]) {
						vi[indata.a_][indata.b_][indata.c_] = true;
						q.push(indata);
					}
				}
				if (!indata.a_) C[indata.c_] = true;
			}
		}
	}

	for (int i = 0; i < 201; i++)
		if (C[i])
			printf("%d ", i);
}