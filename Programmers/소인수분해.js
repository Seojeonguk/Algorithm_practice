import java.util.TreeSet;

class Solution {
    public int[] solution(int n) {
        TreeSet<Integer> primes = new TreeSet<>();
        while (true) {
            boolean found = false;
            for (int i = 2; i <= n; i++) {
                if (n % i == 0) {
                    primes.add(i);
                    n /= i;
                    found = true;
                    break;
                }
            }

            if (!found) {
                break;
            }
        }

        int[] res = new int[primes.size()];
        int index = 0;
        for (int prime : primes) {
            res[index++] = prime;
        }

        return res;
    }
}