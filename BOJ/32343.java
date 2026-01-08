import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        Problem problem = new Problem();
        problem.init();
        problem.solve();
        problem.printAns();
    }

    public static class Problem {

        private int length;
        private int aOneCnt;
        private int bOneCnt;

        private int maxValue;

        public void init() throws IOException {
            length = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            aOneCnt = Integer.parseInt(st.nextToken());
            bOneCnt = Integer.parseInt(st.nextToken());

            maxValue = 0;
        }

        public void solve() throws IOException {
            for (int i = 0; i < (1 << length); i++) {
                String aStr = Integer.toBinaryString(i);
                if (aStr.replaceAll("0", "").length() != aOneCnt) {
                    continue;
                }

                for (int j = 0; j < (1 << length); j++) {
                    String bStr = Integer.toBinaryString(j);
                    if (bStr.replaceAll("0", "").length() != bOneCnt) {
                        continue;
                    }

                    int aValue = Integer.parseInt(aStr, 2);
                    int bValue = Integer.parseInt(bStr, 2);
                    maxValue = Math.max(maxValue, aValue ^ bValue);
                }
            }
        }

        public void printAns() throws IOException {
            bw.write(String.valueOf(maxValue));
            bw.flush();
        }
    }
}
