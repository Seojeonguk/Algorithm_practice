#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

string text;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    while (1) {
        cin >> text;
        if (!text.compare("TTYL")) {
            puts("talk to you later");
            break;
        }
        else if (!text.compare("CU")) {
            puts("see you");
        }
        else if (!text.compare(":-)")) {
            puts("I’m happy");
        }
        else if (!text.compare(":-(")) {
            puts("I’m unhappy");
        }
        else if (!text.compare(";-)")) {
            puts("wink");
        }
        else if (!text.compare(":-P")) {
            puts("stick out my tongue");
        }
        else if (!text.compare("(~.~)")) {
            puts("sleepy");
        }
        else if (!text.compare("TA")) {
            puts("totally awesome");
        }
        else if (!text.compare("CCC")) {
            puts("Canadian Computing Competition");
        }
        else if (!text.compare("CUZ")) {
            puts("because");
        }
        else if (!text.compare("TY")) {
            puts("thank-you");
        }
        else if (!text.compare("YW")) {
            puts("you’re welcome");
        }
        else {
            puts(text.c_str());
        }
    }
}