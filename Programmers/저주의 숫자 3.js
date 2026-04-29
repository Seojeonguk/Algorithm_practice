class Solution {
    public int solution(int n) {
        int cur = 0;
        int notThree = 0;

        while (notThree < n) {
            if (!isThree(cur)) {
                notThree++;
            }
            cur++;
        }

        return cur - 1;
    }

    public boolean isThree(int n) {
        if (n % 3 == 0) {
            return true;
        }

        return isExistThree(n);
    }

    public boolean isExistThree(int n) {
        while (n > 0) {
            if (n % 10 == 3) {
                return true;
            }
            n /= 10;
        }

        return false;
    }
}