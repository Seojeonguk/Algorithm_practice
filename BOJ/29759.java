import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int MAX = 1000000;

    public static void main(String[] args) throws Exception {
        TreeSet<Integer> primes = new TreeSet<>();
        boolean[] isPrime = new boolean[MAX + 1];
        for (int i = 2; i <= MAX; i++) {
            if (isPrime[i]) {
                continue;
            }
            primes.add(i);
            for (int j = i * 2; j <= MAX; j += i) {
                isPrime[j] = true;
            }
        }

        int n = Integer.parseInt(br.readLine());
        int[][] sudoku = new int[n * n][n * n];
        for (int i = 0; i < n * n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n * n; j++) {
                sudoku[i][j] = Integer.parseInt(st.nextToken());
                if (sudoku[i][j] > 0 && primes.contains(sudoku[i][j])) {
                    primes.remove(sudoku[i][j]);
                }
            }
        }

        Iterator<Integer> it = primes.iterator();
        for (int i = 0; i < n * n; i++) {
            for (int j = 0; j < n * n; j++) {
                if (sudoku[i][j] > 0) {
                    sb.append(sudoku[i][j]);
                } else {
                    while (it.hasNext()) {
                        int value = it.next();
                        if (isGood(n, sudoku, i, j, value)) {
                            sudoku[i][j] = value;
                            sb.append(value);
                            break;
                        }
                    }
                }
                sb.append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isGood(int n, int[][] sudoku, int i, int j, int value) {
        for (int idx = 0; idx < n * n; idx++) {
            if (sudoku[i][idx] > 0 && gcd(sudoku[i][idx], value) != 1) {
                return false;
            }
            if (sudoku[idx][j] > 0 && gcd(sudoku[idx][j], value) != 1) {
                return false;
            }
        }

        int startRow = (i / n) * n, startCol = (j / n) * n;
        for (int row = startRow; row < startRow + n; row++) {
            for (int col = startCol; col < startCol + n; col++) {
                if (sudoku[row][col] > 0 && gcd(sudoku[row][col], value) != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
