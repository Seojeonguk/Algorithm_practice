class Solution {
    public int solution(int a, int b) {
        int g = gcd(a, b);

        b /= g;

        while (true) {
            if (b % 2 == 0) {
                b /= 2;
            } else if (b % 5 == 0) {
                b /= 5;
            } else {
                break;
            }
        }

        return b > 1 ? 2 : 1;
    }

    public int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }

        return gcd(y, x % y);
    }
}