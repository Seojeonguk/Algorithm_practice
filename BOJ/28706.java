import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final int LUCKY_VALUE = 7;
    static final String LUCKY = "LUCKY";
    static final String UNLUCKY = "UNLUCKY";

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int testCase = Integer.parseInt(br.readLine());
            boolean[] currents = new boolean[LUCKY_VALUE];
            boolean[] nexts = new boolean[LUCKY_VALUE];
            for (int tc = 1; tc <= testCase; tc++) {
                Arrays.fill(currents, false);
                Arrays.fill(nexts, false);
                currents[1] = true;
                
                int totalTurn = Integer.parseInt(br.readLine());

                for (int turn = 0; turn < totalTurn; turn++) {
                    StringTokenizer options = new StringTokenizer(br.readLine());

                    char op1 = options.nextToken().charAt(0);
                    int v1 = Integer.parseInt(options.nextToken());

                    char op2 = options.nextToken().charAt(0);
                    int v2 = Integer.parseInt(options.nextToken());

                    for (int idx = 0; idx < LUCKY_VALUE; idx++) {
                        if (currents[idx]) {
                            nexts[calculate(idx, op1, v1)] = true;
                            nexts[calculate(idx, op2, v2)] = true;
                        }
                    }

                    for (int i = 0; i < 7; i++) {
                        currents[i] = nexts[i];
                        nexts[i] = false;
                    }
                }

                sb.append(currents[0] ? LUCKY : UNLUCKY).append("\n");
            }

            bw.write(sb.toString());
        }
    }

    public static int calculate(int v1, char op, int v2) {
        return (op == '+' ? v1 + v2 : v1 * v2) % LUCKY_VALUE;
    }
}
